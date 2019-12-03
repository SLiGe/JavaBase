package com.java.thread_learn._volatile;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 外练互斥,内修可见
 *
 * @author Gary
 * @since 2019/12/03 15:07
 */
public class AtomicService {
    private static AtomicLong atomicLong = new AtomicLong();

    private synchronized void addNum() {
        System.out.println(Thread.currentThread().getName() + " 加了100后的值: " + atomicLong.addAndGet(100));
        atomicLong.addAndGet(1);
    }

    static class AtomicThread extends Thread {
        private AtomicService atomicService;

        AtomicThread(AtomicService atomicService) {
            super();
            this.atomicService = atomicService;
        }

        @Override
        public void run() {
            super.run();
            atomicService.addNum();
        }
    }

    public static void main(String[] args) {
        try {
            AtomicService atomicService = new AtomicService();
            AtomicThread[] atomicThreads = new AtomicThread[5];
            for (int i = 0; i < atomicThreads.length; i++) {
                atomicThreads[i] = new AtomicThread(atomicService);
            }
            for (AtomicThread atomicThread : atomicThreads) {
                atomicThread.start();
            }
            Thread.sleep(1000);
            System.out.println(AtomicService.atomicLong.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
