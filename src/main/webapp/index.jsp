<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <p>
        <%= "Start" %>
    </p>
</head>
<body>
<h1>
    <p>
        <% java.util.Date now = new java.util.Date();
        String someTime = "Date today: " + now; %>
        <%= someTime %>

    </p>
    <p>

        <%= "Base Date #1" %>
    </p>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="FirstServlet">Hello FirstServlet</a>

</body>
</html>
