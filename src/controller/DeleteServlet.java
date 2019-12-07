package controller;

import model.DAO.CakeList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        int idEditRecord = Integer.parseInt(req.getParameter("idProduct"));
        CakeList cakeList = new CakeList();
        boolean successState = cakeList.deleteRecord(idEditRecord);

        req.getRequestDispatcher("cake_page.jsp").forward(req, resp);
    }
}
