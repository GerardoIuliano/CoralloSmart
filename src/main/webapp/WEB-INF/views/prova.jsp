<%@ page import="org.corallosmart.models.modelsUtente.Sostenitore" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Prova</title>
</head>
<body>
<%= ((Sostenitore) request.getSession().getAttribute("sostenitore")).getNome() %>
</body>
</html>
