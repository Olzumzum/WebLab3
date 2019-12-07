<%@ page import="model.DAO.AssortmentList" %>
<%@ page import="model.entities.ItemAssortment" %>
<%@ page import="java.util.ArrayList" %>
<!--
Страница представляет собой форму добавление продукта в базу данных
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <!-- connect JQuery -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <!-- connect JQuery ui -->
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet"
          type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

    <script type="text/javascript" src="js/loaderMenu.js"></script>
    <script type="text/javascript" src="js/insertProduct.js"></script>
    <link rel="stylesheet" href="css/insert_page.css">
    <link rel="stylesheet" href="css/fonts.css">
    <link rel="stylesheet" href="css/assortment_list.css">
    <title>Insert information of product</title>
</head>
<body>


<form id="insertProduct" class="insertProduct" action="InsertProductServlet" method="post">
    <h2 class="title"> Добавить новый продукт в базу</h2>

    <h3 class="subtitle"> Название продукта</h3>
    <input id="productName" name="productName" class="insertField" placeholder="Название продукта" required>

    <h3 class="subtitle"> Описание добавляемого продукта</h3>
    <input id="productDescription" name="productDescription" class="insertField description"
           placeholder="Описание добавляемого продукта" required>

    <p class="assort_item">
        <select name="assort" size="1">
            <option id="title_assort" value="">Ассортимент</option>
            <%
                AssortmentList assortmentList = new AssortmentList("AssortmentCake");
                String[] assortmentName = new String[assortmentList.getList().size()];
                int i = 0;
                for (ItemAssortment item : (ArrayList<ItemAssortment>) assortmentList.getList()) {
                    assortmentName[i] = item.getNameAssortment();
            %>
            <option name="assort_item" class="assort_item" value="<%= assortmentName[i] %>"><%= assortmentName[i] %></option>
            <%
                }
            %>
        </select>
    </p>

<h3 class="subtitle"> Вес </h3>
<input id="productWeight" name="productWeight" class="insertField" placeholder="Вес продукта" required>

<h3 class="subtitle"> Стоимость </h3>
<input id="productPrice" name="productPrice" class="insertField" placeholder="Стоимость вашего продукта" required>
<input type="submit" value="Занести в базу"
       onclick="verificationEnteredData(document.getElementById('insertProduct'))"/>

</form>

<div>
    <h4> Вернуться на предыдущую страницу</h4>
    <a href="cake_page.jsp"> Вернуться </a>
</div>


<!-- Диалог неверно введенных данных -->
<div id="succsess_dialog" title="Заполнение данных продукции">
    <p> Не все требуемые поля заполнены </p>
</div>

<script src="js/dialogOpeningSetting.js"></script>
</body>
</html>
