package com.java.thread.synchronizeds;

/**
 * @author Gary
 * @since 2019/11/26 13:04
 */
public class Demo1 {

    private static int count = 10;
    /**
     * 对象锁
     */
    private final Object object = new Object();

    private void m1() {
        System.out.println(Thread.currentThread().getName() + " is running!");
        /*对object进行上锁，当前线程需要拿到object的锁才能运行，锁的是对象而不是代码块*/
        synchronized (object) {
            count++;
            System.out.println(count);
        }
    }

    private void m2() {
        System.out.println(Thread.currentThread().getName() + " is running!");
        synchronized (this) {
            count++;
            System.out.println(count);
        }
    }

    private synchronized void m3() {
        /*
         * 在同步方法内可以调用其他同步锁，重用申请到的锁*/
        m2();
        System.out.println(Thread.currentThread().getName() + " is running!");
        count++;
    }

    /**
     * 修饰静态方法，对某个对象加锁
     */
    private static synchronized void m4() {
        count++;
        System.out.println(count);
    }

    public static void m5() {
        synchronized (Demo1.class) {
            System.out.println(Thread.currentThread().getName() + " is running!");
            count++;
        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        for (int i = 0; i < 10; i++) {
            //new Thread(demo1::m1).start();
            // new Thread(demo1::m2).start();
            new Thread(Demo1::m4).start();
        }
    }
}
