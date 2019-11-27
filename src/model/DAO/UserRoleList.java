package model.DAO;

import model.DbConnection;
import model.entities.UserRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс,осуществляющий работу с ролями:
 * заполняет список существующих ролей
 */
public class UserRoleList {

    /** список существующих в бд ролей */
    private List<UserRole> userRoles = new ArrayList<>();

    /**
     * Заполняет список возможных ролей
     * @return
     */
    private void getListUserRole(){
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        /** получение списка ролей из бд */
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from RoleUser");
            while (resultSet.next()){
                UserRole userRole = new UserRole();
                userRole.setIdUserRole(resultSet.getInt("id_role"));
                userRole.setNameRole(resultSet.getString("name_role"));

                userRoles.add(userRole);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** возвращает название роли по id роли, лежащему в таблице пользователей */
    public String roleCheck(String userRole) {
        /** получаем список ролей */
        getListUserRole();
        /** получаем id роли из бд пользователей */
        int idUserRole = Integer.parseInt(userRole);

        /** Если id в бд пользователя равно id в бд роли,
         * возвращаем название роли
         * */
        for(UserRole role: userRoles){
            if (idUserRole == role.getIdUserRole())
                return role.getNameRole();
        }

        return null;
    }


}
