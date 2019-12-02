package model.DAO;

import controller.ProductShowServlet;
import model.DbConnection;
import model.entities.ItemAssortment;

import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Загрузка ассортимента выбранной категории продукции их БД
 */
public class AssortmentList {
    /** Переменная для получения имени таблицы ассортимента
     * таких таблиц несколько в зависимости от вида продукции
     */
    private String mNameTable = null;

    /** инициализация списка */
    private List<ItemAssortment> mListAssortment = new ArrayList<>();


    public AssortmentList(String nameTable) {
      mNameTable = nameTable;
    }

    /**
     * Заполнить список ассортимента из базы данных
     */
    private void lsitFilling() {
        /** Подключаемся к базе данных */
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.connect();


        /** Запрос к БД */
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select assortment_cake_name from " + mNameTable + " ;");

        /** Заполнение списка */
        while(resultSet.next()){
            ItemAssortment itemAssortment = new ItemAssortment(resultSet.getString("assortment_cake_name"));
            mListAssortment.add(itemAssortment);
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /** если список еще не заполнен, вызвать функцию listFilling
     * иначе вернуть уже существующий заполненный список
     * @return List<ItemAssortment>
     */
    public List getList(){
        if(mListAssortment.isEmpty())
            lsitFilling();

        return mListAssortment;

    }

    public void gettingListAssortmentCriterion(String criterion) {

    }
}
