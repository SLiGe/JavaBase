package com.java.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * @author Gary
 * @since 2020/01/14 15:41
 */
public class SystemDemo {

    public static void main(String[] args) {
        getSystem();
        writeTxt();
        int i = Math.subtractExact(10,5);
        System.out.print(i);
    }

    private static void getSystem() {
        String property = System.getProperty("user.dir");
        System.out.println(property);
    }

    private static void writeTxt() {
        try (OutputStream outputStream = new FileOutputStream("de.txt")) {
            String data = "hello world!";
            byte[] bytes = data.getBytes(Charset.forName("UTF-8"));
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
