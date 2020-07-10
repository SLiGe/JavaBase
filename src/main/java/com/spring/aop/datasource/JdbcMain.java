package com.spring.aop.datasource;

import com.spring.aop.datasource.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author zJiaLi
 * @since 2020-06-30 20:43
 */
public class JdbcMain {

    public static void main(String[] args) {
        //getXmlDataSource();
        processTransactional();
    }

    public static void getXmlDataSource() {
        ClassPathXmlApplicationContext xtc = new ClassPathXmlApplicationContext("spring-component.xml");
        UserService userService = xtc.getBean(UserService.class);
        //MyISAM 不支持事务
        userService.updateMoney();
    }

    public static void processTransactional() {
        ClassPathXmlApplicationContext xtc = new ClassPathXmlApplicationContext("spring-component.xml");
        UserService userService = xtc.getBean(UserService.class);
        userService.addUser("Pom",35,2000);
        System.out.println("addUser is done!!!");
    }

    public static void getAnnotationDataSource() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcConfig.class);
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        // jdbcTemplate.execute("insert into user(name,age) values ('哈哈',16)");
        Map<String, Object> map = jdbcTemplate.queryForMap("select * from user");
        User user1 = jdbcTemplate.queryForObject("select * from user", (resultSet, i) -> {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            return user;
        });
        System.out.println(user1);
    }

}
