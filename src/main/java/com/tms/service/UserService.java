package com.tms.service;

import com.tms.domain.User;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class UserService {

    public User getUserById(int id) {
        User user = new User();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital", "postgres", "root");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setAge(resultSet.getInt("age"));
            user.setLogin(resultSet.getString("user_login"));
            user.setPassword(resultSet.getString("user_password"));
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("something wrong....");
        }
        return user;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital", "postgres", "root");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getInt("age"));
                user.setLogin(resultSet.getString("user_login"));
                user.setPassword(resultSet.getString("user_password"));
                userList.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("something wrong....");
        }
        return userList;
    }


    public int createUser(String firstName, String lastName, int age, String login, String password) {
        int result = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital", "postgres", "root");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (id, first_name, last_name, age, user_login, user_password) VALUES (DEFAULT, ?, ?, ?, ?, ?)");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.setString(4, login);
            statement.setString(5, password);
            result = statement.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("something wrong....");
        }
        return result;
    }

    public int updateUserById(int id, String firstName, String lastName, int age, String login, String password) {
        int result = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital", "postgres", "root");
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET first_name=?, last_name=?, age=?, user_login=?, user_password=? WHERE id=?");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.setString(4, login);
            statement.setString(5, password);
            statement.setInt(6, id);
            result = statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("something wrong....");
        }
        return result;
    }

    public int deleteUserById(int id) {
        int result = 0;
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital", "postgres", "root");
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE id=?");
            statement.setInt(1, id);
            result = statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("something wrong....");
        }
        return result;
    }
}
