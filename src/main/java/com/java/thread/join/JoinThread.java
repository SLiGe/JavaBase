package com.java.thread.join;

/**
 * @author Gary
 * @since 2019/12/05 15:52
 */
public class JoinThread {

    public static void main(String[] args) {
        final Object lock = new Object();
        ThreadA threadA = new ThreadA(lock);
        ThreadA threadA1 = new ThreadA(lock);
        threadA1.start();
        try {
            //join会释放锁
            threadA1.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我在2s后运行");
        threadA.start();
    }


    static class ThreadA extends Thread {
        private final Object lock;

        ThreadA(Object lock) {
            super();
            this.lock = lock;
        }

        @Override
        public void run() {
            System.out.println("当前执行线程-> " + Thread.currentThread().getName());
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "  i -> " + i);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
