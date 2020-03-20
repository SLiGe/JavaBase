package com.java.function;

import java.util.function.Function;

/**
 * @author zJiaLi
 * @since 2020-03-20 17:01
 */
public class FunctionDemo {

    static Integer parseInteger(String num, Function<String,Integer> f){
        return f.apply(num);
    }

    static Integer parseAndAdd(String num, Function<String,Integer> f,Function<Integer,Integer> f1){
        Integer apply = f.andThen(f1).apply(num);
        System.out.println(apply);
        return apply;
    }

    public static void main(String[] args) {
        Integer integer = parseInteger("36", Integer::parseInt);
        System.out.println(integer);

        parseAndAdd("33", Integer::parseInt,(o)-> o + 10);
    }
}
