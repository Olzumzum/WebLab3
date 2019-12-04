package model.DAO;

import model.DbConnection;

import java.sql.*;
import java.util.List;

/**
 * Work with the cake table
 */
public class CakeList extends ProductList implements WorkListProduct {

    String mSwqlShowAll = "select product_name, assortment_cake_name, product_description, " +
            "product_image, weight, price  " +
            "from Cake " +
            "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id\n" +
            "JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id " +
            " where product_name = ?;";

    /**
     * get all table items
     *
     * @return List
     */
    @Override
    public List getAllCakes() {

        /** Соединение с БД */
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        PreparedStatement statement;
        ResultSet result = null;
        try {

            statement = connection.prepareStatement(mSwqlShowAll);
            statement.setString(1, "Макарун сладкий");
            result = statement.executeQuery();

        } catch (SQLException e) {
            System.out.println("Ошибка запроса");
            e.printStackTrace();
        }

        return getTable(result);
    }

    @Override
    public List getCakesAssortmentCriterion(String criterion) {
        criterion = "донаты";

        /** Соединение с БД */
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        Statement statement;
        ResultSet result = null;
        try {
            statement = connection.createStatement();

            result = statement.executeQuery("select product_name, product_description," +
                    "weight, price  from Cake" +
                    "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id" +
                    "JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id where assortment_cake_name ='донаты'" +
                    ";");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getTable(result);
    }


}
