<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/6/2025
  Time: 3:46 PM
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
    <th>Số thứ tự</th>
    <th> Tên điện thoại</th>
    <th> Giá điện thoại</th>
    <th> Mô tả điện thoại</th>
    <th> Nhà sản xuất điện thoại</th>
    <th> loại điện thoại</th>
    <th> xóa</th>
    <th> chỉnh sửa</th>
    <th> Xem chi tiết điện thoại</th>
  </tr>
  <c:forEach var="phone" items="${phones}" varStatus="status">
    <tr>
      <td>${status.count}</td>
      <td>${phone.ten}</td>
      <td>${phone.gia}</td>
      <td>${phone.mo_ta}</td>
      <td>${phone.nha_san_xuat}</td>
      <td>${phone.ma}</td>

    </tr>
  </c:forEach>

</table>
</body>
</html>
