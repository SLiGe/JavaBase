package com.java.thread.lock.fair;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁和非公平锁
 *
 * @author Gary
 * @since 2019-12-08 17:46
 * <p>Code is my soul.<p/>
 */
public class Service {
    private ReentrantLock lock;

    public Service(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println("ThreadName= " + Thread.currentThread().getName() + "获得锁定");
            System.out.println("getHoldCount:-> " + lock.getHoldCount());
            serviceMethod2();
        } finally {
            lock.unlock();
        }
    }
    public void serviceMethod2() {
        try {
            lock.lock();
            System.out.println("ThreadName= " + Thread.currentThread().getName() + "获得锁定");
            System.out.println("getHoldCount:-> " + lock.getHoldCount());
        } finally {
            lock.unlock();
        }
    }
}
