package com.spring.bean.ioc.scope;

import com.spring.bean.ioc.profile.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author zJiaLi
 * @since 2020-06-29 08:02
 */
@Configuration
public class ScopeConfig {

    @Bean("dataSource")
    @Scope("prototype") //表示每次获得bean都会生成一个新的对象
    public DataSource dataSource() {
        return new DataSource();
    }

    @Bean("dataSource2")
    @Scope("singleton") //单例,表示在spring容器中的单例，通过spring容器获得该bean时总是返回唯一的实例
    public DataSource dataSource2() {
        return new DataSource();
    }
}
