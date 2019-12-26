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
@Transactional
public class WykopaliskoDAO implements DAO<Wykopalisko> {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Optional<Wykopalisko> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Wykopalisko> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Wykopalisko").list();
    }

    @Override
    public void save(Wykopalisko wykopalisko) {

    }

    @Override
    public void update(Wykopalisko wykopalisko, String[] params) {

    }

    @Override
    public void delete(Long id) {

    }
}
