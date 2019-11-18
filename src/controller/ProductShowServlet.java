package controller;

import model.DAO.CakeTable;
import model.entities.ItemProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ProductShowServlet")
public class ProductShowServlet extends HttpServlet {

    private List<ItemProduct> mCakeList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CakeTable cakeTable = new CakeTable();
        mCakeList = cakeTable.getTableCake();
        req.setAttribute("listCake", mCakeList);
    }
}
