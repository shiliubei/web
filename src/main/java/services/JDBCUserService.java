package services;

import dao.JDBCUserDAO;
import dao.UserDAO;
import models.User;

import java.util.List;

public class JDBCUserService implements UserService {

    private UserDAO userDAO = new JDBCUserDAO();

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDAO.deleteUserById(id);
    }

    @Override
    public User selectUserById(Integer id) {
        return userDAO.selectUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

}
