<!DOCTYPE html>
<html lang="en">
<head>
    <title>JavaSchool</title>
    <link rel="stylesheet" href="resources/css/styles.css">
    <script src="resources/js/md5.js"></script>
    <script src="resources/js/javaschool.js"></script>
</head>
<body>
<div class="wrapper-form">
    <form action="login" method="post" onsubmit="return cryptPassword();">
        <div class="group">
            <label>User:</label>
            <input type="text" name="user">
        </div>

        <div class="group">
            <label for="password">Password:</label>
            <input type="password" name="password" id="password">
        </div>
        <br/>
        <input type="submit" class="btn">
    </form>
</div>
</body>
</html>