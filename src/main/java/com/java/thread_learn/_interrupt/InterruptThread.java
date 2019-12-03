package com.java.thread_learn._interrupt;

/**
 * 通过interrupt来停止线程
 * 线程停止方式stop已废弃:释放了对象锁，导致数据不一致
 * 暂停线程 suspend[səˈspend],恢复线程 resume 会造成锁独占现象，造成死锁
 *
 * @author Gary
 * @since 2019/12/02 15:47
 */
public class InterruptThread {

    private static int num;

    public static void main(String[] args) {
        SunThread sunThread = new SunThread();
        Thread thread = new Thread(sunThread);
        thread.start();
        //设置线程优先级
        thread.setPriority(Thread.MAX_PRIORITY - 3);
        try {
            Thread.sleep(5000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    static class SunThread implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    num++;
                    //判断当前线程是否被停止,是则抛出异常
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException();
                    }
                    System.out.println("num: " + num);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("线程停止了");
            }
        }
    }
}
