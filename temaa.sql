drop database if exists tema;
create database tema;
use tema;
SET SQL_SAFE_UPDATES = 0;

SET FOREIGN_KEY_CHECKS=0;
DELETE FROM COURSES where idc=1;
SET SQL_SAFE_UPDATES = 1;
select * from courses;
drop table STUDENT;
drop table COURSES;
create table STUDENT(
ids int unique auto_increment primary key,
namee char(10),
birth_date varchar(15),
adresa varchar(15)
);

create table COURSES(
idc int unique auto_increment primary key,
namec char(10),
teacher char (20),
study_year int);



create table STUDENT_ENROL(
ide int unique auto_increment primary key,
studentid int,
courseid int,
foreign key(studentid) references STUDENT(ids),
foreign key(courseid) references COURSES(idc)
);


insert into STUDENT values
(7,'Dregan','14.06.1995','Jibou'),
(8,'Sechel','15.07.1995','Racas'),
(9,'Lazar','28.02.1995','Cuceu');

insert into COURSES values
(1,'BD','Ivan',2),
(2,'PC','Ignat',1),
(7,'IIA','Groza',3);

select * from courses;
insert into STUDENT_ENROL values
(1,1,1),
(2,2,2),
(3,3,3);


