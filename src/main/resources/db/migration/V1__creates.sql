create table IF NOT EXISTS USERS (
    USER_ID                   bigint generated by default as identity,
    USER_NAME        varchar(255),
    USER_REAL_NAME       varchar(255),
    USER_PASSWORD          varchar(255),
    USER_TYPE_ID       numeric,
    USER_STATUS bool,
    PRIMARY KEY (USER_ID)
    );

CREATE TABLE IF NOT EXISTS USER_TYPE (
  USER_TYPE_ID bigint generated by default as identity,
  USER_TYPE_NAME varchar(128),
  PRIMARY KEY (USER_TYPE_ID)
);

CREATE TABLE IF NOT EXISTS PROPERTY (
  PROPERTY_ID bigint generated by default as identity,
  PROPERTY_ADDRESS  VARCHAR(255),
  PROPERTY_PRICE  float4,
  USER_ID numeric,
  PROPERTY_STATUS_ID NUMERIC,
  PROPERTY_OWNER_NAME VARCHAR(255),
  PROPERTY_OWNER_EMAIL VARCHAR(255),
  PROPERTY_OWNER_TEL VARCHAR(255),
  IS_FINANCED boolean,
  IS_OWNER_NAMED boolean,
  IS_NEGOTIABLE boolean,
  CREATED_AT timestamptz(0),
  UPDATED_AT timestamptz(0),
  USER_EDITED_ID numeric,
  PICTURE_1_X64 text,
  PICTURE_2_X64 text,
  PICTURE_3_X64 text,
  PICTURE_4_X64 text,
  PICTURE_5_X64 text,
  PRIMARY KEY (PROPERTY_ID)
);

CREATE TABLE IF NOT EXISTS PROPERTY_STATUS (
  PROPERTY_STATUS_ID bigint generated by default as identity,
  PROPERTY_STATUS_NAME VARCHAR(255),
  PRIMARY KEY (PROPERTY_STATUS_ID)
);

insert into USER_TYPE (USER_TYPE_ID, USER_TYPE_NAME) values (1,'User');
insert into USER_TYPE (USER_TYPE_ID, USER_TYPE_NAME) values (2,'Owner');

insert into PROPERTY_STATUS (PROPERTY_STATUS_ID, PROPERTY_STATUS_NAME) values (1,'Livre');
insert into PROPERTY_STATUS (PROPERTY_STATUS_ID, PROPERTY_STATUS_NAME) values (2,'Alugado');
insert into PROPERTY_STATUS (PROPERTY_STATUS_ID, PROPERTY_STATUS_NAME) values (3,'Vendido');

