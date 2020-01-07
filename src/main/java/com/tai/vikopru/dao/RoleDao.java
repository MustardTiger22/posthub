package com.tai.vikopru.dao;

import com.tai.vikopru.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleDao implements Dao<Role> {
    @Autowired
    private SessionFactory sessionFactory;

    public Role findRoleByName(String theRoleName) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Role> theQuery = currentSession.createQuery("from Role where name=:roleName", Role.class);
        theQuery.setParameter("roleName", theRoleName);

        Role role = null;

        try {
            role = theQuery.getSingleResult();
        } catch (Exception e) {
            role = null;
        }

        return role;
    }

    @Override
    public Optional<Role> get(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public void save(Role role) {

    }

    @Override
    public void update(Role role, String[] params) {

    }

    @Override
    public void delete(Integer id) {

    }
}
