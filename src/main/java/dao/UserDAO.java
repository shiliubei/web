package dao;

import models.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void addUser(User user);

    User selectUserById(Integer id);

    void deleteUserById(Integer id);

    void updateUser(User user);
}
