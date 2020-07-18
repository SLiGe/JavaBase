package com.lambda.demo.recursive;

/**
 * 递归只能是实例变量或静态变量
 *
 * @author zJiaLi
 * @since 2020-07-17 22:51
 */
public class RecursiveIntObj {
    RecursiveIntInterface recursiveIntInterface;

    public RecursiveIntObj() {
        this.recursiveIntInterface = n -> n == 0 ? 0
                : n == 1 ? 1
                : recursiveIntInterface.call(n - 1) + recursiveIntInterface.call(n - 2);
    }

    int fibonacci(int n) {
        return recursiveIntInterface.call(n);
    }

    public static void main(String[] args) {
        RecursiveIntObj intObj = new RecursiveIntObj();
        for (int i = 0; i < 10; i++) {
            System.out.println(intObj.fibonacci(i));
        }
    }
}
