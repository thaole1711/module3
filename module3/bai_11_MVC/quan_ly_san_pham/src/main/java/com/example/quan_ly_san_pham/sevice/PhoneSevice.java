package com.example.quan_ly_san_pham.sevice;

import com.example.quan_ly_san_pham.model.Phone;
import com.example.quan_ly_san_pham.repository.IPhoneRepository;
import com.example.quan_ly_san_pham.repository.PhoneRepository;

import java.util.ArrayList;
import java.util.List;

public class PhoneSevice implements IPhoneSevice {
    private IPhoneRepository iPhoneRepository =new PhoneRepository();
    @Override
    public List<Phone> findAll() {
        return iPhoneRepository.findAll();
    }

    @Override
    public void add(Phone phone) {
        iPhoneRepository.add(phone);

    }

    @Override
    public void update(Phone phone) {
        iPhoneRepository.update(phone);

    }

    @Override
    public void delete(int id) {
       iPhoneRepository.delete(id);


    }

    @Override
    public void search(String name) {

    }

    public IPhoneRepository getiPhoneRepository() {
        return iPhoneRepository;
    }

    public void setiPhoneRepository(IPhoneRepository iPhoneRepository) {
        this.iPhoneRepository = iPhoneRepository;
    }
}
