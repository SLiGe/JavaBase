package com.java.thread.lock.condition.more;

/**
 * @author Gary
 * @since 2019-12-08 17:14
 * <p>Code is my soul.<p/>
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA threadA = new ThreadA(service);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB = new ThreadB(service);
        threadB.setName("B");
        threadB.start();
        Thread.sleep(3000);
        service.signalA();
    }

    static class ThreadA extends Thread {
        private final MyService myService;

        public ThreadA(MyService myService) {
            this.myService = myService;
        }

        @Override
        public void run() {
            myService.awaitA();
        }
    }

    static class ThreadB extends Thread {
        private final MyService myService;

        public ThreadB(MyService myService) {
            this.myService = myService;
        }

        @Override
        public void run() {
            myService.awaitB();
        }
    }

}
