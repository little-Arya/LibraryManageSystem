<%--
  Created by IntelliJ IDEA.
  User: 寒芒
  Date: 2019/12/18
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改密码</title>
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

<form action="CPBreadupdata?rdID=<%=request.getAttribute("rdID")%>" method="post">
<div style="position: relative;top: 15%;width: 95%;margin-left: 2%">
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
            <td>确认修改密码</td>
        </tr>
            <tr>
              <td><%=request.getAttribute("rdID")%></td>
                <input type="hidden" name="rdID" value="<%=request.getAttribute("rdID")%>"/>
                <td><%=request.getAttribute("rdName")%></td>
                <input type="hidden" name="rdName" value="<%=request.getAttribute("rdName")%>"/>
                <td><%=request.getAttribute("rdSex")%></td>
                <input type="hidden" name="rdSex" value="<%=request.getAttribute("rdSex")%>"/>
                <td><%=request.getAttribute("rdType")%></td>
                <input type="hidden" name="rdType" value="<%=request.getAttribute("rdType")%>"/>
                <td><%=request.getAttribute("rdDept")%></td>
                <input type="hidden" name="rdDept" value="<%=request.getAttribute("rdDept")%>"/>
                <td><%=request.getAttribute("rdPhone")%></td>
                <input type="hidden" name="rdPhone" value="<%=request.getAttribute("rdPhone")%>"/>
                <td><%=request.getAttribute("rdEmail")%></td>
                <input type="hidden" name="rdEmail" value="<%=request.getAttribute("rdEmail")%>"/>
                <td><%=request.getAttribute("rdDateReg")%></td>
                <input type="hidden" name="rdDateReg" value="<%=request.getAttribute("rdDateReg")%>"/>
                <td><%=request.getAttribute("rdStatus")%></td>
                <input type="hidden" name="rdStatus" value="<%=request.getAttribute("rdStatus")%>"/>
                <td><%=request.getAttribute("rdBorrowQty")%></td>
                <input type="hidden" name="rdBorrowQty" value="<%=request.getAttribute("rdBorrowQty")%>"/>
                <td><%=request.getAttribute("rdPwd")%></td>
                <input type="text" name="rdPwd" value="<%=request.getAttribute("rdPwd")%>" placeholder="请输入要修改的密码"/>
                <td><%=request.getAttribute("rdAdminRoles")%></td>
                <input type="hidden" name="rdAdminRoles" value="<%=request.getAttribute("rdAdminRoles")%>"/>
            <td><img id="images" style="width: 150px;height: 150px;" src="/images/<%=request.getAttribute("rdPhoto")%>"></td>
                <input type="hidden" name="rdPhoto" value="<%=request.getAttribute("rdPhoto")%>"/>
                <td><input type="submit" value="提交"></td>
            </tr>

    </table>
</div>
</form>
</body>
</html>
