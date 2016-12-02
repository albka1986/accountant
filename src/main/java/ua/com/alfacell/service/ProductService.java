package ua.com.alfacell.service;

// Created by Ponomarenko Oleh on 27.11.2016.

import ua.com.alfacell.dao.impl.ProductDaoImpl;
import ua.com.alfacell.dto.ProductDto;
import ua.com.alfacell.models.Product;
import ua.com.alfacell.utilites.Transformer;

import java.util.List;

public class ProductService implements CrudService<ProductDto> {
    @Override
    public ProductDto findById(int id) {
        return null;
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = new ProductDaoImpl().findAll();
        List<ProductDto> productDtos = Transformer.listProductToProductDto(products);
        return productDtos;
    }

    @Override
    public void save(ProductDto productDto) {
        Product product = Transformer.productDtoToProduct(productDto);
        new ProductDaoImpl().save(product);

    }

    @Override
    public void update(ProductDto productDto) {

    }

    @Override
    public void delete(ProductDto productDto) {

    }
}
