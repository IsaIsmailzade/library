<%--
  Created by IntelliJ IDEA.
  User: Isa
  Date: 12.12.2024
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="header.jsp"%>

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
            <td><label for="name"><fmt:message key="page.name"/></label></td>
            <td><input type="text" id="name" name="name" required></td>
        </tr>
        <tr>
            <td><label for="surname"><fmt:message key="page.surname"/></label></td>
            <td><input type="text" id="surname" name="surname" required></td>
        </tr>
        <tr>
            <td><label for="email"><fmt:message key="page.email"/></label></td>
            <td><input type="email" id="email" name="email" required></td>
        </tr>
        <tr>
            <td><label for="password"><fmt:message key="page.password"/></label></td>
            <td><input type="password" id="password" name="password" required></td>
        </tr>
        <tr>
            <td><label for="phone"><fmt:message key="page.phone"/></label></td>
            <td><input type="tel" id="phone" name="phone" required></td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit"><fmt:message key="page.registration.button"/></button></td>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}/login">
        <fmt:message key="page.login.button"/>
    </a>
    <c:if test="${not empty requestScope.errors}">
        <div style="color: crimson">
            <c:forEach var="error" items="${requestScope.errors}">
                <br>
                <span>${error.message}</span>
            </c:forEach>
        </div>
    </c:if>
</form>
</body>
</html>
