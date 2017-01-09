package ua.com.alfacell.service;

// Created by Ponomarenko Oleh on 04.12.2016.

import ua.com.alfacell.dao.impl.CategoryDaoImpl;
import ua.com.alfacell.dto.CategoryDto;
import ua.com.alfacell.models.Category;
import ua.com.alfacell.utilites.Transformer;

import java.util.List;

public class CategoryService implements CrudService<CategoryDto> {
    CategoryDaoImpl categoryDao = new CategoryDaoImpl();

    @Override
    public CategoryDto findById(int id) {
        Category category = new CategoryDaoImpl().findById(id);
        CategoryDto categoryDto = Transformer.categoryToCategoryDto(category);
        return categoryDto;
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryDao.findAll();
        List<CategoryDto> categoryDtos = Transformer.listCategoryToCategoryDto(categories);
        return categoryDtos;
    }

    @Override
    public void save(CategoryDto categoryDto) {
        Category category = Transformer.categoryDtoToCategory(categoryDto);
        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        categoryDao.save(category);
    }

    @Override
    public void update(CategoryDto categoryDto) {

    }

    @Override
    public void delete(CategoryDto categoryDto) {
        Category category = Transformer.categoryDtoToCategory(categoryDto);
        categoryDao.delete(category);
    }

    public boolean nameCategoryExists(String name) {
        return categoryDao.nameCategoryExists(name);
    }

    public CategoryDto findByName(String nameCategory) {
        Category category = new CategoryDaoImpl().findByName(nameCategory);
        CategoryDto categoryDto = Transformer.categoryToCategoryDto(category);
        return categoryDto;
    }
}
