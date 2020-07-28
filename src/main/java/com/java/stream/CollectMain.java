package com.java.stream;

import cn.hutool.core.map.MapUtil;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.MapUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zJiaLi
 * @since 2020-07-23 15:37
 */
public class CollectMain {

    public static void main(String[] args) {
        List<Student> students = Lists.newArrayList(
                new Student("Jack", 13, Gender.MAN, Grade.ONE),
                new Student("小红", 15, Gender.FEMALE, Grade.FOUR),
                new Student("小白", 16, Gender.MAN, Grade.TWO),
                new Student("Lucy", 20, Gender.FEMALE, Grade.ONE),
                new Student("Tim", 18, Gender.MAN, Grade.ONE),
                new Student("Tina", 19, Gender.FEMALE, Grade.TWO),
                new Student("Julia", 20, Gender.FEMALE, Grade.ONE),
                new Student("Mon", 21, Gender.MAN, Grade.FOUR),
                new Student("Sun", 32, Gender.MAN, Grade.THREE),
                new Student("Lily", 25, Gender.FEMALE, Grade.THREE),
                new Student("Curry", 26, Gender.MAN, Grade.THREE)
        );
        //获取年龄,尽量使用方法引用
        Stream<Student> stream1 = students.stream();
        List<Integer> ages = stream1.map(Student::getAge).collect(Collectors.toList());
        System.out.println(ages);
        //统计汇总信息
        IntSummaryStatistics intSummaryStatistics = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("汇总信息: " + intSummaryStatistics);

        //分块
        Map<Boolean, List<Student>> genderMap = students.stream().collect(Collectors.partitioningBy(s -> s.getGender() == Gender.MAN));
        MapUtils.verbosePrint(System.out, "学生性别分块:", genderMap);

        //班级分组
        Map<Grade, List<Student>> gradeMap = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        MapUtils.verbosePrint(System.out, "班级分组:", gradeMap);
        Map<Grade, Long> gradeCountMap = students.stream().collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
        MapUtils.verbosePrint(System.out, "班级学生个数:", gradeCountMap);
        String join = students.stream().map(Student::getName).collect(Collectors.joining("-", "[", "]"));
        System.out.println(join);
        Stream<Student> stream = students.stream();
        Integer maxAge = stream.map(Student::getAge).max(Comparator.comparingInt(i -> i)).orElse(0);
        System.out.println(maxAge);
    }

}

@AllArgsConstructor
@NoArgsConstructor
@Data
class Student {
    private String name;

    private int age;

    private Gender gender;

    private Grade grade;

}

@Getter
enum Grade {
    ONE,
    TWO,
    THREE,
    FOUR
}

@Getter
enum Gender {
    MAN,

    FEMALE
}