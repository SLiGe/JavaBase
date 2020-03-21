package com.java.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author zJiaLi
 * @since 2020-03-20 17:21
 */
public class StreamForList0 {

    public static void main(String[] args) {
        testList();
        getMember();
    }

    static void getMember() {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");
        Stream<String> oneStream = one.stream().filter(s -> s.length() == 3)
                .limit(3);
        Stream<String> twoStream = two.stream().filter(s -> s.startsWith("张"))
                .skip(2);
        Stream.concat(oneStream, twoStream).map(Person::new)
                .forEach(System.out::println);

    }

    /**
     * 1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
     * 2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
     * 3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
     * 4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
     * 5. 将两个队伍合并为一个队伍；存储到一个新集合中。
     * 6. 根据姓名创建 Person 对象；存储到一个新集合中。
     * 7. 打印整个队伍的Person对象信息。
     * Person{name='宋远桥'}
     * Person{name='苏星河'}
     * Person{name='石破天'}
     * Person{name='张天爱'}
     * Person{name='张二狗'}
     */
    static void testList() {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        ArrayList<String> a = new ArrayList<>();
        for (String s : one) {
            if (s.length() == 3) {
                a.add(s);
            }
        }
        ArrayList<String> b = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (i < 3)
                b.add(a.get(i));
        }

        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");
        ArrayList<String> c = new ArrayList<>();
        for (String n : two
        ) {
            if (n.startsWith("张"))
                c.add(n);
        }
        ArrayList<String> d = new ArrayList<>();
        for (int i = 0; i < c.size(); i++) {
            if (i < 2)
                continue;
            d.add(c.get(i));
        }
        b.addAll(d);
        ArrayList<Person> per = new ArrayList<>();
        for (String s : b) {
            per.add(new Person(s));
        }
        per.forEach(System.out::println);

    }

    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static void test1() {
        List<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张三名");
        list.add("李倩");
        list.add("二号");
        list.stream().filter(n -> n.startsWith("张"))
                .filter(n -> n.length() == 3)
                .forEach(System.out::println);
        String[] nums = {"2", "5", "1", "6", "8", "7"};
        Stream<Integer> integerStream = Stream.of(nums).filter(a -> a.length() < 2)
                .skip(1)
                .limit(4)
                .map(Integer::parseInt)
                .sorted((b, c) -> c - b)
                .filter(b -> b > 1);
        // long count = integerStream.count();
        //流已关闭
        //integerStream.forEach(System.out::println);
        String[] num2 = {"11", "12", "23"};
        Stream<String> num21 = Stream.of(num2);
        Stream.concat(num21, integerStream).forEach(System.out::println);
        //   System.out.println(count);
    }


    static void getStream() {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        Set<String> sets = new HashSet<>();
        Stream<String> stream1 = sets.stream();
        Map<String, String> map = new HashMap<>();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream2 = entries.stream();
        Set<String> strings = map.keySet();
        Stream<String> stream3 = strings.stream();
        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();
        Stream<String> a = Stream.of("a", "b", "c");
    }
}
