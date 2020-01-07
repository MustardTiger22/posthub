package com.tai.vikopru.controller;

import com.tai.vikopru.entity.User;
import com.tai.vikopru.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    UserService userService;

    @GetMapping(path = "/{username}")
    public String profilePage(@PathVariable String username, Model model){
        User user = userService.findByUserName(username);
        model.addAttribute("user", user);
        return "profile";
    }
}
