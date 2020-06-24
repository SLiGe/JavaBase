package com.java.design.factory;

/**
 * Circle 圆
 *
 * @author Gary
 * @since 2019/11/18 16:22
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
