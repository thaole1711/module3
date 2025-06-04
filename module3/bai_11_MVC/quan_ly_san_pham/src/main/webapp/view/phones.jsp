<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/4/2025
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>

</head>
<body>
<h1> danh sách điện thoại</h1>
<button onclick="window.location.href='/phones?action=add'">Thêm mới</button>
<p style="color: red">${param.mess}</p>
<table>
    <tr>
        <th>Số thứ tự</th>
        <th> Tên điện thoại</th>
        <th> Giá điện thoại</th>
        <th> Mô tả điện thoại</th>
        <th> Nhà sản xuất điện thoại</th>
        <th> xóa</th>
        <th> chỉnh sửa</th>
    </tr>
    <c:forEach var="phone" items="${phones}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${phone.ten}</td>
            <td>${phone.gia}</td>
            <td>${phone.mo_ta}</td>
            <td>${phone.nha_san_xuat}</td>
            <td>
                <button onclick="deleteInfo('${phone.ma}','${phone.ten}')" type="button"
                        class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
                  xóa
                </button>
            </td>
            <td>
                <button onclick="updateInfo('${phone.ma}','${phone.ten}')" type="button"
                        class="btn btn-blue btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModals">
                    chỉnh sửa
                </button>
            </td>

        </tr>
    </c:forEach>

</table>
<!-- Modal xóa -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form method="post" action="/phones?action=delete">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabel">Xóa điện thoại</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input hidden="hidden" id="deleteId" name="deleteId">
                    <span>Bạn có muốn xoá điện thoại </span><span id="deleteName"></span> không?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                    <button  class="btn btn-primary">Xoá</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%--modal chỉnh sửa--%>
<div class="modal fade" id="exampleModals" tabindex="-1" aria-labelledby="exampleModalLabels" aria-hidden="true">
    <div class="modal-dialog">
        <form method="post" action="/phones?action=update">
            <div class="modal-content">
                <div class="modal-header">
                    <h1 class="modal-title fs-5" id="exampleModalLabels">Chỉnh sửa điện thoại</h1>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input hidden="hidden" id="updateId" name="updateId">
                    <span>Bạn có muốn chỉnh sửa điện thoại </span><span id="updateName"></span> không?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                    <button  class="btn btn-primary">Chỉnh sửa</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script>
    function deleteInfo(id, name) {
        document.getElementById("deleteId").value= id;
        document.getElementById("deleteName").innerText= name;
    }
    function updateInfo(updateId,updateName){
        document.getElementById("updateId").value= updateId;
        document.getElementById("updateName").value=updateName;
    }
</script>
</html>
