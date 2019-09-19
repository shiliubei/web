package dao;

import configs.Configuration;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserDAO implements UserDAO {


    public JDBCUserDAO() {
    }

    protected Connection getConnection() {
        Configuration conf = new Configuration();
        Connection connection = conf.getJDBCConnection();
        return connection;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User userList = new User();
                userList.setId(rs.getInt(1));
                userList.setName(rs.getString(2));
                userList.setEmail(rs.getString(3));
                userList.setCountry(rs.getString(4));
                list.add(userList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addUser(User user) {
        String userName = user.getName();
        String userEmail = user.getEmail();
        String userCountry = user.getCountry();

        try (Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users(name, email, country) VALUES(?,?,?)");
            ps.setString(1, userName);
            ps.setString(2, userEmail);
            ps.setString(3, userCountry);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserById(Integer id) {
        try (Connection connection = getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public User selectUserById(Integer id) {
        User user = null;
        try (Connection connection = getConnection()) {
            String sql = "SELECT id,name,email,country FROM users WHERE id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(User user) {
        try (Connection connection = getConnection()) {
            String sql = "UPDATE users SET name=?, email=?, country=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
