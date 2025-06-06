package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.dto.PhoneDtoRepose;
import com.example.quan_ly_san_pham.model.Phone;

import java.util.List;

public interface IPhoneRepository {
    List<PhoneDtoRepose> findAll();
    boolean add(Phone phone) ;
    boolean update(Phone phone);
    boolean delete(int id);
    Phone findPhoneById(int id);
    List<PhoneDtoRepose> search(String name);
}
