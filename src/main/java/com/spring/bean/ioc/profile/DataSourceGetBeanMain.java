package com.spring.bean.ioc.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zJiaLi
 * @since 2020-06-28 22:03
 */
public class DataSourceGetBeanMain {

    public static void main(String[] args) {
        getXmlBean();
    }

    public static void getXmlBean(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.setConfigLocation("spring-beans.xml");
        ctx.refresh();
        DataSource dataSource = (DataSource)ctx.getBean("dataSource");
        System.out.println(dataSource);
    }

    public static void getAnnotationBean(){
        AnnotationConfigApplicationContext act = new AnnotationConfigApplicationContext();
        act.getEnvironment().setActiveProfiles("prod");
        act.register(DataSourceConfig.class);
        act.refresh();
        DataSource dataSource = (DataSource)act.getBean("dataSource");
        System.out.println(dataSource);
    }

}
