package ua.com.alfacell.dao.impl;

// Created by Ponomarenko Oleh on 20.08.2016.

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import ua.com.alfacell.dao.BaseDao;
import ua.com.alfacell.dao.CrudDao;
import ua.com.alfacell.models.User;

import java.util.List;


public class UserDaoImpl extends BaseDao implements CrudDao<User> {


    @Override
    public User findById(int id) {
        Session session = getActiveSession();
        User user = (User) session.createCriteria(User.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return user;
    }

    @Override
    public List<User> findAll() {
        Session session = getActiveSession();
        List<User> users = session.createCriteria(User.class).list();
        return users;
    }

    @Override
    public void save(User user) {
        Session session = getActiveSession();
        session.save(user);
        session.flush();
        session.close();
    }

    @Override
    public void update(User updateUser) {
        Session session = getActiveSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(updateUser);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(User user) {
        Session session = getActiveSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public boolean checkAuthentication(String login, String password) {
        boolean result = false;
        Session session = getActiveSession();
        User user = (User) session.createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .add(Restrictions.eq("password", password))
                .uniqueResult();
        if (user != null) {
            result = true;
        }

        return result;
    }

    public User findByLoginPassword(String login, String password) {
        User user = null;
        Session session = getActiveSession();
        User temp = (User) session.createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .add(Restrictions.eq("password", password))
                .uniqueResult();
        if (temp != null) {
            if (temp.getLogin().equals(login) && temp.getPassword().equals(password)) {
                user = temp;
            }
        }
        return user;
    }

    public void createAdmin() {
        User user = new User();
        user.setLogin("admin");
        user.setLogin("admin");
        User temp = findByLoginPassword(user.getLogin(), user.getPassword());
        if (temp == null) {
            save(user);
        }
    }
}
