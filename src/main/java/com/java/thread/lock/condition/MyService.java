package com.java.thread.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition可以实现线程的等待和通知
 *
 * @author Gary
 * @since 2019-12-08 16:45
 * <p>Code is my soul.<p/>
 */
public class MyService {

    private Lock lock = new ReentrantLock();

    public Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();
            System.out.println("await时间为 " + System.currentTimeMillis());
            //拿到lock对象监视器才能进行await,状态为WAITING
            condition.await();//相当于Object的wait()方法
            //condition.await(3, TimeUnit.SECONDS);//相当于Object的wait(long timeout)方法
            System.out.println("await再次拿到lock " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println(" signal时间为 " + System.currentTimeMillis());
            //唤醒WAITING线程,signal()相当于Object的notify()方法,signalALL()=>notifyAll()
            condition.signal();
        } finally {
            lock.unlock();
        }

    }
}
