package com.qiao.community.dao;


import com.qiao.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author apple
 * @create 2021-08-03 上午9:54
 */
@Repository
public interface DiscussPostMapper {

    //@Param注解用于给参数取别名
    List<DiscussPost> selectDiscussPosts(@Param("userId") Integer userId, @Param("offset")Integer offset, @Param("limit")Integer limit);

    Integer selectDiscussPostRows(Integer userId);


}
