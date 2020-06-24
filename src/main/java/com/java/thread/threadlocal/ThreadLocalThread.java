package com.java.thread.threadlocal;

/**
 * ThreadLocal解决的是变量在不同线程间的隔离性,也就是不同线程拥有自己的值,不同线程的值是可以放入ThreadLocal类中进行保存的
 *
 * @author Gary
 * @since 2019-12-08 12:06
 * <p>Code is my soul.<p/>
 */
public class ThreadLocalThread {
    private static ThreadLocal<Object> t1 = new ThreadLocal<>();
    private static ThreadLocalExt t2 = new ThreadLocalExt();

    static class ThreadA extends Thread {
        @Override
        public void run() {
            if (t1.get() == null) {
                System.out.println(Thread.currentThread().getName() + "ThreadLocal现在还没有值");
                t1.set(Thread.currentThread().getName() + ": " + System.currentTimeMillis());
            }
            System.out.println(Thread.currentThread().getName() + " ThreadLocal-> " + t1.get());
            System.out.println(Thread.currentThread().getName() + " ThreadLocal-> " + t1.get());
            System.out.println(Thread.currentThread().getName() + " ThreadLocalExt-> " + t2.get());
        }
    }

    /**
     * 测试默认值
     */
    static class ThreadB extends Thread {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " ThreadLocal默认值->" + t2.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new ThreadA();
        Thread thread1 = new ThreadB();
        thread.start();
        Thread.sleep(3000);
        thread1.start();
        Thread.sleep(3000);
        ThreadLocalThread.t1.set(Thread.currentThread().getName() + ": " + System.currentTimeMillis());
        System.out.println(Thread.currentThread().getName() + "ThreadLocal-> " + ThreadLocalThread.t1.get());
        System.out.println(Thread.currentThread().getName() + "ThreadLocalExt-> " + ThreadLocalThread.t2.get());
    }
}
