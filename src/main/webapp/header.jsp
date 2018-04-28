<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pruiz
  Date: 4/27/18
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>Welcome <c:out value="${sessionScope.get('user')}"/></div>
<a href="/javaschool-web/dashboard?logout">Logout</a>
<hr/>
