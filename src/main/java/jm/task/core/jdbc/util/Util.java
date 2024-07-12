package jm.task.core.jdbc.util;


import java.sql.*;


public class Util {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/new_kata";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";
    private static final String DB_DRIVE = "com.mysql.cj.jdbc.Driver";


    private Util() {
    }


    public static Connection getConnect() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVE);
           connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
           System.out.println("Ok");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error Connection");
        }
        return connection;
    }
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // реализуйте настройку соеденения с БД
}
