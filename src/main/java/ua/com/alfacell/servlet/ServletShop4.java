package ua.com.alfacell.servlet;// Created by Ponomarenko Oleh on 05.11.2016.

import ua.com.alfacell.dto.StorageDto;
import ua.com.alfacell.models.Storage;
import ua.com.alfacell.service.StorageService;
import ua.com.alfacell.utilites.WebRedirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/shop4")
public class ServletShop4 extends WebRedirect {
    int shopId = 4;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        redirectShop(req, resp, shopId);
    }
}
