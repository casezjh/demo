<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap-grid.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.15.4/bootstrap-table-locale-all.min.js"></script>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<h2>Hello World!</h2>
<table style="width: 100%">
    <tr>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Age</th>
    </tr>
    <c:forEach var="" items="">
    <tr>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
