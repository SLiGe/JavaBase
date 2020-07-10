package com.java.serializable;

import org.junit.Test;

import java.io.*;

/**
 * @author Gary
 * @since 2019/11/22 15:29
 */
public class TransientDe {

    /**
     * Serializable
     * 用处：
     * 1.对象状态持久化
     * 2.网络远程调用，用于传递和返回对象
     * 缺点：
     * 1.序列化后的形式比较大，浪费空间，序列化/反序列化的性能也比较低
     * 2.它是Java特有的技术，不能与其他语言交互
     */
    private static void getParentSerializable() throws Exception {
        Student student = new Student("Lucy");
        FileOutputStream fos = new FileOutputStream("student.txt");
        try (ObjectOutputStream os = new ObjectOutputStream(fos)) {
            os.writeObject(student);
            os.flush();
        }
        fos.close();
        FileInputStream fis = new FileInputStream("student.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student student2 = (Student)ois.readObject();
        ois.close();
        fis.close();
        System.out.println(student2);
    }

    public static void main(String[] args) throws Exception {
        //getParentSerializable();
        String a = "aaaa,";
        String[] split = a.split(",");
        for (String s : split) {
            System.out.println(s);
        }
    }

    @Test
    public void getSerializableObj() throws Exception {
        TransientObj obj = new TransientObj();
        obj.setAge("29");
        obj.setName("Jack");
        FileOutputStream fos = new FileOutputStream("TransientObj.txt");
        try (ObjectOutputStream os = new ObjectOutputStream(fos)) {
            os.writeObject(obj);
            os.flush();
        }
        FileInputStream fis = new FileInputStream("TransientObj.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TransientObj obj1;
        obj1 = (TransientObj) ois.readObject();
        ois.close();
        System.out.println(obj1.toString());
    }
}
