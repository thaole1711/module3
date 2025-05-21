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
order_id int,
product_id int ,
primary key(order_id,product_id ),
order_quantity int,
foreign key (product_id ) references product(product_id),
foreign key (order_id ) references orders(order_id)
);
insert into customer values(1,'Minh Quan',10);
insert into customer values(2,'Ngoc Oanh',20);
insert into customer values(3,'Hong Ha',50);

insert into orders values(1,1,'2006-03-14',null);
insert into orders values(2,2,'2006-03-16',null);
insert into orders values(3,1,'2006-03-12',null);

insert into product values(1,'May Giac',3);
insert into product values(2,'Tu Lanh',5);
insert into product values(3,'Dieu Hoa',7);
insert into product values(4,'Quat',1);
insert into product values(5,'Bep Dien',2);

insert into order_detail values(1,1,3);
insert into order_detail values(1,3,7);
insert into order_detail values(1,4,2);
insert into order_detail values(2,1,1);
insert into order_detail values(3,1,8);
insert into order_detail values(2,3,3);
insert into order_detail values(2,5,4);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice 
-- của tất cả các hóa đơn trong bảng Order
select order_id, order_date,order_total_price from orders;

-- Hiển thị danh sách các khách hàng đã mua hàng,
--  và danh sách sản phẩm được mua bởi các khách
select c.customer_id,c.customer_name,group_concat(p.product_name)
from customer c join orders o on c.customer_id=o.customer_id
join order_detail ord on o.order_id=ord.order_id
join  product p on ord.product_id=p.product_id
group by c.customer_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select c.customer_id,c.customer_name
from customer c left join orders o on c.customer_id=o.customer_id
where o.customer_id is null;

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)

select o.order_id,o.order_date,sum(ord.order_quantity*p.product_price) as gia_ban
from orders o join order_detail ord on o.order_id=ord.order_id
join  product p on ord.product_id=p.product_id
group by o.order_id;

