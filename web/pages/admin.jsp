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
    <link rel="stylesheet" type="text/css" href="../css/popup.css">
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

<div name="products">
    <div align="center" class="h2">Список товаров:</div>

    <table class="table">
        <thead class="thead-inverse">
        <tr>
            <th>#</th>
            <th>Категория</th>
            <th>Производитель</th>
            <th>Модель</th>
            <th>Штрих-код</th>
        </tr>
        </thead>


        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td><c:out value="${product.id}"></c:out></td>
                <td><c:out value="${product.categoryDto.nameCategory}"></c:out></td>
                <td><c:out value="${product.brand}"></c:out></td>
                <td><c:out value="${product.nameProduct}"></c:out></td>
                <td><c:out value="${product.barcode}"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>


    <a class="button" href="#popup1">Добавить товар</a>


    <div id="popup1" class="overlay">
        <div class="popup">
            <h2>Добавить товар в базу</h2>
            <a class="close" href="#">&times;</a>
            <div class="content">
                <form method="post" action="/saveProduct">
                    <p><input type="text" name="brand" placeholder="Производитель"/></p>
                    <p><input type="text" name="nameProduct" placeholder="Модель"/></p>
                    <p><input type="text" name="barcode" placeholder="Штрих-код"/></p>
                    <p><input type="submit" value="Добавить"></p>
                </form>
            </div>
        </div>
    </div>


</div>


<div align="center" class="h2">Список пользователей:</div>

<table class="table">
    <thead class="thead-inverse">
    <tr>
        <th>#</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Логин</th>
        <th>Пароль</th>
        <th>Email</th>
        <th>Телефон</th>
        <th>№ магазина</th>
        <th>Роль</th>
        <th>Выбрать</th>
    </tr>
    </thead>


    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"></c:out></td>
            <td><c:out value="${user.firstName}"></c:out></td>
            <td><c:out value="${user.lastName}"></c:out></td>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.password}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.phone}"></c:out></td>
            <td><c:out value="${user.shopDto.id}"></c:out></td>
            <td><c:out value="${user.role}"></c:out></td>
            <td><c:out value=""><input type="radio"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div class="h3">

    Создать нового пользователя:

</div>
<div>
    <form method="post" action="/createUser">
        <p><input type="text" name="firstName" placeholder=" Имя" required></p>
        <p><input type="text" name="lastName" placeholder=" Фамилия" required></p>
        <p><input type="text" name="login" placeholder=" логин" required></p>
        <p><input type="text" name="password" placeholder=" пароль" required></p>
        <p><input type="text" name="email" placeholder=" email" required></p>
        <p><input type="text" name="phone" placeholder=" телефон"></p>
        <p><input type="text" name="shopId" placeholder=" № Магазина"></p>
        <p><input type="text" name="role" placeholder=" Роль"></p>
        <p><input type="submit" value="Создать">
    </form>
</div>


</body>
</html>

