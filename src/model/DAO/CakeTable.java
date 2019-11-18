package model.DAO;

import model.DbConnection;
import model.entities.ItemProduct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CakeTable implements WorkProductTable {

    final static String NAME_TABLE = "Cake";

    @Override
    public void showTable() {
        DbConnection db = new DbConnection();
        Connection connection = db.connect();

        ItemProduct itemProduct = new ItemProduct();

        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select product_name, assortment_cake_name, product_description, product_image, weight, price  from Cake\n" +
                    "INNER JOIN AssortmentCake AC on Cake.assortment_cake_id = AC.assortment_cake_id\n" +
                    "JOIN ItemProduct IP on Cake.item_product_id = IP.item_product_id");
            while(result.next()){
                itemProduct.setmProductName(result.getString("product_name"));
                itemProduct.setmProductDescription(result.getString("product_description"));
                itemProduct.setmProductImage(new byte[]{result.getByte("product_image")});
                itemProduct.setmWeight(result.getInt("weight"));
                itemProduct.setmPrice(result.getInt("price"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchAssortment(String nameAssortment) {

    }
}
