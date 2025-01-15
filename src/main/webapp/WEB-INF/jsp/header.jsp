<%--
  Created by IntelliJ IDEA.
  User: Isa
  Date: 13.01.2025
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">

<c:if test="${not empty sessionScope.user}">
    <div id="logout">
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </div>
</c:if>
<form id="ru" action="${pageContext.request.contextPath}/locale" method="post"></form>
<form id="en" action="${pageContext.request.contextPath}/locale" method="post"></form>
    <div id="locale">
        <button form="ru" type="submit" name="lang" value="ru_RU">RU</button>
        <button form="en" type="submit" name="lang" value="en_US">EN</button>
    </div>


<fmt:setLocale value="${requestScope.lang != null ? sessionScope.lang : (param.lang != null ? param.lang : 'en_US')}" />
<fmt:setBundle basename="translations" />