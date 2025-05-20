create database quanlivattu;
use quanlivattu;
create table phieu_xuat(
so_phieu_xuat int primary key ,
ngay_xuat int
 );
  create table vat_tu(
ma_vat_tu  varchar(50) primary key ,
ten_vat_tu  varchar(50)
 );
 create table phieu_nhap(
so_phieu_nhap int primary key ,
ngay_nhap int
 );
  create table nha_cung_cap(
ma_nha_cung_cap  varchar(50) primary key,
ten_nha_cung_cap  varchar(50),
dia_chi  varchar(50)
);
 create table don_dat_hang(
so_don_hang int ,
primary key (so_don_hang),
ngay_dat_hang date,
ma_nha_cung_cap  varchar(50),
foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);
create table phieu_xuat_vat_tu(
so_phieu_xuat int  ,
ma_vat_tu varchar(50) ,
primary key (so_phieu_xuat,ma_vat_tu),
don_gia_xuat double,
so_luong_xuat int,
foreign key (so_phieu_xuat) references phieu_xuat(so_phieu_xuat),
foreign key (ma_vat_tu) references vat_tu( ma_vat_tu)
 );
 
 create table phieu_nhap_vat_tu(
so_phieu_nhap int  ,
ma_vat_tu  varchar(50) ,
primary key (so_phieu_nhap,ma_vat_tu),
don_gia_nhap double,
so_luong_nhap int,
foreign key (so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
 );
 
  create table don_dat_hang_vat_tu(
ma_vat_tu  varchar(50)  ,
so_don_hang int ,
primary key (ma_vat_tu,so_don_hang),
foreign key (ma_vat_tu) references vat_tu( ma_vat_tu),
foreign key (so_don_hang ) references don_dat_hang(so_don_hang)
 );
 
 create table dien_thoai(
so_dien_thoai int primary key,
ma_nha_cung_cap  varchar(50),
foreign key (ma_nha_cung_cap) references nha_cung_cap(ma_nha_cung_cap)
);
 

 
 