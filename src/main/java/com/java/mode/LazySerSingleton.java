package com.java.mode;

/**
 * 单例模式延迟加载
 *
 * @author : Gary
 * @since 2019/11/07 14:12
 */
public class LazySerSingleton {

    private LazySerSingleton() {
        //创建单例过程可能较慢
        System.out.println("LazySerSingleton is create!!!");
    }

    private static LazySerSingleton instance = null;

    /**
     * 一定要加上synchronized关键字
     */
    public static synchronized LazySerSingleton getInstance() {
        if (instance == null) {
            instance = new LazySerSingleton();
        }
        return instance;
    }

    public static void createString() {
        System.out.println("create string in LazySerSingleton!!");
    }
}
