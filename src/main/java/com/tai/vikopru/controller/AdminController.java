package com.tai.vikopru.controller;

import com.tai.vikopru.entity.User;
import com.tai.vikopru.service.PostService;
import com.tai.vikopru.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    @GetMapping("/panel")
    public String AdminPanelPage(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "admin-panel";
    }

    @GetMapping("/panel/delete")
    public String DeleteUserPage(@RequestParam("idUser") Integer id){
        userService.delete(id);
        return "redirect:/admin/panel";
    }


    @GetMapping("deletePost")
    public String deletePostPage(@RequestParam("idPost") Integer id){
        postService.delete(id);
        return "redirect:/";
    }

    @GetMapping("deleteComment")
    public String deleteCommentPage(@RequestParam("idPost") Integer idPost,
                                    @RequestParam("idComment") Integer idComment){
        postService.deleteComment(idComment);
        return "redirect:/post/" + idPost;
    }
}
