create database my_database;
use my_database;
create table students(
id int primary key,
`name` varchar(255)
);
drop table my_table;

select* from students;
-- select id from students;
insert into students(id,`name`) value(2,'chung');
update students set name='thao' where id=1;
delete from students where id=2;