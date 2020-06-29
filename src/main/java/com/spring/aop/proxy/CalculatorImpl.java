package com.spring.aop.proxy;

/**
 * @author zJiaLi
 * @since 2020-06-29 20:54
 */
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
