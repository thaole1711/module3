package com.example.quan_ly_san_pham.sevice;

import com.example.quan_ly_san_pham.dto.PhoneDtoRepose;
import com.example.quan_ly_san_pham.model.Phone;

import java.util.List;

public interface IPhoneSevice {
    List<PhoneDtoRepose> findAll();
    boolean add(Phone phone);
    boolean update(Phone phone);
    boolean delete(int id);
    List<PhoneDtoRepose> search(String name);
    Phone findPhoneById(int id);
}
