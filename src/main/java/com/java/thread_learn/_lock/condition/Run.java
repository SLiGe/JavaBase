package com.java.thread_learn._lock.condition;

/**
 * @author Gary
 * @since 2019-12-08 16:50
 * <p>Code is my soul.<p/>
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA threadA = new ThreadA(service);
        threadA.start();
        Thread.sleep(3000);
        service.signal();
    }
}
