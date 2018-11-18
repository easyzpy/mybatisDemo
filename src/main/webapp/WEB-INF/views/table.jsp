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
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">
    <script>
        var basePath = "${pageContext.request.contextPath}"

    </script>
</head>
<body>

<table id="table"></table>
</body>
<script src="${basePath}/js/jquery-2.1.1.min.js"></script>
<script src="${basePath}/js/bootstrap.min.js"></script>
<script src="${basePath}/js/bootstrap-table.min.js"></script>
<script src="${basePath}/js/bootstrap-table-zh-CN.js"></script>
<script src="${basePath}/js/table.js"></script>
</html>
