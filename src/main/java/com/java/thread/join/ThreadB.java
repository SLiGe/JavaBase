package com.java.thread.join;

/**
 * @author Gary
 * @since 2019/12/05 16:10
 */
public class ThreadB extends Thread{

    @Override
    synchronized public void run() {
        try {
            System.out.println("begin B ThreadName="
                    + Thread.currentThread().getName() + "  "
                    + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("  end B ThreadName="
                    + Thread.currentThread().getName() + "  "
                    + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
