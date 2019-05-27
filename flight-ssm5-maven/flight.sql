--------------------------------------------------------
--  文件已创建 - 星期日-十二月-09-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SE_BOOKTICKETINFO
--------------------------------------------------------

   CREATE SEQUENCE  "FLIGHT"."SE_BOOKTICKETINFO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 121 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SE_CARBINLEVELINFO
--------------------------------------------------------

   CREATE SEQUENCE  "FLIGHT"."SE_CARBINLEVELINFO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SE_CUSTOMERINFO
--------------------------------------------------------

   CREATE SEQUENCE  "FLIGHT"."SE_CUSTOMERINFO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SE_CUSTOMERTYPEINFO
--------------------------------------------------------

   CREATE SEQUENCE  "FLIGHT"."SE_CUSTOMERTYPEINFO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SE_FLIGHTCARBININFO
--------------------------------------------------------

   CREATE SEQUENCE  "FLIGHT"."SE_FLIGHTCARBININFO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SE_FLIGHTINFO
--------------------------------------------------------

   CREATE SEQUENCE  "FLIGHT"."SE_FLIGHTINFO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SE_PLANEINFO
--------------------------------------------------------

   CREATE SEQUENCE  "FLIGHT"."SE_PLANEINFO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SE_ROUTEINFO
--------------------------------------------------------

   CREATE SEQUENCE  "FLIGHT"."SE_ROUTEINFO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence SE_USERINFO
--------------------------------------------------------

   CREATE SEQUENCE  "FLIGHT"."SE_USERINFO"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table BOOKTICKETINFO
--------------------------------------------------------

  CREATE TABLE "FLIGHT"."BOOKTICKETINFO" 
   (	"ID" NUMBER(10,0), 
	"BTNO" VARCHAR2(200 BYTE), 
	"BOOKDATE" DATE, 
	"PAYSTATE" NUMBER(1,0), 
	"FCID" NUMBER(10,0), 
	"CID" NUMBER(10,0), 
	"PRICE" NUMBER(10,1)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CARBINLEVELINFO
--------------------------------------------------------

  CREATE TABLE "FLIGHT"."CARBINLEVELINFO" 
   (	"ID" NUMBER(10,0), 
	"NAME" VARCHAR2(20 BYTE), 
	"SERVICE" VARCHAR2(200 BYTE), 
	"REMARKS" VARCHAR2(200 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table CUSTOMERINFO
--------------------------------------------------------

  CREATE TABLE "FLIGHT"."CUSTOMERINFO" 
   (	"ID" NUMBER(10,0), 
	"NAME" VARCHAR2(20 BYTE), 
	"CARDNO" VARCHAR2(100 BYTE), 
	"PHONE" VARCHAR2(100 BYTE), 
	"EMAIL" VARCHAR2(100 BYTE), 
	"ADDRESS" VARCHAR2(200 BYTE), 
	"CTID" NUMBER(10,0), 
	"VIP" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table FLIGHTCARBININFO
--------------------------------------------------------

  CREATE TABLE "FLIGHT"."FLIGHTCARBININFO" 
   (	"FID" NUMBER(10,0), 
	"CLID" NUMBER(10,0), 
	"SEATS" NUMBER(5,0), 
	"PRICE" NUMBER(10,1), 
	"ID" NUMBER(10,0), 
	"VERSION" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table FLIGHTINFO
--------------------------------------------------------

  CREATE TABLE "FLIGHT"."FLIGHTINFO" 
   (	"ID" NUMBER(10,0), 
	"FNO" VARCHAR2(20 BYTE), 
	"FROMDATE" DATE, 
	"TODATE" DATE, 
	"ROUTEID" NUMBER(10,0), 
	"PLANEID" NUMBER(10,0), 
	"TYPE" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PLANEINFO
--------------------------------------------------------

  CREATE TABLE "FLIGHT"."PLANEINFO" 
   (	"ID" NUMBER(10,0), 
	"TYPE" VARCHAR2(100 BYTE), 
	"BUYDATE" DATE, 
	"SERVICEDATE" DATE, 
	"PLANENO" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table ROUTEINFO
--------------------------------------------------------

  CREATE TABLE "FLIGHT"."ROUTEINFO" 
   (	"ID" NUMBER(10,0), 
	"FROMCITY" VARCHAR2(100 BYTE), 
	"TOCITY" VARCHAR2(100 BYTE), 
	"REMARKS" VARCHAR2(200 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table USERINFO
--------------------------------------------------------

  CREATE TABLE "FLIGHT"."USERINFO" 
   (	"ID" NUMBER(10,0), 
	"USERNAME" VARCHAR2(100 BYTE), 
	"PASSWORD" VARCHAR2(100 BYTE), 
	"ROLE" NUMBER(2,0), 
	"PHONE" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into FLIGHT.BOOKTICKETINFO
SET DEFINE OFF;
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (1,'DD1544256828143',to_date('08-12月-18','DD-MON-RR'),0,9,4,3000);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (2,'DD1544257054576',to_date('08-12月-18','DD-MON-RR'),0,7,4,200);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (3,'DD1544257054643',to_date('08-12月-18','DD-MON-RR'),0,8,5,100);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (4,'DD1544257054693',to_date('08-12月-18','DD-MON-RR'),0,8,6,500);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (15,'DD1544268874915',to_date('08-12月-18','DD-MON-RR'),0,7,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (17,'DD1544268874967',to_date('08-12月-18','DD-MON-RR'),0,8,5,800);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (19,'DD1544268874999',to_date('08-12月-18','DD-MON-RR'),0,9,6,700);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (21,'DD1544268875057',to_date('08-12月-18','DD-MON-RR'),0,9,8,1000);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (23,'DD1544268976898',to_date('08-12月-18','DD-MON-RR'),0,8,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (25,'DD1544268976931',to_date('08-12月-18','DD-MON-RR'),0,9,5,800);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (27,'DD1544268976959',to_date('08-12月-18','DD-MON-RR'),0,7,6,700);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (29,'DD1544268976997',to_date('08-12月-18','DD-MON-RR'),0,8,8,1000);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (31,'DD1544269081304',to_date('08-12月-18','DD-MON-RR'),0,7,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (33,'DD1544269081346',to_date('08-12月-18','DD-MON-RR'),0,8,5,800);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (35,'DD1544269081380',to_date('08-12月-18','DD-MON-RR'),0,9,6,700);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (37,'DD1544269081422',to_date('08-12月-18','DD-MON-RR'),0,7,8,1000);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (39,'DD1544269272345',to_date('08-12月-18','DD-MON-RR'),0,8,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (41,'DD1544269295803',to_date('08-12月-18','DD-MON-RR'),0,9,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (43,'DD1544269371787',to_date('08-12月-18','DD-MON-RR'),0,7,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (45,'DD1544269515502',to_date('08-12月-18','DD-MON-RR'),0,8,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (47,'DD1544269533067',to_date('08-12月-18','DD-MON-RR'),0,9,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (49,'DD1544269571749',to_date('08-12月-18','DD-MON-RR'),0,7,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (51,'DD1544269653963',to_date('08-12月-18','DD-MON-RR'),0,8,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (53,'DD1544269717661',to_date('08-12月-18','DD-MON-RR'),0,9,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (55,'DD1544269728591',to_date('08-12月-18','DD-MON-RR'),0,7,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (57,'DD1544269741046',to_date('08-12月-18','DD-MON-RR'),0,8,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (59,'DD1544269766792',to_date('08-12月-18','DD-MON-RR'),0,9,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (61,'DD1544269783451',to_date('08-12月-18','DD-MON-RR'),0,8,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (63,'DD1544269793961',to_date('08-12月-18','DD-MON-RR'),0,9,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (65,'DD1544269817586',to_date('08-12月-18','DD-MON-RR'),0,7,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (67,'DD1544269824026',to_date('08-12月-18','DD-MON-RR'),0,8,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (69,'DD1544269851420',to_date('08-12月-18','DD-MON-RR'),0,7,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (71,'DD1544269865736',to_date('08-12月-18','DD-MON-RR'),0,9,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (73,'DD1544269882265',to_date('08-12月-18','DD-MON-RR'),0,8,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (75,'DD1544269911540',to_date('08-12月-18','DD-MON-RR'),0,7,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (77,'DD1544269920032',to_date('08-12月-18','DD-MON-RR'),0,8,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (79,'DD1544269938635',to_date('08-12月-18','DD-MON-RR'),0,9,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (81,'DD1544269960086',to_date('08-12月-18','DD-MON-RR'),0,7,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (83,'DD1544270021833',to_date('08-12月-18','DD-MON-RR'),0,8,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (85,'DD1544270021876',to_date('08-12月-18','DD-MON-RR'),0,7,5,800);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (87,'DD1544270021915',to_date('08-12月-18','DD-MON-RR'),0,9,6,700);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (89,'DD1544270449236',to_date('08-12月-18','DD-MON-RR'),0,8,4,600);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (91,'DD1544288785806',to_date('09-12月-18','DD-MON-RR'),0,7,4,300);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (93,'DD1544288785932',to_date('09-12月-18','DD-MON-RR'),0,8,5,400);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (95,'DD1544288786005',to_date('09-12月-18','DD-MON-RR'),0,8,6,350);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (97,'DD1544288908019',to_date('09-12月-18','DD-MON-RR'),0,9,4,300);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (99,'DD1544288908051',to_date('09-12月-18','DD-MON-RR'),0,7,5,400);
Insert into FLIGHT.BOOKTICKETINFO (ID,BTNO,BOOKDATE,PAYSTATE,FCID,CID,PRICE) values (101,'DD1544288908091',to_date('09-12月-18','DD-MON-RR'),0,8,6,350);
REM INSERTING into FLIGHT.CARBINLEVELINFO
SET DEFINE OFF;
Insert into FLIGHT.CARBINLEVELINFO (ID,NAME,SERVICE,REMARKS) values (1,'头等舱','配备美女一枚',null);
Insert into FLIGHT.CARBINLEVELINFO (ID,NAME,SERVICE,REMARKS) values (2,'商务舱','配备电脑一台',null);
Insert into FLIGHT.CARBINLEVELINFO (ID,NAME,SERVICE,REMARKS) values (3,'经济舱','啥都木有',null);
REM INSERTING into FLIGHT.CUSTOMERINFO
SET DEFINE OFF;
Insert into FLIGHT.CUSTOMERINFO (ID,NAME,CARDNO,PHONE,EMAIL,ADDRESS,CTID,VIP) values (4,'张三','111111','13888888888','aaa@163.com','是打发士大夫皇太极体育局天宇天宇天宇天宇体育教兔兔',null,'钻石');
Insert into FLIGHT.CUSTOMERINFO (ID,NAME,CARDNO,PHONE,EMAIL,ADDRESS,CTID,VIP) values (5,'李四','222222','13777777777','aaa@163.com','挺好记同意同意',null,'黄金');
Insert into FLIGHT.CUSTOMERINFO (ID,NAME,CARDNO,PHONE,EMAIL,ADDRESS,CTID,VIP) values (6,'赵六','333333','13666666666','aaa@163.com','更健康就好',null,'白金');
Insert into FLIGHT.CUSTOMERINFO (ID,NAME,CARDNO,PHONE,EMAIL,ADDRESS,CTID,VIP) values (8,'赵六','444444','13999999999','aaa@163.com','骨语语语',null,'普通');
REM INSERTING into FLIGHT.FLIGHTCARBININFO
SET DEFINE OFF;
Insert into FLIGHT.FLIGHTCARBININFO (FID,CLID,SEATS,PRICE,ID,VERSION) values (3,2,62,1000,9,27);
Insert into FLIGHT.FLIGHTCARBININFO (FID,CLID,SEATS,PRICE,ID,VERSION) values (41,3,111,111,38,0);
Insert into FLIGHT.FLIGHTCARBININFO (FID,CLID,SEATS,PRICE,ID,VERSION) values (41,2,0,0,39,0);
Insert into FLIGHT.FLIGHTCARBININFO (FID,CLID,SEATS,PRICE,ID,VERSION) values (41,1,0,0,40,0);
Insert into FLIGHT.FLIGHTCARBININFO (FID,CLID,SEATS,PRICE,ID,VERSION) values (38,3,111,111,33,0);
Insert into FLIGHT.FLIGHTCARBININFO (FID,CLID,SEATS,PRICE,ID,VERSION) values (38,2,0,0,34,0);
Insert into FLIGHT.FLIGHTCARBININFO (FID,CLID,SEATS,PRICE,ID,VERSION) values (3,1,0,2000,7,1);
Insert into FLIGHT.FLIGHTCARBININFO (FID,CLID,SEATS,PRICE,ID,VERSION) values (3,3,291,500,8,3);
Insert into FLIGHT.FLIGHTCARBININFO (FID,CLID,SEATS,PRICE,ID,VERSION) values (38,1,0,0,35,0);
REM INSERTING into FLIGHT.FLIGHTINFO
SET DEFINE OFF;
Insert into FLIGHT.FLIGHTINFO (ID,FNO,FROMDATE,TODATE,ROUTEID,PLANEID,TYPE) values (41,'AA222',to_date('14-12月-18','DD-MON-RR'),to_date('15-12月-18','DD-MON-RR'),1,2,'单程');
Insert into FLIGHT.FLIGHTINFO (ID,FNO,FROMDATE,TODATE,ROUTEID,PLANEID,TYPE) values (38,'BB333',to_date('22-12月-18','DD-MON-RR'),to_date('28-12月-18','DD-MON-RR'),1,2,'单程');
Insert into FLIGHT.FLIGHTINFO (ID,FNO,FROMDATE,TODATE,ROUTEID,PLANEID,TYPE) values (3,'CC111',to_date('06-12月-18','DD-MON-RR'),to_date('07-12月-18','DD-MON-RR'),3,3,'单程');
REM INSERTING into FLIGHT.PLANEINFO
SET DEFINE OFF;
Insert into FLIGHT.PLANEINFO (ID,TYPE,BUYDATE,SERVICEDATE,PLANENO) values (1,'波音777',to_date('10-12月-19','DD-MON-RR'),to_date('04-12月-19','DD-MON-RR'),'PL001');
Insert into FLIGHT.PLANEINFO (ID,TYPE,BUYDATE,SERVICEDATE,PLANENO) values (2,'波音737',to_date('03-12月-18','DD-MON-RR'),to_date('04-12月-18','DD-MON-RR'),'PL002');
Insert into FLIGHT.PLANEINFO (ID,TYPE,BUYDATE,SERVICEDATE,PLANENO) values (3,'空客666',to_date('04-12月-19','DD-MON-RR'),to_date('20-12月-19','DD-MON-RR'),'PL003');
Insert into FLIGHT.PLANEINFO (ID,TYPE,BUYDATE,SERVICEDATE,PLANENO) values (4,'空客333',to_date('01-12月-17','DD-MON-RR'),to_date('04-12月-18','DD-MON-RR'),'PL004');
REM INSERTING into FLIGHT.ROUTEINFO
SET DEFINE OFF;
Insert into FLIGHT.ROUTEINFO (ID,FROMCITY,TOCITY,REMARKS) values (1,'南京','东京',null);
Insert into FLIGHT.ROUTEINFO (ID,FROMCITY,TOCITY,REMARKS) values (2,'北京','巴黎',null);
Insert into FLIGHT.ROUTEINFO (ID,FROMCITY,TOCITY,REMARKS) values (3,'上海','伦敦',null);
REM INSERTING into FLIGHT.USERINFO
SET DEFINE OFF;
Insert into FLIGHT.USERINFO (ID,USERNAME,PASSWORD,ROLE,PHONE) values (0,'admin','123456',0,'13888888888');
--------------------------------------------------------
--  Constraints for Table USERINFO
--------------------------------------------------------

  ALTER TABLE "FLIGHT"."USERINFO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ROUTEINFO
--------------------------------------------------------

  ALTER TABLE "FLIGHT"."ROUTEINFO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table FLIGHTINFO
--------------------------------------------------------

  ALTER TABLE "FLIGHT"."FLIGHTINFO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table FLIGHTCARBININFO
--------------------------------------------------------

  ALTER TABLE "FLIGHT"."FLIGHTCARBININFO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PLANEINFO
--------------------------------------------------------

  ALTER TABLE "FLIGHT"."PLANEINFO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CUSTOMERINFO
--------------------------------------------------------

  ALTER TABLE "FLIGHT"."CUSTOMERINFO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table CARBINLEVELINFO
--------------------------------------------------------

  ALTER TABLE "FLIGHT"."CARBINLEVELINFO" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
