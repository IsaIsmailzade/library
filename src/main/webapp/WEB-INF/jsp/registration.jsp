<%--
  Created by IntelliJ IDEA.
  User: Isa
  Date: 12.12.2024
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/registration" method="post">
        <label for="name">Name:
            <input type="text" id="name" required>
        </label> <br>
        <label for="surname">Surname:
            <input type="text" id="surname" required>
        </label> <br>
        <label for="email">Email:
            <input type="text" id="email" required>
        </label> <br>
        <label for="password">Password:
            <input type="password" id="password" required>
        </label> <br>
        <label for="phone">Phone:
            <input type="text" id="phone" required>
        </label> <br>
    </form>
</body>
</html>
