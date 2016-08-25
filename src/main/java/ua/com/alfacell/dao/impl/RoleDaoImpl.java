package ua.com.alfacell.dao.impl;

// Created by Ponomarenko Oleh on 25.08.2016.

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import ua.com.alfacell.dao.BaseDao;
import ua.com.alfacell.dao.CrudDao;
import ua.com.alfacell.models.Role;

import java.util.List;

public class RoleDaoImpl extends BaseDao implements CrudDao<Role> {

    @Override
    public Role findById(int id) {
        Session session = getActiveSession();
        Role role = (Role) session.createCriteria(Role.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return role;
    }

    @Override
    public List<Role> findAll() {
        Session session = getActiveSession();
        List<Role> roles = session.createCriteria(Role.class).list();
        return roles;
    }

    @Override
    public void save(Role role) {
        Session session = getActiveSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(role);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Role updateRole) {
        System.out.println("It should to override");
    }

    @Override
    public void delete(Role role) {
        Session session = getActiveSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(role);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
