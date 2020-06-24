package com.java.thread.wait.pattern;

/**
 * 生产者
 *
 * @author Gary
 * @since 2019/12/04 13:57
 */
public class Producer {

    private final Object lock;

    public Producer(Object lock) {
        this.lock = lock;
    }

    public void setValue() {

        try {
            synchronized (lock) {
                if (!ValueObject.value.equals("")) {
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set的值为: " +value);
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
