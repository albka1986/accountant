package ua.com.alfacell.servlet;// Created by Ponomarenko Oleh on 20.11.2016.

import ua.com.alfacell.dto.ShopDto;
import ua.com.alfacell.dto.UserDto;
import ua.com.alfacell.models.Role;
import ua.com.alfacell.service.ShopService;
import ua.com.alfacell.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EnumSet;
import java.util.List;


@WebServlet("/admin")
public class ServletAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {

            UserService userService = new UserService();
            if (userService.findAll().size() != 0) {
                List<UserDto> userDtos = userService.findAll();
                req.getSession().setAttribute("users", userDtos);
            }

            ShopService shopService = new ShopService();
            if (shopService.findAll().size() != 0) {
                List<ShopDto> shopDtos = shopService.findAll();
                req.getSession().setAttribute("shops", shopDtos);
            }

            EnumSet<Role> roles = EnumSet.allOf(Role.class);
            req.getSession().setAttribute("roles", roles);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/admin.jsp");
            rd.forward(req, resp);
        } else {
            resp.sendRedirect("/login");
        }
    }
}
