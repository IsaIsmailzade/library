<%--
  Created by IntelliJ IDEA.
  User: Isa
  Date: 23.01.2025
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="header.jsp"%>

<html>
<head>
    <title>Book</title>
</head>
<body>
        <div>
            <h2>${book.title}</h2>
            <p><strong><fmt:message key="page.book.author"/>: </strong>${book.author}</p>
            <p>${book.description}</p>
        </div>
        <br>
        <c:if test="${not empty book.downloadFb2}">
            <a href="${book.downloadFb2}">FB2</a>
        </c:if>
        <c:if test="${not empty book.downloadEpub}">
            <a href="${book.downloadEpub}">EPUB</a>
        </c:if>
        <c:if test="${not empty book.downloadPdf}">
            <a href="${book.downloadPdf}">PDF</a>
        </c:if>
        <c:if test="${not empty book.downloadDocx}">
            <a href="${book.downloadDocx}">Word</a>
        </c:if>
        <c:if test="${not empty book.downloadMobi}">
            <a href="${book.downloadMobi}">MOBI</a>
        </c:if>
        <br>
    <a href="${pageContext.request.contextPath}/catalog"><fmt:message key="page.back.button"/></a>
</body>
</html>
