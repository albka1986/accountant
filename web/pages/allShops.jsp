<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <title>Accountant for Alfacell</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="../libs/Bootstrap/css/bootstrap.css" rel="stylesheet">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="../libs/Bootstrap/js/bootstrap.js"></script>
    <script src="../libs/jquery.tablesorter.js"></script>
    <script src="../js/script.js"></script>
    <script src="../libs/jquery.liveFilter.js"></script>
    <script src="../libs/jquery.tablesorter.js"></script>
    <script src="../js/script.js"></script>
    <script src="../libs/jquery.liveFilter.js"></script>

</head>

<body>

<div ng-controller="mainCommonController">
    <p align="right">
        <img src="../resources/alfacell_logo.png" width="15%" height="15%"></p>
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
                            <li><a href="#1">Все магазины</a></li>
                            <li><a href="#">Магазин №1</a></li>
                            <li><a href="#">Магазин №2</a></li>
                            <li><a href="#">Магазин №3</a></li>
                            <li><a href="#">Магазин №4</a></li>
                            <li><a href="#">Магазин №5</a></li>
                            <li><a href="#">Магазин №6</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <br>
    <div align="middle">
        <p>
            <input type="text" class="filter" name="liveFilter" placeholder="фильтр"/>
        </p>
        <table class="table_blur tablesorter" id="myTable">
            <thead>
            <tr>
                <th>Категория &#9660</th>
                <th>Производитель &#9660</th>
                <th>Модель &#9660</th>
                <th>Количество &#9660</th>
                <th>№ 1&#9660</th>
                <th>№ 2&#9660</th>
                <th>№ 3&#9660</th>
                <th>№ 4&#9660</th>
                <th>№ 5&#9660</th>
                <th>№ 6&#9660</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>phone</td>
                <td>hkk</td>
                <td>jjj</td>
                <td>12</td>
                <td>5</td>
                <td>59</td>
                <td>6</td>
                <td>0</td>
                <td>5</td>
                <td>7</td>

            </tr>
            <tbody>
        </table>
    </div>
</div>
</body>

</html>
