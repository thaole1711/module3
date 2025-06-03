<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/3/2025
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>danh sách khách hàng</title>
</head>
<body>
<h1>danh sách khách hàng</h1>
<table>
    <tr>
        <th>tên</th>
        <th>ngày sinh</th>
        <th>địa chỉ</th>
        <th>hình ảnh</th>
    </tr>
    <c:forEach var="item" items="${khanhHang}" varStatus="idx">
        <tr>
            <td>${item.ten}</td>
            <td>${item.ngay_sinh}</td>
            <td>${item.dia_chi}</td>
            <td><img src="${item.anh}" alt=""></td>

        </tr>
    </c:forEach>

</table>
</body>
</html>
