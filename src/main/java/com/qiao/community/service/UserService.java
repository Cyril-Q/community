package com.qiao.community.service;

import com.qiao.community.entity.User;

/**
 * @author apple
 * @create 2021-08-03 下午9:00
 */
public interface UserService {
    User findUserById(Integer id);
}
