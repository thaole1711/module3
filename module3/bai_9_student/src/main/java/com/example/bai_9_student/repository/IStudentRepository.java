package com.example.bai_9_student.repository;

import com.example.bai_9_student.entity.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    void add(Student student);
}

