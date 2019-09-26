package fabrica;

import configs.PropertyReader;
import dao.UserDAO;

public interface UserDaoFactory {

    UserDAO getDao();

    static UserDaoFactory getInstance(){

        String method = PropertyReader.getProperty("method");
        if (method.equals("hibernate")) {
            return new HibernateUserDaoFactory();
        }
        if (method.equals("jdbc")) {
            return new JdbcUserDaoFactory();
        }
        return null;
    }
}
