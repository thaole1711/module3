create database demo;
use demo;

create table products(
 id int primary key,
 product_code varchar(100) ,
 product_name varchar(100),
 product_price double,
 product_amount int,
 product_description varchar(100),
 product_status boolean);

insert into products (id,product_code,product_name,product_price,
product_amount,product_description,product_status ) 
values
(1,'p1','may tinh',1000,1,'may tinh dell',1),
(2,'p2','dien thoai',2000,2,'dien thoai iphone',1),
(3,'p3','tivi',3000,3,'tivi lg',1),
(4,'p4','tu lanh',4000,4,'tu lanh aqua',1);

create unique index i_product_code on products(product_code);
create index i_product_name on products(product_name,product_price);
explain select* from products where product_code='p1';
explain select* from products where product_name='tivi' and product_price=3000;

create view v_products as
select product_code,product_name,product_price,product_status
from products;
create or replace view v_products as
select  product_code,product_name,product_price,product_description
from products;
drop view v_products;

delimiter //
create procedure get_all_products()
begin 
select * from products;
end;
//
delimiter ;
call get_all_products();

delimiter //
create procedure add_products(
in pro_id int,
 in pro_code varchar(100),
 in  pro_name varchar(100),
 in  pro_price double,
 in  pro_amount int,
 in pro_description varchar(100),
 in pro_status boolean
 )
 begin 
 insert into products(id,product_code,product_name,product_price,product_amount,product_description,product_status)
 values (pro_id,pro_code,pro_name,pro_price,pro_amount,pro_description,pro_status);
 end;
 //
 delimiter ;
call add_products(5,'P5','may lanh',5000,5,'may lanh hatachi',1);

  delimiter //
 create procedure update_products(
 in pro_id int ,
 in pro_code varchar(100),
 in  pro_name varchar(100),
 in  pro_price double,
 in  pro_amount int,
 in pro_description varchar(100),
 in pro_status boolean
 )
 begin 
 update products
 set product_code=pro_code,
 product_name=pro_name,
 product_price=pro_price,
 product_amount=pro_amount,
 product_description=pro_description,
 product_status=pro_status
 where id=pro_id;
 end;
 // 
 delimiter ;
 call update_products(1,'p1','may lanh 1',6000,7,'may lanh hatachi 7',1);
 
delimiter //
create procedure delete_products(
in pro_id int)
begin 
delete from products where id= pro_id;
end;
//
delimiter ;
call delete_products(4);
select *from products;


 