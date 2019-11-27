package com.java.thread.volatiles;

import java.util.concurrent.TimeUnit;

/**
 * @author Gary
 * @since 2019/11/27 11:28
 */
public class VolatileD1 {

    /**
     * volatile保证变量多线程可见性,刷新缓冲区
     * JMM
     */
    private /*volatile*/ static boolean run = true;

    private  void m1() {
        System.out.println("m1 is running!!!");
        while (run) {

        }
        System.out.println("m1 is down!!!");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileD1 d1 = new VolatileD1();
        new Thread(d1::m1).start();

        TimeUnit.SECONDS.sleep(2);
        run = false;
    }
}
