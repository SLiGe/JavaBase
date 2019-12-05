package com.java.thread_learn._join;

/**
 * @author Gary
 * @since 2019/12/05 16:10
 */
public class ThreadA extends Thread {
    private final ThreadB b;
    ThreadA(ThreadB b) {
        super();
        this.b = b;
    }
    @Override
    public void run() {
        try {
            synchronized (b) {
                System.out.println("begin A ThreadName="
                        + Thread.currentThread().getName() + "  "
                        + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("  end A ThreadName="
                        + Thread.currentThread().getName() + "  "
                        + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
