package ua.com.alfacell.service;

// Created by Ponomarenko Oleh on 04.12.2016.

import ua.com.alfacell.dao.impl.ShopDaoImpl;
import ua.com.alfacell.dto.ShopDto;
import ua.com.alfacell.models.Shop;
import ua.com.alfacell.utilites.Transformer;

import java.util.List;

public class ShopService implements CrudService<ShopDto> {
    ShopDaoImpl shopDao = new ShopDaoImpl();

    @Override
    public ShopDto findById(int id) {
        Shop shop = shopDao.findById(id);
        ShopDto shopDto = Transformer.shopToShopDto(shop);
        return shopDto;
    }

    @Override
    public List<ShopDto> findAll() {
        List<Shop> shopList = shopDao.findAll();
        List<ShopDto> shopDtos = Transformer.listShopToShopDto(shopList);
        return shopDtos;
    }

    @Override
    public void save(ShopDto shopDto) {

    }

    @Override
    public void update(ShopDto shopDto) {

    }

    @Override
    public void delete(ShopDto shopDto) {

    }
}
