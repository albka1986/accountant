<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Accountant: login</title>
    <link rel="icon" href="../resources/favicon.ico">
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/examples/signin/signin.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
</head>

<body>

<div class="logo" align="center">
    <img src="../resources/logo.png" alt="ALFACELL" height="102" width="348"></div>
<br>

<form class="form-signin" role="form" action="/login" method="post">
    <input type="text" class="form-control" required placeholder="Login" autofocus="" name="login">
    <br>
    <input type="password" class="form-control" placeholder="Password" required="" name="password">
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
</form>


</body>
</html>



