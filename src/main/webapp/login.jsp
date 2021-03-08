<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 3/5/21
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%
    String wrongCredentials = "";

    if(request.getMethod().equals("POST")){
        if(request.getParameter("username").equals("admin") && request.getParameter("userPassword").equals("password")) {
            response.sendRedirect("/profile.jsp?username=" + request.getParameter("username"));
        }
        wrongCredentials = "Username or password Invalid";
    }

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="POST" action="/login.jsp">
        <p>
            <%= wrongCredentials %>
        </p>
        <label for="username">Username:</label>
        <input type="text" name="username" placeholder="Username" id="username">

        <br>

        <label for="userPassword">Password:</label>
        <input type="password" name="userPassword" placeholder="Password" id="userPassword">
        <input type="submit" value="login">
    </form>
<%--    <c:if test="param.username != null">--%>
<%--        <p>Username is: ${param.username}</p>--%>
<%--    </c:if>--%>
</body>
</html>
