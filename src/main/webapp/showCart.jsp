<%--
  Created by IntelliJ IDEA.
  User: akulo
  Date: 12.02.2022
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show cart</title>
</head>
<body>
<%@ page import="somePackage.Cart" %>
<% Cart cart = (Cart) session.getAttribute("cart");%>
<p> Name of:  <%= cart.getName()%></p>
<p> Qauntity of: <%= cart.getQuantity()%></p>

</body>
</html>
