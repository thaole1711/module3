package com.example.quan_ly_san_pham.dto;

public class PhoneDtoRepose {
    private int ma;
    private String ten;
    private double gia;
    private String moTa;
    private String nhaSanXuat;
    private String tenLoai;

    public PhoneDtoRepose(int ma, String ten, double gia, String moTa, String nhaSanXuat, String tenLoai) {
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.moTa = moTa;
        this.nhaSanXuat = nhaSanXuat;
        this.tenLoai = tenLoai;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }


}
