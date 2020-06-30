package com.spring.aop.datasource.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zJiaLi
 * @since 2020-06-30 21:32
 */
@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    @Transactional(rollbackFor = Exception.class)
    public void updateMoney() {
        userDao.addMoney("哈哈", 100);
        int a = 1 / 0;
        userDao.minMoney("哈哈", 100);
    }
}
