<%--
  Created by IntelliJ IDEA.
  User: sulfur
  Date: 13.03.16
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Actors</title>
</head>
<body>

<h3>Actor Class:${actorClass}</h3>
<h3>Bean Class:${beanClass}</h3>
<h3>Books list (${interface}):</h3>
<ul>
    <c:forEach items="${actors}" var="actor">
        <li>${actor.id} - ${actor.name}</li>
    </c:forEach>
</ul>

</body>
</html>
