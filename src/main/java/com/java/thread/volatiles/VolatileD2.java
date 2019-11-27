package com.java.thread.volatiles;

/**
 * @author Gary
 * @since 2019/11/27 14:27
 */
public class VolatileD2 {

    private volatile int count = 10;

    private /*synchronized*/ void sub() {
        for (int i = 0; i < 10; i++) {
            count += 1;
        }
        System.out.println("count: " + count);
    }

    public static void main(String[] args) {
        VolatileD2 d2 = new VolatileD2();
        for (int i = 0; i < 500; i++) {
            new Thread(d2::sub).start();
        }
       // System.out.println(d2.count);
    }
}
