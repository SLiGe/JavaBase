package com.java.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Gary
 * @since 2020/01/14 15:41
 */
public class SystemDemo {

    public static void main(String[] args) {
        //getSystem();
        //writeTxt();
        testFile("C:\\Users\\Administrator\\Desktop\\healthcode\\iths\\portalweb-parent\\portalweb-server\\target");
    }

    private static void testFile(String src) {
        File file = new File(src);
        if (file.isFile()) {
            System.out.println("该路径文件");
        } else {
            System.out.println("该路径目录");
        }
    }

    private static void getSystem() {
        String property = System.getProperty("user.dir");
        System.out.println(property);
    }

    private static void writeTxt() {
        try (OutputStream outputStream = new FileOutputStream("de.txt")) {
            String data = "hello world!";
            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
