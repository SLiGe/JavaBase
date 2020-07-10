package com.spring.aop.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

/**
 * @author zJiaLi
 * @since 2020-06-30 20:40
 */
@Configuration
public class JdbcConfig {

    @Bean("mysqlDataSource")
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    @PreDestroy
    public void destroy(){
        System.out.println("JdbcConfig is destroy ...... ");
    }
}
