package com.java.thread.daemon;

/**
 * 守护线程
 * 当进程中不存在非守护线程了,则守护线程自动销毁,典型的守护线程未垃圾回收线程
 * @author Gary
 * @since 2019/12/02 14:16
 */
public class DaemonThread implements Runnable {
    private int count;

    @Override
    public void run() {
        while (true) {
            count++;
            System.out.println(count);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DaemonThread daemonThread = new DaemonThread();
        Thread thread = new Thread(daemonThread);
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);
        System.out.println("main thread exit,daemon thread exit!");
    }
}
