package com.java.thread_learn._wait.pattern;

/**
 * @author Gary
 * @since 2019/12/04 14:06
 */
public class ThreadTest {

    public static void main(String[] args) {
        final Object lock = new Object();
        new ThreadA(new Producer(lock)).start();
        new ThreadB(new Consumer(lock)).start();
    }


    static class ThreadA extends Thread {

        private Producer producer;

        ThreadA(Producer producer) {
            super();
            this.producer = producer;
        }

        @Override
        public void run() {
            while (true) {
                producer.setValue();
            }
        }
    }

    static class ThreadB extends Thread {

        private Consumer consumer;

        ThreadB(Consumer consumer) {
            super();
            this.consumer = consumer;
        }

        @Override
        public void run() {
            while (true) {
                consumer.getValue();
            }
        }
    }
}
