package ua.com.alfacell.servlet;// Created by Ponomarenko Oleh on 22.11.2016.

import ua.com.alfacell.dto.ShopDto;
import ua.com.alfacell.dto.UserDto;
import ua.com.alfacell.models.Role;
import ua.com.alfacell.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createUser")
public class ServletCreateUser extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto userDto = new UserDto();
        userDto.setFirstName(req.getParameter("firstName"));
        userDto.setLastName(req.getParameter("lastName"));
        userDto.setLogin(req.getParameter("login"));
        userDto.setPassword(req.getParameter("password"));
        userDto.setEmail(req.getParameter("email"));
        userDto.setPhone(req.getParameter("phone"));
        ShopDto shopDto = new ShopDto();
        shopDto.setId(new Integer(req.getParameter("shopId")));
        userDto.setShopDto(shopDto);
        if (req.getParameter("role").equals("ADMIN")) {
            userDto.setRole(Role.ADMIN);
        }

        UserService userService = new UserService();
        userService.save(userDto);
        resp.sendRedirect("/admin");

        System.out.println(userDto);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
