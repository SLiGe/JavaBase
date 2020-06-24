package com.java.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可以达到同步的效果,并且具有嗅探锁定,多路分支通知等功能
 *
 * @author Gary
 * @since 2019-12-08 16:02
 * <p>Code is my soul.<p/>
 */
public class ReentrantLockTest {
    private ReentrantLock lock = new ReentrantLock();

    public void testMethod() {
        //调用lock()代码的线程就持有了对象监视器,其他线程只有等待锁被释放时再次挣抢,
        //效果和synchronized一样,线程之间还是顺序执行的
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": i-> " + i);
        }
        //释放锁
        lock.unlock();
        System.out.println(Thread.currentThread().getName() + " 我的锁已经释放了");
    }

    public void lockMethod() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " in lock!");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " close lock!");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        test.lockMethod();
        for (int i = 0; i < 5; i++) {
            ThreadA threadA = new ThreadA(test);
            threadA.start();
        }
    }

    static class ThreadA extends Thread {

        public ThreadA(ReentrantLockTest test) {
            this.test = test;
        }

        private final ReentrantLockTest test;

        @Override
        public void run() {
            test.testMethod();
        }
    }
}
