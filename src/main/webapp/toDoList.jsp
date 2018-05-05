<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To Do List</title>
    <link rel="stylesheet" href="resources/css/styles.css">
</head>
<body>
    <div class="wrapper-form">
        <jsp:include page="header.jsp"></jsp:include>
        <ul>
            <c:forEach items="${sessionScope.get('toDoListItems')}" var="item">
                <li>
                    <c:out value="${item}"/>
                </li>
            </c:forEach>

            <form method="post" action="toDoList">
                <input type="text" name="item" value="" placeholder="To Do...">
                <input type="submit" value="Add item"/>
                <input type="hidden" name="action" value="add"/>
            </form>
    </div>

</body>
</html>
