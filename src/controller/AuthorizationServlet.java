package controller;

import model.DAO.UserTable;
import model.entities.AllUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String emailForm = req.getParameter("email");
        String passwordForm = req.getParameter("password");

        AllUser user = new AllUser();
        user.setEmailUser(emailForm);
        user.setPasswordUser(passwordForm);

        UserTable userTable = new UserTable();
        if (userTable.searchUserInTable(user)) {
            System.out.println("Пользователь успешно авторизован");
            HttpSession session = req.getSession();

            session.setAttribute("email", emailForm);
            session.setAttribute("password", passwordForm);

            String userRole = userTable.getUserRole();
            session.setAttribute("userRole",userRole);

            req.getRequestDispatcher("/Authorization.jsp").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("/authorization.html").forward(req, resp);
        }


    }
}
