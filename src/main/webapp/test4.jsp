<%@ page import="com.qd.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student List</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap-grid.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap-table/1.15.4/bootstrap-table-locale-all.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

</head>
<body>
<h2>Hello World!</h2>
<%
    ArrayList<Student> list=(ArrayList<Student>) request.getAttribute("listStu");
    %>
<button value="call four" id="btn"></button>
</br>
<script>
    $(document).ready(function () {
        $("#btn").click(function () {
            var url = "/demo/demo/page/tutorial/student/list"
            $.ajax({
                type: "GET",
                url: url,
                contentType: "application/x-www-form-urlencoded",
                // dataType: "text/html",
                success: function (msg) {
                    alert("ok");
                }
            })
        })
    })
</script>
<h1>This is <%=list %>></h1>
<h1>This is ${model}</h1>
<h1>This is ${listStu}</h1>
<h1>This is ${requestScope.model }</h1>
<h1>This is ${requestScope.model}</h1>
<h1>This is ${requestScope.it }</h1>
<h1>This is ${requestScope.it}</h1>
<c:out value="${model }"></c:out>
<c:out value="${listStu}"></c:out>
<c:out value="${requestScope.model }"></c:out>
<c:out value="${requestScope.model}"></c:out>
<c:out value="${requestScope.it }"></c:out>
<c:out value="${requestScope.it}"></c:out>

<c:choose>
<c:when test="${it!=null}">
<table style="width: 100%">
    <tr>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Age</th>
    </tr>
    <c:forEach var="stu" items="${it}">
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
