package com.java.function;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author zJiaLi
 * @since 2020-03-20 14:43
 */
public class PredicateDemo {

    public static boolean checkString(String s, Predicate<String> predicate) {
        //用来指定数据类型数据进行判断
        return predicate.test(s);
    }

    /**
     * 逻辑表达式 可以连接多个判断的条件
     */
    static boolean checkStringByAnd(String s, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.and(pre2).test(s);
    }

    static boolean checkStringByOr(String s, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.or(pre2).test(s);
    }

    static boolean checkStringByNegate(String s, Predicate<String> predicate) {
        return predicate.negate().test(s);
    }

    static ArrayList<String> filter(String[] arr, Predicate<String> pre1, Predicate<String> pre2) {
        ArrayList<String> list = new ArrayList<>();
        for (String a : arr) {
            if (pre1.and(pre2).test(a))
                list.add(a);
        }
        return list;
    }

    public static void main(String[] args) {
        boolean ss = checkString("ss", (t) -> t.length() < 5);
        System.out.println(ss);
        boolean b = checkStringByAnd("sssp", (t) -> {
            return t.length() > 2;
        }, (t) -> {
            return t.contains("a");
        });
        System.out.println(b);
        boolean b1 = checkStringByOr("aa", (t) -> {
            return t.length() > 2;
        }, (t) -> {
            return t.contains("a");
        });
        System.out.println(b1);
        boolean ss1 = checkStringByNegate("ss", (t) -> t.length() < 5);
        System.out.println(ss1);

        String [] arr = {"迪丽热巴,女","库奇马哈,男","体力库鲁,男","几码咋哈,女"};
        ArrayList<String> women = filter(arr, (o) -> {
            return o.split(",")[1].contains("女");
        }, (o) -> {
            return o.split(",")[0].length() >= 4;
        });
        women.forEach(System.out::println);
    }
}
