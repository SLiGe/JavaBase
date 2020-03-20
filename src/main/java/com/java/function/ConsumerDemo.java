package com.java.function;

import java.util.function.Consumer;

/**
 * Consumer<T> 消费数据,其数据类型又泛型T决定
 * Consumer接口中包含抽象方法void accept(T t),意为消费一个指定泛型的数据
 *
 * @author zJiaLi
 * @since 2020-03-20 11:24
 */
public class ConsumerDemo {

    static void me(String name, Consumer<String> consumer) {
        consumer.accept(name);
    }

    //andThen连接两个Consumer接口
    static void me(String name, Consumer<String> con1, Consumer<String> con2) {
        con1.andThen(con2).accept(name);
    }

    static void me(String[] names, Consumer<String> con1, Consumer<String> con2) {
        for (String name : names) {
            con1.andThen(con2).accept(name);
        }
    }

    public static void main(String[] args) {
        me("雍正", (o) -> {
            String reserveName = new StringBuilder(o).reverse().toString();
            System.out.println(reserveName);
        });

        me("ABC", (t) -> System.out.println(t.toLowerCase()), (t) -> {
            System.out.println(t);
            System.out.println(t.toUpperCase());
        });

        String[] arr = {"小明,17", "小红,20", "小兰,30"};
        me(arr, (t) -> System.out.print("姓名:" + t.split(",")[0] + "."), (t) -> System.out.println("年龄:" + t.split(",")[1] + "."));
    }
}
