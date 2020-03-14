package com.java.jna;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSONObject;
import com.sun.jna.Library;
import com.sun.jna.Native;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zJiaLi
 * @since 2020-03-14 15:22
 */
@Slf4j
public class OrcDll {

    private static final String MAKE_VERIFY_CODE = "http://120.202.98.106:8990/ebsapi/message/sendsms/makeVerifyCode";
    private static final String UPDATE_SCHEDULE = "http://120.202.98.106:8990/ebsapi/organization/basreservation/public/updateSchedule";
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    static final OkHttpClient okHttpClient = new OkHttpClient();

    private static String getVerify() {
        JSONObject jsonObject = JSONObject.parseObject("{\"iamgeHeight\":32,\"imageWidth\":100,\"type\":\"0\",\"len\":4}");
        String result = toRequest(jsonObject, MAKE_VERIFY_CODE);
        log.info("===获取验证码结果:{}===", result);

        return result;
    }

    private static String toRequest(JSONObject jsonObject, String url) {
        RequestBody requestd = RequestBody.create(jsonObject.toJSONString(), JSON);
        Request request = new Request.Builder().addHeader("Origin", "http://appointment.hbncp.com.cn:9084")
                .addHeader("Referer", "http://appointment.hbncp.com.cn:9084/")
                .addHeader("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1")
                .url(url)
                .post(requestd).build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static void updateSchedule() {
        String verify = getVerify();
        JSONObject jsonObject = JSONObject.parseObject(verify);
        JSONObject data = jsonObject.getJSONObject("data");
        String id = data.getString("id");
        String verifyCode = data.getString("verifyCode");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Base64.decodeToStream(verifyCode, baos, true);
        byte[] bytes = baos.toByteArray();
        String hackedVerifyCode = hackVerifyCode(bytes);
        JSONObject requestBody = new JSONObject();
        requestBody.put("basReservationNumberDate", Long.parseLong("1584115200000"));
        requestBody.put("basReservationNumberIdcard", "452122196807095730");
        requestBody.put("basReservationNumberName", "韦松星");
        requestBody.put("basReservationNumberPhone", "13978193582");
        requestBody.put("verifyCode", hackedVerifyCode);
        requestBody.put("verifyCodeId", Integer.parseInt(id));
        String result = toRequest(requestBody, UPDATE_SCHEDULE);
        log.info("===请求预约结果:{}===", result);

    }

    private static String hackVerifyCode(byte[] bytes) {
        CLibrary.INSTANCE.init();
        return CLibrary.INSTANCE.ocr(bytes, bytes.length);
    }

    public static void main(String[] args) throws IOException, ParseException {
         updateSchedule();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse("2020-03-14");
        System.out.println(parse.getTime());
       /* CLibrary.INSTANCE.init();
        File file = new File("C:\\Users\\Administrator\\Desktop\\1111.png");
        FileInputStream fis = new FileInputStream(file);

        byte[] bytes = new byte[(int) file.length()];
        fis.read(bytes);
        fis.close();
        String ocr = CLibrary.INSTANCE.ocr(bytes, bytes.length);
        System.out.println(ocr);*/
    }

    public interface CLibrary extends Library {
        String ocrPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "java" + File.separator + "com" + File.separator + "java" + File.separator + "jna" + File.separator + "ocr";
        CLibrary INSTANCE = Native.load(ocrPath, CLibrary.class);

        int init();

        String ocr(byte[] z_bin, int ok);
    }
}
