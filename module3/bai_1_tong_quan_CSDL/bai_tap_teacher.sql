create database bai_1;
use bai_1;
create table Teachers (
id int primary key ,
`name` varchar(100),
age int,
country varchar(50)
);
select *from Teachers;
insert into Teachers(id,name,age,country) value(1,'Tran Van A', 23,'VietNam');
insert into Teachers(id,name,age,country) value(2,'Tran Van B', 18,'VietNam');
insert into Teachers(id,name,age,country) value(3,'Tran Van C', 25,'VietNam');
insert into Teachers(id,name,age,country) value(5,'Tran Van C', 27,'VietNam');
delete from teachers where id=3;
update Teachers set name='Tran Van D' where id=5;

truncate table Teachers;
