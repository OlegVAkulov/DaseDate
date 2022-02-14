

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${user != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${user == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${user != null}">
                                Edit User
                            </c:if>
                            <c:if test="${user == null}">
                                Add New User
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${user != null}">
                        <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>User Name</label> <input type="text"
                                                        value="<c:out value='${user.name}' />" class="form-control"
                                                        name="name" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>User Email</label> <input type="text"
                                                         value="<c:out value='${user.email}' />" class="form-control"
                                                         name="email">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>User Country</label> <input type="text"
                                                           value="<c:out value='${user.country}' />" class="form-control"
                                                           name="country">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>



































<%--<%@ page import="java.sql.*" %>--%>
<%--<%@ page import="java.io.PrintWriter" %>--%>
<%--<%@ page import="User" %>&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: akulo--%>
<%--  Date: 12.02.2022--%>
<%--  Time: 12:25--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Login Page</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h3>Input new element</h3>--%>
<%--<form>--%>
<%--    <strong>User Name</strong>:<input type="text" name="name"><br>--%>
<%--    <strong>User Surname</strong>:<input type="text" name="surname"><br>--%>
<%--    <strong>User Age</strong>:<input type="number" name="age"><br>--%>
<%--    <input type="submit" value="INSERT">--%>
<%--    <%  HttpSession httpSession = request.getSession();--%>
<%--        User user = (User) session.getAttribute("user");--%>
<%--        String name = request.getParameter("name");--%>
<%--        String surname = request.getParameter("surname");--%>
<%--        int age = Integer.parseInt(request.getParameter("age"));--%>
<%--        user.setName(name);--%>
<%--        user.setSurname(surname);--%>
<%--        user.setAge(age);--%>
<%--        httpSession.setAttribute("user", user);--%>
<%--        PrintWriter pw = response.getWriter();--%>


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
<%--</form>--%>


<%--</body>--%>
<%--</html>--%>

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
