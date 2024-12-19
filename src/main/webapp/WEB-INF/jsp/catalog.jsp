<%--
  Created by IntelliJ IDEA.
  User: Isa
  Date: 19.12.2024
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Books</title>
</head>
<body>
    <form method="get" action="${pageContext.request.contextPath}/catalog">
        <h1>Книги в библиотеке:</h1>
        <c:forEach items="${requestScope.books}" var="books">
            <li>
                ${books.title}
            </li>
        </c:forEach>
    </form>
</body>
</html>
