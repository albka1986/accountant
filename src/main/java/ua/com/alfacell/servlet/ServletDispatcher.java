package ua.com.alfacell.servlet;// Created by Ponomarenko Oleh on 07.11.2016.

import ua.com.alfacell.dto.StorageDto;
import ua.com.alfacell.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/test")
public class ServletDispatcher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StorageDto> storageList = new StorageService().findProductsByShopId(1);
        req.getSession().setAttribute("storageList", storageList);
        req.getSession().setAttribute("shopId", 1);
        resp.sendRedirect("/pages/test.jsp");
    }
}
