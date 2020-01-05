<%--
  Created by IntelliJ IDEA.
  User: 寒芒
  Date: 2019/12/19
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读者登录页面</title>
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
                <li class="active"><a href="#">图书查询</a></li>
                <li><a href="toChangePwd">修改密码</a></li>
                <li><a href="loginout">注销</a></li>
            </ul>
        </div>
    </div>
</nav>

<center>
    <form action="getBOOKByTDN" method="post" >
        图书编号: <input  type="text"  name="bkCode" style="width: 250px" required="required"><br>
        图书名称: <input type="text" name="bkName" style="width: 250px" required="required"><br>
        图书作者: <input type="text" name="bkAuthor" style="width: 250px" required="required"><br>
        <input type="submit" value="搜索">
    </form>
</center>



​
</body>
</html>
