package controller;

import model.DAO.UserTable;
import model.DAO.WorkUserTable;
import model.entities.User;

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
        /** getting user data from a form */
        String emailForm = req.getParameter("email");
        String passwordForm = req.getParameter("password");

        /** user creation with received fields */
        User user = new User();
        user.setEmailUser(emailForm);
        user.setPasswordUser(passwordForm);

        /** record in the database of a new user */
        WorkUserTable userTable = new UserTable();
        userTable.insetUserRecord(user);
    }
}
