package com.java.thread_learn._lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Gary
 * @since 2019/12/09 13:58
 */
public class AwaitUnInterruptibly {

    public static void main(String[] args) throws InterruptedException {
        IService service = new IService();
        InThread inThread = new InThread(service);
        inThread.start();
        TimeUnit.SECONDS.sleep(3);
        inThread.interrupt();
    }

    static class InThread extends Thread {
        private IService service;

        public InThread(IService service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.awaitMethod();
        }
    }

    static class IService {
        private ReentrantLock lock = new ReentrantLock();

        private Condition condition = lock.newCondition();

        public void awaitMethod() {
            System.out.println("!!!in awaitMethod!!!");
            lock.lock();
            try {
                //condition.await();
                TimeUnit.MILLISECONDS.sleep(1000);
                condition.awaitUninterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }
    }
}
