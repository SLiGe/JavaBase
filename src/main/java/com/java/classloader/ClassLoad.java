package com.java.classloader;


/**
 * @author zJiaLi
 * @since 2020-07-12 12:54
 */
public class ClassLoad {

    static void loadClassByClassLoader(String className) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass(className);
        System.out.println("loadClassByClassLoader className==> " + aClass.getName());
    }

    static void loadClassByClassForName(String className) throws ClassNotFoundException {
        //初始化类
        final Class<?> aClass = Class.forName(className);
        System.out.println("loadClassByClassForName className==> " + aClass.getName());
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //不进行类的初始化
        System.out.println("========================not init=======================");
        //Class<?> aClass1 = Class.forName(className, false, systemClassLoader);
    }


    public static void main(String[] args) {
        //User user = new User();
        //String innerUserClassName = user.getClass().getName();
        try {
            System.out.println("==loadClassByClassLoader==");
            loadClassByClassLoader("com.java.classloader.User");
            System.out.println("==loadClassByClassForName==");
            loadClassByClassForName("com.java.classloader.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class User {

        private static String name = "Jack";

        {
            System.out.println("normal method");
        }

        static {
            System.out.println("InnerClassUser's static init method name:" + name);
        }
    }
}
