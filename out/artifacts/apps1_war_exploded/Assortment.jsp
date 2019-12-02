<%@ page import="model.DAO.AssortmentList" %>
<%@ page import="model.entities.ItemAssortment" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: palm
  Date: 19.11.2019
  Time: 18:30
    Создан для отображения списка ассортимента продукции
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/assortment.css">

    <title>Title</title>
</head>
<body>
<!--Подменю -->

<%

%>
<div class="submenu">
    <h2 class="title_submenu">Ассортимент</h2>
    <ul><%
        AssortmentList assortmentList = new AssortmentList("AssortmentCake");
        String[] assortmentName = new String[assortmentList.getList().size()];
        int i = 0;
        for (ItemAssortment item : (ArrayList<ItemAssortment>) assortmentList.getList()) {
            assortmentName[i] = item.getNameAssortment();
        %>

        <li id="submenu" class="subparagraph_submenu">
            <a href="cake_page.jsp?assort=<%= item.getNameAssortment() %>" class="submenu_item">
                <h3 id="assName"><%= assortmentName[i] %>
                </h3>
            </a>
        </li>
            <%
            }
            %>
</div>

<script src="${pageContext.request.contextPath}/js/assortment.js"></script>
</body>
</html>
