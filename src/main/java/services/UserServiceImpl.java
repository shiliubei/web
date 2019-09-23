package services;

import dao.HIbernateUserDAO;
import dao.UserDAO;
import models.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl userServiceImpl = new UserServiceImpl();

    private UserDAO userDAO = new HIbernateUserDAO();

    public static UserServiceImpl getInstance(){ return userServiceImpl; }

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
