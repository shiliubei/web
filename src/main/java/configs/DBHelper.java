package configs;


import models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHelper {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() throws ClassNotFoundException, IllegalAccessException, SQLException, InstantiationException {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    @SuppressWarnings("UnusedDeclaration")
    private static Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/users_db?useTimezone=true&useSSL=false&useTimezone=true&serverTimezone=UTC");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "root");
        configuration.setProperty("hibernate.show_sql", "true");
       // configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        return configuration;
    }

    private static SessionFactory createSessionFactory() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

        Configuration configuration = getMySqlConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}
