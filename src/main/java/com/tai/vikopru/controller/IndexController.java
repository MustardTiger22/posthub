package com.tai.vikopru.controller;

import com.tai.vikopru.entity.Post;
import com.tai.vikopru.service.UserService;
import com.tai.vikopru.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @GetMapping
    public String indexPage(Model model){
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/mikroblog")
    public String mikroblogPage(Model model){
        return "mikroblog";
    }


}
