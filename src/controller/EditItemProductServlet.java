package controller;


import model.DAO.CakeList;
import model.entities.ItemProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditItemProductServlet")
public class EditItemProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idItemProduct = Integer.parseInt(req.getParameter("idProduct"));
        System.out.println("Мы были в сервлете EditItemProductServlet " + idItemProduct);

        CakeList cakeList = new CakeList();
        ItemProduct itemProduct = cakeList.getItemProductById(idItemProduct);

        req.setAttribute("nameEditProduct", itemProduct.getmProductName());
        req.setAttribute("descriptionProduct", itemProduct.getmProductDescription());
        req.setAttribute("weightProduct", itemProduct.getmWeight());
        req.setAttribute("priceProduct", itemProduct.getmPrice());

    }
}
