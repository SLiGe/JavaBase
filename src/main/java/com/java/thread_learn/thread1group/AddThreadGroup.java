package com.java.thread_learn.thread1group;

/**
 * @author Gary
 * @since 2019/12/10 13:55
 */
public class AddThreadGroup {
    public static void main(String[] args) {
        System.out.println("线程组名称："
                + Thread.currentThread().getThreadGroup().getName());
        System.out.println("线程组中活动的线程数量："
                + Thread.currentThread().getThreadGroup().activeCount());
        System.out.println("线程组中线程组的数量-加之前："
                + Thread.currentThread().getThreadGroup().activeGroupCount());
        ThreadGroup newGroup = new ThreadGroup(Thread.currentThread()
                .getThreadGroup(), "newGroup");
        System.out.println("线程组中线程组的数量-加之后："
                + Thread.currentThread().getThreadGroup().activeGroupCount());
        System.out
                .println("父线程组名称："
                        + Thread.currentThread().getThreadGroup().getParent()
                        .getName());
    }
}
