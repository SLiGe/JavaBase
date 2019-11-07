package com.java.mode;

/**
 * @author : Gary
 * @since 2019/11/07 14:17
 */
public class SerSingletonOne {
    private SerSingletonOne() {
        //创建单例过程可能较慢
        System.out.println("SerSingletonOne is create!!!");
    }

    private static SerSingletonOne instance = new SerSingletonOne();

    public static SerSingletonOne getInstance() {
        return instance;
    }

    public static void createString() {
        System.out.println("create string in LazySerSingleton!!");
    }
}
