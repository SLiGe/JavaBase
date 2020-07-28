package com.java.stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zJiaLi
 * @since 2020-07-23 11:52
 */
public class EndMain {

    public static void main(String[] args) {
        String ps = "My name is jack";
        //使用并行流
        Stream.of(ps.split(" ")).parallel().forEach(System.out::println);
        //保证顺序
        Stream.of(ps.split(" ")).parallel().forEachOrdered(System.out::println);

        //collect到list
        List<String> strings = Stream.of(ps.split(" ")).collect(Collectors.toList());
        System.out.println(strings);

        //使用reduce
        Optional<String> reduce = Stream.of(ps.split(" ")).reduce(((s, s2) -> s + "|" + s2));
        System.out.println(reduce.orElse(" "));
        //带初始值的reduce
        String reduce1 = Stream.of(ps.split(" ")).reduce("",((s, s2) -> s + "|" + s2));
        System.out.println(reduce1);
        Integer reduce2 = Stream.of(ps.split(" ")).map(s -> s.length()).reduce(0, (s, s1) -> s + s1);
        System.out.println(reduce2);
    }

}
