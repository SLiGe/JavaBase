package com.java.file;

/**
 * @author Gary
 * @since 2020/01/14 15:41
 */
public class SystemDemo {

    public static void main(String[] args) {
        getSystem();
    }

    static void getSystem(){
        String property = System.getProperty("user.dir");
        System.out.println(property);
    }
}
