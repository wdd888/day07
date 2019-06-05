<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/4
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login" method="post">
    <div>
        <label>用户名</label>
        <input type="text" name="username">
    </div>
    <div>
        <label>密码</label>
        <input type="text" name="password">
    </div>
    <div>
        <input type="checkbox" name="index" > 保存5天
    </div>
    <input type="submit" value="登录">
</form>
</body>
</html>
