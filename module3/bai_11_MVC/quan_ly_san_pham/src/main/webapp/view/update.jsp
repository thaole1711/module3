<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/4/2025
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <label>Mã điện thoại</label>
    <input name="ma" required readonly value="${phone.ma}">
    <label>Tên điện thoại</label>
    <input name="ten" required value="${phone.ten}">
    <label>Giá điện thoại</label>
    <input name="gia" required value="${phone.gia}">
    <label>Mô tả điện thoại</label>
    <input name="mo_ta" required value="${phone.mo_ta}">
    <label>Nhà sản xuất điện thoại</label>
    <input name="nha_san_xuat" required value="${phone.nha_san_xuat}">
    <select name="loaiPhone">
        <option>loại điện thoại</option>
        <c:forEach var="loaiP" items="${loaiPhone}">
            <option value="${loaiP.ma}">${loaiP.ten_loai}</option>
        </c:forEach>
    </select>
    <button type="submit">chỉnh sửa</button>
</form>

</body>
</html>
