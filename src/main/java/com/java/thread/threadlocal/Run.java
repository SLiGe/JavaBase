package com.java.thread.threadlocal;

/**
 * @author Gary
 * @since 2019-12-08 15:43
 * <p>Code is my soul.<p/>
 */
public class Run {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在线程Main线程中取值= " + Tools.t1.get());
                Thread.sleep(100);
            }
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadA threadA = new ThreadA();
        threadA.start();
        //Tools.t1.set("我被再次重置了!");
    }

    static class ThreadA extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("在线程ThreadA线程中取值= " + Tools.t1.get());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
