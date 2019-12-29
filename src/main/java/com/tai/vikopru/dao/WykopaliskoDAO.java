package com.tai.vikopru.dao;

import com.tai.vikopru.entity.Wykopalisko;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class WykopaliskoDAO implements DAO<Wykopalisko> {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Optional<Wykopalisko> get(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Wykopalisko wykopalisko = session.get(Wykopalisko.class, id);
        return Optional.ofNullable(wykopalisko);
    }

    @Override
    public List<Wykopalisko> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Wykopalisko").list();
    }

    @Override
    public void save(Wykopalisko wykopalisko) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(wykopalisko);
    }

    @Override
    public void update(Wykopalisko wykopalisko, String[] params) {

    }

    @Override
    public void delete(Integer id) {

    }
}
