package com.java.thread.lock;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Gary
 * @since 2019/12/09 14:14
 */
public class AwaitUntilTest {

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        WaitThread waitThread = new WaitThread(service);
        waitThread.start();
        Thread.sleep(3000);
        new NotifyThread(service).start();
    }

    static class NotifyThread extends Thread {
        private Service service;

        public NotifyThread(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.notifyMethod();
        }
    }

    static class WaitThread extends Thread {
        private Service service;

        public WaitThread(Service service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.waitMethod();
        }
    }

    static class Service {
        private ReentrantLock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void waitMethod() {
            lock.lock();
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 10);
            try {
                System.out.println("wait start time: " + System.currentTimeMillis());
                condition.awaitUntil(calendar.getTime());
                System.out.println("wait end time: " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread())
                    lock.unlock();
            }
        }

        public void notifyMethod() {
            lock.lock();
            try {
                System.out.println("notify start time: " + System.currentTimeMillis());
                condition.signalAll();
                System.out.println("notify end time: " + System.currentTimeMillis());
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }

        }
    }
}
