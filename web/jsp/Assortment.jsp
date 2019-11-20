<%@ page import="model.DAO.AssortmentList" %>
<%@ page import="model.entities.ItemAssortment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: palm
  Date: 19.11.2019
  Time: 18:30
    Создан для отображения списка ассортимента продукции
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/assortment.css">
    <title>Title</title>
</head>
<body>
<!--Подменю -->
<div class="submenu">
    <h2 class="title_submenu">Ассортимент</h2>
    <ul><%
        AssortmentList assortmentList = new AssortmentList("AssortmentCake");
        for (ItemAssortment item : (ArrayList<ItemAssortment>) assortmentList.getList()) {
        %>

        <li class="subparagraph_submenu">
            <a href="#" class="submenu_item">
                <%= item.getNameAssortment() %>
            </a>
        </li>
            <%
            }
            %>
</div>
</body>
</html>
