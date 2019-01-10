<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>员工信息</h3>
<table>
    <thead>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>email</td>
    </thead>
    <tbody>
        <c:forEach items="${lists}" var="list">
            <tr>
                <td>${list.id}</td>
                <td>${list.name}</td>
                <td>${list.age}</td>
                <td>${list.email}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
