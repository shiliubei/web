package servlets;

import dao.UserDAO;
import models.User;
import services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/usersList")
public class UsersListServlet extends HttpServlet {


    //private UserDAO userDAO = new UserDAO();
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // ArrayList<User> users = (ArrayList<User>) userDAO.getAllUsers();
        ArrayList<User> users = (ArrayList<User>) userService.getAllUsers();
        req.setAttribute("usersFromServer", users);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/usersList.jsp");
        dispatcher.forward(req, resp);
    }

}