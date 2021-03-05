<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 3/5/21
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="partials/navbar.jsp"%>
<h1>This is the body</h1>

    <c:choose>
        <c:when test="${param.containsKey('username')}">
            <p>Hello There ${param.username}</p>
        </c:when>
        <c:otherwise>
            <p>Hello Unauthenticated user!</p>
        </c:otherwise>
    </c:choose>
    <%@ include file="partials/footer.jsp"%>
</body>
</html>
