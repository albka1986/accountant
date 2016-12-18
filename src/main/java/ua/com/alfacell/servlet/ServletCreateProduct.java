package ua.com.alfacell.servlet;

import ua.com.alfacell.dto.CategoryDto;
import ua.com.alfacell.dto.ProductDto;
import ua.com.alfacell.service.CategoryService;
import ua.com.alfacell.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createProduct")
public class ServletCreateProduct extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            req.setCharacterEncoding("UTF-8");
            ProductService productService = new ProductService();
            int categoryId = Integer.parseInt(req.getParameter("categoryId"));
            String brand = req.getParameter("brand");
            String nameProduct = req.getParameter("nameProduct");
            String barcode = req.getParameter("barcode");

            ProductDto productDto = new ProductDto();
            productDto.setBrand(brand);
            productDto.setNameProduct(nameProduct);
            productDto.setBarcode(barcode);

            CategoryService categoryService = new CategoryService();
            CategoryDto categoryDto = categoryService.findById(categoryId);
            productDto.setCategoryDto(categoryDto);

            productService.save(productDto);

            resp.sendRedirect("/managerStorage");
        } else {
            resp.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}