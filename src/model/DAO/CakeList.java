package model.DAO;

import model.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Work with the cake table
 */
public class CakeList extends ProductList implements WorkListProduct {

    /** get the whole list */
    private final static String SQL_REQUEST_SHOW_ALL = "select product_name, assortment_cake_name, product_description, " +
            "product_image, weight, price  " +
            "from Cake " +
            "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id\n" +
            "JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id ";

    /** get a list by assortment criterion */
    private final static String SQL_REQUEST_SHOW_CRITERION_ASSORTMENT = "select product_name, assortment_cake_name, product_description, " +
            "product_image, weight, price  " +
            "from Cake " +
            "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id\n" +
            "JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id " +
            " where assortment_cake_name = ?;";

    /** get a list by search criterion */
    private final static String SQL_REQUEST_SEARCH = "select product_name, assortment_cake_name, product_description," +
            "       product_image, weight, price  from Cake" +
            "                                              INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id" +
            "                                              JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id " +
            "where product_name = ?;";

    /** get a list by search criteria and assortment */
    private final static String SQL_REQUEST_SEARCH_AND_ASSORTMENT = "select product_name, assortment_cake_name, product_description," +
            " product_image, weight, price from Cake " +
            "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id " +
            "INNER JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id " +
            "where product_name = ? andssortment_cake_name = ?";


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

    /**
     * get a list by assortment criterion
     *
     * @param criterion
     * @return List
     */
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

    /**
     * return list of cakes by search
     *
     * @param searchCriterion
     * @return List
     */
    public List getCakesListSearch(String searchCriterion) {
/** Соединение с БД */
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        PreparedStatement statement;
        ResultSet result = null;
        try {

            statement = connection.prepareStatement(SQL_REQUEST_SEARCH);
            statement.setString(1, searchCriterion);
            result = statement.executeQuery();

        } catch (SQLException e) {
            System.out.println("Ошибка запроса");
            e.printStackTrace();
        }

        return getTable(result);
    }

    /**
     * get a list by search criteria and assortment
     * @param searchCriterion
     * @param assortmentCriterion
     * @return
     */
    public List getCakesListSearchAndAssortment(String searchCriterion, String assortmentCriterion){
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        PreparedStatement statement;
        ResultSet result = null;
        try {

            statement = connection.prepareStatement(SQL_REQUEST_SEARCH_AND_ASSORTMENT);
            statement.setString(1, searchCriterion);
            statement.setString(2, assortmentCriterion);
            result = statement.executeQuery();

        } catch (SQLException e) {
            System.out.println("Ошибка запроса");
            e.printStackTrace();
        }

        return getTable(result);
    }
}
