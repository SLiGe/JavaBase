package com.java.mode.factory;

/**
 * Rectangle 矩形，长方形
 *
 * @author Gary
 * @since 2019/11/18 16:20
 */
public class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
