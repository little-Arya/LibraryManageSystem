<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 寒芒
  Date: 2019/12/17
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户管理</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">图书管理系统</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="system">图书管理</a></li>
                <li><a href="readmanage">读者管理</a></li>
                <li><a href="borrowmanage">借阅管理</a></li>
                <li class="active"><a href="findAllUser">用户管理</a></li>
                <li><a href="loginout">注销</a></li>
            </ul>
        </div>
    </div>
</nav>
<table border="2" cellspacing="0" cellpadding="0"width="100%"height="100">
    <tr>
        <td>读者类别</td>
        <td>读者类别名称</td>
        <td>可借数量</td>
        <td>可借天数</td>
        <td>可续借次数</td>
        <td>罚款率</td>
        <td>证书有效期</td>
        <td>操作</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${usermanage}" var="book">
        <tr>
            <td>${book.rdType}</td>
            <td> ${book.rdTypeName}</td>
            <td>${book.canendQty}</td>
            <td>${book.canendDay}</td>
            <td>${book.canContinueTimes}</td>
            <td>${book.punishRate}</td>
            <td>${book.pateValid}</td>
            <td><a href="${pageContext.request.contextPath}/updateTYRead?rdType=${book.rdType }">修改</a></td>
            <td><a href="deleteTYReadById?rdType=${book.rdType}" id="check" >删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
