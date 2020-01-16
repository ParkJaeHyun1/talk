drop table ph_phone;
drop table ph_color;
drop table ph_capacity;

drop sequence ph_phone_seq;
create sequence ph_phone_seq
	start with 1
	increment by 1
	nocycle
	nocache;


--�ڵ��� ����, �ڵ�����, �ڵ�������, �������, �����
create table ph_phone(
	id number primary key,
	name varchar2(100) not null,
	image LONG not null,
	manufacture varchar2(15) not null,
	release_date varchar2(30) not null
);

--�Ｚ����
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy S7 edge', '/resources/images/phone/GalaxyS7edge_ȭ��Ʈ��.png', '�Ｚ����', '2016��11��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy S7 edge Olympic Games Limited Edition', '/resources/images/phone/GalaxyS7edgeOlympic_����.png', '�Ｚ����', '2016��07��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy S7 edge Injustice Edition', '/resources/images/phone/GalaxyS7edgeInjustice_����.png', '�Ｚ����', '2016��06��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy S7', '/resources/images/phone/GalaxyS7_�������н�.png', '�Ｚ����', '2016��07��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy note5', '/resources/images/phone/Galaxynote5_����÷�Ƽ��.png', '�Ｚ����', '2015��10��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy S6 edge plus', '/resources/images/phone/GalaxyS6_����÷�Ƽ��.png', '�Ｚ����', '2015��08��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy S6 edge', '/resources/images/phone/GalaxyS6edge_����÷�Ƽ��.png', '�Ｚ����', '2015��04��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy S6', '/resources/images/phone/GalaxyS6_ȭ��Ʈ��.png', '�Ｚ����', '2015��04��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy A8(2016)', '/resources/images/phone/GalaxyA8(2016)_�ǹ�.png', '�Ｚ����', '2016��10��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy A3(2016)', '/resources/images/phone/GalaxyA3(2016)_����.png', '�Ｚ����', '2016��03��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy A5(2016)', '/resources/images/phone/GalaxyA5(2016)_����.png', '�Ｚ����', '2016��01��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy A7(2016)', '/resources/images/phone/GalaxyA7(2016)_����.png', '�Ｚ����', '2016��01��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy J3(2016)', '/resources/images/phone/GalaxyJ3(2016)_ȭ��Ʈ.png', '�Ｚ����', '2016��05��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy J5(2016)', '/resources/images/phone/GalaxyJ5(2016)_����.png', '�Ｚ����', '2016��04��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy J7(2016)', '/resources/images/phone/GalaxyJ7(2016)_����.png', '�Ｚ����', '2016��04��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy note edge', '/resources/images/phone/GalaxynoteEdge_ȭ��Ʈ.png', '�Ｚ����', '2014��10��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy note4 S-LTE', '/resources/images/phone/Galaxynote4SLTE_ȭ��Ʈ.png', '�Ｚ����', '2015��01��');
insert into ph_phone values (ph_phone_seq.nextval, 'Galaxy note4', '/resources/images/phone/Galaxynote4_ȭ��Ʈ.png', '�Ｚ����', '2014��09��');

--����
insert into ph_phone values (ph_phone_seq.nextval, 'iPhone 7', '/resources/images/phone/iPhone7_�ǹ�.png', '����', '2016��10��');
insert into ph_phone values (ph_phone_seq.nextval, 'iPhone 7 plus', '/resources/images/phone/iPhone7Plus_�ǹ�.png', '����', '2016��10��');
insert into ph_phone values (ph_phone_seq.nextval, 'iPhone 6s', '/resources/images/phone/iPhone6s_�ǹ�.png', '����', '2015��10��');
insert into ph_phone values (ph_phone_seq.nextval, 'iPhone 6s Plus', '/resources/images/phone/iPhone6sPlus_�ǹ�.png', '����', '2015��10��');
insert into ph_phone values (ph_phone_seq.nextval, 'iPhone 6 Plus', '/resources/images/phone/iPhone6Plus_�ǹ�.png', '����', '2014��10��');
insert into ph_phone values (ph_phone_seq.nextval, 'iPhoneSE', '/resources/images/phone/iPhoneSE_������.png', '����', '2016��05��');

--LG����
insert into ph_phone values (ph_phone_seq.nextval, 'V20', '/resources/images/phone/V20_�ǹ�.png', 'LG����', '2016��09��');
insert into ph_phone values (ph_phone_seq.nextval, 'V10', '/resources/images/phone/V10_����ȭ��Ʈ.png', 'LG����', '2015��10��');
insert into ph_phone values (ph_phone_seq.nextval, 'G5', '/resources/images/phone/G5_�ǹ�.png', 'LG����', '2016��03��');
insert into ph_phone values (ph_phone_seq.nextval, 'G4', '/resources/images/phone/G4_�����ȭ��Ʈ.png', 'LG����', '2015��04��');
insert into ph_phone values (ph_phone_seq.nextval, 'GStylo', '/resources/images/phone/GStylo_ȭ��Ʈ.png', 'LG����', '2015��04��');
insert into ph_phone values (ph_phone_seq.nextval, 'GFlex2', '/resources/images/phone/GFlex2_�÷�Ƽ�ѽǹ�.png', 'LG����', '2015��01��');
insert into ph_phone values (ph_phone_seq.nextval, 'G3Screen', '/resources/images/phone/G3Screen_ȭ��Ʈ.png', 'LG����', '2014��10��');
insert into ph_phone values (ph_phone_seq.nextval, 'G3A', '/resources/images/phone/G3A_ȭ��Ʈ.png', 'LG����', '2014��08��');
insert into ph_phone values (ph_phone_seq.nextval, 'G3Cat6', '/resources/images/phone/G3Cat6_��ũȭ��Ʈ.png', 'LG����', '2014��08��');
insert into ph_phone values (ph_phone_seq.nextval, 'G3', '/resources/images/phone/G3_��ũȭ��Ʈ.png', 'LG����', '2014��05��');


create table ph_color( --�ڵ��� ����
	name varchar2(100) not null,
	color varchar2(30) not null,
	image LONG not null
);

--�Ｚ����
insert into ph_color values ('Galaxy S7 edge', 'ȭ��Ʈ��', '/resources/images/phone/GalaxyS7edge_ȭ��Ʈ��.png');
insert into ph_color values ('Galaxy S7 edge', '�����ڶ�', '/resources/images/phone/GalaxyS7edge_�����ڶ�.png');
insert into ph_color values ('Galaxy S7 edge', '�������н�', '/resources/images/phone/GalaxyS7edge_�������н�.png');
insert into ph_color values ('Galaxy S7 edge', '����÷�Ƽ��', '/resources/images/phone/GalaxyS7edge_����÷�Ƽ��.png');
insert into ph_color values ('Galaxy S7 edge', '�ǹ�ƼŸ��', '/resources/images/phone/GalaxyS7edge_�ǹ�ƼŸ��.png');
insert into ph_color values ('Galaxy S7 edge', '��ũ���', '/resources/images/phone/GalaxyS7edge_��ũ���.png');

insert into ph_color values ('Galaxy S7 edge Olympic Games Limited Edition', '����', '/resources/images/phone/GalaxyS7edgeOlympic_����.png');

insert into ph_color values ('Galaxy S7 edge Injustice Edition', '����', '/resources/images/phone/GalaxyS7edgeInjustice_����.png');

insert into ph_color values ('Galaxy S7', '�������н�', '/resources/images/phone/GalaxyS7_�������н�.png');
insert into ph_color values ('Galaxy S7', 'ȭ��Ʈ��', '/resources/images/phone/GalaxyS7_ȭ��Ʈ��.png');
insert into ph_color values ('Galaxy S7', '�ǹ�ƼŸ��', '/resources/images/phone/GalaxyS7_�ǹ�ƼŸ��.png');
insert into ph_color values ('Galaxy S7', '����÷�Ƽ��', '/resources/images/phone/GalaxyS7_����÷�Ƽ��.png');
insert into ph_color values ('Galaxy S7', '��ũ���', '/resources/images/phone/GalaxyS7_��ũ���.png');
insert into ph_color values ('Galaxy S7', '��ũ���μ�', '/resources/images/phone/GalaxyS7_��ũ���μ�.png');

insert into ph_color values ('Galaxy note5', '����÷�Ƽ��', '/resources/images/phone/Galaxynote5_����÷�Ƽ��.png');
insert into ph_color values ('Galaxy note5', '���������̾�', '/resources/images/phone/Galaxynote5_���������̾�.png');
insert into ph_color values ('Galaxy note5', '�ǹ�ƼŸ��', '/resources/images/phone/Galaxynote5_�ǹ�ƼŸ��.png');
insert into ph_color values ('Galaxy note5', 'ȭ��Ʈ��', '/resources/images/phone/Galaxynote5_ȭ��Ʈ��.png');
insert into ph_color values ('Galaxy note5', '��ũ���', '/resources/images/phone/Galaxynote5_��ũ���.png');

insert into ph_color values ('Galaxy S6 edge plus', '����÷�Ƽ��', '/resources/images/phone/GalaxyS6edgePlus_����÷�Ƽ��.png');
insert into ph_color values ('Galaxy S6 edge plus', '���������̾�', '/resources/images/phone/GalaxyS6edgePlus_���������̾�.png');

insert into ph_color values ('Galaxy S6 edge', '����÷�Ƽ��', '/resources/images/phone/GalaxyS6edge_����÷�Ƽ��.png');
insert into ph_color values ('Galaxy S6 edge', 'ȭ��Ʈ��', '/resources/images/phone/GalaxyS6edge_ȭ��Ʈ��.png');
insert into ph_color values ('Galaxy S6 edge', '���������̾�', '/resources/images/phone/GalaxyS6edge_���������̾�.png');
insert into ph_color values ('Galaxy S6 edge', '�׸����޶���', '/resources/images/phone/GalaxyS6edge_�׸����޶���.png');

insert into ph_color values ('Galaxy S6', 'ȭ��Ʈ��', '/resources/images/phone/GalaxyS6_ȭ��Ʈ��.png');
insert into ph_color values ('Galaxy S6', '���������̾�', '/resources/images/phone/GalaxyS6_���������̾�.png');
insert into ph_color values ('Galaxy S6', '����÷�Ƽ��', '/resources/images/phone/GalaxyS6_����÷�Ƽ��.png');
insert into ph_color values ('Galaxy S6', '��������̾�', '/resources/images/phone/GalaxyS6_��������̾�.png');

insert into ph_color values ('Galaxy A8(2016)', '�ǹ�', '/resources/images/phone/GalaxyA8(2016)_�ǹ�.png');
insert into ph_color values ('Galaxy A8(2016)', '��ũ���', '/resources/images/phone/GalaxyA8(2016)_��ũ���.png');
insert into ph_color values ('Galaxy A8(2016)', 'ȭ��Ʈ����', '/resources/images/phone/GalaxyA8(2016)_ȭ��Ʈ����.png');

insert into ph_color values ('Galaxy A3(2016)', '����', '/resources/images/phone/GalaxyA3(2016)_����.png');
insert into ph_color values ('Galaxy A3(2016)', 'ȭ��Ʈ', '/resources/images/phone/GalaxyA3(2016)_ȭ��Ʈ.png');
insert into ph_color values ('Galaxy A3(2016)', '������ũ', '/resources/images/phone/GalaxyA3(2016)_������ũ.png');

insert into ph_color values ('Galaxy A5(2016)', '����', '/resources/images/phone/GalaxyA5(2016)_����.png');
insert into ph_color values ('Galaxy A5(2016)', 'ȭ��Ʈ', '/resources/images/phone/GalaxyA5(2016)_ȭ��Ʈ.png');
insert into ph_color values ('Galaxy A5(2016)', '������ũ', '/resources/images/phone/GalaxyA5(2016)_������ũ.png');

insert into ph_color values ('Galaxy A7(2016)', '����', '/resources/images/phone/GalaxyA7(2016)_����.png');
insert into ph_color values ('Galaxy A7(2016)', 'ȭ��Ʈ', '/resources/images/phone/GalaxyA7(2016)_ȭ��Ʈ.png');
insert into ph_color values ('Galaxy A7(2016)', '������ũ', '/resources/images/phone/GalaxyA7(2016)_������ũ.png');

insert into ph_color values ('Galaxy J3(2016)', 'ȭ��Ʈ', '/resources/images/phone/GalaxyJ3(2016)_ȭ��Ʈ.png');

insert into ph_color values ('Galaxy J5(2016)', '����', '/resources/images/phone/GalaxyJ5(2016)_����.png');
insert into ph_color values ('Galaxy J5(2016)', 'ȭ��Ʈ', '/resources/images/phone/GalaxyJ5(2016)_ȭ��Ʈ.png');

insert into ph_color values ('Galaxy J7(2016)', '���', '/resources/images/phone/GalaxyJ7(2016)_���.png');
insert into ph_color values ('Galaxy J7(2016)', '����', '/resources/images/phone/GalaxyJ7(2016)_����.png');

insert into ph_color values ('Galaxy note edge', 'ȭ��Ʈ', '/resources/images/phone/GalaxynoteEdge_ȭ��Ʈ.png');
insert into ph_color values ('Galaxy note edge', '����', '/resources/images/phone/GalaxynoteEdge_����.png');

insert into ph_color values ('Galaxy note4 S-LTE', 'ȭ��Ʈ', '/resources/images/phone/Galaxynote4SLTE_ȭ��Ʈ.png');
insert into ph_color values ('Galaxy note4 S-LTE', '����', '/resources/images/phone/Galaxynote4SLTE_����.png');
insert into ph_color values ('Galaxy note4 S-LTE', '�ǹ�', '/resources/images/phone/Galaxynote4SLTE_�ǹ�.png');
insert into ph_color values ('Galaxy note4 S-LTE', '��ũ', '/resources/images/phone/Galaxynote4SLTE_��ũ.png');
insert into ph_color values ('Galaxy note4 S-LTE', '����', '/resources/images/phone/Galaxynote4SLTE_����.png');

insert into ph_color values ('Galaxy note4', 'ȭ��Ʈ', '/resources/images/phone/Galaxynote4_ȭ��Ʈ.png');
insert into ph_color values ('Galaxy note4', '����', '/resources/images/phone/Galaxynote4_����.png');
insert into ph_color values ('Galaxy note4', '���', '/resources/images/phone/Galaxynote4_���.png');
insert into ph_color values ('Galaxy note4', '��ũ', '/resources/images/phone/Galaxynote4_��ũ.png');
insert into ph_color values ('Galaxy note4', '����', '/resources/images/phone/Galaxynote4_����.png');

--����
insert into ph_color values ('iPhone 7', '������', '/resources/images/phone/iPhone7_�ε���.png');
insert into ph_color values ('iPhone 7', '���', '/resources/images/phone/iPhone7_���.png');
insert into ph_color values ('iPhone 7', '�ǹ�', '/resources/images/phone/iPhone7_�ǹ�.png');
insert into ph_color values ('iPhone 7', '����', '/resources/images/phone/iPhone7_����.png');
insert into ph_color values ('iPhone 7', '��Ʈ����', '/resources/images/phone/iPhone7_��Ʈ����.png');

insert into ph_color values ('iPhone 7 plus', '������', '/resources/images/phone/iPhone7Plus_������.png');
insert into ph_color values ('iPhone 7 plus', '���', '/resources/images/phone/iPhone7Plus_���.png');
insert into ph_color values ('iPhone 7 plus', '�ǹ�', '/resources/images/phone/iPhone7Plus_�ǹ�.png');
insert into ph_color values ('iPhone 7 plus', '����', '/resources/images/phone/iPhone7Plus_����.png');
insert into ph_color values ('iPhone 7 plus', '��Ʈ����', '/resources/images/phone/iPhone7Plus_��Ʈ����.png');

insert into ph_color values ('iPhone 6s', '�����̽��׷���', '/resources/images/phone/iPhone6s_�����̽��׷���.png');
insert into ph_color values ('iPhone 6s', '�ǹ�', '/resources/images/phone/iPhone6s_�ǹ�.png');
insert into ph_color values ('iPhone 6s', '���', '/resources/images/phone/iPhone6s_���.png');
insert into ph_color values ('iPhone 6s', '������', '/resources/images/phone/iPhone6s_������.png');

insert into ph_color values ('iPhone 6s Plus', '�����̽��׷���', '/resources/images/phone/iPhone6sPlus_�����̽��׷���.png');
insert into ph_color values ('iPhone 6s Plus', '�ǹ�', '/resources/images/phone/iPhone6sPlus_�ǹ�.png');
insert into ph_color values ('iPhone 6s Plus', '���', '/resources/images/phone/iPhone6sPlus_���.png');
insert into ph_color values ('iPhone 6s Plus', '������', '/resources/images/phone/iPhone6sPlus_������.png');

insert into ph_color values ('iPhone 6 Plus', '���', '/resources/images/phone/iPhone6Plus_���.png');
insert into ph_color values ('iPhone 6 Plus', '�����̽��׷���', '/resources/images/phone/iPhone6Plus_�����̽��׷���.png');
insert into ph_color values ('iPhone 6 Plus', '�ǹ�', '/resources/images/phone/iPhone6Plus_�ǹ�.png');

insert into ph_color values ('iPhoneSE', '�����̽��׷���', '/resources/images/phone/iPhoneSE_�����̽��׷���.png');
insert into ph_color values ('iPhoneSE', '������', '/resources/images/phone/iPhoneSE_������.png');

--LG����
insert into ph_color values ('V20', 'Ƽź', '/resources/images/phone/V20_Ƽź.png');
insert into ph_color values ('V20', '�ǹ�', '/resources/images/phone/V20_�ǹ�.png');
insert into ph_color values ('V20', '��ũ', '/resources/images/phone/V20_��ũ.png');

insert into ph_color values ('V10', '���� ȭ��Ʈ', '/resources/images/phone/V10_����ȭ��Ʈ.png');
insert into ph_color values ('V10', '��� ������', '/resources/images/phone/V10_���������.png');
insert into ph_color values ('V10', '���� ����', '/resources/images/phone/V10_���Ǻ���.png');

insert into ph_color values ('G5', 'Ƽź', '/resources/images/phone/G5_Ƽź.png');
insert into ph_color values ('G5', '�ǹ�', '/resources/images/phone/G5_�ǹ�.png');
insert into ph_color values ('G5', '��ũ', '/resources/images/phone/G5_��ũ.png');
insert into ph_color values ('G5', '���', '/resources/images/phone/G5_���.png');

insert into ph_color values ('G4', '�����ȭ��Ʈ', '/resources/images/phone/G4_�����ȭ��Ʈ.png');
insert into ph_color values ('G4', '��Ż���׷���', '/resources/images/phone/G4_��Ż���׷���.png');
insert into ph_color values ('G4', 'õ�����׺���', '/resources/images/phone/G4_õ�����׺���.png');
insert into ph_color values ('G4', 'õ�����׺���', '/resources/images/phone/G4_õ�����׺���.png');

insert into ph_color values ('GStylo', 'Ƽź', '/resources/images/phone/GStylo_Ƽź.png');
insert into ph_color values ('GStylo', 'ȭ��Ʈ', '/resources/images/phone/GStylo_ȭ��Ʈ.png');

insert into ph_color values ('GFlex2', '�÷�Ƽ�ѽǹ�', '/resources/images/phone/GFlex2_�÷�Ƽ�ѽǹ�.png');
insert into ph_color values ('GFlex2', '�ö�������', '/resources/images/phone/GFlex2_�ö�������.png');

insert into ph_color values ('G3Screen', 'ȭ��Ʈ', '/resources/images/phone/G3Screen_ȭ��Ʈ.png');
insert into ph_color values ('G3Screen', '����', '/resources/images/phone/G3Screen_����.png');

insert into ph_color values ('G3A', 'Ƽź', '/resources/images/phone/G3A_Ƽź.png');
insert into ph_color values ('G3A', 'ȭ��Ʈ', '/resources/images/phone/G3A_ȭ��Ʈ.png');

insert into ph_color values ('G3Cat6', '��Ż������', '/resources/images/phone/G3Cat6_��Ż������.png');
insert into ph_color values ('G3Cat6', '��ũȭ��Ʈ', '/resources/images/phone/G3Cat6_��ũȭ��Ʈ.png');
insert into ph_color values ('G3Cat6', '���ΰ��', '/resources/images/phone/G3Cat6_���ΰ��.png');
insert into ph_color values ('G3Cat6', '����', '/resources/images/phone/G3Cat6_����.png');
insert into ph_color values ('G3Cat6', '�����̿÷�', '/resources/images/phone/G3Cat6_�����̿÷�.png');

insert into ph_color values ('G3', '��Ż������', '/resources/images/phone/G3_��Ż������.png');
insert into ph_color values ('G3', '��ũȭ��Ʈ', '/resources/images/phone/G3_��ũȭ��Ʈ.png');
insert into ph_color values ('G3', '���ΰ��', '/resources/images/phone/G3_���ΰ��.png');


create table ph_capacity( --�ڵ��� �뷮
	name varchar2(100) not null,
	capacity varchar2(15) not null,
	release_price number not null --�����
);

--�Ｚ����
insert into ph_capacity values ('Galaxy S7 edge', '32GB', 924000);
insert into ph_capacity values ('Galaxy S7 edge', '64GB', 968000);
insert into ph_capacity values ('Galaxy S7 edge Olympic Games Limited Edition', '32GB', 1067000);
insert into ph_capacity values ('Galaxy S7 edge Injustice Edition', '32GB', 1199000);
insert into ph_capacity values ('Galaxy S7', '32GB', 836000);
insert into ph_capacity values ('Galaxy S7', '64GB', 880000);
insert into ph_capacity values ('Galaxy note5', '32GB', 899800);
insert into ph_capacity values ('Galaxy note5', '64GB', 965800);
insert into ph_capacity values ('Galaxy note5', '128GB', 999000);
insert into ph_capacity values ('Galaxy S6 edge plus', '32GB', 599500);
insert into ph_capacity values ('Galaxy S6 edge', '32GB', 735900);
insert into ph_capacity values ('Galaxy S6 edge', '64GB', 755700);
insert into ph_capacity values ('Galaxy S6', '32GB', 858000);
insert into ph_capacity values ('Galaxy S6', '64GB', 924000);
insert into ph_capacity values ('Galaxy A8(2016)', '32GB', 649000);
insert into ph_capacity values ('Galaxy A3(2016)', '16GB', 352000);
insert into ph_capacity values ('Galaxy A5(2016)', '16GB', 429000);
insert into ph_capacity values ('Galaxy A7(2016)', '16GB', 528000);
insert into ph_capacity values ('Galaxy J3(2016)', '8GB', 231000);
insert into ph_capacity values ('Galaxy J5(2016)', '16GB', 297000);
insert into ph_capacity values ('Galaxy J7(2016)', '16GB', 363000);
insert into ph_capacity values ('Galaxy note edge', '32GB', 1067000);
insert into ph_capacity values ('Galaxy note4 S-LTE', '32GB', 799700);
insert into ph_capacity values ('Galaxy note4', '32GB', 957000);

--����
insert into ph_capacity values ('iPhone 7', '32GB', 869000);
insert into ph_capacity values ('iPhone 7', '128GB', 999900);
insert into ph_capacity values ('iPhone 7', '256GB', 1130800);
insert into ph_capacity values ('iPhone 7 plus', '32GB', 1021900);
insert into ph_capacity values ('iPhone 7 plus', '128GB', 1152800);
insert into ph_capacity values ('iPhone 7 plus', '256GB', 1283700);
insert into ph_capacity values ('iPhone 6s', '16GB', 869000);
insert into ph_capacity values ('iPhone 6s', '64GB', 999900);
insert into ph_capacity values ('iPhone 6s', '128GB', 1130800);
insert into ph_capacity values ('iPhone 6s Plus', '16GB', 999900);
insert into ph_capacity values ('iPhone 6s Plus', '64GB', 1130800);
insert into ph_capacity values ('iPhone 6s Plus', '128GB', 1261700);
insert into ph_capacity values ('iPhone 6 Plus', '16GB', 899800);
insert into ph_capacity values ('iPhone 6 Plus', '64GB', 1050600);
insert into ph_capacity values ('iPhoneSE', '16GB', 569800);
insert into ph_capacity values ('iPhoneSE', '64GB', 699600);

--LG����
insert into ph_capacity values ('V20', '64GB', 899800);
insert into ph_capacity values ('V10', '64GB', 599500);
insert into ph_capacity values ('G5', '32GB', 699600);
insert into ph_capacity values ('G4', '32GB', 599500);
insert into ph_capacity values ('GStylo', '8GB', 517000);
insert into ph_capacity values ('GFlex2', '32GB', 899800);
insert into ph_capacity values ('G3Screen', '32GB', 550000);
insert into ph_capacity values ('G3A', '32GB', 451000);
insert into ph_capacity values ('G3Cat6', '32GB', 649000);
insert into ph_capacity values ('G3', '32GB', 499400);