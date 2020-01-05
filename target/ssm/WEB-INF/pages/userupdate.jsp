<%--
  Created by IntelliJ IDEA.
  User: 寒芒
  Date: 2019/12/21
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户类型</title>
</head>
<body>

<div style="position: relative;top: 8%;width: 80%;margin-left: 10%">
    <center>
        <form action="TYupdata?rdType=<%=request.getAttribute("ids")%>" method="post">
            <input type="hidden" name="rdType" value="${ids}"><br/>
            读者类别:<input type="text" name="rdTypeName" style="width: 250px" value="<%=request.getAttribute("rdTypeName")%>"><br/>
            可借数量:<input type="text" name="canendQty" style="width: 250px" value="<%=request.getAttribute("canendQty")%>"><br/>
            可借天数:<input type="text" name="canendDay" style="width: 250px" value="<%=request.getAttribute("canendDay")%>"><br/>
            可续借天数:<input type="text" name="canContinueTimes" style="width: 250px" value="<%=request.getAttribute("canContinueTimes")%>"><br/>
            罚款率:<input type="text" name="punishRate" style="width: 250px" value="<%=request.getAttribute("punishRate")%>"><br/>
            证书有效期:<input type="text" name="pateValid" style="width: 250px" value="<%=request.getAttribute("pateValid")%>"><br/>
            <input type="submit" value="提交修改">
        </form>
    </center>
</div>

</body>
</html>
