<%--
  Created by IntelliJ IDEA.
  User: 寒芒
  Date: 2019/12/17
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读者管理</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js" ></script>
    <script src="js/js.cookie.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse " role="navigation">
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

<center>
<form action="getReadByTDN" method="post" >
    读者类别: <input  type="text"  name="rdType" list="typealist" style="width: 250px" required="required">
    <datalist id="typealist">
        <option>教师</option>
        <option>本科生</option>
        <option>专科生</option>
        <option>硕士研究生</option>
        <option>博士研究生</option>
    </datalist><br>
    所在单位: <input type="text" name="rdDept" style="width: 250px" required="required"><br>
    读者姓名: <input type="text" name="rdName" style="width: 250px" required="required"><br>
    <input type="submit" value="搜索">
</form>
</center>

<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 3%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">添加读者</h3>
        </div>
        <div class="panel-body">
            <form action="addRead" method="post" id="readeredit" enctype="multipart/form-data" >
                <div class="input-group">
                    <span class="input-group-addon">读者姓名</span>
                    <input type="text" class="form-control" name="rdName" id="name"  >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">读者性别</span>
                    <input type="text" class="form-control" name="rdSex" id="sex" list="sexlist" >
                    <datalist id="sexlist">
                        <option>男</option>
                        <option>女</option>
                    </datalist>
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">读者类别</span>
                    <input  type="text" class="form-control" name="rdType" id="readerId" list="typelist" >
                    <datalist id="typelist">
                        <option>教师</option>
                        <option>本科生</option>
                        <option>专科生</option>
                        <option>硕士研究生</option>
                        <option>博士研究生</option>
                    </datalist>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">单位名称</span>
                    <input type="text" class="form-control" name="rdDept" id="birth"  >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">电话号码</span>
                    <input type="text" class="form-control" name="rdPhone" id="address"  >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">电子邮箱</span>
                    <input type="text" class="form-control" name="rdEmail" id="telcode"  >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">办证日期</span>
                    <input type="text" class="form-control" name="rdDateReg" id="rdDateReg"  >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">读者照片</span>
                    <input type="file" class="form-control" name="rdPhoto" id="rdPhoto"  >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">读者状态</span>
                    <input type="text" class="form-control" name="rdStatus" id="rdStatus" list="slist" >
                    <datalist id="slist">
                        <option>有效</option>
                        <option>挂失</option>
                        <option>注销</option>
                    </datalist>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">已借数量</span>
                    <input type="text" class="form-control" name="rdBorrowQty" id="rdBorrowQty"  >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">读者密码</span>
                    <input type="text" class="form-control" name="rdPwd" id="rdPwd"  >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">管理角色</span>
                    <input type="text" class="form-control" name="rdAdminRoles" id="rdAdminRoles"  list="rolelist">
                    <datalist id="rolelist">
                        <option>读者</option>
                        <option>借书证管理</option>
                        <option>图书管理</option>
                        <option>借阅管理</option>
                        <option>系统管理</option>
                    </datalist>
                </div>

                <input type="submit" value="添加" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#readeredit").submit(function () {
                        if($("#name").val()==''||$("#author").val()==''||$("#publish").val()==''||$("#isbn").val()==''||$("#introduction").val()==''||$("#language").val()==''||$("#price").val()==''||$("#pubdate").val()==''||$("#classId").val()==''||$("#pressmark").val()==''||$("#state").val()==''){
                            alert("请填入完整读者信息！");
                            return mySubmit(false);
                        }
                    })
                </script>
            </form>
        </div>
    </div>

</div>




</body>
</html>
