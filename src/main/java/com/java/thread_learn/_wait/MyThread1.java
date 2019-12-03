package com.java.thread_learn._wait;

/**
 * @author Gary
 * @since 2019/12/03 15:41
 */
public class MyThread1 extends Thread {
    private final Object lock;

    MyThread1(Object object) {
        super();
        this.lock = object;
    }

    @Override
    public void run() {
        System.out.println("开始 wait时间: " + System.currentTimeMillis());
        synchronized (lock){
            try {
                lock.wait();
                System.out.println("结束 wait时间: " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
