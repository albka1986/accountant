package ua.com.alfacell.servlet;// Created by Ponomarenko Oleh on 20.11.2016.

import ua.com.alfacell.dto.StorageDto;
import ua.com.alfacell.service.StorageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/managerStorage")
public class ServletManagerStorage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            //TODO: list of all products
            //TODO: list of all categories
            //TODO: list of all brands

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/managerStorage.jsp");
            rd.forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }
}
