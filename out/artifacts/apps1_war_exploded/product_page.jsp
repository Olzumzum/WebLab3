<%--
  Created by IntelliJ IDEA.
  User: palm
  Date: 19.12.2019
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <!-- connect JQuery -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <!-- connect JQuery ui -->
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet"
          type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

    <link rel="stylesheet" href="css/fonts.css">
    <link rel="stylesheet" href="css/main_menu.css">

    <script type="text/javascript" src="js/loaderMenu.js"></script>
    <title>Title</title>
</head>
<body>
<!-- Контейнер для главного меню -->
<div id="mailMenu"></div>


<!-- Поиск -->
<div class="search">
    <jsp:include page="search_form.jsp"/>
</div>

<input id="test_field" value="Содержимое"/>



<!-- Контейнер для нижнего меню -->
<div id="footerMenu"></div>



</body>
</html>
