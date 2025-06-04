package com.example.quan_ly_san_pham.model;

public class Phone {
    private int ma;
    private String ten;
    private double gia;
    private String mo_ta;
    private String nha_san_xuat;

    public Phone(int ma, String ten, double gia, String mo_ta, String nha_san_xuat) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.mo_ta = mo_ta;
        this.nha_san_xuat = nha_san_xuat;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public String getNha_san_xuat() {
        return nha_san_xuat;
    }

    public void setNha_san_xuat(String nha_san_xuat) {
        this.nha_san_xuat = nha_san_xuat;
    }
}
