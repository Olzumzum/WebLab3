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
        String searchCriterion = req.getParameter("searchCriterion");
        String assortCriterion = req.getParameter("assort");

        HttpSession session = req.getSession();
        List<ItemProduct> mCakeList = null;


            /**listing and loading product lists */
            CakeList cakeTable = new CakeList();
            if ((assortCriterion == null) && (searchCriterion == null)) {
                /** get list all products */
                mCakeList = cakeTable.getAllCakes();
                req.setAttribute("listCake", mCakeList);
            } else {
                /** search by two criteria */
                if ((assortCriterion != null) && (searchCriterion != null)) {
                    cakeTable.getCakesListSearchAndAssortment(searchCriterion, assortCriterion);
                    req.setAttribute("listCake", mCakeList);
                }

                /** search by one criteria */
                if (searchCriterion == null)
                /** get list by assortment criterion */
                    mCakeList = cakeTable.getCakesAssortmentCriterion(assortCriterion);
                req.setAttribute("listCake", mCakeList);

                if (assortCriterion == null) {
                    mCakeList = cakeTable.getCakesListSearch(searchCriterion);
                    req.setAttribute("listCake", mCakeList);
                    String url = "cake_page.jsp?searchCriterion=" + req.getParameter("searchCriterion");


                }
            }


            /** filling in session data */


            /** getting user role */
            session.setAttribute("roleRule", roleCheck(session));
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
