package services;

import configs.DBHelper;
import dao.HIbernateUserDAO;
import dao.JDBCUserDAO;
import dao.UserDAO;
import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class HibernateUserSevice implements UserService {

    private static HibernateUserSevice hibernateUserSevice;
    private SessionFactory sessionFactory;

    private HibernateUserSevice(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

    public static HibernateUserSevice genInstance() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        if (hibernateUserSevice == null){
            hibernateUserSevice = new HibernateUserSevice(DBHelper.getSessionFactory());
        }
        return hibernateUserSevice;
    }

    private UserDAO userDAO = new HIbernateUserDAO();
    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        UserDAO dao = new HIbernateUserDAO(session);
        return dao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        UserDAO dao = new HIbernateUserDAO(session);
        dao.addUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        Session session = sessionFactory.openSession();
        UserDAO dao = new HIbernateUserDAO(session);
        dao.deleteUserById(id);
    }

    @Override
    public User selectUserById(Integer id) {
        Session session = sessionFactory.openSession();
        UserDAO dao = new HIbernateUserDAO(session);
        return dao.selectUserById(id);
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        UserDAO dao = new HIbernateUserDAO(session);
        dao.updateUser(user);
    }
}
