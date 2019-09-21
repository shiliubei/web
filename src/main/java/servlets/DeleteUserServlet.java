package servlets;

import services.HibernateUserSevice;
import services.JDBCUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {

    private JDBCUserService JDBCUserService = new JDBCUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        //JDBCUserService.deleteUserById(id);
        try {
            HibernateUserSevice.genInstance().deleteUserById(id);
        } catch (ClassNotFoundException | SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/usersList");
    }

}