package com.example.demo_bai_9_student.service;

import com.example.demo_bai_9_student.entity.Student;
import com.example.demo_bai_9_student.repository.IStudentRepository;
import com.example.demo_bai_9_student.repository.StudentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {

        return studentRepository.findAll();
    }

    @Override
    public Map<String,String> add(Student student) {
        Map<String,String> error= new HashMap<>();
        if(!student.getName().matches("^[A-Za-z]{3,100}$"))
            error.put("name","ten phai dung dang");
        if(student.getPoint()<0||student.getPoint()>100){
            error.put("point","diem phai nam trong khoang tu 0->100");
        }
        if(error.isEmpty()){
            studentRepository.add(student);
        }
      return error;
    }
}

