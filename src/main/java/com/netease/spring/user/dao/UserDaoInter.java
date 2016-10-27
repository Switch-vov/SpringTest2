package com.netease.spring.user.dao;

import com.netease.spring.user.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

/**
 * 用户Dao接口
 * Created by switch on 16/10/27.
 */
public interface UserDaoInter {
    @ResultType(User.class)
    @Select("select * from User where userName=#{user.userName} and userPassword=#{user.userPassword}")
    public User login(@Param("user") User user);
}
