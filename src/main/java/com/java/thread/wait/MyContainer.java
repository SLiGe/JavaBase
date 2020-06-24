package com.java.thread.wait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 自定义容器,在数量达到n时停止线程
 *
 * @author Gary
 * @since 2019/12/03 09:45
 */
public class MyContainer {

    /**
     * 使用volatile效果不佳，占用cpu进行循环操作
     */
    private /*volatile*/ ArrayList list = new ArrayList();

    void add(Object o) {
        list.add(o);
    }

    int get() {
        return list.size();
    }

    public static void main(String[] args) {
        MyContainer container = new MyContainer();
        final Object lock = new Object();
        new Thread(() -> {
            System.out.println("线程1启动");
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    container.add(new Object());
                    System.out.println("i-> " + i);
                    if (container.get() == 5){
                        //通知线程2运行
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            System.out.println("线程2启动");
            synchronized (lock) {
                if (container.get() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("线程2结束");
            /*while (true) {
                if (container.get() == 5) {
                    System.out.println("线程退出");
                    break;
                }
            }*/
        }).start();
    }
}
