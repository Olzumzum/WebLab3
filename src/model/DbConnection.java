package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DataBase Connection Class
 */
public class DbConnection {

    private final String LOG_TAG = "Log_DataBase";

    /** DataBase details */
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_HOST = "localhost";
    private static String DB_PORT = "3306";
    private static String DB_NAME = "laba2";
    private final static String DATABASE_USER_NAME = "root";
    private final static String DATABASE_USER_PASSWORD = "2";

    /**Url для соединения с бд */
    private String connectionUrl = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
    private Connection connection;

    /**
     * Establishing a connection to the database
     */
    public Connection connect(){
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(connectionUrl, DATABASE_USER_NAME, DATABASE_USER_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Проблемы с подключением к базе данных");
        }

        return connection;
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
