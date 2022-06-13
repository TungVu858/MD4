<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/6/2022
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <label for="vnd">VND</label>
    <input type="number" name="vnd" id="vnd" value="${vnd}">
    <label for="rate">Tỉ giá</label>
    <input type="number" name="rate" id="rate" value="${rate}">
    <input type="submit" value="Chuyển">
    <span>USD :${usd}</span>
</form>
</body>
</html>
