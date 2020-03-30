package com.java.date;

import java.util.Calendar;
import java.util.Date;

/**
 * @author zJiaLi
 * @since 2020-03-25 10:19
 */
public class GetDate {
    public static void main(String[] args) {
        GetDate getDate = new GetDate();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(() -> {

                Date startTime = null;
                for (int j = 0; j < 20; j++) {
                    startTime = getDate.getStartTime();
                }
                System.out.println(Thread.currentThread().getName());
                System.out.println(startTime);
            });
            threads[i] = t1;
        }

        for (Thread thread : threads) {
            thread.start();
        }

    }

    public Date getStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }
}
