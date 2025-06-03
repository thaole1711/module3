package com.example.demo_student.repository;

import com.example.demo_student.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "HaiTT", "QN", 9, "C0225g1"));
        students.add(new Student(2, "Thao", "QN", 9, "C0225g1"));
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }
}

