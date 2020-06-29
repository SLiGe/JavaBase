package com.spring.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zJiaLi
 * @since 2020-06-29 20:55
 */
public class CalculatorProxy {

    private static Calculator calculator;

    public static Calculator getInstance() {
        return (Calculator)Proxy.newProxyInstance(CalculatorProxy.class.getClassLoader(), new Class[]{Calculator.class}, (proxy, method, args) -> {
            if (calculator == null){
                calculator = new CalculatorImpl();
            }
            System.out.println(method.getName() + "执行中");
            Object invoke = method.invoke(calculator, args);
            System.out.println(method.getName() + "执行结束");
            return invoke;
        });
    }

    public static void main(String[] args) {
        Calculator instance = getInstance();
        instance.add(1,2);
        System.out.println("===");
    }

}
