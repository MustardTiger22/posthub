package com.tai.vikopru.dao;

import com.tai.vikopru.entity.PostComment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class PostCommentDao implements Dao<PostComment> {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Optional<PostComment> get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        PostComment postComment = session.get(PostComment.class, id);
        return Optional.ofNullable(postComment);
    }

    @Override
    public List<PostComment> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from PostComment").list();
    }

    public List<PostComment> getAllCommentsFromPost(Integer idPost) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from PostComment where post.idPost = :id ORDER BY timestamp DESC";
        Query<PostComment> query = session.createQuery(hql, PostComment.class);
        query.setParameter("id", idPost);
        return query.list();
    }

    @Override
    public void save(PostComment postComment) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(postComment);
    }

    @Override
    public void update(PostComment postComment, String[] params) {

    }

    @Override
    public void delete(Integer id) {

    }
}
