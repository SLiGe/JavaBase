package com.java.function;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zJiaLi
 * @since 2020-03-20 10:37
 */
public class ComparatorDemo {

    /**
     * 方法返回值是函数式接口,可返回lambda表达式
     */
    static Comparator<String> getComparator() {
        /*return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        };*/
       /* return (String o1, String o2) -> {
            return o2.length() - o1.length();
        };*/
        return ((o1, o2) -> o2.length() - o1.length());
    }

    public static void main(String[] args) {
        String [] arr = new String[]{"a","sss","cccc"};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,getComparator());
        System.out.println(Arrays.toString(arr));
    }
}
