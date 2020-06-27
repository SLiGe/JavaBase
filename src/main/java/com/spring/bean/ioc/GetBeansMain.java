package com.spring.bean.ioc;

import com.spring.bean.ioc.code.BeanComponent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author zJiaLi
 * @since 2020-06-27 11:30
 */
public class GetBeansMain {

    public static void main(String[] args) {
        getBeanByComponent();
    }

    private static void getBeanByComponent() {
        AnnotationConfigApplicationContext act = new AnnotationConfigApplicationContext(BeanComponent.class);
        Book book = (Book) act.getBean("book");
        System.out.println(book);
    }

    private static void getBeanByXml() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
        //最好使用bean的name属性获取该bean, 避免多个相同类型的bean实例
        Book book = (Book) ctx.getBean("book");
        Book book2 = (Book) ctx.getBean("book2");
        System.out.println(book);
        System.out.println(book2);
    }

}


