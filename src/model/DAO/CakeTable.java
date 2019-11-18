package model.DAO;

import model.DbConnection;
import model.entities.ItemProduct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CakeTable extends ProductTable {

    public List getTableCake() {

        /** Соединение с БД */
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        Statement statement = null;
        ResultSet result = null;
        try {
            statement = connection.createStatement();

            result = statement.executeQuery("select product_name, assortment_cake_name, product_description, " +
                    "product_image, weight, price  " +
                    "from Cake \n" +
                    "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id\n" +
                    "JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getTable(result);
    }

}
