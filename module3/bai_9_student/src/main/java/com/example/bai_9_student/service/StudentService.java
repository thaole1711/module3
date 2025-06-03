package com.example.bai_9_student.service;

import com.example.bai_9_student.entity.Student;
import com.example.bai_9_student.repository.IStudentRepository;
import com.example.bai_9_student.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {

        return studentRepository.findAll();
    }

    @Override
    public void add(Student student) {
        studentRepository.add(student);
    }
}

