<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: palm
  Date: 19.11.2019
  Time: 15:05
  Loading and displaying products in the form of blocks
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- connect JQuery -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <!-- connect JQuery ui -->
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet"
          type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

    <link rel="stylesheet" type="text/css" href="css/page_style.css">
    <title>Title</title>
</head>
<body>

<c:set var="roleRule" value="${roleRule}" />
<c:if test="${roleRule == true}">
<div>
    <a href="insert_page.jsp"> Добавить новый товар </a>
</div>
</c:if>

<table>
    <tr>
        <!-- Counter for the presentation of products line by line: in one line -->
        <c:set var="i" value="${0}"/>

        <c:forEach items="${listProduct}" var="item">
            <!-- If this is 0 element open container line -->
            <c:if test="${i == 0}">
                <div class="row">
            </c:if>
            <div class="item_cake">
                <div class="content_item_cake">
<!-- Admin Feature -->
                   <%-- <c:if test="${roleRule == true}"> --%>
                    <a href="edit_item_page.jsp?idProduct=${item.mIdProduct}"> Редактировать </a>
                    <a href="delete_page.jsp?idProduct=${item.mIdProduct}"> Удалить </a>
                        <%--  </c:if>--%>

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
                     <%-- If the item is the last in the line (i == 1)
                     then close the block --%>
                <c:when test="${i == 1}">
                    </div>
                    <c:set var="i" value="${0}"/>
                </c:when>

                <%-- If the item is not the last in the line (i! = 1), close the block --%>
                <c:otherwise>
                    <c:set var="i" value="${i+1}"/>
                </c:otherwise>
            </c:choose>

        </c:forEach>

    </tr>

</table>
</body>
</html>
