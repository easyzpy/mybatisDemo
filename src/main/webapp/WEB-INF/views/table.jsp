<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/18
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="baseJsp.jsp"%>
<html>
<head>
    <title>bootStrapTable</title>
    <link rel="stylesheet" href="${basePath}/css/bootstrap-table.min.css">
    <link rel="stylesheet" hef

    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">
    <script>
        var basePath = "${pageContext.request.contextPath}"

    </script>
</head>
<body>

<table id="table"></table>
<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>
</body>
<script src="${basePath}/js/jquery-2.1.1.min.js"></script>
<script src="${basePath}/js/bootstrap.min.js"></script>
<script src="${basePath}/js/bootstrap-table.min.js"></script>
<script src="${basePath}/js/bootstrap-table-zh-CN.js"></script>
<script src="${basePath}/js/table.js?v=asdfsf"></script>
</html>
