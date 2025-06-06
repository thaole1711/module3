package com.example.quan_ly_san_pham.sevice;

import com.example.quan_ly_san_pham.dto.PhoneDtoRepose;
import com.example.quan_ly_san_pham.model.Phone;
import com.example.quan_ly_san_pham.repository.IPhoneRepository;
import com.example.quan_ly_san_pham.repository.PhoneRepository;

import java.util.ArrayList;
import java.util.List;

public class PhoneSevice implements IPhoneSevice {
    private IPhoneRepository iPhoneRepository =new PhoneRepository();
    @Override
    public List<PhoneDtoRepose> findAll() {
        return iPhoneRepository.findAll();
    }

    @Override
    public boolean add(Phone phone) {
     return iPhoneRepository.add(phone);

    }

    @Override
    public boolean update(Phone phone) {
       return iPhoneRepository.update(phone);

    }

    @Override
    public boolean delete(int id) {
       return iPhoneRepository.delete(id);


    }

    @Override
    public List<PhoneDtoRepose> search(String name) {
        return iPhoneRepository.search(name);

    }

    @Override
    public Phone findPhoneById(int id) {
      return   iPhoneRepository.findPhoneById(id);
    }


}
