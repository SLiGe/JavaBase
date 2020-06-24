package com.java.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  读写锁表示有两个锁,一个是读操作锁->共享锁,写操作锁-> 排他锁
 *  多个读锁之间不互斥,读锁与写锁互斥,写锁与写锁互斥。
 * @author Gary
 * @since 2019/12/09 14:59
 */
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) {
        Service service = new Service();
        new Thread(service::write).start();
        new Thread(service::read).start();
        new Thread(service::read).start();
    }

    static class Service {
        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public void read(){
            lock.readLock().lock();
            try {
                System.out.println("获得读锁" + Thread.currentThread().getName()
                        + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.readLock().unlock();
            }
        }

        public void write(){
            lock.writeLock().lock();
            try {
                System.out.println("获得写锁" + Thread.currentThread().getName()
                        + " " + System.currentTimeMillis());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.writeLock().unlock();
            }
        }
    }
}
