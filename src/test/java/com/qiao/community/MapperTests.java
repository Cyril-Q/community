package com.qiao.community;

import com.qiao.community.dao.DiscussPostMapper;
import com.qiao.community.dao.UserMapper;
import com.qiao.community.entity.DiscussPost;
import com.qiao.community.entity.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;


/**
 * @author apple
 * @create 2021-08-03 上午10:32
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
@MapperScan(basePackages = "com.qiao.community.dao")
public class MapperTests {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectDiscussPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for (DiscussPost post : list) {
            System.out.println(post);
        }

//        System.out.println(discussPostMapper.selectDiscussPostRows(101));
    }

    @Test
    public void testSelectById(){
        User user = userMapper.selectById(101);
        System.out.println(user);
    }

}
