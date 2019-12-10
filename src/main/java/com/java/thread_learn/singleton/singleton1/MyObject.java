package com.java.thread_learn.singleton.singleton1;

/**
 * 内部类
 *
 * @author Gary
 * @since 2019/12/10 09:58
 */
public class MyObject {

    private MyObject() {
    }

    private static class MyObjectHolder {
        private static MyObject myObject = new MyObject();
    }

    public static MyObject getInstance() {
        return MyObjectHolder.myObject;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new MyThread().start();
        }
    }
    static class MyThread extends Thread {
        @Override
        public void run() {
            //System.out.println(MyObject.getInstance().hashCode());
            System.out.println(MyObject.getInstance().hashCode());
        }
    }
}
