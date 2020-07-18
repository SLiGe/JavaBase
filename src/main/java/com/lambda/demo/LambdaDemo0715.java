package com.lambda.demo;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * lambda 表达式常见写法
 *
 * @author zJiaLi
 * @since 2020-07-15 22:47
 */
public class LambdaDemo0715 {
    static IntInterface i5 ;

    public static void main(String[] args) {
        IntInterface i1 = i -> i * 2;
        IntInterface i2 = (int i) -> i * 2;

        IntInterface i3 = i -> {
            System.out.println("i: " + i);
            return i * 2;
        };

        IntInterface i4 = (i) -> i * 2;

        List<String> words = new ArrayList<>();
        //使用匿名内部类
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        //使用Lambda表达式实现Comparator接口
        Collections.sort(words, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        //使用List在JDK1.8新增的sort(Comparator<? super E> c)方法
        words.sort(Comparator.comparingInt(String::length));

        i5 = i -> i == 0 ? 1 : i * i5.doubleNum(i - 1);
        for (int j = 0; j < 5; j++) {
            int i6 = i5.doubleNum(j);
            System.out.println(i6);
        }
    }

}

/**
 * 函数式接口
 */
@FunctionalInterface
interface IntInterface {

    int doubleNum(int i);

    /**
     * Object 的public方法不算抽象接口
     */
    int hashCode();


    /**
     * 默认实现方法
     */
    default int add(int x, int y) {
        return x + y;
    }

    default boolean min(int x, int y) {
        return x > y;
    }
}
