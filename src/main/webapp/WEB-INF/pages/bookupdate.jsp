<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 寒芒
  Date: 2019/12/18
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>修改图书详情页</title>
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

<div style="position: relative;top: 8%;width: 80%;margin-left: 10%">
<center>
    <form action="doupdata?bkID=<%=request.getAttribute("ids")%>" method="post">
        <input type="hidden" name="id" value="${ids}"><br/>
        图书编号:<input type="text" name="bkCode" style="width: 250px;" value="<%=request.getAttribute("bkCode")%>"><br/>
        图书名称:<input type="text" name="bkName" style="width: 250px" value="<%=request.getAttribute("bkName")%>"><br/>
        图书作者:<input type="text" name="bkAuthor" style="width: 250px" value="<%=request.getAttribute("bkAuthor")%>"><br/>
        出版社名:<input type="text" name="bkPress" style="width: 250px" value="<%=request.getAttribute("bkPress")%>"><br/>
        出版日期:<input type="text" name="bkDatePress" style="width: 250px" value="<%=request.getAttribute("bkDatePress")%>"><br/>
        标准ISBN:<input type="text" name="bkISBN" style="width: 250px" value="<%=request.getAttribute("bkISBN")%>"><br/>
        分类名称:<input type="text" name="bkCatalog" style="width: 250px" value="<%=request.getAttribute("bkCatalog")%>"><br/>
        所属语种:<input type="text" name="bkLanguage" style="width: 250px" value="<%=request.getAttribute("bkLanguage")%>"><br/>
        图书页数:<input type="text" name="bkPages" style="width: 250px" value="<%=request.getAttribute("bkPages")%>"><br/>
        图书价格:<input type="text" name="bkPrice" style="width: 250px" value="<%=request.getAttribute("bkPrice")%>"><br/>
        入馆日期:<input type="text" name="bkDateIn" style="width: 250px" value="<%=request.getAttribute("bkDateIn")%>"><br/>
        图书状态:<input type="text" name="bkStatus" style="width: 250px" value="<%=request.getAttribute("bkStatus")%>"><br/>

        <img id="images" style="width: 150px;height: 150px;" src="/images/<%=request.getAttribute("bkCover")%>"><br>
        <input type="hidden" name="bkCover" value="<%=request.getAttribute("bkCover")%>"><br/>
        图书简介：
        <textarea rows="25" cols="30" name="bkBrief" style="width: 379px;height: 162px;"><%=request.getAttribute("bkBrief")%></textarea>
        <br>
        <input type="submit" value="提交">
    </form>
</center>
</div>
</body>
</html>
