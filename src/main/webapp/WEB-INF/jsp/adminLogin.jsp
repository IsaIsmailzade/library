<%--
  Created by IntelliJ IDEA.
  User: Isa
  Date: 20.01.2025
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp"%>

<html>
<head>
    <title>Admin Log In</title>
</head>
<body>
    <h1><fmt:message key="page.admin.welcome"/></h1>
    <h2><fmt:message key="page.admin.request"/></h2>
    <br>
    <form action="${pageContext.request.contextPath}/adminLogin" method="post">
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

        <c:if test="${requestScope.errors}" var="error">
            <div style="color: crimson">
                <br>
                    ${error.message}
            </div>
        </c:if>
    </form>
</body>
</html>
