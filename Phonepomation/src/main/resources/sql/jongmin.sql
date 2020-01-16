--1대 1문의

drop table ph_ono;
create table ph_ono(
ono number primary key,
userid varchar2(50) foreign key,
title varchar2(100)	not null,
categori varchar2(30) not null,
content varchar2(100) not null,
image_path varchar2(500),
regdate date default sysdate,
answer varchar2(100),
answer_regdate date
);

drop sequence ph_ono_seq;
create sequence ph_ono_seq
   start with 1
   increment by 1 
   nocache
   nocycle;


select*from ph_ono;


select * from ph_member;

insert into ph_member values('qweqwe4','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe5','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqw6','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe7','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe8','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe9','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe10','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe11','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe12','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe13','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe14','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe15','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe16','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe17','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe18','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe19','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe20','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe21','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe22','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe23','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe24','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe25','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe26','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe27','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');
insert into ph_member values('qweqwe28','123123','papapap',sysdate,'1992/10/10','남자','qweas@qwerr.com','010-1234-4567','3','1');




