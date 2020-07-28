package com.java.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author zJiaLi
 * @since 2020-07-22 23:00
 */
public class StreamDemo {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int sum = Arrays.stream(nums).map(i -> i * 2).sum();
        System.out.println(sum);
        long asInt = new Random().ints(1,10).flatMap(IntStream::of).limit(3).map(i -> i * 2).sum();
        System.out.println(asInt);
        int[] arr = {1, 2, 3};
        int[] b = arr;
        b[0] = 5;
        System.out.println(arr[0]);
    }

}
