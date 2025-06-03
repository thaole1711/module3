package com.example.demo;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/index")
public class Calculator extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/index.jsp").forward(req,resp);
//
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double so_thu_1 = Double.parseDouble(req.getParameter("first"));
        double so_thu_2 = Double.parseDouble(req.getParameter("second"));
        double result;
        String operator = req.getParameter("operand");
        if (operator.equals("cong")) {
            result = so_thu_1 + so_thu_2;
        } else if (operator.equals("tru")) {
            result = so_thu_1 - so_thu_2;
        } else if (operator.equals("nhan")) {
            result = so_thu_1 * so_thu_2;
        } else {
            result = so_thu_1 / so_thu_2;

        }
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h2> ket qua" + result + "</h2");
    }
}
