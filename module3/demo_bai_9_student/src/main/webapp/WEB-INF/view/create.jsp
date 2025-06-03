<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/3/2025
  Time: 7:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>thêm mới</title>
</head>
<body>
<form method="post">
  <label> họ và tên</label>
  <input name="name" required value="${student.name}">
  <span style="color: red">${error.get("name")}</span>
  <label>dia chi</label>
  <input name="address" value="${student.address}">
  <label>diem</label>
  <input name="point" value="${student.point}">
  <span style="color: red">${error.get("point")}</span>
  <label>lop</label>
  <input name="className" value="${student.className}">
  <button type="submit"> them</button>

</form>
</body>
</html>
