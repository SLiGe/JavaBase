package com.java.file;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Gary
 * @since 2020/01/07 11:24
 */
public class FileReadObj {

    public static void main(String[] args) throws IOException {
        String path = "E:\\电子书\\Java编程的逻辑.pdf";

        File file = new File(path);
        System.out.println(file.getCanonicalPath());
        File file2 = new File("C:\\Users\\Administrator\\Desktop\\bb.bmp");
        try (FileInputStream inputStream = new FileInputStream(file); FileOutputStream outputStream = new FileOutputStream(file2)) {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes, 0, bytes.length)) > 0) {
                outputStream.write(bytes, 0, len);
            }
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(format);
            /*try (DataInputStream dataInputStream = new DataInputStream(inputStream); DataOutputStream dataOutputStream = new DataOutputStream(outputStream)) {
                byte[] bytes = new byte[1024];
                int len;
                while ((len = dataInputStream.read(bytes, 0, bytes.length)) != -1) {
                    dataOutputStream.write(bytes, 0, len);
                }
            }*/
        //}
    }
}
