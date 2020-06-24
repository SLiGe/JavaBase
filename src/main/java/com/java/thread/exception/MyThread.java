package com.java.thread.exception;

/**
 * 捕获线程异常
 *
 * @author Gary
 * @since 2019/12/10 14:22
 */
public class MyThread extends Thread {
    private String name;

    @Override
    public void run() {
        System.out.println(name.hashCode());
    }

    public static void main(String[] args) {
        MyThread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("线程 " + t.getName() + " 出现异常");
            e.printStackTrace();
        });
        MyThread myThread = new MyThread();
        MyThread myThread1 = new MyThread();
        /*myThread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("线程 " + t.getName() + " 出现异常");
            e.printStackTrace();
        });*/
        myThread.start();
        myThread1.start();
    }
}
