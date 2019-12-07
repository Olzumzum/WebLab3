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
 * сервлет сохраняет измениня записи в бд
 */
@WebServlet("/SaveChangesServlet")
public class SaveChangaseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        /** изменяемый объект */
        ItemProduct itemProduct = null;

        /** поля изменяемого объекта */
        String nameProduct = null;
        String descriptionProduct = null;
        Integer weightProduct = null;
        Integer priceProduct = null;

        /** получаем данные формы */
        nameProduct = req.getParameter("productName");
        descriptionProduct = req.getParameter("productDescription");

        /** проверка вводимых данных */
        try {
            weightProduct = Integer.parseInt(req.getParameter("productWeight"));
            priceProduct = Integer.parseInt(req.getParameter("productPrice"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("Неверный формат данных");
            req.getRequestDispatcher("edit_item_page.jsp").forward(req, resp);
        }

        if ((weightProduct != null) && (priceProduct != null)) {
            itemProduct = new ItemProduct(nameProduct, descriptionProduct,
                    null, weightProduct, priceProduct);

            /** по id получаем изменяемую запись */
            int idEditRecord = Integer.parseInt(req.getParameter("idProduct"));
            CakeList cakeList = new CakeList();

            boolean succsessStatus = cakeList.saveChangsItem(idEditRecord, itemProduct);
            req.setAttribute("succsessStatusConservation", succsessStatus);
        }

    }
}
