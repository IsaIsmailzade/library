<%--
  Created by IntelliJ IDEA.
  User: Isa
  Date: 20.01.2025
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp"%>

<html>
<head>
    <title>Admin</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/adminPage" method="post">
        <h2><fmt:message key="page.admin.adding"/></h2>
        <fmt:message key="page.admin.book.information"/>
        <br>
        <tr>
            <td><label for="title"><fmt:message key="page.admin.input.title"/></label></td>
            <td><input type="text" id="title" name="title"></td>
        </tr>
        <br>
        <tr>
            <td><label for="author"><fmt:message key="page.admin.input.author"/></label></td>
            <td><input type="text" id="author" name="author"></td>
        </tr>
        <br>
        <tr>
            <td><label for="description"><fmt:message key="page.admin.input.description"/></label></td>
            <td><input type="text" id="description" name="description" required></td>
        </tr>
        <button type="submit"><fmt:message key="page.admin.add.button"/></button>
        <br>
        <br>
        <h2><fmt:message key="page.admin.deleting"/></h2>
    </form>
</body>
</html>
