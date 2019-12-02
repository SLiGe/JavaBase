package com.java.thread_learn._synchronized;

/**
 * 方法内部的私有变量是线程安全的
 * 方法中的变量不存在非线程安全问题,永远都是都是线程安全的,因为内部变量是私有的，不属于共有资源，属于方法栈内存
 * @author Gary
 * @since 2019/12/02 15:21
 */
public class HasSelfPrivateNum {
    private int num;

    public void addI(String username) {
        try {
            int num = 0;
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num=" + num);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public /*synchronized*/ void addI2(String username) {
        try {
            if (username.equals("a")) {
                num = 100;
                System.out.println("a set over!");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over!");
            }
            System.out.println(username + " num=" + num);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        ThreadA threadA = new ThreadA(hasSelfPrivateNum);
        threadA.start();
        ThreadB threadB = new ThreadB(hasSelfPrivateNum);
        threadB.start();
    }

    static class ThreadA extends Thread {
        private HasSelfPrivateNum selfPrivateNum;

        public ThreadA(HasSelfPrivateNum selfPrivateNum) {
            super();
            this.selfPrivateNum = selfPrivateNum;
        }

        @Override
        public void run() {
            super.run();
            selfPrivateNum.addI2("a");
        }
    }

    static class ThreadB extends Thread {
        private HasSelfPrivateNum selfPrivateNum;

        public ThreadB(HasSelfPrivateNum selfPrivateNum) {
            super();
            this.selfPrivateNum = selfPrivateNum;
        }

        @Override
        public void run() {
            super.run();
            selfPrivateNum.addI2("b");
        }
    }
}
