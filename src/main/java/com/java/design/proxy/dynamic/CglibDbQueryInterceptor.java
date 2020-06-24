package com.java.design.proxy.dynamic;

import com.java.design.proxy.DBQuery;
import com.java.design.proxy.IDBQuery;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib生成动态代理
 *
 * @author : Gary
 * @since 2019/11/08 09:57
 */
public class CglibDbQueryInterceptor implements MethodInterceptor {
    private IDBQuery real = null;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (real == null) {
            real =  new DBQuery();
        }
        return real.request();
    }

    public static IDBQuery createCglibProxy() {
        Enhancer enhancer = new Enhancer();
        //指定切入器，定义代理类逻辑
        enhancer.setCallback(new CglibDbQueryInterceptor());
        //指定实现的接口
        enhancer.setInterfaces(new Class[]{IDBQuery.class});
        //返回生成代理类的实例
        return (IDBQuery) enhancer.create();
    }
}
