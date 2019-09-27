package servlets;

import models.User;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = userService.getUserByNameAndPassword(name, password);
        if (user != null) {
            if (user.getRole().equals("admin")) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("adminUsersList");
            } else if (user.getRole().equals("user")) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/user");
            } else {
                resp.sendRedirect("/login");
            }
        }
    }
}