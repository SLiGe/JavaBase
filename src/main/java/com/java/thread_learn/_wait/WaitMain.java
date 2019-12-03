package com.java.thread_learn._wait;

import java.util.concurrent.TimeUnit;

/**
 * 1.wait()方法可以使调用该方法的线程释放共享资源的锁,然后从运行状态退出,进入等待队列,一直到被再次唤醒
 * 2.notify() 方法可以随机唤醒等待队列中等待同一共享资源的"一个"线程,并使该线程退出等待队列,进入可运行状态，
 * 也就是notify()方法仅通知"一个"线程
 * 3.notifyAll() 方法可以使所有正在等待队列中等待同一共享资源的"全部"线程从等待状态退出,进入可运行状态.
 * 此时,优先级最高的那个线程最先执行,但也有可能是随机执行,因为这要取决于JVM虚拟机的实现.
 * <p>
 * 暂停线程的集中方式-> 1.wait(会释放当前锁) 2.sleep(不会释放当前锁) 3.suspend(不会释放当前锁)
 * notify() 不立即释放锁,必须执行完notify()方法所在的同步synchronized同步代码块后才会释放
 *
 * @author Gary
 * @since 2019/12/03 15:46
 */
public class WaitMain {

    public static void main(String[] args) {
        Object lock = new Object();
        MyThread1 thread1 = new MyThread1(lock);
        MyThread2 thread2 = new MyThread2(lock);
        thread1.start();
        try {
            TimeUnit.SECONDS.sleep(2);
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
