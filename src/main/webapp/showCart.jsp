<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: akulo
  Date: 12.02.2022
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
<h3>Input new element</h3>
<form>
    <strong>User Name</strong>:<input type="text" name="name"><br>
    <strong>User Surname</strong>:<input type="text" name="surname"><br>
    <strong>User Age</strong>:<input type="number" name="age"><br>
    <input type="submit" value="INSERT">
    <%
        PrintWriter pw = response.getWriter();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://192.168.0.32:5432/test_db",
                    "postgres", "123qwerty321");
            Statement statement = connection.createStatement();
            statement.executeQuery("INSERT INTO people VALUES(" +
                    "(name , surname, age)");
            statement.close();
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    %>
</form>

</body>
</html>
<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>JSP - Hello World</title>--%>

<%--</head>--%>
<%--<body>--%>
<%--<h1>New Page</h1>--%>


<%--</body>--%>
<%--</html>--%>
