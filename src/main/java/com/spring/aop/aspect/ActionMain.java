package com.spring.aop.aspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zJiaLi
 * @since 2020-06-30 08:20
 */
public class ActionMain {

    @ComponentScan(value = {"com.spring.*"})
    @Configuration
    @EnableAspectJAutoProxy
    public static class ActionConfig{
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ActionConfig.class);
        AopCalculator aopCalculator = ctx.getBean(AopCalculator.class);
        aopCalculator.add(1,2);
        aopCalculator.min(3,2);
    }

}
