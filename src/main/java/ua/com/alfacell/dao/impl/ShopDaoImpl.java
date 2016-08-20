package ua.com.alfacell.dao.impl;

// Created by Ponomarenko Oleh on 21.08.2016.

import ua.com.alfacell.dao.BaseDao;
import ua.com.alfacell.dao.CrudDao;
import ua.com.alfacell.models.Shop;

import java.util.List;

public class ShopDaoImpl extends BaseDao implements CrudDao<Shop> {
    @Override
    public Shop findById(int id) {
        return null;
    }

    @Override
    public List<Shop> findAll() {
        return null;
    }

    @Override
    public void save(Shop shop) {

    }

    @Override
    public void update(Shop shop) {

    }

    @Override
    public void delete(Shop shop) {

    }
}
