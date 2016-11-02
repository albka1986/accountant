<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table>
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
                <td><c:out value="${storage1.product.category}"> </c:out></td>
                <td><c:out value="${storage1.product.brand}"> </c:out></td>
                <td><c:out value="${storage1.product.nameProduct}"> </c:out></td>
                <td><c:out value="${storage1.amount}"> </c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
