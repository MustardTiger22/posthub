package com.tai.vikopru.controller;

import com.tai.vikopru.crm.CrmWykopalisko;
import com.tai.vikopru.entity.Wykopalisko;
import com.tai.vikopru.service.UserService;
import com.tai.vikopru.service.WykopaliskoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/wykopalisko")
public class WykopaliskoController {
    @Autowired
    UserService userService;
    @Autowired
    WykopaliskoService wykopaliskoService;

    @GetMapping
    public String wykopaliskoFormPage(Model model){
        model.addAttribute("crmWykopalisko", new CrmWykopalisko());
        return "znalezisko-form";
    }

    @PostMapping("/processForm")
    public String wykopaliskoProcessFormPage(@Valid @ModelAttribute("crmWykopalisko") CrmWykopalisko crmWykopalisko,
                                      BindingResult bindingResult,
                                      Model model){
        // form validation
        if (bindingResult.hasErrors()){
            return "znalezisko-form";
        }

        wykopaliskoService.save(crmWykopalisko);
        List<Wykopalisko> wykopaliska = wykopaliskoService.getAll();
        model.addAttribute("wykopaliska", wykopaliska);
        return "index";
    }


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}