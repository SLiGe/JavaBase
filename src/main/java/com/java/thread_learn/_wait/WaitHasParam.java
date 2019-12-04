package com.java.thread_learn._wait;

/**
 * @author Gary
 * @since 2019/12/03 16:32
 */
public class WaitHasParam extends Thread {

    private final Object lock;

    private WaitHasParam(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("WaitHasParam is start !!!");
        synchronized (lock) {
            try {
                lock.wait(5000);
                System.out.println("wait  自动唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Object lock = new Object();
        WaitHasParam waitHasParam = new WaitHasParam(lock);
        waitHasParam.start();
    }
}
