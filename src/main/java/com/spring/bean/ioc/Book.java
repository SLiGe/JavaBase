package com.spring.bean.ioc;

import lombok.*;

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


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", page=" + page +
                '}';
    }
}
