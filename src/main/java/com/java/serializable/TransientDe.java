package com.java.serializable;

import org.junit.Test;

import java.io.*;

/**
 * @author Gary
 * @since 2019/11/22 15:29
 */
public class TransientDe {

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
