package com.java.function.normal;

import com.java.function.interfaces.TestFunctionInterface;

/**
 * @author zJiaLi
 * @since 2020-07-13 21:09
 */
public class TestFunctionInterfaceMain {

    public static void main(String[] args) {
        String methodArg = "Function";
        TestFunctionInterface testFunctionInterface = method -> System.out.println(methodArg);
        testFunctionInterface.test(methodArg);
    }


}
