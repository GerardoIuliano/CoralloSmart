<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Prova</title>
</head>
<body>
<c:choose>
    <c:when test="${sostenitore != null}">
        <h1>Sostenitore</h1>
    </c:when>
    <c:otherwise>
        <h1>Otherwise</h1>
    </c:otherwise>
</c:choose>
</body>
</html>
