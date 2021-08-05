package com.qiao.community.controller;


import com.qiao.community.entity.DiscussPost;
import com.qiao.community.entity.Page;
import com.qiao.community.entity.User;
import com.qiao.community.service.DiscussPostService;
import com.qiao.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author apple
 * @create 2021-08-03 上午11:50
 */
@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String getIndexPage(Model model,Integer current){
        Page page = new Page();
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        if (current == null) {
            current = 1;
        }
        page.setCurrent(current);

        List<DiscussPost> discussPosts = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String,Object>> list = new ArrayList<>();
        if (discussPosts != null) {
            for (DiscussPost post : discussPosts) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                list.add(map);
            }
        }
        model.addAttribute("discussPosts", list);
        model.addAttribute("page", page);
        return "index";
    }


}
