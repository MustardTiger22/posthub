package com.tai.vikopru.controller;

import com.tai.vikopru.entity.User;
import com.tai.vikopru.service.UserService;
import com.tai.vikopru.validation.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/form")
    public String RegistrationFormPage(Model model) {
        model.addAttribute("crmUser", new CrmUser());
        return "registration-form";
    }

    @PostMapping("/processForm")
    public String ProcessRegistrationFormPage(@Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
                                              BindingResult theBindingResult,
                                              Model theModel) {
        // form validation
        if (theBindingResult.hasErrors()){
            return "registration-form";
        }
        String userName = theCrmUser.getUserName();
        // check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null){
            theModel.addAttribute("crmUser", new CrmUser());
            theModel.addAttribute("registrationError", "User name already exists.");
            return "registration-form";
        }
        // create user account
        userService.save(theCrmUser);
        return "login";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
