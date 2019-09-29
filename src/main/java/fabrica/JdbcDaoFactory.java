package fabrica;

import dao.JDBCUserDAO;
import dao.UserDAO;

public class JdbcDaoFactory implements UserDaoFactory{
    @Override
    public UserDAO getUserDao() {
        return new JDBCUserDAO();
    }
}
