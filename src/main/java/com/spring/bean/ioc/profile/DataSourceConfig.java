package com.spring.bean.ioc.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author zJiaLi
 * @since 2020-06-28 22:01
 */
@Configuration
public class DataSourceConfig {

    @Bean("dataSource")
    @Profile("prod")
    public DataSource prodDataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1/prod");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean("dataSource")
    @Profile("dev")
    public DataSource devDataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1/dev");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

}
