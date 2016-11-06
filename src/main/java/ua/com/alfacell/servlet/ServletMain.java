package ua.com.alfacell.servlet;// Created by Ponomarenko Oleh on 01.11.2016.

import ua.com.alfacell.models.Storage;
import ua.com.alfacell.models.User;
import ua.com.alfacell.service.StorageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class ServletMain extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login");
            rd.forward(req, resp);
        } else {
            User user1 = (User) httpSession.getAttribute("user");
            System.out.println(user1.getFirstName());
        }

        List<Storage> storageList = new StorageService().findAllProductsByShopId(user.getShop().getId());

        req.getSession().setAttribute("storageListStorage1", storageList);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/shop" + user.getShop().getId());
        rd.forward(req, resp);
    }
}
