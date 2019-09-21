package servlets;

import models.User;
import services.HibernateUserSevice;
import services.JDBCUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet("/usersList")
public class UsersListServlet extends HttpServlet {

    private JDBCUserService JDBCUserService = new JDBCUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // ArrayList<User> users = (ArrayList<User>) JDBCUserService.getAllUsers();

        try {
            ArrayList<User> users = (ArrayList<User>) HibernateUserSevice.genInstance().getAllUsers();
            req.setAttribute("usersFromServer", users);
        } catch (ClassNotFoundException | SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/usersList.jsp");
        dispatcher.forward(req, resp);
    }

}