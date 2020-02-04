package com.java.file;

import com.java.file.basicdb.BasicDB;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * 全局请求拦截器
 *
 * @author Gary
 * @since 2020-02-04 15:44
 * <p>Code is my soul.<p/>
 */
public class PropertiesFileObj {

    @Test
    public void getProperties() throws IOException {
        Properties properties = new Properties();

        properties.load(new FileInputStream("D:\\DevProject\\Java\\JavaBase\\src\\main\\java\\com\\java\\file\\config.properties"));
        String dbHost = properties.getProperty("db.host","127.0.0.1"); //1.key键  2.默认值
        System.out.println(dbHost);
    }

    @Test
    public void testBasicDB() throws IOException, InterruptedException {
        BasicDB db = new BasicDB("D:\\DevProject\\Java\\JavaBase\\src\\main\\java\\com\\java\\file","Student");
        db.put("Gary","35".getBytes());
        db.flush();
        TimeUnit.SECONDS.sleep(3);
        byte[] gary = db.get("Gary");
        System.out.println(Arrays.toString(gary));
        db.close();
    }
}
