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

    <p><% String name = request.getParameter("name")%>
        <%=
        "Hello, " + name
        %>

    </p>
    <p>

        <%= "Base Date" %>
    </p>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="FirstServlet">Hello FirstServlet</a>
</h1>
</body>
</html>
