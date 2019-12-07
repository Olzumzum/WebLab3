package model.DAO;

import model.DbConnection;
import model.entities.ItemProduct;

import java.sql.*;
import java.util.List;

/**
 * Work with the cake table
 */
public class CakeList extends ProductList implements WorkListProduct {

    /**
     * get the whole list
     */
    private final static String SQL_REQUEST_SHOW_ALL = "select * " +
            "from Cake " +
            "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id\n" +
            "JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id ";

    /**
     * get a list by assortment criterion
     */
    private final static String SQL_REQUEST_SHOW_CRITERION_ASSORTMENT = "select * " +
            "from Cake " +
            "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id\n" +
            "JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id " +
            " where assortment_cake_name = ?;";

    /**
     * get a list by search criterion
     */
    private final static String SQL_REQUEST_SEARCH = "select * " +
            "from Cake " +
            "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id " +
            "JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id " +
            "where product_name = ?;";

    /**
     * get a list by search criteria and assortment
     */
    private final static String SQL_REQUEST_SEARCH_AND_ASSORTMENT = "select * " +
            "from Cake " +
            "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id " +
            "INNER JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id " +
            "where product_name = ? andssortment_cake_name = ?";

    /**
     * добавить новую продукцию
     */
    private final static String SQL_REQUEST_INSERT = "insert into ItemProduct" +
            "(product_name, product_description, weight,price)" +
            " value (?, ?, ?, ?);";

    /**
     * получить id названия ассортимента
     */
    private final String SQL_REQUEST_GET_ID_ASSORTMENT = "select assortment_cake_id from AssortmentCake\n" +
            "where assortment_cake_name = ?;";

    /**
     * добавить запись в таблицу Cake
     */
    private final String SQL_REQUEST_INSERT_CAKE = "insert into Cake(assortment_cake_id, item_product_id) VALUE (?,?);";

    /** вернуть запись по id */
    private final String SQL_REQUEST_RETURN_RECORD_BY_ID = "select * from Cake " +
            "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id " +
            "INNER JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id " +
            "where IP.item_product_id = ?;";

    /** изменить запись по id */
    private final String SQL_REQUEST_SAVE_CHANGES = "update ItemProduct set product_name = ?, " +
            "product_description = ?, " +
            "                       weight = ?, price = ? " +
            "where item_product_id = ?;";

    /**удаление записи по id */
    private final String SQL_REQUEST_DELETE_CAKE = "delete from Cake where item_product_id = ?";
    private final String SQL_REQUEST_DELETE_ITEM_PRODUCT = "delete from ItemProduct where item_product_id = ?";

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
        List itemCakeList = null;
        try {

            statement = connection.prepareStatement(SQL_REQUEST_SHOW_ALL);
            result = statement.executeQuery();

            itemCakeList = getTable(result);
            connection.close();
            db.closeConnection();

        } catch (SQLException e) {
            System.out.println("Ошибка запроса");
            e.printStackTrace();
        }

        
        return itemCakeList;
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
        List itemCakeList = null;
        try {

            statement = connection.prepareStatement(SQL_REQUEST_SHOW_CRITERION_ASSORTMENT);
            statement.setString(1, criterion);
            result = statement.executeQuery();

            itemCakeList = getTable(result);

            connection.close();
            db.closeConnection();

        } catch (SQLException e) {
            System.out.println("Ошибка запроса");
            e.printStackTrace();
        }

        return itemCakeList;
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
        List itemCakeList = null;
        try {

            statement = connection.prepareStatement(SQL_REQUEST_SEARCH);
            statement.setString(1, searchCriterion);
            result = statement.executeQuery();

            itemCakeList = getTable(result);

            connection.close();
            db.closeConnection();

        } catch (SQLException e) {
            System.out.println("Ошибка запроса");
            e.printStackTrace();
        }

        return itemCakeList;
    }

    /**
     * get a list by search criteria and assortment
     *
     * @param searchCriterion
     * @param assortmentCriterion
     * @return
     */
    public List getCakesListSearchAndAssortment(String searchCriterion, String assortmentCriterion) {
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        PreparedStatement statement;
        ResultSet result = null;
        List itemCakeList = null;
        try {

            statement = connection.prepareStatement(SQL_REQUEST_SEARCH_AND_ASSORTMENT);
            statement.setString(1, searchCriterion);
            statement.setString(2, assortmentCriterion);
            result = statement.executeQuery();

            itemCakeList = getTable(result);

            connection.close();
            db.closeConnection();

        } catch (SQLException e) {
            System.out.println("Ошибка запроса");
            e.printStackTrace();
        }

        return itemCakeList;
    }

    /**
     * insert a new record in db
     *
     * @param itemProduct
     */
    public void insertProductIntoList(ItemProduct itemProduct, String assortmentName) {
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        PreparedStatement statement;
        ResultSet result = null;
        try {
            /** fill the columns with occupied */
            statement = connection.prepareStatement(SQL_REQUEST_INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, itemProduct.getmProductName());
            statement.setString(2, itemProduct.getmProductDescription());
            statement.setInt(3, itemProduct.getmWeight());
            statement.setInt(4, itemProduct.getmPrice());

            /** fullfill the request */
            statement.execute();

            /** get id of added record */
            result = statement.getGeneratedKeys();
            int idRecord = 0;
            if (result.next()) {
                idRecord = result.getInt(1);
                System.out.println("Значение id = " + idRecord);
            }

            int idAssortment = gettingListAssortmentCriterion(assortmentName);
            statement = connection.prepareStatement(SQL_REQUEST_INSERT_CAKE);
            statement.setInt(1, idAssortment);
            statement.setInt(2, idRecord);

            statement.execute();

            connection.close();
            db.closeConnection();

        } catch (SQLException e) {
            System.out.println("Ошибка запроса");
            e.printStackTrace();
        }
    }

    /**
     * вернуть id записи по названию ассортимента
     */
    public int gettingListAssortmentCriterion(String criterion) {
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        PreparedStatement statement;
        ResultSet resultSet;
        int idAssortment = 0;
        try {
            statement = connection.prepareStatement(SQL_REQUEST_GET_ID_ASSORTMENT);
            statement.setString(1, criterion);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                idAssortment = resultSet.getInt(1);
                System.out.println("Id ассортимента " + idAssortment);
            }

            connection.close();
            db.closeConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idAssortment;
    }

    /** вернуть запись по id */
    public ItemProduct getItemProductById(int idProduct){
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        PreparedStatement statement;
        ResultSet resultSet;
        try{
            statement = connection.prepareStatement(SQL_REQUEST_RETURN_RECORD_BY_ID);
            statement.setInt(1, idProduct);
            resultSet = statement.executeQuery();

            ItemProduct itemProduct = new ItemProduct();
            if(resultSet.next()){
                itemProduct.setmIdProduct(resultSet.getInt("item_product_id"));
                itemProduct.setmProductName(resultSet.getString("product_name"));
                itemProduct.setmProductDescription(resultSet.getString("product_description"));
                itemProduct.setmWeight(resultSet.getInt("weight"));
                itemProduct.setmPrice(resultSet.getInt("price"));
            }

            connection.close();
            db.closeConnection();

            return itemProduct;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**сохранить изменения в элементе по id */
    public boolean saveChangsItem(int idProduct, ItemProduct itemProduct){
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        PreparedStatement statement;
        ResultSet resultSet;
        try{
            statement = connection.prepareStatement(SQL_REQUEST_SAVE_CHANGES);
            statement.setString(1, itemProduct.getmProductName());
            statement.setString(2, itemProduct.getmProductDescription());
            statement.setInt(3, itemProduct.getmWeight());
            statement.setInt(4, itemProduct.getmPrice());
            statement.setInt(5, idProduct);

            statement.execute();

            connection.close();
            db.closeConnection();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось изменить запись");
            return false;
        }
    }

    /**удаление записи */
    public boolean deleteRecord(int idProduct){
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        PreparedStatement statement;
        ResultSet resultSet;
        try{
            statement = connection.prepareStatement(SQL_REQUEST_DELETE_CAKE);
            statement.setInt(1, idProduct);
            statement.execute();

            statement = connection.prepareStatement(SQL_REQUEST_DELETE_ITEM_PRODUCT);
            statement.setInt(1, idProduct);
            statement.execute();

            connection.close();
            db.closeConnection();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Удаление не завершено успешно");
            return false;
        }
    }
}
