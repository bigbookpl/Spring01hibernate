<%--
  Created by IntelliJ IDEA.
  User: bigbook
  Date: 03/04/2022
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Book Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <%--@elvariable id="book" type="pl.coderslab.entity.Book"--%>
    <form:form modelAttribute="book" method="post">
        <label for="title">Title</label>
        <form:input path="title"/>
        <form:errors path="title" cssClass="error" />
        <br/>

        <label for="rating">Rating:</label>
        <form:input path="rating" />
        <form:errors path="rating" cssClass="error" />
        <br/>

        <label for="pages">Pages:</label>
        <form:input path="pages" />
        <form:errors path="pages" cssClass="error"/>
        <br/>

        <label for="description">Description</label>
        <form:textarea path="description"/>
        <form:errors path="description" cssClass="error"/>
        <br/>

        <label for="publisher">Publisher:</label>
        <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id"/>
        <form:errors path="publisher" cssClass="error"/>

        <input type="submit">
    </form:form>
</body>
</html>
