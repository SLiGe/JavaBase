package com.java.mode.proxy;

/**
 * 主要调用者:客户端，使用代理类和主题完成一些工作
 *
 * @author : Gary
 * @since 2019/11/07 16:13
 */
public class Main {

    public static void main(String[] args) {
        //使用代理
        long beginTime = System.currentTimeMillis();
        IDBQuery query = new DBQueryProxy();
        System.out.println("create proxy object success!!!");
        //真正使用时才会创建真实对象,延迟加载，提升系统启动速度
        query.request();
        long endProxyTime = System.currentTimeMillis() - beginTime;
        System.out.println("使用代理模式耗时: " + endProxyTime);
        long beginComTime = System.currentTimeMillis();
        //直接创建真实对象
        IDBQuery idbQuery = new DBQuery();
        System.out.println("create object success!!!");
        idbQuery.request();
        long endComTime = System.currentTimeMillis() - beginComTime;
        System.out.println("不使用代理模式耗时: " + endComTime);

    }
}

