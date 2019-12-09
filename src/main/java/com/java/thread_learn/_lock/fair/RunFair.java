package com.java.thread_learn._lock.fair;

/**
 * @author Gary
 * @since 2019-12-08 17:48
 * <p>Code is my soul.<p/>
 */
public class RunFair {
    public static void main(String[] args) {
        /*
         * 公平锁:线程顺序获得锁 , synchronized是非公平锁🔒
         * 非公平锁:线程随机获得锁*/
        final Service service = new Service(false);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            Thread thread = new Thread(service::serviceMethod);
            threads[i] = thread;
        }
        for (Thread thread : threads) {
            thread.start();
        }

    }
}
