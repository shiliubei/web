package dao;

import configs.DBHelper;
import models.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class HIbernateUserDAO implements UserDAO {

    private SessionFactory sessionFactory = DBHelper.getSessionFactory();


    public HIbernateUserDAO() {
    }

    @Override
    public List<User> getAllUsers() {
        List userList = null;
        Transaction tr = null;
        try {
            Session session = sessionFactory.openSession();
            tr = session.beginTransaction();
            userList = session.createQuery("From User").list();
            tr.commit();
            session.close();
        } catch (HibernateException e) {
            tr.rollback();
        }
        return userList;
    }

    @Override
    public void addUser(User user) {
        Transaction tr = null;
        try {
            Session session = sessionFactory.openSession();
            tr = session.beginTransaction();
            session.save(user);
            tr.commit();
            session.close();
        } catch (HibernateException e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public User selectUserById(Integer id) {
        Transaction tr = null;
        User user = null;
        try {
            Session session = sessionFactory.openSession();
            tr = session.beginTransaction();
            user = (User) session.get(User.class, id);
            tr.commit();
            session.close();
        } catch (HibernateException e) {
            tr.rollback();
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteUserById(Integer id) {

        Transaction tr = null;
        try {
            Session session = sessionFactory.openSession();
            tr = session.beginTransaction();
            User user = (User) session.get(User.class, id);
            session.delete(user);
            tr.commit();
            session.close();
        } catch (HibernateException e) {
            tr.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        Transaction tr = null;
        try {
            Session session = sessionFactory.openSession();
            tr = session.beginTransaction();
            session.update(user);
            tr.commit();
            session.close();
        } catch (HibernateException e) {
            tr.rollback();
            e.printStackTrace();
        }
    }
}
