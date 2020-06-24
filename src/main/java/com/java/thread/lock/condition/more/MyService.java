package com.java.thread.lock.condition.more;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition 实现通知部分线程,
 * 应该使用多个Condition进行分组控制,而不是使用signalAll()进行唤醒WAITING线程
 *
 * @author Gary
 * @since 2019-12-08 17:05
 * <p>Code is my soul.<p/>
 */
public class MyService {

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA时间为 " + System.currentTimeMillis() + "ThreadName= " + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA时间为 "+System.currentTimeMillis() + "ThreadName= " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("begin awaitB时间为 " + System.currentTimeMillis() + "ThreadName= " + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end awaitB时间为 "+System.currentTimeMillis() + "ThreadName= " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalA(){
        try {
            lock.lock();
            System.out.println("begin signalA时间为 " + System.currentTimeMillis() + "ThreadName= " + Thread.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void signalB(){
        try {
            lock.lock();
            System.out.println("begin signalB时间为 " + System.currentTimeMillis() + "ThreadName= " + Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }

}
