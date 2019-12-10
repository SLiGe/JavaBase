package com.java.thread_learn.thread1group;

/**
 * @author Gary
 * @since 2019/12/10 13:51
 */
public class Run {
    public static void main(String[] args) {
        // 方法activeGroupCount()取得当前线程组对象中的子线程组数量
        // 方法enumerate()的作用是将线程组中的子线程组以复制的形式
        // 拷贝到ThreadGroup[]数组对象中
        System.out.println("A处线程：" + Thread.currentThread().getName()
                + " 所属的线程组名为："
                + Thread.currentThread().getThreadGroup().getName() + " "
                + " 中有线程组数量："
                + Thread.currentThread().getThreadGroup().activeGroupCount());
        ThreadGroup group = new ThreadGroup("新的组");// 自动加到main组中
        ThreadGroup group1 = new ThreadGroup("新的组1");// 自动加到main组中
        System.out.println("B处线程：" + Thread.currentThread().getName()
                + " 所属的线程组名为："
                + Thread.currentThread().getThreadGroup().getName() + " "
                + " 中有线程组数量："
                + Thread.currentThread().getThreadGroup().activeGroupCount());

        ThreadGroup[] threadGroup = new ThreadGroup[Thread.currentThread()
                .getThreadGroup().activeGroupCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadGroup);
        for (int i = 0; i < threadGroup.length; i++) {
            System.out.println("第一个线程组名称为：" + threadGroup[i].getName());
        }
        //获取根线程组,main线程组的父线程组是system
        System.out.println("线程：" + Thread.currentThread().getName()
                + " 所在的线程组名为："
                + Thread.currentThread().getThreadGroup().getName());
        System.out
                .println("main线程所在的线程组的父线程组的名称是："
                        + Thread.currentThread().getThreadGroup().getParent()
                        .getName());
        System.out.println("main线程所在的线程组的父线程组的父线程组的名称是："
                + Thread.currentThread().getThreadGroup().getParent()
                .getParent().getName());
    }
}
