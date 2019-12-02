package model.DAO;

import model.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Work with the cake table
 */
public class CakeList extends ProductList implements WorkListProduct{
    /**
     * get all table items
     * @return List
     */
    @Override
    public List getAllCakes() {

        /** Соединение с БД */
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        Statement statement;
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
                    "       weight, price  from Cake" +
                    "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id" +
                    "JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id where assortment_cake_name = 'донаты'" +
                    ";");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getTable(result);
    }


}
