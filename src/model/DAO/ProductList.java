package model.DAO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.entities.ItemProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс общей логики для таблицый продукции
 */
abstract class ProductList {

    /**
     * вернуть таблицу по запросу
     */
    List getTable(ResultSet resultSet) {


        /** инициализация списка */
        List<ItemProduct> mListProducts = new ArrayList<>();

        /** заполнение списка */
        try {
            while (resultSet.next()) {
                ItemProduct itemProduct = new ItemProduct();
                itemProduct.setmIdProduct(resultSet.getInt("item_product_id"));
                itemProduct.setmProductName(resultSet.getString("product_name"));
                itemProduct.setmProductDescription(resultSet.getString("product_description"));
                itemProduct.setmWeight(resultSet.getInt("weight"));
                itemProduct.setmPrice(resultSet.getInt("price"));


                mListProducts.add(itemProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mListProducts;
    }

   /* Integer getIdProductRecord() {

    }*/
}
