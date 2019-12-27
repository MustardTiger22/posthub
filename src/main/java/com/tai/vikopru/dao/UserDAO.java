package com.tai.vikopru.dao;

import com.tai.vikopru.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class UserDAO implements DAO<User> {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Optional<User> get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void save(User theUser) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theUser);
    }

    @Override
    public void update(User user, String[] params) {

    }

    @Override
    public void delete(Long id) {

    }

    public User findByUserName(String theUserName) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> theQuery = currentSession.createQuery("from User where username=:uName", User.class);
        theQuery.setParameter("uName", theUserName);
        User user = null;
        try {
            user = theQuery.getSingleResult();
        } catch (Exception e) {
            user = null;
        }

        return user;
    }


}
