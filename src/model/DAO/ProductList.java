package model.DAO;

import model.DbConnection;
import model.entities.ItemProduct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/** 
 * Класс общей логики для таблицый продукции 
 */
abstract class ProductList {

    /** вернуть таблицу по запросу*/
    List getTable(ResultSet resultSet){
        /** Соединение с БД */
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        /** инициализация списка */
        List<ItemProduct> mListProducts = new ArrayList<>();

        /** заполнение списка */
        try {
            while (resultSet.next()) {
                ItemProduct itemProduct = new ItemProduct();
                itemProduct.setmProductName(resultSet.getString("product_name"));
                itemProduct.setmProductDescription(resultSet.getString("product_description"));
                itemProduct.setmProductImage(new byte[]{resultSet.getByte("product_image")});
                itemProduct.setmWeight(resultSet.getInt("weight"));
                itemProduct.setmPrice(resultSet.getInt("price"));

                mListProducts.add(itemProduct);
            }

            connection.close();
            db.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return mListProducts;
    }
}
