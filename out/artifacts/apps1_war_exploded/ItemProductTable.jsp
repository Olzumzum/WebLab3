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
    <link rel="stylesheet" type="text/css" href="css/page_style.css">
    <title>Title</title>
</head>
<body>


<table>
    <tr>
        <!-- Счетчик для отображения продукции построчно: в одной строке 2 элемента -->
        <c:set var="i" value="${0}"/>

        <c:forEach items="${listCake}" var="item">
            <!-- Если это 0 элемент открываем контейнер-строчку -->
            <c:if test="${i == 0}">
                <div class="row">
            </c:if>
            <div class="item_cake">
                <div class="content_item_cake">

                    <h3 class="name_cake">
                        <c:out value="${item.mProductName}"/>
                    </h3>
                    <h4>
                        <c:out value="${item.mProductDescription}"/>
                    </h4>
                    <h4 class="price">
                        <c:out value="${item.mWeight}"/> гр.
                    </h4>
                    <h4 class="weight">
                        <c:out value="${item.mPrice}"/> руб.
                    </h4>
                </div>
            </div>

            <c:choose>
                <%-- Если элемент последний в строчке (i == 1)
                то закрываем блок --%>
                <c:when test="${i == 1}">
                    </div>
                    <c:set var="i" value="${0}"/>
                </c:when>

                <%-- Если элемент не последний в строчке (i != 1) закрываем блок --%>
                <c:otherwise>
                    <c:set var="i" value="${i+1}"/>
                </c:otherwise>
            </c:choose>

        </c:forEach>

    </tr>

</table>
</body>
</html>
