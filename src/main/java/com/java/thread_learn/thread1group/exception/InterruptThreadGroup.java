package com.java.thread_learn.thread1group.exception;

/**
 * @author Gary
 * @since 2019/12/10 14:36
 */
public class InterruptThreadGroup extends ThreadGroup {

    public InterruptThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        super.uncaughtException(t, e);
        this.interrupt();
    }
}
