<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

</head>
<body>
<h1>Data Base</h1>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">



        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>

<br/>


<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Users</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
                New User</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Age</th>
            </tr>
            </thead>
            <tbody>

            <с:forEach var="user" items="${listUser}">

                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.surname}" /></td>
                    <td><c:out value="${user.age}" /></td>
                    <td><a href="edit?id=<'${user.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="delete?id=<'${user.id}' />">Delete</a></td>
                </tr>
            </с:forEach>

            </tbody>

        </table>
    </div>
</div>

<a href="FirstServlet">Data Base</a>
<%--<a href="GetCookiesServlet">List Users</a>--%>
<%--<a href="SetCookiesServlet">Search for id</a>--%>
<%--<a href="AddPetrIvanovServlet">AddPetrIvanov</a>--%>


</body>
</html>
