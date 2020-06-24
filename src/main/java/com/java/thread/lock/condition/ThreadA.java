package com.java.thread.lock.condition;

/**
 * @author Gary
 * @since 2019-12-08 16:49
 * <p>Code is my soul.<p/>
 */
public class ThreadA extends Thread{
    private MyService service;

    public ThreadA(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
       service.await();
    }
}
