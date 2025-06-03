<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/2/2025
  Time: 10:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> danh sach hoc sinh</title>
</head>
<body>
<button onclick="window.location.href='/students?action=create'">Them moi</button>
<table>
  <tr>
    <th>no</th>
    <th>ho va ten</th>
    <th>diem </th>
    <th>lop</th>
  </tr>
  <c:forEach var="item" items="${students}" varStatus="idx">
    <tr>
      <td>${idx.count}</td>
      <td>${item.name}</td>
      <td>${item.address}</td>
      <td>${item.point}</td>
      <td>${item.className}</td>

    </tr>
  </c:forEach>
</table>
<c:if test="${message=='create'}">
  <p id="message" style="color: blue"> thêm moi thanh cong</p>
</c:if>

</body>
<script>
  setTimeout(function () {
    document.getElementById("message").remove();
  },3000)
</script>
</html>
