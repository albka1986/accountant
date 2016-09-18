package ua.com.alfacell.web;

import ua.com.alfacell.dao.CrudDao;
import ua.com.alfacell.dao.impl.ProductDaoImpl;
import ua.com.alfacell.models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class ServletMain extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        CrudDao<Product> productCrudDao = new ProductDaoImpl();
        List<Product> productList = productCrudDao.findAll();
        httpSession.setAttribute("productList", productList);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/main.jsp");
        rd.forward(req, resp);

    }
}
