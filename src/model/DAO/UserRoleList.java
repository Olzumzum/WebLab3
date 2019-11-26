package model.DAO;

import model.DbConnection;
import model.entities.AllUser;
import model.entities.UserRole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRoleList {

    private List<UserRole> userRoles = new ArrayList<>();

    /**
     * Заполняет список возможных ролей
     * @return
     */
    private void getListUserRole(){
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

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

    public String roleCheck(String userRole) {
        getListUserRole();
        int idUserRole = Integer.parseInt(userRole);

        /** Если пользователь администратор */
        for(UserRole role: userRoles){
            if (idUserRole == role.getIdUserRole())
                return role.getNameRole();
        }

        return null;
    }


}
