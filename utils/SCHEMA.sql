drop table if exists business, shark, pitches, commenting;

create table business (
	businessId serial primary key,
	firstName varchar(20) not null,
	lastName varchar(20) not null,
	businessName varchar(20) not null,
	username varchar(20) unique not null,
	password varchar(30) not null, 
	role varchar(10) not null
);

create table shark (
	sharkId serial primary key,
	firstName varchar(20) not null,
	lastName varchar(20) not null,
	username varchar(20) unique not null,
	businessName varchar(20),
	password varchar(30) not null,
	role varchar(10) not null
);

create table pitches (
	pitchId serial primary key, 
	businessId int references business(businessId) on delete cascade,
	businessName varchar(20) not null,
	creationDate varchar(10) not null,
	pitch text not null, 
	amount decimal not null, 
	percentage decimal not null,
	status varchar(8) default null
);

create table commenting (
	commentId serial primary key,
	businessId int references business(businessId) on delete cascade,
	sharkId int references shark(sharkId) on delete cascade,
	commenting text,
	createDate varchar(10) not null
);