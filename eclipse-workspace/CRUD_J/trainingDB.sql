drop database if exists trainingDB;
create database trainingDB;

use trainingDB;

create table userdata (
	id int auto_increment not null primary key,
	username varchar(45) not null,
    keyword varchar(45) not null
);

create table cars (
	id int auto_increment not null primary key,
    carName varchar(45) not null,
    brandName varchar(45) not null,
    modelYear varchar(5) not null,
    carColor varchar(45) not null
);

insert into userdata(username, keyword) values ('admin', '1234567890');

select * from userdata;

# delete from userdata where id=?;

# MEXENDO DIRETAMENTE COM O CAMPO ID (MANIPULAR APENAS EM TESTE DE PROJETO).
#ALTER TABLE `trainingDB`.`userdata` DROP `id`; 
#ALTER TABLE `trainingDB`.`userdata` ADD `id` INT(255) NOT NULL AUTO_INCREMENT FIRST, ADD PRIMARY KEY (`id`);
#