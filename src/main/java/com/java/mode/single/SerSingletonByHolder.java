package com.java.mode.single;

/**
 * 单例模式
 * 此方式最佳
 *
 * @author : Gary
 * @since 2019/11/07 13:59
 */
public class SerSingletonByHolder {

    /**
     * 私有化构造器，防止实例化
     */
    private SerSingletonByHolder() {
        //创建单例过程可能较慢
        System.out.println("SerSingletonByHolder is create!!!");
    }

    /**
     * 使用内部类来维护单例的实例，当SerSingletonTwo被加载时，其内部类不会被初始化，
     * 所以能保证当SerSingletonTwo被载入JVM时，SerSingletonTwo不会初始化,
     * 只有getInstance()被调用时，才会加载SerSingletonTwo,从而初始化instance
     */
    private static class SerSingletonTwoHolder {
        private static SerSingletonByHolder instance = new SerSingletonByHolder();
    }

    public static SerSingletonByHolder getInstance() {
        return SerSingletonTwoHolder.instance;
    }
}
