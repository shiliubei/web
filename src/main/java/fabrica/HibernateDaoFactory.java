package fabrica;


import dao.HIbernateUserDAO;
import dao.UserDAO;

public class HibernateDaoFactory implements UserDaoFactory{

    @Override
    public UserDAO getUserDao() {
        return new HIbernateUserDAO();
    }
}
