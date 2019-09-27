package services;

import dao.UserDAO;
import models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUserById(Integer id);

    User selectUserById(Integer id);

    void updateUser(User user);

    User getUserByNameAndPassword(String name, String password);

}
