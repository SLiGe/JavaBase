package com.java.thread_learn._threadlocal;

/**
 * InheritableThreadLocal可以在子线程取得父线程继承下来的值
 * PS:如果子线程在取值的同时,主线程将InheritableThreadLocal中的值进行更改,那么线程取到的还是旧值
 * (子线程只是从主线程的ThreadLocal复制了一份?)
 *
 * @author Gary
 * @since 2019-12-08 15:40
 * <p>Code is my soul.<p/>
 */
public class InheritableThreadLocalExt extends InheritableThreadLocal {


    /**
     * 初始化值
     */
    @Override
    protected Object initialValue() {
        return System.currentTimeMillis();
    }

    /**
     * 继承父线程值时,对该值进一步处理
     */
    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + " 我是子线程加的!-_-!";
    }
}
