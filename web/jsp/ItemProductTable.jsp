<%@ page import="model.entities.ItemProduct" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.DAO.CakeList" %><%--
  Created by IntelliJ IDEA.
  User: palm
  Date: 19.11.2019
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    CakeList cakeList = new CakeList();
%>
<table>
    <tr class="item_cake">
        <td class="content_item_cake">
            <table>
                <tr>
                    <td>
                        c:out value
                    </td>
                </tr>
                <tr>
                    <td> CakeImage</td>
                </tr>
                <tr>
                    <td> CakeDescription</td>
                </tr>
                <tr>
                    <td> CakeWeight</td>
                    <td> CakePrice</td>
                </tr>

            </table>
        </td>
    </tr>

</table>
</body>
</html>