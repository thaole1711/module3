create database quanlyphone;
use quanlyphone;

create table loai_phone(
id_loai int primary key,
ten_loai varchar(50)
);
create table phones(
ma int primary key auto_increment,
ten  varchar(50),
gia double,
mo_ta varchar(250),
nha_san_xuat varchar(100),
id_loai int ,
foreign key  (id_loai) references loai_phone(id_loai)
);
select* from phones;
select * from loai_phone;
insert into phones(ten,gia,mo_ta,nha_san_xuat,id_loai) value ("nokia",13000,"gon,nhe","nokia",3);

