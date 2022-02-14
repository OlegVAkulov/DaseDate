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
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> User
                Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>


<br/>

<a href="FirstServlet">Data Base</a>
<a href="GetCookiesServlet">List Users</a>
<a href="SetCookiesServlet">Search for id</a>
<a href="AddPetrIvanovServlet">AddPetrIvanov</a>


</body>
</html>
