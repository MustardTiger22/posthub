package com.tai.vikopru.controller;

import com.tai.vikopru.entity.Post;
import com.tai.vikopru.entity.PostComment;
import com.tai.vikopru.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;
    // Current post
    private Post post;

    @GetMapping(path = "/{id}")
    public String postPage(Model model, @PathVariable Integer id){
        post = postService.get(id).get();
        List<PostComment> comments = postService.getAllCommentsFromPost(id);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "post";
    }

    @PostMapping("/processComment")
    public String addCommentPage(@ModelAttribute("postComment") PostComment postComment) {
        postService.saveComment(postComment, post);
        return "redirect:/post/" + post.getIdPost();
    }
}
