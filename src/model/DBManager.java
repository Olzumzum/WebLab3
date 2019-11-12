package model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Класс подключения к БД
 */
public class DBManager {



    final static String DATABASE_USER_NAME = "root";
    final static String DATABASE_USER_PASSWORD = "2";
    final static String DATABASE_CONNECTION_URL = "jdbc:mysql://localhost:3306/laba2";

    /**
     * Установка соединения с БД
     */
    public static void getConnectionDB(){
        try {
            Connection connection = DriverManager.getConnection(DATABASE_CONNECTION_URL, DATABASE_USER_NAME, DATABASE_USER_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
