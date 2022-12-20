<%@ page import="org.corallosmart.models.modelsUtente.Sostenitore" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Prova</title>
</head>
<body>
<c:out value="${sostenitore.nome}">SOS</c:out>
<%= ((Sostenitore) request.getSession().getAttribute("sostenitore")).getNome() %>
</body>
</html>
