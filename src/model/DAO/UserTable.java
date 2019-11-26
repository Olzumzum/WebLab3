package model.DAO;

import model.DbConnection;
import model.entities.AllUser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTable implements WorkUserTable {

    private String userRole;

    /**
     * Поиск пользователя по таблице
     * @param user
     * @return
     */
    @Override
    public boolean searchUserInTable(AllUser user) {

        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Users");
            while (resultSet.next()) {
                String dbEmail = resultSet.getString("email_user");
                String dbPassword = resultSet.getString("password_user");

                /** если введенный эмаил и пароль соответствуют пользователю из базы*/
                if ((dbEmail.equals(user.getEmailUser())) && (dbPassword.equals(user.getPasswordUser()))) {
                    userRole = resultSet.getString("role_id");

                    connection.close();
                    db.closeConnection();
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

    /**
     * Зарегистрировать нового пользователя
     * @param user
     */
    @Override
    public void insetUserRecord(AllUser user) {
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        String email = user.getEmailUser();
        String password = user.getPasswordUser();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into Users(email_user, password_user) " +
                    "value ('"+ email + "', '" + password + "');");

            connection.close();
            db.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUserRole(){
        return userRole;
    }

}
