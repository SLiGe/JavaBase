package com.java.serializable;

import java.io.Serializable;

/**
 * @author Gary
 * @since 2019/11/22 15:29
 */
public class TransientObj implements Serializable {

    private String name;

    /**
     * transient 不参与序列化
     */
    private transient String age;

    /**
     * 静态变量不会参与序列化，无论是否加上transient
     * 静态变量读取的是当前类在JVM的成员值
     */
    private static String fa;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TransientObj{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
