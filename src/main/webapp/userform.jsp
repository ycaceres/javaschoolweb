<%--
  Created by IntelliJ IDEA.
  User: pruiz
  Date: 4/27/18
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
    <link rel="stylesheet" href="resources/css/styles.css">
    <script src="resources/js/md5.js"></script>
    <script src="resources/js/javaschool.js"></script>
</head>
<body>
    <div class="wrapper-form">
        <h1>Add User</h1>
        <form method="post" action="dashboard" onsubmit="return validPasswords()">
            <div class="group">
                <label>Name:</label>
                <input name="name" type="text" required/>
            </div>
            <div class="group">
                <label>User:</label>
                <input name="user" type="text" required/>
            </div>
            <div class="group">
                <label>Password:</label>
                <input id="password" name="password" type="password" />
            </div>
            <div class="group">
                <label>Confirm Password:</label>
                <input id="pass2" name="pass2" type="password" />
            </div>
            <div class="group">
                <input type="submit" value="Guardar" class="btn"/>
                <input type="hidden" name="action" value="save">
            </div>
        </form>
    </div>
    <script type="application/javascript">
        function validPasswords(event) {
            var password = document.getElementById('password').value;
            var confirmPassword = document.getElementById('pass2').value;
            if ( password !== confirmPassword){
                alert("error passwords doesn't match");
                return false;
            }

            document.getElementById('password').value = md5(password);
            document.getElementById('pass2').value = md5(confirmPassword);

            return true;

        }
    </script>
</body>
</html>

