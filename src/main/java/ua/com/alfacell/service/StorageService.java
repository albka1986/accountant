package ua.com.alfacell.service;

// Created by Ponomarenko Oleh on 05.11.2016.

import ua.com.alfacell.dao.impl.StorageDaoImpl;
import ua.com.alfacell.models.Storage;

import java.util.List;

public class StorageService implements CrudService<Storage> {
    @Override
    public Storage findById(int id) {
        return null;
    }

    @Override
    public List<Storage> findAll() {
        return null;
    }

    public List<Storage> findAllProductsByShopId(int shopId) {
        StorageDaoImpl storageDao = new StorageDaoImpl();
        List<Storage> storageList = storageDao.findAll();
        for (int i = 0; i < storageList.size(); i++) {
            if (storageList.get(i).getShop().getId() != shopId) {
                storageList.remove(i);
            }
        }
        return storageList;
    }

    @Override
    public void save(Storage storage) {

    }

    @Override
    public void update(Storage storage) {

    }

    @Override
    public void delete(Storage storage) {

    }
}
