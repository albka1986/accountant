package ua.com.alfacell.servlet;

import ua.com.alfacell.dto.CategoryDto;
import ua.com.alfacell.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createCategory")
public class ServletCreateCategory extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            req.setCharacterEncoding("UTF-8");
            CategoryService categoryService = new CategoryService();
            String nameCategory = req.getParameter("nameCategory");
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setNameCategory(nameCategory);
            categoryService.save(categoryDto);

            resp.sendRedirect("/managerStorage");
        } else {
            resp.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}