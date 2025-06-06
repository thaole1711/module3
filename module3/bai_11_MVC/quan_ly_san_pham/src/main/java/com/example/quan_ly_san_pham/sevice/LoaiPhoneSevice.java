package com.example.quan_ly_san_pham.sevice;

import com.example.quan_ly_san_pham.model.LoaiPhone;
import com.example.quan_ly_san_pham.repository.ILoaiPhoneRepository;
import com.example.quan_ly_san_pham.repository.LoaiPhoneRepository;

import java.util.List;

public class LoaiPhoneSevice implements ILoaiPhoneSevice{
    ILoaiPhoneRepository iLoaiPhoneRepository =new LoaiPhoneRepository();
    @Override
    public List<LoaiPhone> findAll() {
        return iLoaiPhoneRepository.findAll();
    }
}
