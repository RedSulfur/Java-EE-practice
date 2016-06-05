<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Actors</title>
</head>
<body>

<h3>Actor Class:${actorClass}</h3>
<h3>Bean Class:${beanClass}</h3>
<h3>Actors list:</h3>
<ul>
    <c:forEach items="${actors}" var="actor">
        <li>${actor.id} - ${actor.name}</li>
    </c:forEach>
</ul>

</body>
</html>
