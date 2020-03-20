package com.java.function;

import java.util.function.Supplier;

/**
 * Supplier<T>接口被称之为生产型接口,指定接口的泛型是什么类型,那么接口中的get方法就好产生什么类型的数据
 *
 * @author zJiaLi
 * @since 2020-03-20 11:02
 */
public class SupplierDemo {

    static String getString(Supplier<String> stringSupplier) {
        return stringSupplier.get() + " crack";
    }

    static Integer getMax(Supplier<Integer> integerSupplier) {
        return integerSupplier.get();
    }

    static Integer getMaxValFromArray(int[] arr) {
        return getMax(() -> {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max)
                    max = arr[i];
            }
            return max;
        });
    }

    public static void main(String[] args) {
        String s = getString(() -> {
            return "Hello";
        });

        String s1 = getString(() -> "World");
        System.out.println(s);
        System.out.println(s1);
        int[] arr = {100, 2, 333, 50, 221};
        Integer maxValFromArray = getMaxValFromArray(arr);
        System.out.println("数组最大值: " + maxValFromArray);
    }
}
