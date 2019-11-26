package controller;

import model.DAO.CakeList;
import model.DAO.UserRoleList;
import model.entities.ItemProduct;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession session = req.getSession();
        CakeList cakeTable = new CakeList();
        mCakeList = cakeTable.getTableCake();
        req.setAttribute("listCake", mCakeList);

        System.out.println("Мы тут");
        session.setAttribute("roleRule", roleCheck(session));
    }

    private boolean roleCheck(HttpSession session) {
        String userRole = String.valueOf(session.getAttribute("userRole"));

        if (!userRole.equals("null")) {
            UserRoleList userRoleList = new UserRoleList();
            String role = userRoleList.roleCheck(userRole);
            System.out.println("Наша роль " + role);
            if (role == "admin")
                return true;
        }
        return false;
    }
}
