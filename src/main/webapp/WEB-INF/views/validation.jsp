<%--
  Created by IntelliJ IDEA.
  User: bigbook
  Date: 23/04/2022
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Validation results</title>
</head>
<body>
<c:forEach var="violation" items="${violations}">
    <p>${violation.propertyPath} - ${violation.message}</p>
</c:forEach>

</body>
</html>
