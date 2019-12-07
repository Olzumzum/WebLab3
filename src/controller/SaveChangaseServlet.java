package controller;

import model.DAO.CakeList;
import model.entities.ItemProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** сервлет сохраняет измениня записи в бд */
@WebServlet("/SaveChangesServlet")
public class SaveChangaseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        /** получаем данные формы */
        String nameProduct = req.getParameter("productName");
        String descriptionProduct = req.getParameter("productDescription");
        int weightProduct = Integer.parseInt(req.getParameter("productWeight"));
        int priceProduct = Integer.parseInt(req.getParameter("productPrice"));

        ItemProduct itemProduct = new ItemProduct(nameProduct, descriptionProduct,
                null, weightProduct, priceProduct);

        /** по id получаем изменяемую запись */
        int idEditRecord = Integer.parseInt(req.getParameter("idProduct"));
        CakeList cakeList = new CakeList();

        boolean succsessStatus = cakeList.saveChangsItem(idEditRecord, itemProduct);
        req.setAttribute("succsessStatusConservation", succsessStatus);

    }
}
