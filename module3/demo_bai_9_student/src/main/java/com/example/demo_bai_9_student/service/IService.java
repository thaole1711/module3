package com.example.demo_bai_9_student.service;

import java.util.List;
import java.util.Map;

public interface IService<T> {

    List<T> findAll();
    Map<String,String> add(T student);
}
