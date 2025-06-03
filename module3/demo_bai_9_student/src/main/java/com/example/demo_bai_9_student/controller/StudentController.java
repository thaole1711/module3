package com.example.demo_bai_9_student.controller;

import com.example.demo_bai_9_student.entity.Student;
import com.example.demo_bai_9_student.service.IStudentService;
import com.example.demo_bai_9_student.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/students")
public class StudentController extends HttpServlet {
    private IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("WEB-INF/view/create.jsp").forward(req, resp);
                break;
            default:
                String message = req.getParameter("message");
                List<Student> students = studentService.findAll();
                req.setAttribute("students", students);
//                req.setAttribute("message", message);
                req.getRequestDispatcher("WEB-INF/view/list.jsp").forward(req, resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String name = req.getParameter("name");
                String address = req.getParameter("address");
                Float points = Float.parseFloat(req.getParameter("point"));
                String className = req.getParameter("className");
                Student student = new Student(name, address, points, className);
                Map<String, String> error = studentService.add(student);
                if (error.isEmpty()) {
                    resp.sendRedirect("/students?message=created");
                } else {
                    req.setAttribute("error", error);
                    req.setAttribute("student", student);
                    req.getRequestDispatcher("WEB-INF/view/create.jsp").forward(req, resp);
                }
                break;
            case "update":
                break;
            case "delete":
                break;
                
        }
    }
}
