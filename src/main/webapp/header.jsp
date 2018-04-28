<%--
  Created by IntelliJ IDEA.
  User: pruiz
  Date: 4/27/18
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String user = request.getSession().getAttribute("user").toString();
    out.println("<div>Welcome " + user + "</div>");
%>
<a href="/javaschool-web/dashboard?logout">Logout</a>
<hr/>
