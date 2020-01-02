package com.tai.vikopru.service;

import com.tai.vikopru.crm.CrmPost;
import com.tai.vikopru.dao.PostCommentDao;
import com.tai.vikopru.dao.PostDao;
import com.tai.vikopru.entity.PostComment;
import com.tai.vikopru.entity.User;
import com.tai.vikopru.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Service
public class PostService {
    @Autowired
    UserService userService;
    @Autowired
    PostCommentDao postCommentDao;
    @Autowired
    PostDao postDAO;
    //Get current logged in user

    @Transactional
    public void save(@Valid CrmPost crmPost) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userService.findByUserName(username);

        Post post = new Post(
                crmPost.getTitle(),
                crmPost.getDescription(),
                crmPost.getImageSrc(),
                crmPost.getSourceUrl()
        );
        post.setUser(user);
        postDAO.save(post);
    }

    @Transactional
    public void saveComment(PostComment comment, Post post) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userService.findByUserName(username);
        PostComment postComment = new PostComment(
            comment.getContent()
        );
        postComment.setUser(user);
        postComment.setPost(post);
        postCommentDao.save(postComment);
    }

    @Transactional
    public List<Post> getAll(){
        return postDAO.getAll();
    }

    @Transactional
    public Optional<Post> get(Integer id) {
        return postDAO.get(id);
    }

    @Transactional
    public List<PostComment> getAllCommentsFromPost(Integer idPost) {
        return postCommentDao.getAllCommentsFromPost(idPost);
    }
}
