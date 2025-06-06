<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/5/2025
  Time: 8:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>

        <th> Tên điện thoại</th>
        <th> Giá điện thoại</th>
        <th> Mô tả điện thoại</th>
        <th> Nhà sản xuất điện thoại</th>

    </tr>
    <tr>
        <td>${phoneDetail.ten}</td>
        <td>${phoneDetail.gia}</td>
        <td>${phoneDetail.mo_ta}</td>
        <td>${phoneDetail.nha_san_xuat}</td>
    </tr>


</table>
</body>
</html>
