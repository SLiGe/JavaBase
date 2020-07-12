package com.java.json;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * @author zJiaLi
 * @since 2020-07-12 12:38
 */
public class InnerJson {

    static void innerMethodJson() {
        @Data
        class Person {
            private String name;

            private int age;
        }
        Person person = new Person();
        person.setAge(12);
        person.setName("FastJson");
        {
            System.out.println("inner method " + person.toString());
        }
        String jsonString = JSON.toJSONString(person);
        System.out.println(jsonString);
    }

    public static void main(String[] args) {
        innerMethodJson();
    }
}
