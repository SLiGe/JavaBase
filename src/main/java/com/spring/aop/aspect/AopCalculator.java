package com.spring.aop.aspect;

import org.springframework.stereotype.Component;

/**
 * @author zJiaLi
 * @since 2020-06-30 08:01
 */
@Component
public class AopCalculator {

    @Action
    public int add(int a, int b) {
        return a + b;
    }

    public int min(int a, int b) {
        return a - b;
    }
}
