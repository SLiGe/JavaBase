package com.java.reference;

/**
 * @author Gary
 * @since 2019/11/22 09:57
 */
public class MyObject {

    @Override
    public String toString() {
        return "I'm MyObject";
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        //被回收时输出
        System.out.println("MyObject's finalize called");
    }

}
