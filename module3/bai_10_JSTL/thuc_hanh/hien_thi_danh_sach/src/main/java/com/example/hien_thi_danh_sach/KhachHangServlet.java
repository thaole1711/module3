package com.example.hien_thi_danh_sach;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/list")
public class KhachHangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<KhachHang> khachHangs= new ArrayList<>();
        khachHangs.add(new KhachHang("Mai Văn Hoàn","1983-08-20","Hà Nội","https://cdn11.dienmaycholon.vn/filewebdmclnew/public/userupload/files/Image%20FP_2024/hinh-anh-avatar-ca-tinh-nu-54.jpg"));
        khachHangs.add(new KhachHang("Mai Văn Thái","1983-09-21","Sài Gòn","https://cdn11.dienmaycholon.vn/filewebdmclnew/public/userupload/files/Image%20FP_2024/hinh-anh-avatar-ca-tinh-nu-54.jpg"));
        khachHangs.add(new KhachHang("Mai Văn Hậu","1983-08-22","Huế","https://cdn11.dienmaycholon.vn/filewebdmclnew/public/userupload/files/Image%20FP_2024/hinh-anh-avatar-ca-tinh-nu-54.jpg"));
        khachHangs.add(new KhachHang("Mai Văn Mẫu","1983-08-23","Vinh","https://cdn11.dienmaycholon.vn/filewebdmclnew/public/userupload/files/Image%20FP_2024/hinh-anh-avatar-ca-tinh-nu-54.jpg"));
        req.setAttribute("khanhHang",khachHangs);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
