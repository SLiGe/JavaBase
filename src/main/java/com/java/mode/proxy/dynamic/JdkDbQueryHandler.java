package com.java.mode.proxy.dynamic;

import com.java.mode.proxy.DBQuery;
import com.java.mode.proxy.IDBQuery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 * 使用JDK的动态代理生成代理对象，替代DBQueryProxy
 *
 * @author : Gary
 * @since 2019/11/08 09:36
 */
public class JdkDbQueryHandler implements InvocationHandler {

    /**
     * 主题接口
     */
    IDBQuery real = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (real == null) {
            //如果是第一次调用，则生成真实对象
            real = new DBQuery();
        }
        //使用真实主题完成实际操作
        return real.request();
    }

    public static IDBQuery createJdkProxy() {
        //返回代理类的实例
        return (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader()
                , new Class[]{IDBQuery.class}
                , new JdkDbQueryHandler());
    }
}
