package ua.com.alfacell.servlet;// Created by Ponomarenko Oleh on 01.11.2016.

import ua.com.alfacell.dao.impl.StorageDaoImpl;
import ua.com.alfacell.models.Category;
import ua.com.alfacell.models.Product;
import ua.com.alfacell.models.Shop;
import ua.com.alfacell.models.Storage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class ServletMain extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        StorageDaoImpl storageDao = new StorageDaoImpl();
        List<Storage> storageList = storageDao.findAll();
        for (int i = 0; i < storageList.size(); i++) {
            if (storageList.get(i).getShop().getId() != 1) {
                storageList.remove(i);
            }
        }

        req.getSession().setAttribute("storageListStorage1", storageList);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/shop1.jsp");
        rd.forward(req, resp);
    }
}
