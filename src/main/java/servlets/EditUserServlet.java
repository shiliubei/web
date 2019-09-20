package servlets;

import models.User;
import services.JDBCUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/edit")
public class EditUserServlet extends HttpServlet {

    private JDBCUserService JDBCUserService = new JDBCUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        User user = JDBCUserService.selectUserById(id);
        req.setAttribute("user", user);
        req.getServletContext().getRequestDispatcher("/jsp/editUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(id, name, email, country);
        JDBCUserService.updateUser(user);
        resp.sendRedirect("/usersList");
    }
}