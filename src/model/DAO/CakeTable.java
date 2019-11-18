package model.DAO;

import model.DbConnection;
import model.entities.ItemProduct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CakeTable implements WorkProductTable {

    /**
     * Название таблицы к кооторой идет обращение
     */
    final static String NAME_TABLE = "Cake";
    /**
     * Списко продукции, который будет отображен
     */
    private List<ItemProduct> mListProducts = null;

    @Override
    public List getTable() {
        /** Соединение с БД */
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        /** инициализация списка */
        mListProducts = new ArrayList<>();

        /**Запрос */
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select product_name, assortment_cake_name, product_description, product_image, weight, price  " +
                    "from " + NAME_TABLE + " \n" +
                    "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id\n" +
                    "JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id");

            while (result.next()) {
                ItemProduct itemProduct = new ItemProduct();
                itemProduct.setmProductName(result.getString("product_name"));
                itemProduct.setmProductDescription(result.getString("product_description"));
                itemProduct.setmProductImage(new byte[]{result.getByte("product_image")});
                itemProduct.setmWeight(result.getInt("weight"));
                itemProduct.setmPrice(result.getInt("price"));

                mListProducts.add(itemProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mListProducts;
    }

    @Override
    public void searchAssortment(String nameAssortment) {

    }
}
