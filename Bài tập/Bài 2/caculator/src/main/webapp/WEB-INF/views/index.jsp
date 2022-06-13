<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/6/2022
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Caculator</h1>
  <form action="/cal" method="post">
    <input type="number" name="num1" value="${num1}">
    <input type="number" name="num2" value="${num2}">
    <button name="key" value="+">+</button>
    <button name="key" value="-">-</button>
    <button name="key" value="*">*</button>
    <button name="key" value="/">/</button>
    =${result}
  </form>
  </body>
</html>
