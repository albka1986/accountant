<html>
<head>
    <meta charset="UTF-8">
    <title>Accountant: login</title>
</head>
<body>
<link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="http://getbootstrap.com/examples/signin/signin.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/home.css">

<p align="right">
    <img src="http://localhost:8080/resources/alfacell_logo.png" width="15%" height="15%"></p>

<form class="form-signin" role="form" action="/login" method="post">
    <input type="text" class="form-control" required placeholder="login" autofocus="" name="login">
    <input type="password" class="form-control" placeholder="password" required="" name="password">
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>

</body>
</html>



