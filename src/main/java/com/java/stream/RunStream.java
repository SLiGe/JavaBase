package com.java.stream;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author zJiaLi
 * @since 2020-07-23 16:50
 */
public class RunStream {

    public static void main(String[] args) {
        //链式调用 sourceStage指向同一地址 Head,
        // nextStage 为下一步操作
        Stream<Integer> limit = Stream.generate(() -> new Random().nextInt())
                .limit(10)
                .peek(RunStream::print)
                .filter(i -> {
                    System.out.println("filter " + i);
                    return i > 0;
                })
                .peek(RunStream::print)
                .parallel();
        limit.count();
    }

    private static void print(int s) {
        System.out.println("peek " + s);
    }

}
