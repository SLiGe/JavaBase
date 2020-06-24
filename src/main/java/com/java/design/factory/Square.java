package com.java.design.factory;

/**
 * Square 正方形
 *
 * @author Gary
 * @since 2019/11/18 16:22
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
