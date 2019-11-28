package com.java.thread.synchronizeds;

import java.util.concurrent.TimeUnit;

/**
 * 脏读
 *
 * @author Gary
 * @since 2019/11/26 13:32
 */
public class Account {

    private String name;

    private double money;

    private synchronized void set(String name, double money) {
        this.name = name;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.money = money;
    }

    private synchronized void get(String name) {
        System.out.println(this.name + "  " + this.money);
    }

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        new Thread(() -> {
            account.set("zhangsan", 100.00);
            /*try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }).start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> account.get("zhangsan")).start();

        TimeUnit.SECONDS.sleep(2);
        new Thread(() -> account.get("zhangsan")).start();
    }
}
