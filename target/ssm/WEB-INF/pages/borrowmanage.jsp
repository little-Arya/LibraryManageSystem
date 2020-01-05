<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 寒芒
  Date: 2019/12/17
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>借阅管理</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js" ></script>
    <script src="js/js.cookie.js"></script>
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
                <li class="active"><a href="#">借阅管理</a></li>
                <li><a href="findAllUser">用户管理</a></li>
                <li><a href="loginout">注销</a></li>
                <li><a href="findAllBorrow">查询借书信息</a></li>
            </ul>
        </div>
    </div>
</nav>


<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 3%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">查询读者</h3>
        </div>
        <div class="panel-body">
            <form action="findOneread" method="post"  >
                <div class="input-group">
                    <span class="input-group-addon">读者编号</span>
                    <input type="text" class="form-control" name="rdID" id="name"  >
                </div>
                <input type="submit" value="查询" class="btn btn-success btn-sm" class="text-left">
            </form>
        </div>

        <table border="2" cellspacing="0" cellpadding="0"width="100%"height="100">
            <tr>
                <td>借书证号</td>
                <td>读者姓名</td>
                <td>读者性别</td>
                <td>读者类别</td>
                <td>办证日期</td>
                <td>证件状态</td>
                <td>已借数量</td>
                <td>借阅情况</td>
                <td>操作</td>
            </tr>
            <tr>
                <td><%=request.getAttribute("ids")%></td>
                <td><%=request.getAttribute("rdName")%></td>
                <td><%=request.getAttribute("rdSex")%></td>
                <td><%=request.getAttribute("rdType")%></td>
                <td><%=request.getAttribute("rdDateReg")%></td>
                <td><%=request.getAttribute("rdStatus")%></td>
                <td><%=request.getAttribute("rdBorrowQty")%></td>
                <td><a href="findAllBorrow">借阅情况</a></td>
                <td><a href="toborrow">借书</a></td>
            </tr>
        </table>
    </div>

    <div class="col-xs-6 col-md-offset-3" style="position: relative;top: 10%">
    <form action="getBOOKByTDNSB" method="post" >
        图书编号: <input  type="text"  name="bkCode" style="width: 250px" required="required"><br>
        图书名称: <input type="text" name="bkName" style="width: 250px" required="required"><br>
        图书作者: <input type="text" name="bkAuthor" style="width: 250px" required="required"><br>
        <input type="submit" value="搜索">
    </form>
    </div>

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
    <c:forEach items="${borrowmanage1}" var="book">
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
