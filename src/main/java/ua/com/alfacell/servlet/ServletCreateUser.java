package ua.com.alfacell.servlet;

import ua.com.alfacell.dto.ShopDto;
import ua.com.alfacell.dto.UserDto;
import ua.com.alfacell.models.Role;
import ua.com.alfacell.service.ShopService;
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

        req.setCharacterEncoding("UTF-8");
        UserDto userDto = new UserDto();
        userDto.setFirstName(req.getParameter("firstName"));
        userDto.setLastName(req.getParameter("lastName"));
        userDto.setLogin(req.getParameter("login"));
        userDto.setPassword(req.getParameter("password"));
        userDto.setEmail(req.getParameter("email"));
        userDto.setPhone(req.getParameter("phone"));

        if (req.getParameter("shopId") != null && req.getParameter("shopId") != "") {
            int shopId = Integer.parseInt(req.getParameter("shopId"));
            ShopDto shopDto = new ShopService().findById(shopId);
            userDto.setShopDto(shopDto);
        }
        Role role = Role.valueOf(req.getParameter("roleNewUser"));
        System.out.println("ROLE: " + role);
        switch (role) {
            case ADMIN:
                userDto.setRole(Role.ADMIN);
            case MANAGER:
                userDto.setRole(Role.MANAGER);
            case USER:
                userDto.setRole(Role.USER);
        }
        System.out.println(userDto);

        UserService userService = new UserService();
        userService.save(userDto);
        resp.sendRedirect("/admin");

        System.out.println(userDto);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
