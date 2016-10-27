package com.netease.spring.user.service.impl;

import com.netease.spring.user.dao.UserDaoInter;
import com.netease.spring.user.domain.User;
import com.netease.spring.user.service.UserServiceInter;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Resource;

/**
 * 用户服务实现类
 * Created by switch on 16/10/27.
 */
public class UserServiceImpl implements UserServiceInter {
    @Resource
    SqlSessionFactory sessionFactory;

    public User login(User user) {
        // 创建Session
        SqlSession session = sessionFactory.openSession();
        // 从session中获得userDao
        UserDaoInter userDao = session.getMapper(UserDaoInter.class);
        // 在数据库中获得user
        user = userDao.login(user);
        return user;
    }
}
