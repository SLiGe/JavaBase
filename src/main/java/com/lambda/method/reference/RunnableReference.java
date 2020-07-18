package com.lambda.method.reference;

/**
 * 方法引用与 Runnable 接口的结合使用
 *
 * @author zJiaLi
 * @since 2020-07-18 18:58
 */
public class RunnableReference {

    static class Go {
        static void go() {
            System.out.println("Go::go");
        }
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class");
            }
        }).start();

        new Thread(() -> {
            System.out.println("Lambda");
        }).start();
        //Runnable
        new Thread(Go::go).start();
    }
}
