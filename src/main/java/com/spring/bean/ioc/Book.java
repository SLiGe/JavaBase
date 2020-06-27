package com.spring.bean.ioc;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author zJiaLi
 * @since 2020-06-27 11:22
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private String name;

    private int page;

    private List<String> hobbies;

    private Map<String,String> anotherAttr;

    private Properties properties;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", page=" + page +
                ", hobbies=" + hobbies +
                ", anotherAttr=" + anotherAttr +
                ", properties=" + properties +
                '}';
    }
}
