<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
    String driverName = "com.mysql.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/";
    String dbName = "javaschool";
    String userId = "root";
    String password = "";
%>
<html>
<head>
    <title>To Do List</title>
    <link rel="stylesheet" href="resources/css/styles.css">
</head>
<body>
    <div class="wrapper-form">
        <jsp:include page="header.jsp"></jsp:include>



    </div>

</body>
</html>
