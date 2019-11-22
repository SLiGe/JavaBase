package com.java.reference;

import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author Gary
 * @since 2019/11/22 09:43
 */
public class ReferenceMark {

    private static ReferenceQueue<MyObject> softQueue;

    /**
     * 强引用->{
     * 1.强引用可以直接访问目标对象
     * 2.强引用所指向的对象在任何时候都不会被系统回收，JVM宁愿抛出OOM异常，也不回收强引用所指向的对象
     * 3.强引用可能会导致内存泄漏
     * }
     */
    @Test
    public void strongReference() {
        /*局部变量sb分配在栈上，对象StringBuilder的实例分配在堆上，局部变量sb指向StringBuilder实例所在堆空间
         * 通过sb可以操作该实例，sb就是StringBuilder的引用*/
        StringBuilder sb = new StringBuilder("Hello World");
        /*
         *局部栈空间分配空间给s1,s1也是StringBuilder实例的引用*/
        StringBuilder s1 = sb;
        System.out.println(sb);
    }

    /**
     * 软引用->{
     * 1.软引用是除了强引用之外最强的引用类型
     * 2.GC在内存充足情况下不会回收软引用对象
     * 3.用来描述一些还有用但并非必须的对象。对于软引用关联着的对象，在系统将要发生内存溢出异常之前，
     * 将会把这些对象列进回收范围之中进行第二次回收。如果这次回收还没有足够的内存，才会抛出内存溢出异常。
     * }
     */
    @Test
    public void softReference() {
        MyObject obj = new MyObject(); //强引用
        softQueue = new ReferenceQueue<>(); //创建引用队列
        //创建软引用
        SoftReference<MyObject> softReference = new SoftReference<>(obj, softQueue);
        Thread thread = new Thread(new CheckRefQueue());//检查引用队列，监控对象回收情况
        thread.start();
        //删除强引用
        obj = null;
        System.gc();
        System.out.println("After GC:Soft Get= " + softReference.get());
        System.out.println("分配大块内存");
        //分配较大内存区，强迫GC
        byte[] b = new byte[4 * 1024 * 925];
        System.out.println("After new byte[]:Soft Get= " + softReference.get());
    }

    /**
     * 弱引用是比软引用较弱的引用类型在系统GC时，只要发现弱引用，不管系统堆内存是否足够，对会将对象进行回收
     * 但是，由于垃圾回收期的线程通常优先级很低，并不一定能很快地发现持有软引用的对象
     */
    @Test
    public void weakReference() {
        MyObject object = new MyObject();
        softQueue = new ReferenceQueue<MyObject>();
        Reference<MyObject> weakRef = new WeakReference<>(object, softQueue);
        Thread thread = new Thread(new CheckRefQueue());//检查引用队列，监控对象回收情况
        thread.start();
        //删除强引用
        object = null;
        System.out.println("Before FC:Weak:get = " + weakRef.get());
        System.out.println("After GC:Weak Get="+ weakRef.get());

    }

    public static class CheckRefQueue implements Runnable {
        Reference<MyObject> obj = null;

        @Override
        public void run() {
            try {
                obj = (Reference<MyObject>) softQueue.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (obj != null) {
                System.out.println("Object for SoftReference is " + obj.get());
            }
        }
    }

}
