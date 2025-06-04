package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Phone;

import java.util.List;

public interface IPhoneRepository {
    List<Phone> findAll();
    void add(Phone phone);
    void update(Phone phone);
    void delete(int id);
    void search(String name);
}
