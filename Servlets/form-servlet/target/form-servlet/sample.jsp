<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Obtained Information</title>
</head>
<body>

    <h1>Info obtained by the enumeration style</h1>

<c:forEach items="${enumAttr}" var="temp" >
    ${temp} <br/>
</c:forEach>
    <br/>
    <br/>

    <h1>Info obtained by the common style</h1>
    <c:forEach items="${commonAttr}" var="temp" >
        ${temp} <br/>
    </c:forEach>
    <br/>
    <br/>

    ${user}

</body>
</html>
