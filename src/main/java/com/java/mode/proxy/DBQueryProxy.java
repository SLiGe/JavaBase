package com.java.mode.proxy;

/**
 * 代理类：用来代理和封装真是主题
 * 轻量级对象，创建很快
 *
 * @author : Gary
 * @since 2019/11/07 16:09
 */
public class DBQueryProxy implements IDBQuery {

    private DBQuery real = null;

    @Override
    public String request() {
        //在真正需要时才会创建对象，创建过程可能很慢
        if (real == null) {
            real = new DBQuery();
        }
        //在多线程环境下，这里返回一个虚假类。类似Future模式
        return real.request();
    }
}
