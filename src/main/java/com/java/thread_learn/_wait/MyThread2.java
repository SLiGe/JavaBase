package com.java.thread_learn._wait;

/**
 * @author Gary
 * @since 2019/12/03 15:44
 */
public class MyThread2 extends Thread {

    private final Object lock;

    MyThread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("开始 notify时间: " + System.currentTimeMillis());
        synchronized (lock) {
            lock.notify();
            System.out.println("结束 notify时间: " + System.currentTimeMillis());
        }
    }
}
