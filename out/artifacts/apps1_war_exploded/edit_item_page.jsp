<%--
  Created by IntelliJ IDEA.
  User: palm
  Date: 06.12.2019
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/EditItemProductServlet"/>
<jsp:useBean id="itemEditProduct" class="model.entities.ItemProduct"/>
<%
    String nameProdct = (String) request.getAttribute("nameEditProduct");
    String descriptionProduct = (String) request.getAttribute("descriptionProduct");
    if(descriptionProduct == null)
        descriptionProduct = "*";
    int weightProduct = (int) request.getAttribute("weightProduct");
    int priceProduct = (int) request.getAttribute("priceProduct");

%>

<jsp:setProperty name="itemEditProduct" property="mProductName" value="<%= nameProdct%>"/>
<jsp:setProperty name="itemEditProduct" property="mProductDescription" value="<%= descriptionProduct %>"/>
<jsp:setProperty name="itemEditProduct" property="mWeight" value="<%= weightProduct%>" />
<jsp:setProperty name="itemEditProduct" property="mPrice" value="<%= priceProduct%>" />

<form id="insertProduct" class="insertProduct" action="EditItemProductServlet" method="post">

    <h2 class="title"> Редактировать товар</h2>

    <h3 class="subtitle"> Название продукта</h3>
    <input id="productName" name="productName" class="insertField" value="${itemEditProduct.mProductName}" required>

    <h3 class="subtitle"> Описание добавляемого продукта</h3>
    <input id="productDescription" name="productDescription" class="insertField description"
           value="${itemEditProduct.mProductDescription}" required>

    <h3 class="subtitle"> Вес </h3>
    <input id="productWeight" name="productWeight" class="insertField"
           value="${itemEditProduct.mWeight}" required>

    <h3 class="subtitle"> Стоимость </h3>
    <input id="productPrice" name="productPrice" class="insertField"
           value="${itemEditProduct.mPrice}" required>
    <input type="submit" value="Редактировать продукт"
           onclick="verificationEnteredData(document.getElementById('insertProduct'))"/>
</form>
</body>
</html>
