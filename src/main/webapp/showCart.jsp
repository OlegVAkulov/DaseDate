<%--
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
<h3>Login with email and password</h3>
<form action="Login" method="post">
    <strong>User Email</strong>:<input type="text" name="email"><br>
    <strong>Password</strong>:<input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
<br>
If you are new user, please <a href="register.html">register</a>.
</body>
</html>
