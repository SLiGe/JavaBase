package com.java.mode;


import java.io.Serializable;

/**
 * 单例模式学习
 * 场景:单例对象串行化
 *
 * @author : Gary
 * @since 2019/11/07 11:43
 */
public class SerSingleton implements Serializable {

    String name;

    /**
     * 私有化构造器,无法对本对象进行实例化(不包含反射->极端方法)
     */
    private SerSingleton() {
        //创建单例的过程比较慢
        System.out.println("SerSingleton is create!!");
        name = "SerSingleton";
    }

    private static SerSingleton instance = new SerSingleton();

    public static SerSingleton getInstance() {
        return instance;
    }

    public static void createString() {
        System.out.println("create string in SerSingleton");
    }

    /**
     * 阻止生成新的实例，返回当前对象
     */
    private Object readResolve() {
        return instance;
    }

}
