package com.tai.vikopru.controller;

import com.tai.vikopru.crm.CrmProfile;
import com.tai.vikopru.crm.CrmUser;
import com.tai.vikopru.entity.User;
import com.tai.vikopru.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    UserService userService;

    @GetMapping(path = "/{username}")
    public String profilePage(@PathVariable String username, Model model, HttpServletRequest request){
        User user = userService.findByUserName(username);
        User sessionUser = (User)request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("sessionUser", sessionUser);
        return "profile";
    }

    @GetMapping("/edit")
    public String editProfilePage(Model model, HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("crmProfile", new CrmProfile());
        return "profile-edit";
    }

    @PostMapping("/edit/update")
    public String updateProfilePage(@Valid @ModelAttribute("user") CrmProfile crmProfile,
                                    HttpServletRequest request,
                                    BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return "profile-edit";
        }

        User sessionUser = (User)request.getSession().getAttribute("user");
        String[] params = {crmProfile.getFirstName(), crmProfile.getLastName(), crmProfile.getEmail()};
        System.out.printf("Firstname: "+ crmProfile.getFirstName());
        userService.update(sessionUser, params);
        return "redirect:/profile/" + sessionUser.getUsername();
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
