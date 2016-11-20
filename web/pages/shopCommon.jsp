<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div align="center">
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
        <li><a href="/admin">Администрирование</a></li>
        <li><a href="/ServletLogout" title="${sessionScope.user.firstName} ${sessionScope.user.lastName}">Выход</a></li>
    </ul>
</div>

<div>
    <div align="middle">
        <p>
            <span><img src="../resources/search.svg" height="24" width="24" ></span>
            <input type="text" class="filter" name="liveFilter" placeholder=" поиск товара по магазину"/>
        </p>
        <br>
        <table class="table_blur tablesorter" id="myTable">
            <thead>
            <tr>
                <th>Категория</th>
                <th>Производитель</th>
                <th>Модель</th>
                <th>Количество</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${storageList}" var="storage">
                <tr>
                    <td><c:out value="${storage.productDto.categoryDto.nameCategory}"> </c:out></td>
                    <td><c:out value="${storage.productDto.brand}"> </c:out></td>
                    <td><c:out value="${storage.productDto.nameProduct}"> </c:out></td>
                    <td><c:out value="${storage.amount}"> </c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>

