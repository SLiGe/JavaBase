package com.java.thread_learn.singleton.singleton2;

/**
 * @author Gary
 * @since 2019/12/10 10:18
 */
public class StaticSingleton {
    private static StaticSingleton instance = null;

    /*
     * 静态代码块的代码在使用类的时候就已经执行了,
     * */
    static {
        instance = new StaticSingleton();
    }

    private StaticSingleton() {
    }

    public static StaticSingleton getInstance() {
        return instance;
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(StaticSingleton.getInstance().hashCode());
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new MyThread().start();
        }
    }
}
