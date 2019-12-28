package com.tai.vikopru.controller;

import com.tai.vikopru.dao.UserDAO;
import com.tai.vikopru.dao.WykopaliskoDAO;
import com.tai.vikopru.entity.Wykopalisko;
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
    UserDAO userDAO;

    @Autowired
    WykopaliskoDAO wykopaliskoDAO;

    @GetMapping
    public String indexPage(Model model){
        List<Wykopalisko> wykopaliska = wykopaliskoDAO.getAll();
        model.addAttribute("wykopaliska", wykopaliska);
        return "index";
    }

    @GetMapping("/mikroblog")
    public String mikroblogPage(Model model){
        return "mikroblog";
    }

}
