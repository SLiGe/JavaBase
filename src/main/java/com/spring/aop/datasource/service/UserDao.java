package com.spring.aop.datasource.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author zJiaLi
 * @since 2020-06-30 21:38
 */
@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addMoney(String name,Integer money){
        jdbcTemplate.update("update user set money = money + ? where name = ?", money, name);
    }

    public void minMoney(String name,Integer money){
        jdbcTemplate.update("update user set money = money - ? where name = ?", money, name);
    }
}
