package services;

import models.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void addUser(User user);

    public void deleteUserById(Integer id);

    public User selectUserById(Integer id);

    public void updateUser(User user);

}
