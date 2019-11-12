package model.workTables;

import model.DbConnection;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTable implements WorkUserTable {
    @Override
    public boolean searchUserInTable(User user) {

        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Users");
            while (resultSet.next()) {
                String dbEmail = resultSet.getString("email_user");
                String dbPassword = resultSet.getString("password_user");

                /** если введенный эмаил и пароль соответствуют пользователю из базы*/
                if ((user.getEmailUser() == dbEmail) && (user.getPasswordUser() == dbPassword)) {
                    return true;
                }
            }

            connection.close();
            db.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void insetUserRecord(User user) {
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into Users (email_user) values(" + user.getEmailUser() + ") ," +
                    " (password_user) values (" + user.getPasswordUser() + ")");

            connection.close();
            db.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
