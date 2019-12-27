package com.tai.vikopru.controller;

import com.tai.vikopru.service.UserService;
import com.tai.vikopru.validation.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String RegistrationFormPage(Model model) {
        model.addAttribute("crmUser", new CrmUser());
        return "registration-from";
    }

    @RequestMapping("/processRegistrationForm")
    public String ProcessRegistrationFormPage() {
        return "registration-from";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
