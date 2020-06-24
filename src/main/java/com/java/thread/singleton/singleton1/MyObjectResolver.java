package com.java.thread.singleton.singleton1;

import java.io.*;

/**
 * @author Gary
 * @since 2019/12/10 10:07
 */
public class MyObjectResolver implements Serializable {

    private static final long serialVersionUID = 7854168007729041710L;

    private MyObjectResolver() {
    }

    private static class MyObjectHolder {
        private static MyObjectResolver myObject = new MyObjectResolver();
    }

    public static MyObjectResolver getInstance() {
        return MyObjectHolder.myObject;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyObjectResolver myObject = MyObjectHolder.myObject;
        FileOutputStream outputStream = new FileOutputStream("MyObjectHolder.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(myObject);
        objectOutputStream.close();
        outputStream.close();
        System.out.println(myObject.hashCode());
        for (int i = 0; i < 10; i++) {
            new MyThread().start();
        }
        FileInputStream fis = new FileInputStream("MyObjectHolder.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        MyObjectResolver myObjectResolver = (MyObjectResolver) ois.readObject();
        System.out.println(myObjectResolver.hashCode());
    }

    protected Object readResolve() throws ObjectStreamException {
        System.out.println("调用了readResolve方法！");
        return MyObjectHolder.myObject;
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            //System.out.println(MyObject.getInstance().hashCode());
            System.out.println(MyObjectResolver.getInstance().hashCode());
        }
    }
}
