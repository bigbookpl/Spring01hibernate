<%--
  Created by IntelliJ IDEA.
  User: bigbook
  Date: 03/04/2022
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>


<%--@elvariable id="books" type="java.util.List<pl.coderslab.entity.Book>"--%>
<table>
    <c:forEach var="item" items="${books}">
        <tr>
            <td>${item.id}</td>
            <td>${item.title}</td>
            <td>${item.description}</td>
            <td>${item.publisher.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
