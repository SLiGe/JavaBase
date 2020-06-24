package com.java.thread.thread1group.exception;

/**
 * @author Gary
 * @since 2019/12/10 14:29
 */
public class MyThread extends Thread {

    private String num;

    public MyThread(String num, ThreadGroup threadGroup, String name) {
        super(threadGroup, name);
        this.num = num;
    }

    @Override
    public void run() {
        Integer.parseInt(num);
        while (this.isInterrupted() == false) {
            System.out.println("死循环中：" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ThreadGroup master = new ThreadGroup("master");
        for (int i = 0; i < 5; i++) {
            MyThread myThread = new MyThread("1", master, String.valueOf("线程 " + i));
            //myThread.start();
        }
        //加入异常线程,遇到异常不影响其他线程
        MyThread myThread = new MyThread("a", master, ("线程 error"));
        //myThread.start();
        interrupt1();
    }

    static void interrupt1(){
        InterruptThreadGroup group = new InterruptThreadGroup("我的线程组");
        MyThread[] myThread = new MyThread[10];
        for (int i = 0; i < myThread.length; i++) {
            myThread[i] = new MyThread("1", group, String.valueOf("线程 " + i));
            myThread[i].start();
        }
        MyThread newT = new MyThread("a", group, "报错线程");
        newT.start();
    }
}
