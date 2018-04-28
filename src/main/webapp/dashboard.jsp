<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pruiz
  Date: 4/27/18
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="resources/css/styles.css">
</head>
<body>
    <div class="wrapper-form">
        <jsp:include page="header.jsp"></jsp:include>
        <ul>

            <c:forEach items="${sessionScope.get('userList')}" var="u">
                <li>
                    <c:out value="${u}"/>
                </li>
            </c:forEach>

        <form method="post" action="dashboard" >
            <input type="submit" value="Add User"/>
            <input type="hidden" name="action" value="add"/>
        </form>
    </div>

</body>
</html>
