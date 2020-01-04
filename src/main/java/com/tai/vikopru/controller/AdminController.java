package com.tai.vikopru.controller;

import com.tai.vikopru.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    PostService postService;

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
