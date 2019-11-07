package com.java.mode;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * @author : Gary
 * @since 2019/11/07 13:47
 */
public class SerSingletonTest {

    @Test
    public void testSerSingleton() throws Exception {
        SerSingleton s = null;
        SerSingleton s1 = SerSingleton.getInstance();
        //将实例串行化写到文件
        FileOutputStream fos = new FileOutputStream("SerSingleton.txt");
        try (ObjectOutputStream os = new ObjectOutputStream(fos)) {
            os.writeObject(s1);
            os.flush();
        }
        FileInputStream fis = new FileInputStream("SerSingleton.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        s = (SerSingleton) ois.readObject();
        Assert.assertEquals(s, s1);
    }

    @Test
    public void testCreateSerSingletonTime() {
        long beginTime = System.currentTimeMillis();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                SerSingletonTwo.getInstance();
            }
            System.out.println(System.currentTimeMillis() - beginTime);
        }).run();

    }
}
