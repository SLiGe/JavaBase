package com.java.thread_learn._wait.pattern;

/**
 * 消费者
 *
 * @author Gary
 * @since 2019/12/04 14:03
 */
public class Consumer {

    private final Object lock;

    public Consumer(Object lock) {
        this.lock = lock;
    }

    public void getValue() {

        try {
            synchronized (lock) {
                if (ValueObject.value.equals("")) {
                    lock.wait();
                }
                System.out.println("get的值为: " + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
