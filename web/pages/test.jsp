<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../css/popup.css">


</head>
<body>

<div class="box">
    <a class="button" href="#popup1">Let me Pop up</a>
</div>

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


</body>
</html>