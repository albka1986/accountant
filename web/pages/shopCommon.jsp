<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Accountant for Alfacell</title>
    <link rel="shortcut icon" href="../resources/favicon.ico" type="image/x-icon">

    <link rel="stylesheet" type="text/css" href="../css/main.css">
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
    <script type="text/javascript" src="../js/navigation-bar.js"></script>
    <script type="text/javascript">
        function logout() {
            location.href = '/ServletLogout'
        }
    </script>

</head>
<body>

<%--<ul class="topnav" id="myTopnav">
    <li><a href="/home">Склад</a></li>
    <ul>
        <li><a href="#">Магазин №1 </a></li>
        <li><a href="#">Магазин №2 </a></li>
        <li><a href="#">Магазин №3 </a></li>
        <li><a href="#">Магазин №4 </a></li>
        <li><a href="#">Магазин №5 </a></li>
        <li><a href="#">Магазин №6 </a></li>
        <li><a href="#">Все магазины </a></li>
    </ul>
    <li><a href="#">Управление складом</a></li>
    <li><a href="#">Приход</a></li>
    <li><a href="#">Расход</a></li>
    <li><a href="#">Отчет</a></li>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="#"></span>  <img src="../resources/user.svg" height="24" width="24"/> </a></li>
        </li>
        <li><a href="/ServletLogout"></span>  <img src="../resources/logout.svg" height="24" width="24"> </a></li>
        </li>
    </ul>


    <li class="icon">
        <a href="javascript:void(0);" style="font-size:15px;" onclick="myFunction()">☰</a>
    </li>
</ul>--%>


<div id="menu">
    <ul>
        <li><a href="/shop${shopId}">Магазин №${shopId}</a>
            <ul>
                <li><a href="/allShops">Все магазины </a></li>
                <li><a href="/shop1">Магазин №1 </a></li>
                <li><a href="/shop2">Магазин №2 </a></li>
                <li><a href="/shop3">Магазин №3 </a></li>
                <li><a href="/shop4">Магазин №4 </a></li>
                <li><a href="/shop5">Магазин №5 </a></li>
                <li><a href="/shop6">Магазин №6 </a></li>
            </ul>
        </li>
        <li><a href="#">Приход</a></li>
        <li><a href="#">Расход</a></li>
        <li><a href="#">Управление складом</a></li>
        <li><a href="#">Отчет</a></li>
        <li><a href="#"></span><img src="../resources/user.svg" height="" width="24"/></a></li>
        <li><a href="/ServletLogout"><img src="../resources/logout.svg" height="24px"> </a></li>
    </ul>


</div>

<h4 align="right">Пользователь: ${sessionScope.user.firstName} ${sessionScope.user.lastName}


    <div ng-controller="mainController">
        <p align="center">
            <img src="../resources/alfacell_logo.png" alt="ALFACELL" height="95.2" width="324.8"></p>

        <div align="center">
            <h2>Магазин # ${shopId}</h2></div>


        <div align="middle">
            <p>
                <span><img src="../resources/filter.png" height="42" width="42"></span>
                <input type="text" class="filter" name="liveFilter" placeholder="поиск по магазину"/>
            </p>
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

