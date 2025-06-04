package com.example.quan_ly_san_pham.controller;

import com.example.quan_ly_san_pham.model.Phone;
import com.example.quan_ly_san_pham.sevice.IPhoneSevice;
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
                updatePhone(request,response);
                break;
            default:
                List<Phone> phones = phoneSevice.findAll();
                request.setAttribute("phones", phones);
                request.getRequestDispatcher("/view/phones.jsp").forward(request, response);
        }

    }

    private void updatePhone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/update.jsp").forward(request,response);
    }

    private void showAddPhones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        int ma = Integer.parseInt(req.getParameter("ma"));
        String ten = req.getParameter("ten");
        double gia = Double.parseDouble(req.getParameter("gia"));
        String mo_ta = req.getParameter("mo_ta");
        String nha_san_xuat = req.getParameter("nha_san_xuat");
        Phone phone = new Phone(ma, ten, gia, mo_ta, nha_san_xuat);
        phoneSevice.add(phone);
        resp.sendRedirect("/phones?mess=add");


    }
}
