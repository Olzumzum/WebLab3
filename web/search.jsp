<!--
Часть html-страницы, отвечающая за поиск:
отображает поле ввода и кнопку
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/list_search.js"></script>
    <link rel="stylesheet" href="css/list_search.css">
    <title>Title</title>
</head>
<body>
<form id="search_form" action="" method="post">
<input id="searchfield"  name="searchfield" placeholder="Поиск">

<input id="search_button" type="submit" value="Поиск" onclick="searchList(document.getElementById('search_form'))">
</form>

</body>
</html>