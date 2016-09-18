<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/examples/signin/signin.css" rel="stylesheet">
    <link href="http://justified-nav.css" rel="stylesheet">
    <title>Accountant for Alfacell</title>
</head>

<body>
<p align="center">
    Складкской учет ALFACELL</p></h1>

<div ng-app="a1" align="center">
    <a href="#/storageAll">Все магазины </a>
    <div ng-view></div>

    <p align="middle"><input type="search" name="q" placeholder="Search">
        <input type="submit" value="Найти">
        <style></style>
    </p>

    <table class="table_blur">
        <tbody>
        <tr>
            <th>#</th>
            <th>category</th>
            <th>brand</th>
            <th>model</th>
            <th>IMEI</th>
            <%--<th>amount</th>--%>
        </tr>
        <c:forEach items="${sessionScope.productList}" var="product">
        <tr>
            <td><c:out value="${product.id}"></c:out></td>
            <%--<td><c:out value="${product.category}"></c:out></td>--%>
            <td><c:out value="${product.brand}"></c:out></td>
            <td><c:out value="${product.nameProduct}"></c:out></td>
            <td><c:out value="${product.imei}"></c:out></td>
            <%--<td><c:out value="${product.nameProduct}"></c:out></td>--%>
         </tr>
        </c:forEach>
        </tbody>
    </table>
    <style>
        .table_blur {
            background: #f5ffff;
            border-collapse: collapse;
            text-align: left;
        }

        .table_blur th {
            border-top: 1px solid #777777;
            border-bottom: 1px solid #777777;
            box-shadow: inset 0 1px 0 #999999, inset 0 -1px 0 #999999;
            background: linear-gradient(#9595b6, #5a567f);
            color: white;
            padding: 10px 15px;
            position: relative;
        }

        .table_blur th:after {
            content: "";
            display: block;
            position: absolute;
            left: 0;
            top: 25%;
            height: 25%;
            width: 100%;
            background: linear-gradient(rgba(255, 255, 255, 0), rgba(255, 255, 255, .08));
        }

        .table_blur tr:nth-child(odd) {
            background: #ebf3f9;
        }

        .table_blur th:first-child {
            border-left: 1px solid #777777;
            border-bottom: 1px solid #777777;
            box-shadow: inset 1px 1px 0 #999999, inset 0 -1px 0 #999999;
        }

        .table_blur th:last-child {
            border-right: 1px solid #777777;
            border-bottom: 1px solid #777777;
            box-shadow: inset -1px 1px 0 #999999, inset 0 -1px 0 #999999;
        }

        .table_blur td {
            border: 1px solid #e3eef7;
            padding: 10px 15px;
            position: relative;
            transition: all 0.5s ease;
        }

        .table_blur tbody:hover td {
            color: transparent;
            text-shadow: 0 0 3px #a09f9d;
        }

        .table_blur tbody:hover tr:hover td {
            color: #444444;
            text-shadow: none;
        }
    </style>
</div>
</body>

</html>