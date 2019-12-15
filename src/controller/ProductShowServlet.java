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
import java.util.List;

/**
 * Download product lists and add data to the session.
 * obtaining user rights information
 */

@WebServlet("/ProductShowServlet")
public class ProductShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        List<ItemProduct> mCakeList = null;
        String url = null;
        /**listing and loading product lists */
        CakeList cakeTable = new CakeList();

        HttpSession session = req.getSession();
        String searchCriterion = req.getParameter("searchCriterion");
        String assortCriterion = req.getParameter("assort");
        //assortCriterion = "Донат";


        if (searchCriterion != null) {
            mCakeList = cakeTable.getCakesListSearch(searchCriterion);
            url = "cake_page.jsp?searchCriterion=" + req.getParameter("searchCriterion");

        }

        if(assortCriterion == "Донат"){
            mCakeList = cakeTable.getCakesListSearch(searchCriterion);
            req.setAttribute("listCake", mCakeList);
            url = "cake_page.jsp?searchCriterion=" + assortCriterion;
        }

        req.setAttribute("listCake", mCakeList);
        session.setAttribute("roleRule", roleCheck(session));

        req.getRequestDispatcher(url).forward(req, resp);
    }


    /**
     * Сheck user rights
     *
     * @param session
     * @return
     */
    private boolean roleCheck(HttpSession session) {
        String userRole = String.valueOf(session.getAttribute("userRole"));

        if (!userRole.equals("null")) {
            UserRoleList userRoleList = new UserRoleList();
            String role = userRoleList.roleCheck(userRole);
            System.out.println("Наша роль " + role);
            return role.equals("admin");
        }
        return false;
    }
}
