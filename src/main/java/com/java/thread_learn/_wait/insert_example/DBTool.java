package com.java.thread_learn._wait.insert_example;

/**
 * 交叉备份
 *
 * @author Gary
 * @since 2019/12/04 15:25
 */
public class DBTool {

    private volatile boolean isNext = false;

    public synchronized void backupA() {
        try {
            while (isNext) {
                wait();
            }
            for (int i = 0; i < 2; i++) {
                System.out.println("★★★★★");
            }
            isNext = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void backupB() {
        try {
            while (!isNext) {
                wait();
            }
            for (int i = 0; i < 2; i++) {
                System.out.println("⭐⭐⭐⭐⭐");
            }
            isNext = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
