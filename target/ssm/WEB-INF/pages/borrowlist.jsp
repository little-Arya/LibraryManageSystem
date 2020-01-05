<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 寒芒
  Date: 2019/12/19
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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


<table border="2" cellspacing="0" cellpadding="0"width="100%"height="100">
    <tr>
        <td>借书序号</td>
        <td>读者序号</td>
        <td>图书序号</td>
        <td>续借次数</td>
        <td>借书日期</td>
        <td>应还日期</td>
        <td>实还日期</td>
        <td>超期天数</td>
        <td>超期金额</td>
        <td>罚款金额</td>
        <td>是否还书</td>
        <td>借书操作员</td>
        <td>还书操作员</td>
        <td>操作</td>
        <td>续借</td>
    </tr>
    <c:forEach items="${borrowlist}" var="book">
        <tr>
            <td>${book.borrowID}</td>
            <td>${book.rdID}</td>
            <td> ${book.bkID}</td>
            <td>${book.ldContinueTimes }</td>
            <td><fmt:formatDate value="${book.ldDateOut}" pattern="yyyy-MM-dd"/> </td>
            <td><fmt:formatDate value="${book.ldDateRetPlan}" pattern="yyyy-MM-dd"/> </td>
            <td><fmt:formatDate value="${book.ldDateRetAct}" pattern="yyyy-MM-dd"/> </td>
            <td>${book.ldOverDay}</td>
            <td>${book.ldOverMoney}</td>
            <td>${book.ldPunishMoney}</td>
            <td>${book.lsHasReturn}</td>
            <td>${book.operatorLend}</td>
            <td>${book.operatorRet}</td>
            <td><a href="${pageContext.request.contextPath}/ReturnBook?rdID=${book.rdID}&&bkID=${book.bkID}&&BorrowID=${book.borrowID}">还书</a></td>
            <td><a href="${pageContext.request.contextPath}/ContinueBook?rdID=${book.rdID}&&bkID=${book.bkID}&&BorrowID=${book.borrowID}">续借</a></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
