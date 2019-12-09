package com.java.thread_learn._lock.trylock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Gary
 * @since 2019/12/09 10:04
 */
public class ReentrantLockTry {
    private ReentrantLock lock = new ReentrantLock();

    public ReentrantLock getLock() {
        return lock;
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTry reentrantLockTry = new ReentrantLockTry();
        new Thread(reentrantLockTry::m1).start();
        Thread thread = new Thread(reentrantLockTry::m2);
        thread.start();
        new Thread(reentrantLockTry::m2).start();
        TimeUnit.SECONDS.sleep(3);
        //getQueueLength()返回正等待获取此锁定的线程数
        System.out.println("有线程数：" + reentrantLockTry.getLock().getQueueLength() + "在等待获取锁！");
        TimeUnit.SECONDS.sleep(5);
        thread.interrupt();
    }

    public void m1() {
        System.out.println("!!!已经进入m1方法!!!");
        //lock.lock();
        /*
        * tryLock()方法是有返回值的，它表示用来尝试获取锁，如果获取成功，则返回true，
        * 如果获取失败（即锁已被其他线程获取），则返回false，这个方法无论如何都会立即返回。在拿不到锁时不会一直在那等待。*/
        boolean hasLock = lock.tryLock();
        System.out.println("!!!m1->tryLock: " + hasLock + "!!!");
        try {
            System.out.println("m1 get lock!!!");
           // TimeUnit.SECONDS.sleep(5);
            Thread.sleep(8000);
            System.out.println("m1 is down!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //判断锁是否被当前线程持有
            if (lock.isHeldByCurrentThread())
                lock.unlock();
        }
    }

    public void m2() {
        System.out.println("!!!已经进入m2方法!!!");
        boolean hasLock = lock.tryLock();
        System.out.println("!!!m2->tryLock: " + hasLock + "!!!");
        try {
            /*如果当前线程未被中断，则获取锁*/
       //     lock.lock();
            lock.lockInterruptibly();
//            Thread.sleep(1);
            System.out.println("m2 is running!");
        } catch (InterruptedException e) {
            System.out.println("m2 is stop");
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread())
                lock.unlock();
        }
    }
}
