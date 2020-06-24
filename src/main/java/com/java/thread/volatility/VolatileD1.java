package com.java.thread.volatility;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Gary
 * @since 2019/11/27 11:28
 */
public class VolatileD1 {

    /**
     * volatile保证变量多线程可见性,刷新缓冲区 ps:不会保证原子性
     * JMM
     */
    private /*volatile*/ static boolean run = true;

    /**
     * 原子Integer,在多线程情况下，不一定保证原子性
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private void m2() {
        for (int i = 0; i < 10; i++) {
            //当thread-1拿到atomicInteger为1000时，thread_learn-2进行了atomicInteger自增为1001
//            if (atomicInteger.get() < 1000)
                atomicInteger.incrementAndGet();
        }
        System.out.println("atomicInteger: " + atomicInteger);
    }

    private void m1() {
        System.out.println("m1 is running!!!");
        while (run) {

        }
        System.out.println("m1 is down!!!");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileD1 d1 = new VolatileD1();
        for (int i = 0; i < 1000; i++) {
            new Thread(d1::m2).start();
        }

        //TimeUnit.SECONDS.sleep(2);
        //run = false;
    }
}
