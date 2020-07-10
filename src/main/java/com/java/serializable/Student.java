package com.java.serializable;

/**
 * @author zJiaLi
 * @since 2020-07-08 11:13
 */
public class Student extends BaseBo{

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
