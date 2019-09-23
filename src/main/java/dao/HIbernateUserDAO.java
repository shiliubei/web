package dao;

import org.hibernate.Query;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import models.User;

import java.util.List;

public class HIbernateUserDAO implements UserDAO {


    private Session session;

    public HIbernateUserDAO(Session session) {
        this.session = session;
    }

    public HIbernateUserDAO() {
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = session.createQuery("From User").list();
        session.close();
        return userList;
    }

    @Override
    public void addUser(User user) {
        Transaction tr1 = session.beginTransaction();
        session.save(user);
        tr1.commit();
    }

    @Override
    public User selectUserById(Integer id) {
        User user = (User) session.get(User.class, id);
        return user;
    }

    @Override
    public void deleteUserById(Integer id) {
        Transaction tr1 = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        session.delete(user);
        tr1.commit();
    }

    @Override
    public void updateUser(User user) {
        Transaction tr1 = session.beginTransaction();
        session.update(user);
        tr1.commit();
    }
}
