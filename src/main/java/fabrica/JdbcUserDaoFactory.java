package fabrica;

import dao.JDBCUserDAO;
import dao.UserDAO;

public class JdbcUserDaoFactory implements UserDaoFactory{
    @Override
    public UserDAO getDao() {
        return new JDBCUserDAO();
    }
}
