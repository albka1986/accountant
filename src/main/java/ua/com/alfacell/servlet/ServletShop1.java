package ua.com.alfacell.servlet;// Created by Ponomarenko Oleh on 05.11.2016.

import ua.com.alfacell.utilites.WebRedirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shop1")
public class ServletShop1 extends WebRedirect {
    int shopId = 1;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        redirectShop(req, resp, shopId);
    }
}
