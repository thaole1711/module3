package com.example.quan_ly_san_pham.controller;

import com.example.quan_ly_san_pham.dto.PhoneDtoRepose;
import com.example.quan_ly_san_pham.model.Phone;
import com.example.quan_ly_san_pham.repository.ILoaiPhoneRepository;
import com.example.quan_ly_san_pham.sevice.ILoaiPhoneSevice;
import com.example.quan_ly_san_pham.sevice.IPhoneSevice;
import com.example.quan_ly_san_pham.sevice.LoaiPhoneSevice;
import com.example.quan_ly_san_pham.sevice.PhoneSevice;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/phones")
public class PhoneController extends HttpServlet {
    private IPhoneSevice phoneSevice = new PhoneSevice();
    private ILoaiPhoneSevice iLoaiPhoneSevice= new LoaiPhoneSevice();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddPhones(request, response);
                break;
            case "delete":
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                Phone phone = phoneSevice.findPhoneById(id);
                request.setAttribute("phone", phone);
                updatePhone(request,response);
                break;
            case "search":
                String name= request.getParameter("searchName");
                List<PhoneDtoRepose> listPhoneByName= phoneSevice.search(name);
                request.setAttribute("phones", listPhoneByName);
                request.getRequestDispatcher("/view/phones.jsp").forward(request, response);
                break;
            case "details":
                int idDetail=Integer.parseInt(request.getParameter("idDetail"));
                Phone phoneDetail= phoneSevice.findPhoneById(idDetail);
                request.setAttribute("phoneDetail",phoneDetail);
                request.getRequestDispatcher("/view/details.jsp").forward(request, response);
                break;
            default:
                List<PhoneDtoRepose> phones = phoneSevice.findAll();
                request.setAttribute("phones", phones);
                request.getRequestDispatcher("/view/phones.jsp").forward(request, response);
        }

    }

    private void updatePhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setAttribute("loaiPhone",iLoaiPhoneSevice.findAll());

        request.getRequestDispatcher("/view/update.jsp").forward(request, response);
    }

    private void showAddPhones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("loaiPhone",iLoaiPhoneSevice.findAll());
        request.getRequestDispatcher("/view/add.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "add":
                save(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "update":
                int ma = Integer.parseInt(req.getParameter("ma"));
                String ten = req.getParameter("ten");
                double gia = Double.parseDouble(req.getParameter("gia"));
                String mo_ta = req.getParameter("mo_ta");
                String nha_san_xuat = req.getParameter("nha_san_xuat");
                int loaiPhone= Integer.parseInt(req.getParameter("loaiPhone"));
                Phone phone = new Phone(ma, ten, gia, mo_ta, nha_san_xuat,loaiPhone);
                phoneSevice.update(phone);
                resp.sendRedirect("/phones?mess=update success");

                break;
        }

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int deleteId = Integer.parseInt(req.getParameter("deleteId"));
        phoneSevice.delete(deleteId);
        resp.sendRedirect("/phones?mess=delete success");
    }

    private void doDelete() {
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ten = req.getParameter("ten");
        double gia = Double.parseDouble(req.getParameter("gia"));
        String moTa = req.getParameter("mo_ta");
        String nhaSanXuat = req.getParameter("nha_san_xuat");
        int loai= Integer.parseInt(req.getParameter("loai"));
        Phone phone = new Phone( ten, gia,moTa,nhaSanXuat,loai);
        phoneSevice.add(phone);
        resp.sendRedirect("/phones?mess=add success");


    }
}
