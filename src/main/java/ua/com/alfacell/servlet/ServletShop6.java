package ua.com.alfacell.servlet;// Created by Ponomarenko Oleh on 05.11.2016.

import ua.com.alfacell.models.Storage;
import ua.com.alfacell.service.StorageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/shop6")
public class ServletShop6 extends HttpServlet {
    int shopId = 6;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            List<Storage> storageList = new StorageService().findAllProductsByShopId(shopId);
            req.getSession().setAttribute("storageListStorage" + shopId, storageList);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/shop" + shopId + ".jsp");
            rd.forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }
}
