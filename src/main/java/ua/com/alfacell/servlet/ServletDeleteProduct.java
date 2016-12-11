package ua.com.alfacell.servlet;// Created by Ponomarenko Oleh on 11.12.2016.

import ua.com.alfacell.dto.ProductDto;
import ua.com.alfacell.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/ServletDeleteProduct")
public class ServletDeleteProduct extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameterValues("productsListDelete") != null) {
            String[] strings = req.getParameterValues("productsListDelete");
            List<ProductDto> productDtos = new LinkedList<>();
            ProductService productService = new ProductService();
            for (String productId : strings) {
                ProductDto productDto = productService.findById(Integer.parseInt(productId));
                productDtos.add(productDto);
            }
            productService.deleteProductList(productDtos);


            resp.sendRedirect("/managerStorage");
        } else {
            resp.sendRedirect("/managerStorage");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
