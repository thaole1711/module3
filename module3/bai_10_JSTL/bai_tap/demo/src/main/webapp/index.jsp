<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/3/2025
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<form method="post" action="/index">
    <label>Calculator</label>
    <label>First operand</label>
    <input name="first" type="number">
    <label>operand</label>
    <select name="operand">
        <option value="cong">+</option>
        <option value="tru">-</option>
        <option value="nhan">*</option>
        <option value="chia">/</option>
    </select>
    <label>second operand</label>
    <input name="second" type="number">
    <button type="submit">calculate</button>
</form>
</body>
</html>
