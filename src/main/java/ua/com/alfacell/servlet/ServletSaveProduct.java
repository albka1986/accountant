package ua.com.alfacell.servlet;

import ua.com.alfacell.dto.ProductDto;
import ua.com.alfacell.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/saveProduct")
public class ServletSaveProduct extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            ProductDto productDto = new ProductDto();
            productDto.setBrand(req.getParameter("brand"));
            productDto.setNameProduct(req.getParameter("nameProduct"));
            productDto.setBarcode(req.getParameter("barcode"));
            new ProductService().save(productDto);
            resp.sendRedirect("/admin");

        } else {
            resp.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}