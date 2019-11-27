package com.java.thread.sychronized;

import java.util.concurrent.TimeUnit;

/**
 * 死锁
 * for ->
 *   lock1方法内先获取到o1的锁，在获取o2的锁
 *   lock2方法内先获取到o2的锁，在获取o1的锁
 *   当lock1要去获取o2时，此时lock2在持有该锁，并且没有释放，lock1就一直在等待o2的锁
 *   lock2则相反
 *
 *   产生死锁的必要条件：{
 *          1. 互斥条件：进程要求对所分配的资源进行排它性控制，即在一段时间内某资源仅为一进程所占用。
 *          2.请求和保持条件：当进程因请求资源而阻塞时，对已获得的资源保持不放。
 *          3.不剥夺条件：进程已获得的资源在未使用完之前，不能剥夺，只能在使用完时由自己释放。
 *          4.环路等待条件：在发生死锁时，必然存在一个进程--资源的环形链。
 *   }
 * 预防死锁{
 *     1.资源一次性分配：一次性分配所有资源，这样就不会再有请求了：（破坏请求条件）
 *     2.只要有一个资源得不到分配，也不给这个进程分配其他的资源：（破坏请保持条件）
 *     3.可剥夺资源：即当某进程获得了部分资源，但得不到其它资源，则释放已占有的资源（破坏不可剥夺条件）
 *     4.资源有序分配法：系统给每类资源赋予一个编号，每一个进程按编号递增的顺序请求资源，释放则相反（破坏环路等待条件）
 * }
 * @author Gary
 * @since 2019/11/27 08:44
 */
public class DeadLockThread {

    private final Object o1 = new Object();
    private final Object o2 = new Object();

    private void lock1() {

        synchronized (o1) {
            System.out.println("lock1 is get o1's lock");
            /*try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            synchronized (o2) {
                System.out.println("lock1 is get o2's lock");
            }
        }

    }

    private void lock2() {
        synchronized (o2) {
            System.out.println("lock2 is get o2's lock");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1) {
                System.out.println("lock2 is get o1's lock");
            }
        }

    }

    private void lock3(){
        synchronized (o1){
            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DeadLockThread deadLockThread = new DeadLockThread();
        //new Thread(deadLockThread::lock3).start();
        for (int i = 0; i < 10; i++) {

            new Thread(deadLockThread::lock1).start();
            new Thread(deadLockThread::lock2).start();
        }
    }
}
