create database rentcar;
use rentcar;

create table users (
user_id varchar(20) primary key,
`name` varchar(20) not null,
phone varchar(20) not null,
`password`varchar(20) not null,
sign_date date not null,
email varchar(20) not null
);

create table car (
car_code int(5) primary key,
car_name varchar(20) not null,
hour_price int(8) not null,
seat int(2) not null
);

alter table car add column image_url varchar(1000); 

create table board (
`code` int(5) primary key,
title varchar(100) not null,
main varchar(4000) not null,
modified_date date not null,
register_date date not null,
writer varchar(20) not null,
foreign key (writer) references users (user_id)
);

create table venue (
venue_code int(5) primary key,
venue_name varchar(20)
);

CREATE TABLE book (
  rent_car int(5) NOT NULL,
  rent_user varchar(20) NOT NULL,
  rent_day int(3) NOT NULL,
  rent_time int(20) NOT NULL,
  booking_day date NOT NULL,
  rent_venue int(5) NOT NULL,
  total_price int,
  PRIMARY KEY (rent_day, rent_car, rent_user),
  FOREIGN KEY (rent_car) REFERENCES car (car_code),
  FOREIGN KEY (rent_user) REFERENCES users (user_id),
  FOREIGN KEY (rent_venue) REFERENCES venue (venue_code)
);
