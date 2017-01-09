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

<div name="topmenu" align="center">
    <ul id="menu">
        <li>
            <a href="#">
                <img src="../resources/icons/home.svg" height="16px" width="16px"></img>
                Магазин
            </a>
            <ul>
                <li><a href="/allShops">Все магазины</a></li>
                <li><a href="/shop1">Магазин #1(Ленина)</a></li>
                <li><a href="/shop2">Магазин #2(Университетская)</a></li>
                <li><a href="/shop3">Магазин #3(Алексеевка)</a></li>
                <li><a href="/shop4">Магазин #4(Французский бульвар)</a></li>
                <li><a href="/shop5">Магазин #5(пл. Свободы)</a></li>
                <li><a href="/shop6">Магазин #6(Петровского)</a></li>
            </ul>
        </li>
        <li><a href=" #">
            <img src="../resources/icons/sales.svg" height="16px" width="16px">Продажи</img>
        </a></li>
        <li><a href="#">
            <img src="../resources/icons/transfer.svg" height="16px" width="16px">Перемещение</img>
        </a></li>
        <li><a href="#">
            <img src="../resources/icons/receive.svg" height="16px" width="16px">Принять товар</img>
        </a></li>
        <li><a href="/managerStorage">
            <img src="../resources/icons/management.svg" height="16px" width="16px"></img>
            Управлением складом</a></li>
        <li><a href="/admin">
            <img src="../resources/icons/admin.svg" height="16px" width="16px"></img>
            Администрирование</a></li>
        <li><a href="/ServletLogout" title="${sessionScope.user.firstName} ${sessionScope.user.lastName}">
            <img src="../resources/icons/exit.svg" height="16px" width="16px"></img>
            Выход</a></li>
    </ul>
</div>

<div align="center" class="h1">Список пользователей:</div>

<div name="search" align="middle" id="search">
    <p>
        <span><img src="../resources/search.svg" height="30" width="30"></span>
        <input class="filter" name="livefilter" type="text" value="" placeholder="   Поиск..."/>
    </p>

    <form action="/ServletDeleteUser" method="post">
        <a href="#createUser"><img src="../resources/icons/add.png"></a>
        <a href="#editUser"><img src="../resources/icons/edit.png"></a>
        <button id="deleteButton" type="submit"><img src="../resources/icons/del.png"></button>

        <table class="table_blur" id="myTable">
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
                    <td><input type="checkbox" name="userListDelete" value="${user.id}"></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>
</div>

<div id="createUser" class="overlay">
    <div class="popup">
        <h2>Создать нового пользователя</h2>

        <a class="close" href="#">&times;</a>
        <div class="content">
            <form method="post" action="/createUser" accept-charset="UTF-8">
                <p><input type="text" name="firstName" placeholder=" Имя" required></p>
                <p><input type="text" name="lastName" placeholder=" Фамилия" required></p>
                <p><input type="text" name="login" placeholder=" логин" required></p>
                <p><input type="text" name="password" placeholder=" пароль" required></p>
                <p><input type="email" name="email" placeholder=" email" required></p>
                <p><input type="tel" name="phone" placeholder=" телефон" pattern="[\d]*"></p>
                <p>
                    <select name="shopId">
                        <option disabled selected>Выберите магазин...</option>
                        <c:forEach items="${shops}" var="shop">
                            <option value="${shop.id}">${shop.nameShop}</option>
                        </c:forEach>
                    </select>
                </p>
                <p>
                    <select name="roleNewUser">
                        <option disabled selected>Уровень доступа...</option>
                        <c:forEach items="${roles}" var="role">
                            <option value="${role}">${role}</option>
                        </c:forEach>
                        <option></option>
                    </select>
                </p>
                <p><input type="submit" value="Создать">
            </form>
        </div>
    </div>
</div>

</body>
</html>

