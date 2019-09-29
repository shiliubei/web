package fabrica;

import configs.PropertyReader;
import dao.UserDAO;

public interface UserDaoFactory {

    UserDAO getUserDao();

    static UserDaoFactory getInstance(){

        String method = PropertyReader.getProperty("method");
        if (method.equals("hibernate")) {
            return new HibernateDaoFactory();
        }
        if (method.equals("jdbc")) {
            return new JdbcDaoFactory();
        }
        return null;
    }
}
