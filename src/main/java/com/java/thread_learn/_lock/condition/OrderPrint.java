package com.java.thread_learn._lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 顺序打印
 *
 * @author Gary
 * @since 2019/12/09 14:34
 */
public class OrderPrint {
    private static volatile int nextPrintWho = 1;
    final private static ReentrantLock lock = new ReentrantLock();
    final private static Condition condition1 = lock.newCondition();
    final private static Condition condition2 = lock.newCondition();
    final private static Condition condition3 = lock.newCondition();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                if (nextPrintWho != 1) {
                    condition1.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("Thread1 i=" + i);
                }
                nextPrintWho = 2;
                condition2.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread())
                    lock.unlock();
            }
        });
        Thread thread2 = new Thread(() -> {
            lock.lock();
            try {
                if (nextPrintWho != 2) {
                    condition2.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("Thread2 i=" + i);
                }
                nextPrintWho = 3;
                condition3.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread())
                    lock.unlock();
            }
        });
        Thread thread3 = new Thread(() -> {
            lock.lock();
            try {
                if (nextPrintWho != 3) {
                    condition3.await();
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("Thread3 i=" + i);
                }
                nextPrintWho = 1;
                condition1.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread())
                    lock.unlock();
            }
        });
        Thread[] aArray = new Thread[5];
        Thread[] bArray = new Thread[5];
        Thread[] cArray = new Thread[5];
        for (int i = 0; i < 5; i++) {
            aArray[i] = new Thread(thread1);
            bArray[i] = new Thread(thread2);
            cArray[i] = new Thread(thread3);
            aArray[i].start();
            bArray[i].start();
            cArray[i].start();
        }
    }
}
