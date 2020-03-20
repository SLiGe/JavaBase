package com.java.function;

import com.java.function.impl.MyFunctionInterfaceImpl;
import com.java.function.interfaces.MyFunctionInterface;
import org.jetbrains.annotations.NotNull;

/**
 * @author zJiaLi
 * @since 2020-03-19 22:49
 */
public class MyFunctionInterFaceDemo {

    public static void show(@NotNull MyFunctionInterface myFunctionInterface) {
        myFunctionInterface.method();
    }

    public static void main(String[] args) {
        //实现类对象
        show(new MyFunctionInterfaceImpl());
        //接口匿名内部类
        show(new MyFunctionInterface() {
            @Override
            public void method() {
                System.out.println("匿名内部类");
            }
        });
        show(()->{
            System.out.println("lambda---");
        });
        show(()-> System.out.println("lambda"));
    }
}
