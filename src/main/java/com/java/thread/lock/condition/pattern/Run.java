package com.java.thread.lock.condition.pattern;

/**
 * @author Gary
 * @since 2019-12-08 17:25
 * <p>Code is my soul.<p/>
 */
public class Run {
    public static void main(String[] args) {
        MyService myService = new MyService();
        Provider provider = new Provider(myService);
        Consumer consumer = new Consumer(myService);
        provider.start();
        consumer.start();
    }

    static class Provider extends Thread {
        private MyService myService;

        public Provider(MyService myService) {
            this.myService = myService;
        }


        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                myService.set();
            }
        }
    }

    static class Consumer extends Thread {
        private MyService myService;

        public Consumer(MyService myService) {
            this.myService = myService;
        }


        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                myService.get();
            }
        }
    }
}
