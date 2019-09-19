package services;

import dao.UserDAO;
import models.User;

import java.util.List;

public class UserService {
    public List<User> getAllUsers(){
        UserDAO userDAO = new UserDAO();
        return userDAO.getAllUsers();
    }
    public void addUser(User user){
        UserDAO userDAO = new UserDAO();
        userDAO.addUser(user);
    }

    public void deleteUserById(Integer id){
        UserDAO userDAO = new UserDAO();
        userDAO.deleteUserById(id);
    }
    public User selectUserById(Integer id){
        UserDAO userDAO = new UserDAO();
        return userDAO.selectUserById(id);
    }

    public void updateUser(User user){
        UserDAO userDAO = new UserDAO();
        userDAO.updateUser(user);
    }

}
