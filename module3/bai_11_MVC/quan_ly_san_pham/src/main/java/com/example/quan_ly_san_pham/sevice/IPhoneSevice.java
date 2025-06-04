package com.example.quan_ly_san_pham.sevice;

import com.example.quan_ly_san_pham.model.Phone;

import java.util.List;

public interface IPhoneSevice {
    List<Phone> findAll();
    void add(Phone phone);
    void update(Phone phone);
    void delete(int id);
    void search(String name);
}
