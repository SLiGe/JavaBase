package com.java.thread.singleton.singleton3;

/**
 * @author Gary
 * @since 2019/12/10 10:34
 */
public class EnumMain {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(SingletonByEnum.map.getHashMap().hashCode());
        }
    }
}
