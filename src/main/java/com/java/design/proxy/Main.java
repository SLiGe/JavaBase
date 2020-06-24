package com.java.design.proxy;

import com.java.design.proxy.dynamic.CglibDbQueryInterceptor;
import com.java.design.proxy.dynamic.JavassistDynDbQueryHandler;
import com.java.design.proxy.dynamic.JdkDbQueryHandler;

/**
 * 主要调用者:客户端，使用代理类和主题完成一些工作
 *
 * @author : Gary
 * @since 2019/11/07 16:13
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //使用代理
        long beginTime = System.currentTimeMillis();
        IDBQuery query = new DBQueryProxy();
        System.out.println("create proxy object success!!!");
        //真正使用时才会创建真实对象,延迟加载，提升系统启动速度
        query.request();
        long endProxyTime = System.currentTimeMillis() - beginTime;
        System.out.println("使用代理模式耗时: " + endProxyTime);
        long beginComTime = System.currentTimeMillis();
        System.out.println("-----------------------分割线---------------------------");
        //直接创建真实对象
        IDBQuery idbQuery = new DBQuery();
        System.out.println("create object success!!!");
        idbQuery.request();
        long endComTime = System.currentTimeMillis() - beginComTime;
        System.out.println("直接创建真实主题耗时: " + endComTime);
        System.out.println("-----------------------分割线---------------------------");
        /*使用JDK动态代理*/
        long beginJdkProxyTime = System.currentTimeMillis();
        IDBQuery jdkProxyDbQuery = JdkDbQueryHandler.createJdkProxy();
        System.out.println("create jdkProxyDbQuery success!!!");
        jdkProxyDbQuery.request();
        long endJdkProxyTime = System.currentTimeMillis() - beginJdkProxyTime;
        System.out.println("使用JDK动态代理模式耗时: " + endJdkProxyTime);
        System.out.println("-----------------------分割线---------------------------");
        /*使用Cglib动态代理*/
        long beginCglibProxyTime = System.currentTimeMillis();
        IDBQuery cglibProxyDbQuery = CglibDbQueryInterceptor.createCglibProxy();
        System.out.println("create cglibProxyDbQuery success!!!");
        cglibProxyDbQuery.request();
        long endCglibProxyTime = System.currentTimeMillis() - beginCglibProxyTime;
        System.out.println("使用Cglib动态代理模式耗时: " + endCglibProxyTime);
        System.out.println("-----------------------分割线---------------------------");
        /*使用Javassist创建动态代理*/
        long beginJavassistProxyTime = System.currentTimeMillis();
        IDBQuery javassistProxyDbQuery = JavassistDynDbQueryHandler.createJavassistBytecodeDynamicProxy();
        System.out.println("create javassistProxyDbQuery success!!!");
        javassistProxyDbQuery.request();
        long endJavassistProxyTime = System.currentTimeMillis() - beginJavassistProxyTime;
        System.out.println("使用Javassist动态代理模式耗时: " + endJavassistProxyTime);
        System.out.println("-----------------------分割线---------------------------");
    }
}

