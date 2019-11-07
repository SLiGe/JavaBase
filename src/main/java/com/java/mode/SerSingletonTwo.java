package com.java.mode;

/**
 * 单例模式
 *
 * @author : Gary
 * @since 2019/11/07 13:59
 */
public class SerSingletonTwo {

    /**
     * 私有化构造器，防止实例化
     */
    private SerSingletonTwo() {
        //创建单例过程可能较慢
        System.out.println("SerSingletonTwo is create!!!");
    }

    /**
     * 使用内部类来维护单例的实例，当SerSingletonTwo被加载时，其内部类不会被初始化，
     * 所以能保证当SerSingletonTwo被载入JVM时，SerSingletonTwo不会初始化,
     * 只有getInstance()被调用时，才会加载SerSingletonTwo,从而初始化instance
     */
    private static class SerSingletonTwoHolder {
        private static SerSingletonTwo instance = new SerSingletonTwo();
    }

    public static SerSingletonTwo getInstance() {
        return SerSingletonTwoHolder.instance;
    }
}
