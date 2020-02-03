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
<button value="call four" id="btn"></button>
<script>
    $(document).ready(function () {
        $("#btn").click(function () {
            var url="/demo/demo/page/tutorial/student/list"
            $.ajax({
                type:"GET",
                url:url,
                contentType:"application/x-www-form-urlencoded",
                dataType:("text/html"),
                success:function (msg) {
                    alert("ok");
                }
            })
        })
    })
</script>
<table style="width: 100%">
    <tr>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Age</th>
    </tr>
    <c:choose>
        <c:when test="${studentList!=null}">
            <c:forEach var="stu" items="${studentList}">
                <tr>
                    <td>${stu.firstname}</td>
                    <td>${stu.lastname}</td>
                    <td>${stu.age}</td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr>数据为空</tr>
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>
