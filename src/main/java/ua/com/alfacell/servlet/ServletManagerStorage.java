package ua.com.alfacell.servlet;// Created by Ponomarenko Oleh on 20.11.2016.

import ua.com.alfacell.dto.CategoryDto;
import ua.com.alfacell.dto.ProductDto;
import ua.com.alfacell.service.CategoryService;
import ua.com.alfacell.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/managerStorage")
public class ServletManagerStorage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {

            ProductService productService = new ProductService();
            if (productService.findAll().size() != 0) {
                List<ProductDto> productDtos = productService.findAll();
                Collections.sort(productDtos, new Comparator<ProductDto>() {
                    @Override
                    public int compare(ProductDto o1, ProductDto o2) {
                        return o2.getId().compareTo(o1.getId());
                    }
                });
                req.getSession().setAttribute("products", productDtos);
            }

            CategoryService categoryService = new CategoryService();
            if (categoryService.findAll().size() != 0) {
                List<CategoryDto> categoryDtos = new CategoryService().findAll();
                Collections.sort(categoryDtos, new Comparator<CategoryDto>() {
                    @Override
                    public int compare(CategoryDto o1, CategoryDto o2) {
                        return o1.getNameCategory().compareTo(o2.getNameCategory().toString());
                    }
                });
                req.getSession().setAttribute("categories", categoryDtos);
            }

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/managerStorage.jsp");
            rd.forward(req, resp);

        } else {
            resp.sendRedirect("/login");
        }
    }
}
