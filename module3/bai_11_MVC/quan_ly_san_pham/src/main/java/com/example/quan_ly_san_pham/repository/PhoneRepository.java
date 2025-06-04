package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneRepository implements IPhoneRepository {
  private static   List<Phone> phones = new ArrayList<>();
    static {
        phones.add(new Phone(1,"samsung",10000,"nhẹ, bền, tính năng cao","samsung"));
        phones.add(new Phone(2,"iphone",20000,"nhẹ, bền, tính năng cao","iphone"));
        phones.add(new Phone(3,"nokia",30000,"nhẹ, bền, tính năng cao","nokia"));
        phones.add(new Phone(4,"opple",40000,"nhẹ, bền, tính năng cao","opple"));
    }

    @Override
    public List<Phone> findAll() {
        return phones;
    }

    @Override
    public void add(Phone phone) {
        phones.add(phone);

    }

    @Override
    public void update(Phone phone) {
        for (int i = 0; i < phones.size(); i++) {
            if(phones.get(i).getMa()==phone.getMa()){
                phones.set(i,phone);
                break;
            }

        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < phones.size(); i++) {
            if(phones.get(i).getMa()==id){
                phones.remove(i);
                break;
            }

        }

    }

    @Override
    public void search(String name) {

    }
}
