package com.java.thread.wait.communicate;

import java.io.*;

/**
 * 通过管道进行线程间通信: 字节流和字符流
 *
 * @author Gary
 * @since 2019/12/04 14:35
 */
public class StreamData {
    /**
     * 字节流
     */
    public void writeMethod(PipedOutputStream outputStream) {
        System.out.println("write by bytes: ");
        try {
            for (int i = 0; i < 50; i++) {
                String outData = "" + (i + 1);
                outputStream.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMethod(PipedInputStream inputStream) {
        System.out.println("read by bytes: ");
        byte[] bytes = new byte[20];
        try {
            int length = inputStream.read(bytes);
            while (length != -1) {
                String newData = new String(bytes, 0, length);
                System.out.print(newData);
                length = inputStream.read(bytes);
            }
            System.out.println();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流
     */
    public void writeMethodByChar(PipedWriter writer) {
        System.out.println("write by char: ");
        try {
            for (int i = 0; i < 50; i++) {
                String newData = "" + i;
                writer.write(newData);
                System.out.print(newData);
            }
            System.out.println();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMethodByChar(PipedReader reader) {
        System.out.println("read by char: ");
        try {
            char[] chars = new char[20];
            int len = reader.read(chars);
            while (len != -1) {
                String newData = String.valueOf(chars, 0, len);
                System.out.print(newData);
                len = reader.read(chars);
            }
            System.out.println();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
