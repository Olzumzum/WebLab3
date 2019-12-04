package model.DAO;

import model.DbConnection;

import java.sql.*;
import java.util.List;

/**
 * Work with the cake table
 */
public class CakeList extends ProductList implements WorkListProduct {

    private final static String SQL_REQUEST_SHOW_ALL = "select product_name, assortment_cake_name, product_description, " +
            "product_image, weight, price  " +
            "from Cake " +
            "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id\n" +
            "JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id ";

    private final static String SQL_REQUEST_SHOW_CRITERION_ASSORTMENT = "select product_name, assortment_cake_name, product_description, " +
            "product_image, weight, price  " +
            "from Cake " +
            "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id\n" +
            "JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id " +
            " where assortment_cake_name = ?;";

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

            statement = connection.prepareStatement(SQL_REQUEST_SHOW_ALL);
            result = statement.executeQuery();

        } catch (SQLException e) {
            System.out.println("Ошибка запроса");
            e.printStackTrace();
        }

        return getTable(result);
    }

    @Override
    public List getCakesAssortmentCriterion(String criterion) {

        /** Соединение с БД */
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        PreparedStatement statement;
        ResultSet result = null;
        try {

            statement = connection.prepareStatement(SQL_REQUEST_SHOW_CRITERION_ASSORTMENT);
            statement.setString(1, criterion);
            result = statement.executeQuery();

        } catch (SQLException e) {
            System.out.println("Ошибка запроса");
            e.printStackTrace();
        }

        return getTable(result);
    }


}
