package com.tai.vikopru.dao;

import com.tai.vikopru.entity.Post;
import com.tai.vikopru.entity.PostComment;
import com.tai.vikopru.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao implements Dao<User> {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Optional<User> get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM User").getResultList();
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public void update(User user, String[] params) {

    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        session.delete(user);
    }

    public User findByUserName(String username) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("from User where username=:uName", User.class);
        query.setParameter("uName", username);
        User user = null;
        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            user = null;
        }

        return user;
    }


}
