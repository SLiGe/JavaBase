package com.java.classloader;

/**
 * @author zJiaLi
 * @since 2020-07-12 13:08
 */
public class User {
    private static String name = "Jack";
    {
        System.out.println("normal method");
    }

    private static  int a;

    static {
        System.out.println("InnerClassUser's static init method name:"+name+ " " +a);
    }

    static void initA(){
        System.out.println("method initA");
        a = 2;
    }
}
