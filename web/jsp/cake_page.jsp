<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <!-- connect JQuery -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
    <!-- connect JQuery ui -->
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet"
          type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

    <link rel="stylesheet" type="text/css" href="../css/page_style.css">
    <link rel="stylesheet" href="../css/fonts.css">
    <script type="text/javascript" src="../js/loaderMenu.js"></script>
    <title> Tasty House </title>
</head>
<body>

<!-- Контейнер для главного меню -->
<div id="mailMenu"></div>


<div class="container">
    <!--Подменю -->
    <div class="submenu">
        <h2 class="title_submenu">Ассортимент</h2>
        <ul>
            <li class="
				subparagraph_submenu">Донаты
            </li>
            <li class="
			subparagraph_submenu">Макаруны
            </li>
            <li class="
			subparagraph_submenu">Пирожные
            </li>
            <li class="
			subparagraph_submenu">Торты
            </li>
            <li class="
			subparagraph_submenu">Чизкейки
            </li>
            <li class="
			subparagraph_submenu">Эклеры
            </li>
        </ul>
    </div>

    <!-- Ассортимент -->
    <div class="content">
        <h2 class="title_content">Торты и пирожные</h2>
        <jsp:include page="/ProductShowServlet"/>
        <jsp:include page="ItemProductTable.jsp" />
    </div>

    <!-- Контейнер для нижнего меню -->
    <div id="footerMenu"></div>

</body>
</html>