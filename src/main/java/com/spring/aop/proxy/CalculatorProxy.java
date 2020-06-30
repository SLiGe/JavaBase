package com.spring.aop.proxy;

import java.lang.reflect.Proxy;

/**
 * @author zJiaLi
 * @since 2020-06-29 20:55
 */
public class CalculatorProxy {

    private static Calculator calculator;

    public static Calculator getInstance() {
        return (Calculator) Proxy.newProxyInstance(CalculatorProxy.class.getClassLoader(), new Class[]{Calculator.class}, (proxy, method, args) -> {
            //获取对象实例
            if (calculator == null) {
                calculator = new CalculatorImpl();
            }
            System.out.println(method.getName() + "执行中");
            //执行真正的方法逻辑
            Object invoke = method.invoke(calculator, args);
            System.out.println(method.getName() + "执行结束");
            return invoke;
        });
    }

    public static void main(String[] args) {
        Calculator instance = getInstance();
        instance.add(1, 2);
        System.out.println("===");
    }

}
