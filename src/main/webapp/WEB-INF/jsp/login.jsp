<%--
  Created by IntelliJ IDEA.
  User: Isa
  Date: 14.12.2024
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp"%>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<h1>Library</h1>
<br>
<form action="${pageContext.request.contextPath}/login" method="post">
    <table>
        <tr>
            <td><label for="email"><fmt:message key="page.email"/></label></td>
            <td><input type="email" id="email" name="email" value="${param.email}" required></td>
        </tr>
        <tr>
            <td><label for="password"><fmt:message key="page.password"/></label></td>
            <td><input type="password" id="password" name="password" required></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit"><fmt:message key="page.login.button"/></button></td>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}/registration">
        <fmt:message key="page.registration.button"/>
    </a>
</form>
</body>
</html>