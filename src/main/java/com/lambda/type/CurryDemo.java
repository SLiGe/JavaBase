package com.lambda.type;

import java.util.function.Function;

/**
 * 函数级联表达式
 *
 * @author zJiaLi
 * @since 2020-07-22 22:40
 */
public class CurryDemo {

    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> function = x -> y -> x + y;
        Integer apply = function.apply(3).apply(2);
        System.out.println(apply);
        Function<Integer, Function<Integer, Function<Integer, Integer>>> function2 = x -> y -> z -> x + y + z;
        System.out.println(function2.apply(1).apply(2).apply(3));

        Function f = function2;
        int[] nums = {1, 2, 3};
        for (int num : nums) {
            if (f instanceof Function) {
                Object obj = f.apply(num);
                if (obj instanceof Function) {
                    f = (Function) obj;
                } else {
                    System.out.println("调用结束" + obj);
                }
            }
        }
    }
}
