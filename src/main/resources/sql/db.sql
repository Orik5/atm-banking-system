CREATE SCHEMA IF NOT EXISTS atm_banking_system;

USE atm_banking_system;
CREATE TABLE user (
 user_id int(5)  NOT NULL AUTO_INCREMENT primary key,
 user_name varchar (50),
 password varchar (50),
 balance decimal (50),
 mobile_phone varchar (50),
 surname varchar (50),
 middle_name  varchar (50)
);
USE atm_banking_system;
CREATE TABLE atm (
 atm_id int (5) NOT NULL AUTO_INCREMENT primary key,
 user_name varchar (50),
 balance decimal (50)
);
