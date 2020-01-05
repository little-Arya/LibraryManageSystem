<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 寒芒
  Date: 2019/12/19
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>图书详情页</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">用户登录页</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="toUser">图书查询</a></li>
                <li><a href="toChangePwd">修改密码</a></li>
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

        </tr>
        <c:forEach items="${bookpage}" var="book">
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
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
