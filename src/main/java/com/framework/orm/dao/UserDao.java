package com.framework.orm.dao;

import com.framework.orm.entity.User;
import com.github.orm.core.ORMConfig;
import com.github.orm.core.SqlSession;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.PostConstruct;
import java.sql.SQLException;

/**
 * @author zJiaLi
 * @since 2020-07-14 23:22
 */
public class UserDao {

    private ORMConfig ormConfig;

    @PostConstruct
    public void init(){
        this.ormConfig = new ORMConfig();
    }

    public UserDao() {
        this.ormConfig = new ORMConfig();
    }

    public void testSave() throws SQLException, ClassNotFoundException {
        SqlSession sqlSession = ormConfig.buildSqlSession();
        User user = new User();
        user.setId(12);
        user.setAge(20);
        user.setMoney(3000);
        user.setName("Tom");
        sqlSession.save(user);
        sqlSession.close();
    }

    public void testDelete() throws SQLException, ClassNotFoundException {
        SqlSession sqlSession = ormConfig.buildSqlSession();
        User user = new User();
        user.setId(10);
        sqlSession.delete(user);
        sqlSession.close();
    }

    public void testQueryOne() throws SQLException, ClassNotFoundException {
        SqlSession sqlSession = ormConfig.buildSqlSession();
        User o = (User)sqlSession.queryOne(User.class, 1);
        System.out.println(o);
        sqlSession.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
       // userDao.testSave();
        ///userDao.testDelete();
        userDao.testQueryOne();
    }


}
