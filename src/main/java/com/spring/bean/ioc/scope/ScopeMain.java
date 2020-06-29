package com.spring.bean.ioc.scope;

import com.spring.bean.ioc.profile.DataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zJiaLi
 * @since 2020-06-29 08:04
 */
public class ScopeMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext act= new AnnotationConfigApplicationContext(ScopeConfig.class);
        //多个实例
        System.out.println("====prototypeDataSource====");
        DataSource dataSource = (DataSource)act.getBean("dataSource");
        DataSource dataSource2 = (DataSource)act.getBean("dataSource");
        System.out.println(dataSource == dataSource2);
        //单例
        System.out.println("====singletonDataSource====");
        DataSource singletonDataSource1 = (DataSource)act.getBean("dataSource2");
        DataSource singletonDataSource2 = (DataSource)act.getBean("dataSource2");
        System.out.println(singletonDataSource1 == singletonDataSource2);
    }
}
