package model.DAO;

import model.DbConnection;
import model.entities.User;

import java.sql.*;

/**
 * Класс осуществляет работу с таблицей пользователей
 * все возможные манипуляции с этой таблице описаны здесь
 */
public class UserTable implements WorkUserTable {

    /** по умолчанию, все создаваемые пользователи - не администраторы,
     * задаем id роли "user"
     */
    private final int ROLE_ID = 2;
    private final String SQL_SEARCH_USER_EMAIL ="SELECT * from Users where email_user = ?";

    private String userRole;

    /**
     * Поиск пользователя по таблице
     * @param user
     * @return
     */
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
     * внесение новой записи в таблицу Users
     * @param user
     */
    @Override
    public void insetUserRecord(User user) {
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        String email = user.getEmailUser();
        String password = user.getPasswordUser();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into Users(email_user, password_user, role_id) " +
                    "value ('"+ email + "', '" + password + "', '" + ROLE_ID + "');");

            connection.close();
            db.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** возвращает роль пользователя */
    public String getUserRole(){
        return userRole;
    }

    public boolean getUserEmail(String userRole){
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.connect();

        PreparedStatement statement;
        ResultSet resultSet;

        try{
            statement = connection.prepareStatement(SQL_SEARCH_USER_EMAIL);
            statement.setString(1, userRole);

            resultSet = statement.executeQuery();

            while (resultSet.next())
                return false;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}
