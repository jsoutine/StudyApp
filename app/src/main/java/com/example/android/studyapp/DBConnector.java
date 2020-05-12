package com.example.android.studyapp;

import java.sql.*;

public class DBConnector {
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    static User loggedInUser;
    private static DBConnector dbInstance = null;

    public static DBConnector getInstance() {
        if (dbInstance == null) {
            dbInstance = new DBConnector();
        }
        return dbInstance;
    }

    void loginBackend(String username, String password) {
        connectToDB();
        String query = "SELECT * FROM user WHERE username = ? AND password = ?;";
        System.out.println("0");
        if (connection != null) {
            System.out.println("CONN = NULL!");
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                System.out.println("1");
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery(query);
                if (resultSet.next()) {
                    System.out.println("2");
                    loggedInUser = userHandler(resultSet);
                }
                System.out.println("4");
                resultSet.close();
                System.out.println("5");
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
                System.out.println("ISSUE WITH DB CONNECTION FOR LOGIN BACKEND");
            } finally {
                //disconnectFromDB();
            }
        }
    }

    private User userHandler(ResultSet resultSet) throws SQLException {
        User user = new User(
                resultSet.getInt("iduser"),
                resultSet.getString("username"),
                resultSet.getString("email"),
                resultSet.getString("password"),
                resultSet.getString("calenderaddress"));
        System.out.println("Username: " + user.getUsername() + " | Email: " + user.getEmail());
        return user;
    }

    void connectToDB() {
        String ip = "den1.mysql5.gear.host";
        String port = "3306";
        String database = "StudEasyDB";
        String user = "studeasydb";
        String password = "studeasydb!";
        try {
            String url = "jdbc:mysql://"+ ip +":"+ port +"/"+ database +"&useSSL=false&user="+ user+"&password="+ password +"&serverTimeZone=UTC";
            System.out.println("(0");
            connection = DriverManager.getConnection(url);
            System.out.println("(1");
            preparedStatement = (PreparedStatement) connection.createStatement();
            System.out.println("(2");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR CONNECTING TO DB");
        }
    }


    void disconnectFromDB() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("PROBLEM CLOSING DB ResultSet");
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("PROBLEM CLOSING DB PreparedStatement");
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("PROBLEM CLOSING DB connection");
            }
        }
    }
}