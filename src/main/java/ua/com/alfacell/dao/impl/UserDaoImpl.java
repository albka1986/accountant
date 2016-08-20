package ua.com.alfacell.dao.impl;

// Created by Ponomarenko Oleh on 20.08.2016.

import ua.com.alfacell.dao.BaseDao;
import ua.com.alfacell.dao.CrudDao;
import ua.com.alfacell.models.User;

import java.util.List;

public class UserDaoImpl extends BaseDao implements CrudDao<User> {
    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
