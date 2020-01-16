-- 요금제 테이플

-- SKT 테이블
drop table skt_pay;
create table skt_pay(
	payment 			varchar2(50) 	primary key,
	data 					varchar2(50),
	call					varchar2(70),
	sms					varchar2(50),
	fixed_month		number,
	fares_month		number,
	fares_24month		number,
	discount				number

);

-- KT 테이블
drop table kt_pay;
create table kt_pay(
	payment 			varchar2(50) 	primary key,
	data 					varchar2(50),
	call					varchar2(70),
	sms					varchar2(50),
	fixed_month		number,
	fares_month		number,
	fares_24month		number,
	discount				number

);

-- LG 테이블
drop table lg_pay;
create table lg_pay(
	payment 			varchar2(50) 	primary key,
	data 					varchar2(50),
	call					varchar2(70),
	sms					varchar2(50),
	fixed_month		number,
	fares_month		number,
	fares_24month		number,
	discount				number

);

select * from SKT_PAY;

select * from SKT_PAY
where payment like '%시그니처%'; 

--SKT 요금제 INSERT
INSERT INTO SKT_PAY VALUES('T 시그니처 Master', '35GB + 매일 2GB 이후 속도 제어', '집전화, 이동전화 무제한', '기본제공', 110000, 22000, 528000, 88000);
INSERT INTO SKT_PAY VALUES('T 시그니처 Classic', '20GB + 매일 2GB 이후 속도 제어', '집전화, 이동전화 무제한', '기본제공', 88000,	17600,	422400,	70400);
INSERT INTO SKT_PAY VALUES('band YF 퍼펙트', '12GB + 매일 2GB 이후 속도 제어', '집전화, 이동전화 무제한', '기본제공', 71000,	14200,	340800,	56800);
INSERT INTO SKT_PAY VALUES('band YF 7G', '7G', '집전화, 이동전화 무제한', '기본제공', 62000, 12400, 297600, 49600);
INSERT INTO SKT_PAY VALUES('band YF 3G', '3G', '집전화, 이동전화 무제한', '기본제공', 52000, 10400, 249600, 41600);
INSERT INTO SKT_PAY VALUES('band YF 1G', '1G', '집전화, 이동전화 무제한', '기본제공', 42000,	8400,	201600,	33600);
INSERT INTO SKT_PAY VALUES('band YF 세이브', '500MB', '집전화, 이동전화 무제한', '기본제공', 38000,	7600,	182400,	30400);
INSERT INTO SKT_PAY VALUES('band 데이터 퍼펙트S', '16GB + 매일 2GB 이후 속도 제어', '집전화, 이동전화 무제한', '기본제공', 75000, 15180, 364320, 59820);
INSERT INTO SKT_PAY VALUES('band 데이터 퍼펙트', '11GB + 매일 2GB 이후 속도 제어', '집전화, 이동전화 무제한', '기본제공', 65890, 13200, 316800, 52690);
INSERT INTO SKT_PAY VALUES('band 데이터 6.5G',	'6.5GB', '집전화, 이동전화 무제한', '기본제공', 56100, 11220, 269280, 44880);
INSERT INTO SKT_PAY VALUES('band 데이터 3.5G', '3.5GB', '집전화, 이동전화 무제한', '기본제공', 51700, 10340, 248160, 41360);
INSERT INTO SKT_PAY VALUES('band 데이터 2.2G', '2.3GB', '집전화, 이동전화 무제한', '기본제공', 46200,	9240,	221760,	36960);
INSERT INTO SKT_PAY VALUES('band 데이터 1.2G', '1.2GB', '집전화, 이동전화 무제한', '기본제공', 39600, 7920, 190080, 31680);
INSERT INTO SKT_PAY VALUES('band 데이터 save', '300MB', 'ㅍ무제한', '기본제공', 32890, 6600, 158400, 26290);
INSERT INTO SKT_PAY VALUES('전국민 무한 100', '16GB	+ 매일 2GB 이후 속도 제어', '집전화, 이동전화 무제한 부가 / 영상 300분', '기본제공', 83600, 16720, 401280, 66880);
INSERT INTO SKT_PAY VALUES('전국민 무한 85', '12GB	+ 매일 2GB 이후 속도 제어', '집전화, 이동전화 무제한 부가 / 영상 300분', '기본제공', 71500, 14300, 343200, 57200);
INSERT INTO SKT_PAY VALUES('LTE 데이터 무제한 80팩', '8GB	+ 매일 2GB 이후 속도 제어', '집전화, 이동전화 무제한 부가 / 영상 300분', '기본제공', 	67375, 12375, 297000, 55000);
INSERT INTO SKT_PAY VALUES('전국민 무한 75', '8GB', '집전화, 이동전화 무제한 부가 / 영상 300분', '기본제공', 61875, 12375 , 297000, 49500);
INSERT INTO SKT_PAY VALUES('전국민 무한 69', '5GB', '집전화, 이동전화 무제한 부가 / 영상 200분', '기본제공', 56650, 11330, 271920, 45320);
INSERT INTO SKT_PAY VALUES('T끼리 65', '5GB', 'SKT 고객간 무제한 그 외 280분' , '기본제공', 53075, 10615, 254760, 42460);
INSERT INTO SKT_PAY VALUES('T끼리 55', '2GB', 'SKT 고객간 무제한 그 외 180분', '기본제공', 44825, 8965, 215160, 35860);
INSERT INTO SKT_PAY VALUES('T끼리 45', '1.1GB', 'SKT 고객간 무제한 그 외 130분', '기본제공', 37125, 7425, 178200, 29700);
INSERT INTO SKT_PAY VALUES('T끼리 35', '550MB', 'SKT 고객간 무제한 그 외 80분', '기본제공', 30580, 6160, 147840, 24420);


select * from KT_PAY;

-- KT 요금제 테이블
INSERT INTO KT_PAY VALUES('데이터 일반', '300MB', '유무선기본제공', '기본제공', 32890, 6578, 157872, 26312);
INSERT INTO KT_PAY VALUES('데이터 1.3', '1.3GB', '유무선기본제공', '기본제공', 39490, 7898, 189552, 31592);
INSERT INTO KT_PAY VALUES('데이터 2.3', '2.3GB', '유무선기본제공', '기본제공', 46090, 9218, 221232, 36872);
INSERT INTO KT_PAY VALUES('데이터 3.6', '3.6GB', '유무선기본제공', '기본제공', 51590, 10318, 247632, 41272);
INSERT INTO KT_PAY VALUES('데이터 6.6', '6.6GB', '유무선기본제공', '기본제공', 55990, 11198, 268752, 44792);
INSERT INTO KT_PAY VALUES('데이터 스폐셜A', '11GB + 매일 2GB', '유무선기본제공', '기본제공', 65890, 13178, 316272, 52712);
INSERT INTO KT_PAY VALUES('데이터 스폐셜B', '11GB + 매일 2GB', '유무선기본제공', '기본제공', 74800, 14960, 359040, 59840);
INSERT INTO KT_PAY VALUES('데이터 스폐셜C', '20GB + 매일 2GB', '유무선기본제공', '기본제공', 88000, 17600, 422400, 70400);
INSERT INTO KT_PAY VALUES('데이터 스폐셜D', '35GB + 매일 2GB	', '유무선기본제공', '기본제공', 110000, 22000, 528000, 88000);
INSERT INTO KT_PAY VALUES('LTE 망내 34', '750MB', '망내 무제한 (그외 115분)', '기본제공', 37400, 5940, 142560, 31460);
INSERT INTO KT_PAY VALUES('LTE 망내 42', '1.4GB', '망내 무제한 (그외 148분)',  '기본제공', 46200, 6930, 166320, 39270);
INSERT INTO KT_PAY VALUES('LTE 망내 52', '2.1GB', '망내 무제한 (그외 205분)', '기본제공', 57200, 8470, 203280, 48730);
INSERT INTO KT_PAY VALUES('청소년 스폐셜', '750MB', '유무선기본제공', '기본제공', 32890, 6578, 157872, 26312);
INSERT INTO KT_PAY VALUES('LTE 시니어', '1G', '150분', '200건', 37400, 5940, 142560, 31460);
INSERT INTO KT_PAY VALUES('LTE 34', '750MB', '160분', '200건', 37400, 5940, 142560, 31460);
INSERT INTO KT_PAY VALUES('LTE 42', '1.5GB', '200분', '200건', 46200, 6930, 166320, 39270);
INSERT INTO KT_PAY VALUES('LTE 52', '2.6GB', '250분', '250', 57200, 8470, 203280, 48730);
INSERT INTO KT_PAY VALUES('LTE 62', '6GB', '350분', '350건', 68200, 9680, 232320, 58520);
INSERT INTO KT_PAY VALUES('LTE 72', '10GB', '500분', '450건', 79200, 11440, 274560, 67760);
INSERT INTO KT_PAY VALUES('LTE 85', '14GB', '750분', '650건', 93500, 13860, 332640, 79640);
INSERT INTO KT_PAY VALUES('LTE 100', '20GB', '1200분', '1000건', 110000, 16720, 401280, 93280);
INSERT INTO KT_PAY VALUES('LTE 120', '24GB', '1500분', '1000건', 132000, 21120, 506880, 110880);


select * from LG_PAY;

-- LG 요금제 테이블
INSERT INTO LG_PAY VALUES('순 완전무한99(LTE)', '25GB + 매일 2GB', '집 / 이동전화 무제한 (음성 / 부가 200분)', '기본제공', 108900, 21780, 522720, 87120);
INSERT INTO LG_PAY VALUES('순 완전무한77(LTE)	', '17GB + 매일 2GB', '집 / 이동전화 무제한 (음성 / 부가 200분)', '기본제공', 84700, 16940, 406560, 67760);
INSERT INTO LG_PAY VALUES('순 완전무한67(LTE)', '12GB + 매일 2GB', '집 / 이동전화 무제한 (음성 / 부가 200분)', '기본제공', 73700, 14740, 353760, 58960);
INSERT INTO LG_PAY VALUES('순 완전무한61(LTE)', '10GB + 매일 2GB', '집 / 이동전화 무제한 (음성 / 부가 200분)', '기본제공', 67100, 13420, 322080, 53680);
INSERT INTO LG_PAY VALUES('순 완전무한51(LTE)', '5GB + 매일 2GB', '집 / 이동전화 무제한 (음성 / 부가 200분)', '기본제공', 56100, 11220, 269280, 44880);
INSERT INTO LG_PAY VALUES('순 모두다올레41(LTE)', '2.5GB', 'KT 모바일끼리 무제한 + 망외 250분', '기본제공', 45100, 9020, 216480, 36080);
INSERT INTO LG_PAY VALUES('순 모두다올레34(LTE)', '1.5GB', 'KT 모바일끼리 무제한 + 망외 185분', '기본제공', 37400, 7480, 179520, 29920);
INSERT INTO LG_PAY VALUES('순 모두다올레28(LTE)', '750MB', 'KT 모바일끼리 무제한 + 망외 130분', '기본제공', 30800, 6160, 147840, 24640);
INSERT INTO LG_PAY VALUES('Y틴 38', '4700MB', '매일 10시간(45056알)', '200건/일', 38390, 7700, 184800, 30690);
INSERT INTO LG_PAY VALUES('Y틴 32', '3600MB', '매일 10시간(45056알)', '200건/일', 32890, 6600, 158400, 26290);
INSERT INTO LG_PAY VALUES('Y틴 27', '2000MB', '매일 10시간(45056알)', '200건/일', 27390, 5500, 132000, 21890);
INSERT INTO LG_PAY VALUES('Y틴 20', '1400MB', '매일 10시간(45056알)', '200건/일', 20900, 4180, 100320, 16720);
INSERT INTO LG_PAY VALUES('Y24 65.8', '10GB', '집 / 이동전화 무제한 (영상 / 부가 200분)', '기본제공', 65890, 13200, 316800, 52690);
INSERT INTO LG_PAY VALUES('Y24 54.8', '6GB', '집 / 이동전화 무제한 (영상 / 부가 30분)', '기본제공', 54890, 11000, 264000, 43890);
INSERT INTO LG_PAY VALUES('Y24 49.3', '3GB', '집 / 이동전화 무제한 (영상 / 부가 30분)', '기본제공', 49390, 9900, 237600, 39490);
INSERT INTO LG_PAY VALUES('Y24 43.8', '2GB', '집 / 이동전화 무제한 (영상 / 부가 30분)', '기본제공', 43890, 8800, 211200, 35090);
INSERT INTO LG_PAY VALUES('Y24 38.3', '1GB', '집 / 이동전화 무제한 (영상 / 부가 30분)', '기본제공', 38390, 7700, 184800, 30690);
INSERT INTO LG_PAY VALUES('Y24 32.8', '300MB', '집 / 이동전화 무제한 (영상 / 부가 30분)', '기본제공', 32890, 6600, 158400, 26290);
INSERT INTO LG_PAY VALUES('LTE-알520', '2.5GB', '62000알', '기본제공', 41800, 8360, 200640, 33440);
INSERT INTO LG_PAY VALUES('LTE-알420', '1.5GB', '52000알', '20000알', 34100, 6820, 163680, 27280);
INSERT INTO LG_PAY VALUES('LTE-알340', '750MB', '34000알', '20000알', 29700, 5940, 142560, 23760);
INSERT INTO LG_PAY VALUES('LTE-알240', '500MB', '28000알', '20000알', 25300, 5060, 121440, 20240);
INSERT INTO LG_PAY VALUES('LTE-알190', '300MB', '20000알', '20000알', 20900, 4180, 100320, 16720);





		select *
		from skt_pay
		where payment like '%시그니처%'
		order by fixed_month;
		
		select *
		from skt_pay
		where payment like 'T 시그니처 Master';









