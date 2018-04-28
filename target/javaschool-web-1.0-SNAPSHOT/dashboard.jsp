<%@ page import="ns.javaschool.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="ns.javaschool.controller.LoginController" %><%--
  Created by IntelliJ IDEA.
  User: pruiz
  Date: 4/27/18
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>--%>

<html>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="resources/css/styles.css">
</head>
<body>
    <div class="wrapper-form">
        <jsp:include page="header.jsp"></jsp:include>
        <ul>
        <%
            List<User> users = LoginController.getInstance().loadAll();
            for (User u : users) {
                out.println("<li>" + u + "<br/></li>");
            }
        %>
        <%--<c:forEach var = "i" begin = "0" end = "5">--%>
            <%--Item <c:out value = "${i}"/><p>--%>
        <%--</c:forEach>--%>
       </ul>

        <form method="post" action="dashboard" >
            <input type="submit" value="Add User"/>
            <input type="hidden" name="action" value="add"/>
        </form>
    </div>

</body>
</html>
