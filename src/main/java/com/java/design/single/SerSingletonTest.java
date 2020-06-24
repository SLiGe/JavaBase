package com.java.design.single;

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
        ois.close();
        //如果将readResolve去除，则会实例化多个对象，加上本方法会阻止实例化，返回源对象
        Assert.assertEquals(s, s1);
    }

    @Test
    public void testCreateSerSingletonTime() {
        long beginTime = System.currentTimeMillis();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                SerSingletonByHolder.getInstance();
            }
            System.out.println(System.currentTimeMillis() - beginTime);
        });
        thread.setDaemon(false);
        thread.start();
    }

    @Test
    public void testLazySerSingleton() {
        LazySerSingleton.createString();
    }

    @Test
    public void testCommonSerSingleton() {
        SerSingletonOne.createString();
    }
}
