create database quanlybanhang;

use quanlybanhang;
create table customer(
customer_id int primary key,
customer_name varchar(100),
customer_age int
);
create table orders(
order_id int primary key,
customer_id int ,
order_date date,
order_total_price double,
foreign key (customer_id ) references customer(customer_id)
);
create table product(
product_id int primary key,
product_name varchar(255),
product_price double
);
create table order_detail(
order_detail_id int,
product_id int ,
primary key(order_detail_id,product_id ),
order_id int,
order_quality varchar(255),
foreign key (product_id ) references product(product_id),
foreign key (order_id ) references orders(order_id)
);



