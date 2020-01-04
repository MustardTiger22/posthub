package com.tai.vikopru.dao;

import com.tai.vikopru.entity.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostDao implements Dao<Post> {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Optional<Post> get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Post post = session.get(Post.class, id);
        return Optional.ofNullable(post);
    }

    @Override
    public List<Post> getAll() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Post ORDER BY timestamp DESC";
        Query<Post> query = session.createQuery(hql, Post.class);
        return query.list();
    }

    @Override
    public void save(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(post);
    }

    @Override
    public void update(Post post, String[] params) {

    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Post post = session.get(Post.class, id);
        session.delete(post);
    }
}
