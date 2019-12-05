package controller;

import model.DAO.CakeList;
import model.entities.ItemProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SearchListServlet")
public class SearchListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchCriterion = req.getParameter("searchCriterion");
        System.out.println("Обработка поиска " + searchCriterion);

        /**listing and loading product lists */
        CakeList cakeTable = new CakeList();

        List<ItemProduct> mCakeList = cakeTable.getCakesListSearch(searchCriterion);
    }
}
