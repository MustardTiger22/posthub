package com.tai.vikopru.controller;

import com.tai.vikopru.entity.Wykopalisko;
import com.tai.vikopru.service.WykopaliskoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/znalezisko")
public class ZnaleziskoController {
    @Autowired
    WykopaliskoService wykopaliskoService;

    @GetMapping(path = "/{id}")
    public String znaleziskoPage(Model model, @PathVariable Integer id){
        Wykopalisko wykopalisko = wykopaliskoService.get(id).get();
        model.addAttribute("wykopalisko", wykopalisko);
        return "znalezisko";
    }
}
