<%--
  Created by IntelliJ IDEA.
  User: palm
  Date: 05.12.2019
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input id="search_field"  name="search_field" placeholder="Поиск">
<input id="search_button" type="submit" value="Поиск" onclick="">

<jsp:useBean id="searchList" class="model.entities.ItemProduct">
    <%
    String nameProduct = request.getParameter("search_field");
    %>
    <jsp:setProperty name="searchList" property="mProductName" value="<%= nameProduct%>"/>

</jsp:useBean>
</body>
</html>
