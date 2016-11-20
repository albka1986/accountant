<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>

<!DOCTYPE html>
<html>
<head>
    <style>

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        li {
            float: left;
        }

        li a, .dropbtn {
            display: inline-block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover, .dropdown:hover .dropbtn {
            background-color: white;
            color: #000;
        }
        li.dropdown {
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }

        .dropdown-content a:hover {
            background-color: black;
            color: #fafafa;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }
    </style>
</head>
<body>

<ul>
    <li><a href="#home">Home</a></li>
    <li><a href="#news">News</a></li>
    <li class="dropdown">
        <a href="#" class="dropbtn">Dropdown</a>
        <div class="dropdown-content">
            <a href="/allShops">Все магазины</a>
            <a href="/shop1">Магазин 1</a>
            <a href="/shop1">Магазин 1</a>
            <a href="/shop1">Магазин 1</a>
            <a href="/shop1">Магазин 1</a>
            <a href="/shop1">Магазин 1</a>
            <a href="/shop1">Магазин 1</a>
            <a href="/shop1">Магазин Александр</a>

        </div>
    </li>
</ul>


</body>
</html>





</body>
</html>