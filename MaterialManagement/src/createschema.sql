create database IF NOT EXISTS material_records_db;
use material_records_db;

CREATE TABLE IF NOT EXISTS admins(
	id  int(11) NOT NULL  auto_increment PRIMARY KEY,
	username varchar(50),
	password varchar(50)
);

select * from admins;
INSERT INTO admins values(1,'karoms','karoms123');

CREATE TABLE IF NOT EXISTS MUsers(
	id  int(11) NOT NULL  auto_increment PRIMARY KEY,
	username varchar(50),
	password varchar(50),
	VoucherPermissionModify TinyInt(1) DEFAULT 1 NOT NULL,
	VoucherPermissionDelete TinyInt(1) DEFAULT 1 NOT NULL,
	AdministrationPref TinyInt(1) DEFAULT 1 NOT NULL,
	TranasctionPref TinyInt(1) DEFAULT 1 NOT NULL,
	DisplayPref TinyInt(1) DEFAULT 1 NOT NULL
);

CREATE TABLE IF NOT EXISTS AccountGroup(
id  int(11) NOT NULL  auto_increment PRIMARY KEY,
	GName varchar(50),
	GType varchar(2)
);

CREATE TABLE IF NOT EXISTS Account(
id  int(11) NOT NULL  auto_increment PRIMARY KEY,
	AName varchar(100),
	Address varchar(1000),
	GId int(11),
	OpenBalance int(100),
	phone varchar(20),
	FOREIGN KEY (GId) REFERENCES AccountGroup(id)
);

CREATE TABLE IF NOT EXISTS ItemGroup(
id  int(11) NOT NULL  auto_increment PRIMARY KEY,
	IGName varchar(100)
	);
	
CREATE TABLE IF NOT EXISTS Item(
id  int(11) NOT NULL  auto_increment PRIMARY KEY,
	IName varchar(100),
	IGid int(11),
	UnitsType varchar(50),
	OpeningStock double(10,3),
	ItemDesc varchar(200),
	FOREIGN KEY (IGId) REFERENCES ItemGroup(id)
	);

	
CREATE TABLE IF NOT EXISTS MaterialCentre(
	id  int(11) NOT NULL  auto_increment PRIMARY KEY,
	Name varchar(100),
	Address varchar(1000),
	Stock_Account varchar(200),
	transfered varchar(1)
	);

CREATE TABLE IF NOT EXISTS MUnits(
	id  int(11) NOT NULL  auto_increment PRIMARY KEY,
	Name varchar(100),
	Comments varchar(1000)
	);
