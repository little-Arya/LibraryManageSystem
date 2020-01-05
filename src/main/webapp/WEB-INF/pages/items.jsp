<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 寒芒
  Date: 2019/12/18
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>查看是否有此用户</title>
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
                <li class="active"><a href="readmanage">读者管理</a></li>
                <li><a href="borrowmanage">借阅管理</a></li>
                <li><a href="findAllUser">用户管理</a></li>
                <li><a href="findAllRead">查看读者信息</a></li>
                <li><a href="loginout">注销</a></li>
            </ul>
        </div>
    </div>
</nav>


<h1>如若存在此用户即不可重复添加</h1>
<table border="2" cellspacing="0" cellpadding="0"width="100%"height="100">
    <tr>
        <td>读者编号</td>
        <td>读者姓名</td>
        <td>读者性别</td>
        <td>读者类别</td>
        <td>单位名称</td>
        <td>电话号码</td>
        <td>电子邮箱</td>
        <td>办证日期</td>
        <td>证件状态</td>
        <td>已借数量</td>
        <td>读者密码</td>
        <td>管理角色</td>
        <td>读者照片</td>
        <td>操作</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${items}" var="book">
        <tr>
            <td>${book.rdID}</td>
            <td> ${book.rdName}</td>
            <td>${book.rdSex }</td>
            <td>${book.rdType }</td>
            <td>${book.rdDept }</td>
            <td>${book.rdPhone }</td>
            <td>${book.rdEmail}</td>
            <td>${book.rdDateReg}</td>
            <td>${book.rdStatus}</td>
            <td>${book.rdBorrowQty}</td>
            <td>${book.rdPwd}</td>
            <td>${book.rdAdminRoles}</td>
            <td> <img id="images" src="/images/${book.rdPhoto }"style="width: 60px;height: 60px;"></td>
            <td><a href="${pageContext.request.contextPath}/updateRead?rdID=${book.rdID }">修改</a></td>
            <td><a href="deleteReadById?rdID=${book.rdID }" id="check" onclick="return fun1()" >注销</a></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
