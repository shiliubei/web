package services;

import dao.UserDAO;
import fabrica.UserDaoFactory;
import models.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = UserDaoFactory.getInstance().getUserDao();

    private static UserServiceImpl userServiceImpl = new UserServiceImpl();

    public static UserServiceImpl getInstance() {
        return userServiceImpl;
    }

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

    public User getUserByNameAndPassword(String name, String password) {
        for (User user : getAllUsers()) {
            if (user.getName().equals(name) &&
                    user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;

    }

}
