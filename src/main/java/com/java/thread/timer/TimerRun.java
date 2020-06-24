package com.java.thread.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Gary
 * @since 2019/12/09 15:31
 */
public class TimerRun {

    private static Timer timer = new Timer();

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr = "2019-12-09 15:41:00";
        try {
            Date date = sdf.parse(dateStr);
            System.out.println("字符串时间：" + date.toLocaleString() + " 当前时间："
                    + new Date().toLocaleString());
            timer.schedule(myTask, date, 4000);
            timer.scheduleAtFixedRate(new MyTaskA(), date, 4000);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    static class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("MyTask is running! at: " + System.currentTimeMillis());
            //将任务队列的所有任务清除,有时候并不能正常停止任务,因为没有抢到queue锁
           // timer.cancel();
        }
    }

    static class MyTaskA extends TimerTask {
        @Override
        public void run() {
            System.out.println("MyTaskA is running! at: " + System.currentTimeMillis());
            //从任务队列中剔除
            //this.cancel();
        }
    }
}
