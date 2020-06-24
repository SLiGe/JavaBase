package com.java.thread.singleton.singleton0;

/**
 * @author Gary
 * @since 2019/12/09 16:21
 */
public class MyObject {
    private MyObject() {
    }

    //立即加载 = 饿汉模式
    private static MyObject myObject = new MyObject();

    //延迟加载 = 懒汉模式
    private static MyObject myObject2;

    //DoubleCheck双检机制
    private volatile static MyObject myObject3;

    // DCL:使用双检测机制来解决问题，既保证了不需要同步代码的异步执行性
    // 又保证了单例的效果
    public static MyObject getMyObject3() {
        if (myObject3 == null) {
            synchronized (MyObject.class) {
                if (myObject3 == null) {
                    myObject3 = new MyObject();
                }
            }
        }
        return myObject3;
    }

    public synchronized static MyObject getMyObject2() {
        if (myObject2 == null)
            myObject2 = new MyObject();
        return myObject2;
    }

    public static MyObject getInstance() {
        // 此代码版本为立即加载
        // 此版本代码的缺点是不能有其他实例变量
        // 因为getInstance()方法没有同步
        // 所以有可能出现非线程安全问题
        return myObject;
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            //System.out.println(MyObject.getInstance().hashCode());
            System.out.println(MyObject.getMyObject3().hashCode());
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}
