package com.java.thread_learn._wait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 使用CountDownLatch进行线程通知,替代notify/wait
 *
 * @author Gary
 * @since 2019/12/05 11:18
 */
public class CountDownLatchTest {

    volatile List<Object> list = new ArrayList<>();

    void add(int i) {
        list.add(i);
    }

    int get() {
        System.out.println("当前size: " + list.size());
        return list.size();
    }

    public static void main(String[] args) {
        CountDownLatchTest latchTest = new CountDownLatchTest();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            System.out.println("Add Thread start!!!");
            for (int i = 0; i < 10; i++) {
                latchTest.add(i);
                if (latchTest.get() == 5) {
                    countDownLatch.countDown();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            System.out.println("Check Thread start!!!");
            try {
                if (latchTest.get() != 5) {
                    countDownLatch.await();
                }
                System.out.println("Check Thread stop");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
