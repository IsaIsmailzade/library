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
        <a href="${book.downloadFb2}">FB2</a>
        <a href="${book.downloadEpub}">EPUB</a>
        <a href="${book.downloadPdf}">PDF</a>
        <a href="${book.downloadDocx}">Word</a>
        <a href="${book.downloadMobi}">MOBI</a>
        <br>
    <a href="${pageContext.request.contextPath}/catalog"><fmt:message key="page.back.button"/></a>
</body>
</html>
