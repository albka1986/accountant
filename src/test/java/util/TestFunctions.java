package util;

// Created by Ponomarenko Oleh on 09.01.2017.

import org.testng.annotations.Test;
import ua.com.alfacell.dto.CategoryDto;
import ua.com.alfacell.service.CategoryService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestFunctions {

    @Test
    public void testMethodSort() {
        List<CategoryDto> categoryDto = new CategoryService().findAll();
        Collections.sort(categoryDto, new Comparator<CategoryDto>() {
            @Override
            public int compare(CategoryDto o1, CategoryDto o2) {
                return o1.getNameCategory().compareTo(o2.getNameCategory());
            }
        });
        for (CategoryDto dto : categoryDto) {
            System.out.println(dto);
        }
    }
}
