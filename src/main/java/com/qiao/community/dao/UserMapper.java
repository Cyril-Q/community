package com.qiao.community.dao;

import com.qiao.community.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author apple
 * @create 2021-08-03 下午8:21
 */
@Repository
public interface UserMapper {

    User selectById(Integer id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(@Param("id") Integer id, @Param("status") Integer status);

    int updateHeader(@Param("id") Integer id, @Param("headerUrl") Integer headerUrl);

    int updatePassword(@Param("id") Integer id, @Param("password") String password);
}
