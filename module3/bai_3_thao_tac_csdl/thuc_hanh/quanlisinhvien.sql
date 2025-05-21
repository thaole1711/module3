create database quanlisinhvien;
use quanlisinhvien;

create table class(
class_id int not null auto_increment primary key,
class_name varchar(60) not null,
startdate datetime not null,
status bit
);
create table student(
student_id int not null auto_increment primary key,
student_name varchar(60) not null,
address varchar(20),
phone varchar(20),
status bit,
class_id int,
foreign key(class_id) references class(class_id)
);
create table subjects(
sub_id int not null auto_increment primary key,
sub_name varchar(60) not null,
credit tinyint not null default 1 check (credit >=1),
status bit default 1
);
create table mark(
mark_id int not null auto_increment primary key,
sub_id int not null,
student_id int not null,
mark float default 0 check (mark between 0 and 100),
examtimes tinyint default  1,
unique(sub_id,student_id),
foreign key(sub_id) references subjects(sub_id),
foreign key(student_id) references student(student_id)
);
insert into class values(1,'A1','2008-12-20', 1);
insert into class values(2,'A2','2008-12-22', 1);
insert into class values(3,'B3',current_date(), 0);

insert into student(student_name,address,phone,status,class_id)
 value('Hung','Ha Noi','0912113113',1,1);
insert into student(student_name,address,status,class_id)
  value('Hoa','Hai Phong',1,1);
insert into student(student_name,address,phone,status,class_id)
  value('Manh','HCM','0912167113',0,2);

insert into subjects
 values(1,'CF',5, 1),
 (2,'C',6, 1),
 (3,'HDJ',5, 1),
 (4,'RDBMS',10, 1);
 insert into mark(sub_id,student_id,mark,examtimes)
 values(1,1,8,1),
 (1,2,10,2),
 (2,1,12,1);

select*from student;
select*from student where status=true;
select*from subjects where credit<10;
select s.student_id, s.student_name,c.class_name
from student s join class c on s.class_id=c.class_id;
select s.student_id, s.student_name, c.class_name
from student s join class c on s.class_id= c.class_id 
where c.class_name='A1';
select s.student_id, s.student_name,sub.sub_name, m.mark
from student s join mark m on s.student_id=m.student_id 
join subjects sub on  m.sub_id = sub.sub_id
where sub.sub_name='CF';

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select*from student s where s.student_name like 'H%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
select*from class c where c.startdate  like '%12%';

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select*from subjects sub where sub.credit between 3 and 5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
update  student set student.class_id=2 
where student.student_name like 'Hung'
limit 1;

-- Hiển thị các thông tin: StudentName, SubName, Mark. 
-- Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
select  s.student_name,sub.sub_name, m.mark
from student s join mark m on s.student_id=m.student_id 
join subjects sub on  m.sub_id = sub.sub_id
order by m.mark DESC ,s.student_name ;

