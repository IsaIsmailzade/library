<%-- Created by IntelliJ IDEA. User: Isa Date: 20.01.2025 --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp"%>

<html>
<head>
    <title>Admin Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/adminPage.css">
</head>
<body>
<div class="admin-container">
    <h1 class="admin-title"><fmt:message key="page.admin.book.information"/></h1>
    <div class="admin-box">
        <form action="${pageContext.request.contextPath}/adminPage" method="post">
            <h2 class="section-title"><fmt:message key="page.admin.adding" /></h2>
            <input type="hidden" name="action" value="add">
            <div class="form-group">
                <label for="title"><fmt:message key="page.admin.input.title" /></label>
                <input type="text" id="title" name="title">
            </div>
            <div class="form-group">
                <label for="author"><fmt:message key="page.admin.input.author" /></label>
                <input type="text" id="author" name="author">
            </div>
            <div class="form-group">
                <label for="description"><fmt:message key="page.admin.input.description" /></label>
                <textarea id="description" name="description"></textarea>
            </div>
            <h2>Links for download:</h2>
            <div>
                <label for="FB2">FB2</label>
                <input type="text" id="FB2" name="FB2">
            </div>
            <div>
                <label for="EPUB">EPUB</label>
                <input type="text" id="EPUB" name="EPUB">
            </div>
            <div>
                <label for="PDF">PDF</label>
                <input type="text" id="PDF" name="PDF">
            </div>
            <div>
                <label for="Word">Word</label>
                <input type="text" id="Word" name="Word">
            </div>
            <div>
                <label for="MOBI">MOBI</label>
                <input type="text" id="MOBI" name="MOBI">
            </div>
            <button type="submit" class="btn-submit"><fmt:message key="page.admin.add.button" /></button>
        </form>
    </div>

    <div class="admin-box">
        <form action="${pageContext.request.contextPath}/adminPage" method="post">
            <h2 class="section-title"><fmt:message key="page.admin.deleting" /></h2>
            <input type="hidden" name="action" value="delete">
            <div class="form-group">
                <label for="id"><fmt:message key="page.admin.input.id" /></label>
                <input type="text" id="id" name="id">
            </div>
            <button type="submit" class="btn-submit"><fmt:message key="page.admin.delete.button" /></button>
        </form>
    </div>

    <c:if test="${not empty requestScope.errors}">
        <div class="error-message">
            <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span><br>
            </c:forEach>
        </div>
    </c:if>
</div>
</body>
</html>
