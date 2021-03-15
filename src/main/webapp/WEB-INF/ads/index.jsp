<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
<%--    <h1>Here Are all the ads!</h1>--%>

<%--    <c:forEach var="ad" items="${ads}">--%>
<%--        <div class="col-md-6">--%>
<%--            <h2>${ad.title}</h2>--%>
<%--            <p>${ad.description}</p>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>


    <h1>Product Search Results</h1>
    <h2>Showing Results for <c:out value="${searchTerm}" /></h2>
    <c:forEach var="product" items="${searchResults}">
        <h3>
            <c:out value="${product.name}" />
            <small><c:out value="${product.price}" /></small>
        </h3>
    </c:forEach>
</div>

</body>
</html>
