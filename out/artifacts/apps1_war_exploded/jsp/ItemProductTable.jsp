<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<table>
    <tr class="item_cake">
        <c:forEach items="${listCake}" var="item">

            <div class="content_item_cake">
            <c:out value="${item.mProductName}"/>
            <c:out value="${item.mProductImage}"/>
            <c:out value="${item.mProductDescription}"/>
            <c:out value="${item.mWeight}"/>
            <c:out value="${item.mPrice}"/>

            </div>
        </c:forEach>

    </tr>

</table>
</body>
</html>
