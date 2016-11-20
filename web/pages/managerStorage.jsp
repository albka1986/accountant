<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Accountant for Alfacell</title>
    <link rel="shortcut icon" href="../resources/favicon.ico" type="image/x-icon">
    <%--<link rel="stylesheet" type="text/css" href="../css/main.css">--%>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link href="../libs/Bootstrap/css/bootstrap.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../libs/Bootstrap/js/bootstrap.js"></script>
    <script src="../libs/jquery.tablesorter.js"></script>
    <script src="../js/script.js"></script>
    <script src="../libs/jquery.liveFilter.js"></script>
    <%--top menu--%>
    <link rel="stylesheet" type="text/css" href="../css/topmenu.css">
</head>
<body>

<br>
<div align="center">
    <img src="../resources/alfacell_logo.png" alt="ALFACELL" height="95.2" width="324.8">
</div>
<br>

<div>
    <ul id="menu">
        <li>
            <a href="#">Магазин #${shopId}</a>
            <ul>
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
        <li><a href="/ServletLogout" title="${sessionScope.user.firstName} ${sessionScope.user.lastName}">Выход</a></li>
    </ul>
</div>
<div align="center"><h1>Управление складом</h1></div>
<div class="managerStorage">
    Добавить товар в базу:
</div>
<div id="table1">
    <table>
        <th>Column 1</th>
        <th>Column 2</th>
        <th>Column 3</th>
        <th>Column 4</th>

        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
        </tr>
        <tr>
            <td>10</td>
            <td>20</td>
            <td>30</td>
            <td>40</td>
        </tr>
    </table>
</div>

<div >
    Список всех товаров:

</div>

</body>
</html>
