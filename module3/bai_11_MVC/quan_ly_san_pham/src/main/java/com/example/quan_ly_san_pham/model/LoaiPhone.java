package com.example.quan_ly_san_pham.model;

public class LoaiPhone {
    int ma;
    String ten_loai;

    public LoaiPhone(int ma, String ten_loai) {
        this.ma = ma;
        this.ten_loai = ten_loai;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen_loai() {
        return ten_loai;
    }

    public void setTen_loai(String ten_loai) {
        this.ten_loai = ten_loai;
    }
}
