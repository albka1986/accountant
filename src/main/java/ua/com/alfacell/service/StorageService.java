package ua.com.alfacell.service;

// Created by Ponomarenko Oleh on 05.11.2016.

import ua.com.alfacell.dao.impl.StorageDaoImpl;
import ua.com.alfacell.dto.StorageDto;
import ua.com.alfacell.models.Storage;
import ua.com.alfacell.utilites.Transformer;

import java.util.LinkedList;
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

    public List<StorageDto> findProductsByShopId(int shopId) {
        List<Storage> temp = new StorageDaoImpl().findAll();
        List<Storage> storageList = new LinkedList<>();
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getShop().getId() == shopId) {
                storageList.add(temp.get(i));
            }
        }
        List<StorageDto> storageDtos = Transformer.listStorageToListStorageDto(storageList);
        return storageDtos;

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
