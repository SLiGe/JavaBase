package com.java.stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zJiaLi
 * @since 2020-07-23 12:24
 */
public class ParallelStream {

    public static void main(String[] args) {
        String ps = "My name is jack";
        //使用并行流
        Stream.of(ps.split(" "))
                //调用parallel产生并行流
                .parallel().peek(ParallelStream::debug)
                //调用sequential产生串行流,多次调用parallel/调用sequential产生串行流以最后一次为准
                .sequential()
                .forEach(System.out::println);

        //IntStream.range(1,10).parallel().peek(ParallelStream::debug2).count();
        Stream<String> split = Stream.of(ps.split(" "));
        Stream<Integer> integerStream = split.peek(System.out::println)
                .filter(a -> {
                    System.out.println(a);
                    return a.length() > 0;
                })
                .map(String::length);
        long count = integerStream.count();
        ForkJoinPool forkJoinPool = new ForkJoinPool(20);
        forkJoinPool.submit(() -> IntStream.range(1, 10).parallel().peek(ParallelStream::debug2).count());
        forkJoinPool.shutdown();
        synchronized (forkJoinPool) {
            try {
                forkJoinPool.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void debug(String i) {
        System.out.println(Thread.currentThread().getName() + " " + i);
    }

    public static void debug2(int i) {
        try {
            System.out.println("debug2");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + i);
    }

}
