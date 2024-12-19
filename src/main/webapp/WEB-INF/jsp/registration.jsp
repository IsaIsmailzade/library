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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/registration.css">
</head>
<body>
<h1>Library</h1>
<br>
<form action="${pageContext.request.contextPath}/registration" method="post">
    <table>
        <tr>
            <td><label for="name">Name:</label></td>
            <td><input type="text" id="name" name="name" required></td>
        </tr>
        <tr>
            <td><label for="surname">Surname:</label></td>
            <td><input type="text" id="surname" name="surname" required></td>
        </tr>
        <tr>
            <td><label for="email">Email:</label></td>
            <td><input type="email" id="email" name="email" required></td>
        </tr>
        <tr>
            <td><label for="password">Password:</label></td>
            <td><input type="password" id="password" name="password" required></td>
        </tr>
        <tr>
            <td><label for="phone">Phone:</label></td>
            <td><input type="tel" id="phone" name="phone" required></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit">Register</button></td>
        </tr>
    </table>
</form>
</body>
</html>
