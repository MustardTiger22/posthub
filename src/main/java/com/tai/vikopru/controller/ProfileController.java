package com.tai.vikopru.controller;

import com.tai.vikopru.entity.User;
import com.tai.vikopru.entity.Wykopalisko;
import com.tai.vikopru.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    UserService userService;

    @GetMapping
    public String profilePage(Principal principal, Model model){
        String username = principal.getName();
        User user = userService.findByUserName(username);
        model.addAttribute("user", user);
        return "profile";
    }
}
