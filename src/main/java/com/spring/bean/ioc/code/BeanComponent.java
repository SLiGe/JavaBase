package com.spring.bean.ioc.code;

import com.spring.bean.ioc.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * 使用Java配置类注入Bean
 *
 * @author zJiaLi
 * @since 2020-06-27 20:44
 */
@Component
@ComponentScan(value = "com.java", useDefaultFilters = true, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})})
public class BeanComponent {

    @Bean("book")
    public Book getBook() {
        Book book = new Book();
        book.setName("生死疲劳");
        return book;
    }

}
