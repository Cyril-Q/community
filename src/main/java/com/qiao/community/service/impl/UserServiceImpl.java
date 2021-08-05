package com.qiao.community.service.impl;

import com.qiao.community.dao.UserMapper;
import com.qiao.community.entity.User;
import com.qiao.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author apple
 * @create 2021-08-03 下午9:07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectById(id);
    }
}
