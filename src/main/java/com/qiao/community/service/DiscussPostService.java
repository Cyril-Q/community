package com.qiao.community.service;

import com.qiao.community.entity.DiscussPost;

import java.util.List;

/**
 * @author apple
 * @create 2021-08-03 下午8:12
 */
public interface DiscussPostService {

    List<DiscussPost> findDiscussPosts(Integer userId, Integer offset, Integer limit);

    int findDiscussPostRows(Integer userId);
}
