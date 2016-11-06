package ua.com.alfacell.servlet;

// Created by Ponomarenko Oleh on 06.11.2016.

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletLogout")
public class ServletLogout extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        session.removeAttribute("user");
        session.invalidate();
        resp.sendRedirect("/home");
    }
}