package controller;

import model.DAO.UserTable;
import model.DAO.WorkUserTable;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emailForm = req.getParameter("email");
        String passwordForm = req.getParameter("password");

        User user = new User();
        user.setEmailUser(emailForm);
        user.setPasswordUser(passwordForm);

        WorkUserTable userTable = new UserTable();
        userTable.insetUserRecord(user);
    }
}
