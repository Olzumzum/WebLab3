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
    <script type="text/javascript" src="js/loaderMenu.js"></script>
    <script type="text/javascript" src="edit_item_page.jsp"></script>
    <title>Title</title>
</head>
<body>
<jsp:include page="/EditItemProductServlet"/>
<jsp:useBean id="itemEditProduct" class="model.entities.ItemProduct"/>
<%
    int idProduct = (int) request.getAttribute("idProduct");
    String nameProdct = (String) request.getAttribute("nameEditProduct");
    String descriptionProduct = (String) request.getAttribute("descriptionProduct");
    int weightProduct = (int) request.getAttribute("weightProduct");
    int priceProduct = (int) request.getAttribute("priceProduct");

%>

<jsp:setProperty name="itemEditProduct" property="mProductName" value="<%= nameProdct%>"/>
<jsp:setProperty name="itemEditProduct" property="mIdProduct" value="<%= idProduct%>"/>
<jsp:setProperty name="itemEditProduct" property="mProductDescription" value="<%= descriptionProduct %>"/>
<jsp:setProperty name="itemEditProduct" property="mWeight" value="<%= weightProduct%>"/>
<jsp:setProperty name="itemEditProduct" property="mPrice" value="<%= priceProduct%>"/>

<form id="insertProduct" class="insertProduct" action="SaveChangesServlet" method="post">

    <h2 class="title"> Редактировать товар</h2>

    <input name="idProduct" value="${itemEditProduct.mIdProduct}" hidden>
    <h3 class="subtitle"> Название продукта</h3>
    <input id="productName" name="productName" class="insertField" value="${itemEditProduct.mProductName}" required>

    <h3 class="subtitle"> Описание добавляемого продукта</h3>
    <input id="productDescription" name="productDescription" class="insertField description"
           value="${itemEditProduct.mProductDescription}">

    <h3 class="subtitle"> Вес </h3>
    <input id="productWeight" name="productWeight" class="insertField"
           value="${itemEditProduct.mWeight}" required>

    <h3 class="subtitle"> Стоимость </h3>
    <input id="productPrice" name="productPrice" class="insertField"
           value="${itemEditProduct.mPrice}" required>
    <input type="submit" value="Редактировать продукт"
           onclick="verificationEnteredData(document.getElementById('insertProduct'))"/>
</form>


<!-- Диалог неверно введенных данных -->
<form>
    <div id="succsess_dialog" title="Заполнение данных продукции">
        <p> Не все требуемые поля заполнены </p>
    </div>
</form>
<!-- Диалог успеха сохранения -->
<form>
    <div id="succsess_save_dialog" title="Заполнение данных продукции">
        <p> Изменения успешно сохранены </p>
    </div>
</form>

</body>
<script src="js/dialogOpeningSetting.js"></script>
</html>