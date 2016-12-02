<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Accountant for Alfacell</title>

    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link href="../libs/Bootstrap/css/bootstrap.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../libs/Bootstrap/js/bootstrap.js"></script>
    <script src="../libs/jquery.tablesorter.js"></script>
    <script src="../js/script.js"></script>
    <script src="../libs/jquery.liveFilter.js"></script>
    <script src="../libs/jquery.tablesorter.js"></script>
    <script src="../libs/jquery.liveFilter.js"></script>
    <script src="../js/script.js"></script>
    <%--top menu--%>
    <script type="text/javascript" src="../js/navigation-bar.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/topmenu.css">
</head>

<body>

<div name="logo" align="center" class="logo">
    <a href="/home">
        <img src="../resources/logo.png" alt="ALFACELL" height="102" width="348">
    </a>
</div>

<div name="topmenu" align="center">
    <ul id="menu">
        <li>
            <a href="#">Магазин #${shopId}</a>
            <ul>
                <li><a href="/allShops">Все магазины</a></li>
                <li><a href="/shop1">Магазин #1</a></li>
                <li><a href="/shop2">Магазин #2</a></li>
                <li><a href="/shop3">Магазин #3</a></li>
                <li><a href="/shop4">Магазин #4</a></li>
                <li><a href="/shop5">Магазин #5</a></li>
                <li><a href="/shop6">Магазин #6</a></li>
                <li><a href="#">Магазин Александр</a></li>
            </ul>
        </li>
        <li><a href="#">Продажи</a></li>
        <li><a href="#">Перемещение</a></li>
        <li><a href="#">Принять товар</a></li>
        <li><a href="/managerStorage">Управлением складом</a></li>
        <li><a href="/admin">Администрирование</a></li>
        <li><a href="/ServletLogout" title="${sessionScope.user.firstName} ${sessionScope.user.lastName}">Выход</a></li>
    </ul>
</div>

</body>

</html>
