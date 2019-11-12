package model;

import java.sql.*;

/**
 * DataBase Connection Class
 */
public class DbConnection {

    private final String LOG_TAG = "Log_DataBase";

    /** DataBase details */
    private final static String DATABASE_USER_NAME = "root";
    private final static String DATABASE_USER_PASSWORD = "2";
    private final static String DATABASE_CONNECTION_URL = "jdbc:mysql://localhost:3306/laba2";

    private Connection connection = null;

    /**
     * Establishing a connection to the database
     */
    public Connection connect(){
        try {
            this.connection = DriverManager.getConnection(DATABASE_CONNECTION_URL, DATABASE_USER_NAME, DATABASE_USER_PASSWORD);
            //statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return this.connection;
    }

    /**
     * Close database connection
     */
    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
