--board.sql
drop table ph_reply;
drop table ph_board;
drop table ph_boardtype;

create table ph_boardtype(
	tno number primary key,
	title varchar2(50) not null
);
create table ph_board(
   bno number primary key,
   tno number references ph_boardtype(tno),
   title varchar2(200) not null,
   content varchar2(1000) not null,
   image varchar2(200),
   writer varchar2(50) not null,
   regdate date default sysdate,
   viewcnt number default 0
);
create table ph_reply(
   rno         number primary key,
   bno        number references ph_board(bno),
   replytext   varchar2(1000) not null,
   replyer      varchar2(50) not null,
   regdate     date default sysdate,
   updatedate    date default sysdate
);

drop sequence ph_boardtype_seq;
create sequence ph_boardtype_seq
   start with 1
   increment by 1 
   nocache
   nocycle;

drop sequence ph_reply_seq;
create sequence ph_reply_seq
	start with 1
	increment by 1 
	nocache
	nocycle;

drop sequence ph_board_seq;
create sequence ph_board_seq
   start with 1
   increment by 1 
   nocache
   nocycle;
   
insert into ph_boardtype values (ph_boardtype_seq.nextval,'KT 이벤트');
insert into ph_boardtype values (ph_boardtype_seq.nextval,'LGU+ 이벤트');
insert into ph_boardtype values (ph_boardtype_seq.nextval,'SKT 이벤트');

insert into ph_boardtype values (ph_boardtype_seq.nextval,'공지사항');
insert into ph_boardtype values (ph_boardtype_seq.nextval,'자유게시판');