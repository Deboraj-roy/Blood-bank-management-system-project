--------------------------------------------------------
--  File created - Wednesday-August-24-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BLOODS
--------------------------------------------------------

  CREATE TABLE "ROOT"."BLOODS" 
   (	"DONOR_ID" VARCHAR2(45 BYTE), 
	"PLATELETCOUNT" NUMBER(*,0), 
	"HAEMOGLOBIN" FLOAT(126), 
	"LYMPHOCYTES" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into ROOT.BLOODS
SET DEFINE OFF;
Insert into ROOT.BLOODS (DONOR_ID,PLATELETCOUNT,HAEMOGLOBIN,LYMPHOCYTES) values ('Faruk',222,16,36);
Insert into ROOT.BLOODS (DONOR_ID,PLATELETCOUNT,HAEMOGLOBIN,LYMPHOCYTES) values ('Goutom',324,16,39);
Insert into ROOT.BLOODS (DONOR_ID,PLATELETCOUNT,HAEMOGLOBIN,LYMPHOCYTES) values ('Tutul',267,16,37);
Insert into ROOT.BLOODS (DONOR_ID,PLATELETCOUNT,HAEMOGLOBIN,LYMPHOCYTES) values ('Rakibul',233,16,33);
--------------------------------------------------------
--  DDL for Index BLOODS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ROOT"."BLOODS_PK" ON "ROOT"."BLOODS" ("DONOR_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table BLOODS
--------------------------------------------------------

  ALTER TABLE "ROOT"."BLOODS" MODIFY ("HAEMOGLOBIN" NOT NULL ENABLE);
  ALTER TABLE "ROOT"."BLOODS" MODIFY ("PLATELETCOUNT" NOT NULL ENABLE);
  ALTER TABLE "ROOT"."BLOODS" MODIFY ("DONOR_ID" NOT NULL ENABLE);
  ALTER TABLE "ROOT"."BLOODS" ADD CONSTRAINT "BLOODS_PK" PRIMARY KEY ("DONOR_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
