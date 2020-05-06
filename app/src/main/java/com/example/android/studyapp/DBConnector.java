package com.example.android.studyapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnector {
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    private static DBConnector dbInstance = null;

    private DBConnector() {
    }

    public static DBConnector getInstance() {
        if (dbInstance == null) {
            dbInstance = new DBConnector();
        }
        return dbInstance;
    }

    public String [] loginBackend() {
        connectToDB();
        String[] data = new String[3];
        String query = "SELECT * WHERE email = ? AND password = ?;";
        try {
            resultSet = preparedStatement.executeQuery(query);
            String username = resultSet.getString("username");
            System.out.println(username);
            String email1 = resultSet.getString("email");
            System.out.println(email1);
            String password1 = resultSet.getString("password");
            System.out.println(password1);

            data[0] = username;
            data[1] = email1;
            data[2] = password1;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ISSUE WITH DB CONNECTION FOR LOGIN BACKEND");
        }
        finally {
            disconnectFromDB();
        }
        return data;
    }

    private void connectToDB() {
        String url = "den1.mysql5.gear.host";
        try {
            connection = DriverManager.getConnection(url);
            preparedStatement = (PreparedStatement) connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR CONNECTING TO DB");
            disconnectFromDB();
        }
    }

    private void disconnectFromDB() {
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


