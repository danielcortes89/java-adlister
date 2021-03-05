<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 3/5/21
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="POST">
        <label for="username">Username:</label>
        <input type="text" placeholder="Username" id="username">
        <label for="password">Password:</label>
        <input type="text" placeholder="Password" id="password">
        <button>Search</button>
    </form>
    <c:if test="param.username != null">
        <p>Username is: ${param.username}</p>
    </c:if>
</body>
</html>
