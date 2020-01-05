<%--
  Created by IntelliJ IDEA.
  User: 寒芒
  Date: 2019/12/18
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>修改读者页</title>
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

<div style="position: relative;top: 0.5%;width: 80%;margin-left: 10%">
    <center>
        <form action="doreadupdata?rdID=<%=request.getAttribute("ids")%>" method="post">
            <input type="hidden" name="id" value="${ids}"><br/>
            读者姓名:<input type="text" name="rdName" style="width: 250px;" value="<%=request.getAttribute("rdName")%>"><br/>
            读者性别:<input type="text" name="rdSex" style="width: 250px" value="<%=request.getAttribute("rdSex")%>"><br/>
            读者类别:<input type="text" name="rdType" style="width: 250px" value="<%=request.getAttribute("rdType")%>"><br/>
            单位名称:<input type="text" name="rdDept" style="width: 250px" value="<%=request.getAttribute("rdDept")%>"><br/>
            电话号码:<input type="text" name="rdPhone" style="width: 250px" value="<%=request.getAttribute("rdPhone")%>"><br/>
            电子邮箱:<input type="text" name="rdEmail" style="width: 250px" value="<%=request.getAttribute("rdEmail")%>"><br/>
            办证日期:<input type="text" name="rdDateReg" style="width: 250px" value="<%=request.getAttribute("rdDateReg")%>"><br/>
            证件状态:<input type="text" name="rdStatus" style="width: 250px" value="<%=request.getAttribute("rdStatus")%>" placeholder="有效、挂失、注销">
            <br/>
            已借数量:<input type="text" name="rdBorrowQty" style="width: 250px" value="<%=request.getAttribute("rdBorrowQty")%>"><br/>
            读者密码:<input type="text" name="rdPwd" style="width: 250px" value="<%=request.getAttribute("rdPwd")%>"><br/>
            管理角色:<input type="text" name="rdAdminRoles" style="width: 250px" value="<%=request.getAttribute("rdAdminRoles")%>"><br/>

            <img id="images" style="width: 150px;height: 150px;" src="/images/<%=request.getAttribute("rdPhoto")%>"><br>
            <input type="hidden" name="rdPhoto" value="<%=request.getAttribute("rdPhoto")%>"><br/>
            <input type="submit" value="提交">
        </form>
    </center>
</div>

</body>
</html>
