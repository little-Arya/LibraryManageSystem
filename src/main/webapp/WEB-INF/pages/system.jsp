<%--
  Created by IntelliJ IDEA.
  User: 寒芒
  Date: 2019/12/16
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理系统</title>
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

<div style="position: relative;top: 15%;width: 80%;margin-left: 10%">
    <form action="addbook" method="post" id="addbook" enctype="multipart/form-data" >
        <div class="form-group">
            <label for="name">图书编号</label>
            <input type="text" class="form-control" name="bkCode" id="code" placeholder="请输入图书编号">
        </div>
        <div class="form-group">
            <label for="name">图书名称</label>
            <input type="text" class="form-control" name="bkName" id="name" placeholder="请输入书名">
        </div>
        <div class="form-group">
            <label for="author">图书作者</label>
            <input type="text" class="form-control" name="bkAuthor" id="author"  placeholder="请输入作者名">
        </div>
        <div class="form-group">
            <label for="publish">出版社名</label>
            <input type="text" class="form-control"  name="bkPress" id="publish"  placeholder="请输入出版社">
        </div>
        <div class="form-group">
            <label for="pubdate">出版日期</label>
            <input type="text" class="form-control"  name="bkDatePress" id="pubdate"   placeholder="请输入出版日期">
        </div>
        <div class="form-group">
            <label for="isbn">标准ISBN</label>
            <input type="text" class="form-control" name="bkISBN" id="isbn"  placeholder="请输入ISBN">
        </div>
        <div class="form-group">
            <label for="classId">分类名称</label>
            <input type="text" class="form-control" name="bkCatalog" id="classId"  placeholder="请输入分类号">
        </div>
        <div class="form-group">
            <label for="language">所属语种</label>
            <input type="text" class="form-control" name="bkLanguage" id="language"  placeholder="0-中文，1-英文，2-日文，3-俄文，
4-德文，5-法文" list="lanlist">
            <datalist id="lanlist">
                <option>中文</option>
                <option>日文</option>
                <option>英文</option>
                <option>俄文</option>
            </datalist>
        </div>
        <div class="form-group">
            <label for="pressmark">图书页数</label>
            <input type="text" class="form-control"  name="bkPages" id="pressmark" placeholder="请输入图书页数">
        </div>
        <div class="form-group">
            <label for="price">图书价格</label>
            <input type="text" class="form-control"  name="bkPrice"  id="price" placeholder="请输入价格">
        </div>

        <div class="form-group">
            <label for="introduction">内容简介</label>
            <textarea class="form-control" rows="3"  name="bkBrief" id="introduction" placeholder="请输入简介"></textarea>
        </div>

        <div class="form-group">
            <label for="todate">入馆日期</label>
            <input type="text" class="form-control"  name="bkDateIn" id="todate"   placeholder="请输入馆日期">
        </div>
        <div class="form-group">
            <label for="state">图书状态</label>
            <input type="text" class="form-control"  name="bkStatus"  id="state"   placeholder="请输入图书状态" list="stalist">
            <datalist id="stalist">
                <option>在馆</option>
                <option>借出</option>
                <option>遗失</option>
                <option>变卖</option>
                <option>销毁</option>
            </datalist>
        </div>
        <div class="form-group">
            <label for="pic">图书封面照片</label>
            <input type="file" class="form-control"  name="bkCover"  id="pic" >
        </div>


        <input type="submit" value="添加" class="btn btn-success btn-sm" class="text-left">
        <script>
            function mySubmit(flag){
                return flag;
            }
            $("#addbook").submit(function () {
                if($("#todate").val()==''||$("#pic").val()==''||$("#code").val()==''||$("#name").val()==''||$("#author").val()==''||$("#publish").val()==''||$("#isbn").val()==''||$("#introduction").val()==''||$("#language").val()==''||$("#price").val()==''||$("#pubdate").val()==''||$("#classId").val()==''||$("#pressmark").val()==''||$("#state").val()==''){
                    alert("请填入完整图书信息！");
                    return mySubmit(false);
                }
            })
        </script>
    </form>

</div>



</body>
</html>
