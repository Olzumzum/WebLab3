package controller;

import model.DAO.UserTable;
import model.DAO.WorkUserTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CheckUserEmailServlet")
public class CheckUserEmailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String emailForm = req.getParameter("emailU");
        WorkUserTable userTable = new UserTable();

        if(! ((UserTable) userTable).getUserEmail(emailForm) )
            resp.getWriter().write("Пользователь существует");

    }
}
