<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="somePackage.User" %><%--
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
    <%  HttpSession httpSession = request.getSession();
        User user = (User) session.getAttribute("user");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);
        httpSession.setAttribute("user", user);
        PrintWriter pw = response.getWriter();
        %>
    <%=
    pw.println(user.toString())
    %>

<%--        try {--%>
<%--            Class.forName("org.postgresql.Driver");--%>
<%--        } catch (ClassNotFoundException e) {--%>
<%--            e.printStackTrace();--%>
<%--        }--%>
<%--        try {--%>

<%--            Connection connection = DriverManager.getConnection(--%>
<%--                    "jdbc:postgresql://192.168.0.32:5432/test_db",--%>
<%--                    "postgres", "123qwerty321");--%>
<%--            Statement statement = connection.createStatement();--%>
<%--            name =user.getName();--%>
<%--            surname = user.getSurname();--%>
<%--            age = user.getAge();--%>
<%--            statement.addBatch("INSERT INTO people (name, surname, age) VALUES " +--%>
<%--                    "('name' , 'surname', age)");--%>
<%--            statement.close();--%>

<%--        } catch (SQLException throwables) {--%>
<%--            throwables.printStackTrace();--%>
<%--        }--%>

<%--    %>--%>
</form>

</body>
</html>

//            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
//            dispatcher.forward(request, response);



<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>JSP - Hello World</title>--%>

<%--</head>--%>
<%--<body>--%>
<%--<h1>New Page</h1>--%>


<%--</body>--%>
<%--</html>--%>
