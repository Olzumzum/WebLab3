package controller;

import model.DAO.CakeList;
import model.entities.ItemProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class to insert a product record in the db
 */
@WebServlet("/InsertProductServlet")
public class InsertProductServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String nameProduct = null;
        String descriptionProduct = null;
        /** By default, the weight and price of the product cannot be zero */
        int weightProduct = 0;
        int priceProduct = 0;
        String assortmentName = null;

        /**geting product data from a form */
        nameProduct = req.getParameter("productName");
        descriptionProduct = req.getParameter("productDescription");
        try {
            weightProduct = Integer.parseInt(req.getParameter("productWeight"));
            priceProduct = Integer.parseInt(req.getParameter("productPrice"));
        }catch (NumberFormatException ex){
            ex.printStackTrace();
            System.out.println("Введен неверный формат данных");
            req.getRequestDispatcher("insert_page.jsp").forward(req, resp);
        }

        assortmentName = req.getParameter("assort");
        if(assortmentName.equals("Ассортимент")) {
            System.out.println("Неверное значение поля ассортимент");
            req.getRequestDispatcher("insert_page.jsp").forward(req, resp);
        }


        /** if all required fields are filled */
        if((nameProduct != null) && (descriptionProduct != null) && (weightProduct != 0) && (priceProduct != 0)) {
            /**new product creation */
            ItemProduct itemProduct = new ItemProduct();
            itemProduct.setmProductName(nameProduct);
            itemProduct.setmProductDescription(descriptionProduct);
            itemProduct.setmWeight(weightProduct);
            itemProduct.setmPrice(priceProduct);

            CakeList cakeList = new CakeList();
            cakeList.insertProductIntoList(itemProduct, assortmentName);
        } else {
            System.out.println("Неверно введены данные");
            req.getRequestDispatcher("insert_page.jsp").forward(req, resp);
        }

        req.getRequestDispatcher("cake_page.jsp").forward(req, resp);
    }
}
