package com.example.android.studyapp;

import java.sql.*;

public class DBConnector implements Runnable {
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    public static User loggedInUser;
    private static DBConnector dbInstance;
    private String username;
    private String password;
    private boolean checkUserInDB;

    public DBConnector() {
    }

    @Override
    public void run() {
    }

    public static DBConnector getInstance() {
        if (dbInstance == null) {
            dbInstance = new DBConnector();
        }
        return dbInstance;
    }

    void loginBackend(String un, String pw) {
        username = un;
        password = pw;

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                User tempUser;
                System.out.println("T1 running!");
                connectToDB();
                String query = "SELECT * FROM user WHERE username = ? AND password = ?";
                System.out.println("0");
                if (connection != null) {
                    try {
                        preparedStatement = connection.prepareStatement(query);
                        //System.out.println("1");
                        preparedStatement.setString(1, username);
                        preparedStatement.setString(2, password);
                        resultSet = preparedStatement.executeQuery();
                        while (resultSet.next()) {
                            //System.out.println("2");
                            tempUser = userHandler(resultSet);
                            System.out.println(tempUser.getEmail());
                            loggedInUser = tempUser;
                            //System.out.println("3");
                        }
                        resultSet.close();
                    } catch (SQLException | NullPointerException e) {
                        e.printStackTrace();
                        System.out.println("ISSUE WITH DB CONNECTION FOR LOGIN BACKEND");
                    } finally {
                        disconnectFromDB();
                    }
                }
            }
        });

        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private User userHandler(ResultSet resultSet) throws SQLException {
        User user = new User(
                resultSet.getInt("iduser"),
                resultSet.getString("username"),
                resultSet.getString("email"),
                resultSet.getString("password"),
                resultSet.getString("firstName"),
                resultSet.getString("lastName"),
                resultSet.getString("calenderaddress"));
        System.out.println("Username: " + user.getUsername() + " | Email: " + user.getEmail() + " | PW:" + user.getPassword());
        return user;
    }

    boolean registerBackend(final RegUser user) {
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String query = "INSERT INTO `user` (username, email, password, firstname, lastname) VALUES (?,?,?,?,?)";
                System.out.println("T2 running!");
                connectToDB();
                verifyUniqueUser(user);
                if (!checkUserInDB) {
                    if (connection != null) {
                        try {
                            preparedStatement = connection.prepareStatement(query);
                            System.out.println("1");
                            preparedStatement.setString(1, user.getUsername());
                            preparedStatement.setString(2, user.getEmail());
                            preparedStatement.setString(3, user.getPassword());
                            preparedStatement.setString(4, user.getFirstName());
                            preparedStatement.setString(5, user.getLastName());
                            preparedStatement.executeUpdate();
                        } catch (SQLException | NullPointerException e) {
                            e.printStackTrace();
                            System.out.println("ISSUE WITH DB CONNECTION FOR LOGIN BACKEND");
                        } finally {
                            disconnectFromDB();
                        }
                    }
                } else {
                    System.out.println("User already exists with entered username or email. Change these to continue!");
                }
            }
        });
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return checkUserInDB;
    }

    private void verifyUniqueUser(RegUser user) {
        String query = "SELECT * FROM user WHERE username = ? OR email = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            System.out.println("1");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                checkUserInDB = true;
            } else {
                checkUserInDB = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connectToDB() {
        System.out.println("CONNECT REACHED");
        String ip = "den1.mysql5.gear.host";
        String port = "3306";
        String database = "StudEasyDB";
        String user = "studeasydb";
        String password = "studeasydb!";
        try {
            String url = "jdbc:mysql://" + ip + ":" + port + "/" + database + "?verifyServerCertificate=false&useSSL=false&allowPublicKeyRetrieval=true&user=" + user + "&password=" + password + "&serverTimeZone=UTF-8";
            System.out.println("(0");
            connection = DriverManager.getConnection(url);
            System.out.println("(1");
        } catch (
                SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR CONNECTING TO DB");
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