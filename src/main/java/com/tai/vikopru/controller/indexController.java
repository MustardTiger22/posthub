package com.tai.vikopru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
    @RequestMapping("/")
    public String indexPa3ge(Model model){
        return "index";
    }
}
