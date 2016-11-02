<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Accountant for Alfacell</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link href="/libs/Bootstrap/css/bootstrap.css" rel="stylesheet">
    <script  type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script  type="text/javascript" src="/libs/Bootstrap/js/bootstrap.js"></script>
    <script  type="text/javascript" src="/libs/jquery.tablesorter.js"></script>
    <script  type="text/javascript" src="/libs/jquery.liveFilter.js"></script>
</head>

<body>


<p align="right">
    <img src="resources/alfacell_logo.png" width="15%" height="15%"></p>
<p align="right">
    <h1>
<p align="center">
    Складкской учет ALFACELL</p></h1>


<div class="container">
    <div class="row">

        <div class="navbar navbar-default ">
            <div class="container ">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#responsive-menu">
                        <span class="sr-only">Открыть навигацию</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="responsive-menu">
                    <ul class="nav navbar-nav">
                        <li><a href="/1">Все магазины</a></li>
                        <li><a href="/shop1">Магазин №1</a></li>
                        <li><a href="/shop2">Магазин №2</a></li>
                        <li><a href="/shop4">Магазин №3</a></li>
                        <li><a href="/shop5">Магазин №4</a></li>
                        <li><a href="/shop6">Магазин №5</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<div align="middle">
    <p>
        <input type="text" class="filter" name="liveFilter" placeholder="фильтр"/>
    </p>
    <table class="table_blur tablesorter" id="myTable">
        <thead>
        <tr>
            <th>category&#9660;</th>
            <th>brand&#9660;</th>
            <th>model&#9660;</th>
            <th>amount&#9660;</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${storageListStorage1}" var="storage1">
            <tr>
                <td><c:out value="${storage1.product.category.nameCategory}"> </c:out></td>
                <td><c:out value="${storage1.product.brand}"> </c:out></td>
                <td><c:out value="${storage1.product.nameProduct}"> </c:out></td>
                <td><c:out value="${storage1.amount}"> </c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>

