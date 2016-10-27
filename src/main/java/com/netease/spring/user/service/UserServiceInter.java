package com.netease.spring.user.service;

import com.netease.spring.user.domain.User;

/**
 * 用户服务接口
 * Created by switch on 16/10/27.
 */
public interface UserServiceInter {
    /**
     * 登陆接口
     *
     * @param user 用户Bean
     * @return 数据库中用户，无则返回null
     */
    public User login(User user);
}
