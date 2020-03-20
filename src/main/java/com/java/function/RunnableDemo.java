package com.java.function;

/**
 * @author zJiaLi
 * @since 2020-03-20 10:20
 */
public class RunnableDemo {

    static void startThread(Runnable runnable) {
        new Thread(runnable).start();
    }

    public static void main(String[] args) {
        /*匿名内部类*/
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "-- 运行");
            }
        });
        //lambda传参
        startThread(() -> {
            System.out.println(Thread.currentThread().getName() + "-- 运行");
        });
        startThread(() -> System.out.println(Thread.currentThread().getName() + "-- 运行"));
    }
}
