package com.java.thread_learn._synchronized;

/**
 * @author Gary
 * @since 2019/11/26 14:41
 */
public class Demo2 implements Runnable {
    private int count = 10;

    /**
     * synchronized包含的代码块为原子操作，不可分
     */
    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count=" + count);
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        for (int i = 0; i < 5; i++) {
            new Thread(demo2, "Thread" + i).start();
        }
    }
}
