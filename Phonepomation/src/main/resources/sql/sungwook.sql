drop table ph_member;
create table ph_member(
userid varchar2(50) primary key,
userpwd varchar2(50) ,
username varchar2(50),
rdate Date ,
birth varchar2(50),
gender varchar2(10),
email varchar2(50),
tel varchar2(50),
root number(20),
status number(20) 
);

drop table ph_business_member;
create table ph_business_member(
userid varchar2(50) primary key,
userpwd varchar2(50) ,
tel varchar2(50),
email varchar2(50),
businessNum varchar(50),
companyName varchar(50),
leader varchar(50),
address varchar(50),
rdate Date ,
root number(20)
);
select *from ph_business_member

		select * from ph_member
			where userid='lee52x'

		select count(*) from ph_member
			where userid='lee52x'
			
		select count(*) from ph_member
			where userid='lee52x' and userpwd='qldirt'
			
			
					select userid,userpwd,username,rdate,birth,gender,email,tel,root,status from ph_member
			where userid='lee52x'
			
			select*from ph_member
			select*from ph_business_member