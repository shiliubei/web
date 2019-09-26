package fabrica;


import dao.HIbernateUserDAO;
import dao.UserDAO;

public class HibernateUserDaoFactory implements UserDaoFactory{

    @Override
    public UserDAO getDao() {
        return new HIbernateUserDAO();
    }
}
