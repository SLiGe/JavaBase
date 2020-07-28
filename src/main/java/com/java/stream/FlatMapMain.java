package com.java.stream;

import java.util.stream.Stream;

/**
 * @author zJiaLi
 * @since 2020-07-23 11:21
 */
public class FlatMapMain {
    public static void main(String[] args) {
        String ps = "My name is jack";

        //map
        Stream.of(ps.split(" ")).map(s -> s.length()).forEach(System.out::println);
        //flatMap A->B 属性(是个集合),最终得到所有的A元素里面的所有B属性集合
        //IntStream/LongStream并不是Stream的子类,所以要进行装箱boxed
        //peek是中间操作,用于debug
        Stream.of(ps.split(" ")).peek(System.out::println).flatMap(s->s.chars().boxed()).forEach(
                integer -> System.out.println((char) integer.intValue())
        );

    }
}
