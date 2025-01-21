<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp"%>

<html>
<head>
    <title>Admin Log In</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminLogin.css">
</head>
<body>
<div class="login-container">
    <div class="login-box">
        <h1>Welcome, Admin!</h1>

        <h2>Please Log In</h2>
        <form action="${pageContext.request.contextPath}/adminLogin" method="post">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" value="${param.email}" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="btn-submit">Sign In</button>
            <c:if test="${requestScope.errors}" var="error">
                <div class="error-message">
                        ${error.message}
                </div>
            </c:if>
        </form>
    </div>
</div>
</body>
</html>
