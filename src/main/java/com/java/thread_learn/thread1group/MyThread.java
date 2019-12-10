package com.java.thread_learn.thread1group;

/**
 * 批量停止线程组
 * @author Gary
 * @since 2019/12/10 14:02
 */
public class MyThread extends Thread {

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        System.out.println("ThreadName=" + Thread.currentThread().getName()
                + "准备开始死循环了：)");
        while (!this.isInterrupted()) {
        }
        System.out.println("ThreadName=" + Thread.currentThread().getName()
                + "结束了：)");
    }

    public static void main(String[] args) {
        try {
            ThreadGroup group = new ThreadGroup("我的线程组");
            for (int i = 0; i < 5; i++) {
                MyThread thread = new MyThread(group, "线程" + (i + 1));
                thread.start();
            }
            Thread.sleep(5000);
            group.interrupt();
            System.out.println("调用了interrupt()方法");
        } catch (InterruptedException e) {
            System.out.println("停了停了！");
            e.printStackTrace();
        }
    }
}
