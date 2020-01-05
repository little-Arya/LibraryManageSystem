<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 寒芒
  Date: 2019/12/17
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<html>
<head>
    <title>图书详情页</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js" ></script>
    <script src="js/js.cookie.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">图书管理系统</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="system">图书管理</a></li>
                <li><a href="readmanage">读者管理</a></li>
                <li><a href="borrowmanage">借阅管理</a></li>
                <li><a href="findAllUser">用户管理</a></li>
                <li><a href="findAllBook">查看图书信息</a></li>
                <li><a href="loginout">注销</a></li>
            </ul>
        </div>
    </div>
</nav>

<div style="position: relative;top: 15%;width: 95%;margin-left: 2%">

    <table border="2" cellspacing="0" cellpadding="0"width="100%"height="100">
    <tr>
        <td>图书序号</td>
        <td>图书编号</td>
        <td>图书名称</td>
        <td>图书作者</td>
        <td>出版社名</td>
        <td>出版日期</td>
        <td>标准ISBN</td>
        <td>分类名称</td>
        <td>所属语种</td>
        <td>图书页数</td>
        <td>图书价格</td>
        <td>入馆日期</td>
        <td>图书状态</td>
        <td>图书封面</td>
        <td>操作</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="book">
        <tr>
            <td>${book.bkID}</td>
            <td>${book.bkCode}</td>
            <td> ${book.bkName}</td>
            <td>${book.bkAuthor }</td>
            <td>${book.bkPress }</td>
            <td>${book.bkDatePress }</td>
            <td>${book.bkISBN }</td>
            <td>${book.bkCatalog}</td>
            <td>${book.bkLanguage}</td>
            <td>${book.bkPages}</td>
            <td>${book.bkPrice}</td>
            <td>${book.bkDateIn}</td>
            <td>${book.bkStatus}</td>
            <td> <img id="images" src="/images/${book.bkCover }"style="width: 60px;height: 60px;"></td>
            <td><a href="${pageContext.request.contextPath}/updatebook?bkID=${book.bkID }">查看详情</a></td>
            <td><a href="deleteItemById?bkID=${book.bkID }">删除</a></td>
        </tr>
    </c:forEach>
</table>
</div>


</body>
</html>
