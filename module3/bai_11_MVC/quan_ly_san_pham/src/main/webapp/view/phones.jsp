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
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>--%>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />

</head>
<body>
<h1> danh sách điện thoại</h1>
<div>
    <input id="searchByName" placeholder="Nhập tên cần tìm">
    <button onclick="searchPhone()">Tìm kiếm</button>
</div>
<button onclick="window.location.href='/phones?action=add'">Thêm mới</button>
<p style="color: red">${param.mess}</p>
<table id="tableProduct">
    <thead>
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
    </thead>
    <tbody>
    <c:forEach var="phone" items="${phones}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${phone.ten}</td>
            <td>${phone.gia}</td>
            <td>${phone.moTa}</td>
            <td>${phone.nhaSanXuat}</td>
            <td>${phone.tenLoai}</td>
            <td>
                <button onclick="deleteInfo('${phone.ma}','${phone.ten}')" type="button"
                        class="btn btn-danger btn-sm" data-bs-toggle="modal" data-bs-target="#exampleModal">
                    xóa
                </button>
            </td>
            <td>
                <button onclick="window.location.href='/phones?action=update&&id=${phone.ma}'" type="button"
                        class="btn btn-warning  btn-sm" >
                    chỉnh sửa
                </button>
            </td>
            <td><a href="/phones?action=details&idDetail=${phone.ma}"> xem chi tiết</a></td>
        </tr>
    </c:forEach>
    </tbody>
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
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function() {
        $('#tableProduct').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        } );
    } );
</script>
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
    function searchPhone() {
        const searchName = document.getElementById("searchByName").value;
        window.location.href='/phones?action=search&searchName='+searchName;
    }
</script>

</html>
