package services;

import dao.JDBCUserDAO;
import models.User;

import java.util.List;

public class UserService {
    public List<User> getAllUsers() {
        JDBCUserDAO JDBCUserDAO = new JDBCUserDAO();
        return JDBCUserDAO.getAllUsers();
    }

    public void addUser(User user) {
        JDBCUserDAO JDBCUserDAO = new JDBCUserDAO();
        JDBCUserDAO.addUser(user);
    }

    public void deleteUserById(Integer id) {
        JDBCUserDAO JDBCUserDAO = new JDBCUserDAO();
        JDBCUserDAO.deleteUserById(id);
    }

    public User selectUserById(Integer id) {
        JDBCUserDAO JDBCUserDAO = new JDBCUserDAO();
        return JDBCUserDAO.selectUserById(id);
    }

    public void updateUser(User user) {
        JDBCUserDAO JDBCUserDAO = new JDBCUserDAO();
        JDBCUserDAO.updateUser(user);
    }

}
