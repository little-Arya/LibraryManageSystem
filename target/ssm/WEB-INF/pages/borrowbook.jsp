<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 寒芒
  Date: 2019/12/19
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借书详情页</title>
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
                <li class="active"><a href="borrowmanage">借阅管理</a></li>
                <li><a href="findAllUser">用户管理</a></li>
                <li><a href="loginout">注销</a></li>
            </ul>
        </div>
    </div>
</nav>

<!--
<table border="2" cellspacing="0" cellpadding="0"width="100%"height="100">
    <tr>
        <td>读者姓名</td>
        <td>读者性别</td>
        <td>读者类别</td>
        <td>办证日期</td>
        <td>证件状态</td>
        <td>已借数量</td>
        <td>读者照片</td>
    </tr>
        <tr>
            <td><%=request.getAttribute("rdName")%></td>
            <td><%=request.getAttribute("rdSex")%></td>
            <td><%=request.getAttribute("rdType")%></td>
            <td><%=request.getAttribute("rdDateReg")%></td>
            <td><%=request.getAttribute("rdStatus")%></td>
            <td><%=request.getAttribute("rdBorrowQty")%></td>
            <td><img id="images" style="width: 150px;height: 150px;" src="/images/<%=request.getAttribute("rdPhoto")%>"></td>
        </tr>
</table>

-->
<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 3%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">借书</h3>
        </div>
        <div class="panel-body">
            <form action="addBorrow" method="post"  enctype="multipart/form-data" onSubmit= "return ret()">
                <div class="input-group">
                    <span class="input-group-addon">读者序号</span>
                    <input type="text" class="form-control" name="rdID" id="name" required="required" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">图书序号</span>
                    <input type="text" class="form-control" name="bkID" id="sex" required="required" >
                </div>
         <!--       <div class="input-group">
                    <span class="input-group-addon">借书日期</span>
                    <input type="text" class="form-control" name="ldDateOut" id="birth"  required="required">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">应还日期</span>
                    <input type="text" class="form-control" name="ldDateRetPlan" id="address" required="required" >
                </div> -->
                <input type="submit" value="借书" class="btn btn-success btn-sm" class="text-left" id="toalert">
                <script>
               //     function mySubmit(flag){
                 //       return flag;
                   // }
                //    $("#toalert").submit(function () {
                        //if($("#name").val()==''||$("#sex").val()==''||$("#birth").val()==''||$("#address").val()==''){
                         //   alert("请填入完整读者信息！");
                          //  return mySubmit(false);
                        //}
                        //alert("只有借书证有效且图书在馆才可以借书哦！")
                  //  })
               function ret(){
                   if(confirm("证件状态有效且图书在馆才可借书，确认无误嘛？")) {
                       return true;
                   };
                   return false;
               }
                </script>
            </form>
        </div>
    </div>

</div>






</body>
</html>
