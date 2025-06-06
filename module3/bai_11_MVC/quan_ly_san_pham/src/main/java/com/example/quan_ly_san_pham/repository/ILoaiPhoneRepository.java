package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.LoaiPhone;

import java.util.List;

public interface ILoaiPhoneRepository {
    List<LoaiPhone> findAll();
}
