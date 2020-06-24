package com.java.thread.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * synchronized同步锁锁住的是对象在堆中的实例，而不是栈中的引用
 *  synchronized锁的代码块应该业务明确
 * @author Gary
 * @since 2019/11/28 10:16
 */
public class ObjectLock1 {

    private Object obj = new Object();

    private void m1() {
        synchronized (obj) {
            System.out.println("m1 get lock!");
            while (true) {

            }
        }
    }

    private void m2() {
        synchronized (obj) {
            System.out.println("m2 get lock!");
        }
    }

    public static void main(String[] args) {
        ObjectLock1 objectLock1 = new ObjectLock1();
        new Thread(objectLock1::m1).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //修改实例，m2拿到锁
        objectLock1.obj = new Object();
        new Thread(objectLock1::m2).start();
    }
}
