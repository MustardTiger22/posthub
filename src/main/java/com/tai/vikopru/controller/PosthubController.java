package com.tai.vikopru.controller;

import com.tai.vikopru.crm.CrmPost;
import com.tai.vikopru.entity.Post;
import com.tai.vikopru.service.UserService;
import com.tai.vikopru.service.PostService;
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
@RequestMapping("/posts")
public class PosthubController {
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @GetMapping("/add")
    public String wykopaliskoFormPage(Model model){
        model.addAttribute("crmPost", new CrmPost());
        return "post-form";
    }

    @PostMapping("/processForm")
    public String wykopaliskoProcessFormPage(@Valid @ModelAttribute("crmPost") CrmPost crmPost,
                                      BindingResult bindingResult,
                                      Model model){
        // form validation
        if (bindingResult.hasErrors()){
            return "post-form";
        }

        postService.save(crmPost);
        return "redirect:/";
    }


    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
