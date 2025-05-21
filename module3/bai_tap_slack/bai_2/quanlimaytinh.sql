create database quanlimaytinh;
use quanlimaytinh;

create table may_tinh(
ma_may varchar(100)primary key,
hang_may varchar(220),
vi_tri varchar(200)
);
create table loai_khach(
ma_loai_khach varchar(100) primary key,
ten_loai_khach varchar(250)
);
create table khach_hang(
ma_khach_hang varchar(100) primary key,
ten_khach_hang varchar(250),
so_dien_thoai varchar(100),
email varchar(100),
ma_loai_khach varchar(100),
foreign key (ma_loai_khach ) references loai_khach(ma_loai_khach)
);
create table dich_vu_di_kem(
ma_dich_vu varchar(100) primary key,
ten_dich_vu varchar(220),
so_luong int
);
create table khach_hang_su_dung(
ma_khach_hang_su_dung varchar(100) primary key,
ma_khach_hang varchar(100),
ma_may varchar(100) ,
thoi_gian_bat_dau time,
thoi_gian_ket_thuc time,
foreign key (ma_khach_hang ) references  khach_hang(ma_khach_hang),
foreign key (ma_may ) references  may_tinh(ma_may )
);
create table khach_hang_su_dung_dich_vu(
ma_khach_hang_su_dung varchar(100),
ma_dich_vu varchar(100),
primary key(ma_khach_hang_su_dung,ma_dich_vu),
foreign key (ma_khach_hang_su_dung ) references  khach_hang_su_dung(ma_khach_hang_su_dung),
foreign key (ma_dich_vu ) references  dich_vu_di_kem(ma_dich_vu )
);



