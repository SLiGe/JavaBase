package com.java.thread_learn._threadlocal;

/**
 * 解决ThreadLocal返回null
 *
 * @author Gary
 * @since 2019-12-08 15:27
 * <p>Code is my soul.<p/>
 */
public class ThreadLocalExt extends ThreadLocal<java.lang.Object> {


    /**
     * 初始化默认值
     */
    @Override
    protected Object initialValue() {
        return System.currentTimeMillis();
    }
}
