package com.spring.bean.ioc.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zJiaLi
 * @since 2020-06-29 08:41
 */
public class BeanAwareMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext act = new AnnotationConfigApplicationContext();
        act.register(BeanAware.class);
        act.refresh();
        BeanAware beanAware = (BeanAware)act.getBean("beanAware");
        boolean hasBeanAware = beanAware.containsBean("beanAware");
        System.out.println("BeanAware : "+hasBeanAware);
    }

}
