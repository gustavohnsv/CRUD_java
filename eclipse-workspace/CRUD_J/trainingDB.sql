drop database if exists trainingDB;
create database trainingDB;

use trainingDB;

create table userdata (
	id int auto_increment not null primary key,
	username varchar(45) not null,
    keyword varchar(45) not null
);

create table ownerData(
	id_Owner int auto_increment not null primary key,
	nameOwner varchar(45) not null,
    documentOwner varchar(19) not null
);

create table carDocumentation (
	id_Document int auto_increment not null primary key,
    RENAVAM varchar(12) not null,
    CRV varchar(13) not null,
    currentPlate varchar(8) not null,
    lastPlate varchar(12) not null,
    speciesCar varchar(25) not null,
    typeCar varchar(25) not null,
    carBrand varchar(45) not null,
    carModel varchar(45) not null,
    carColor varchar(45) not null,
    modelYear varchar(5) not null,
    ownerID int,
    foreign key (ownerID) references ownerData (id_Owner)
);

insert into userdata(username, keyword) values ('admin', '1234567890');

select * from ownerData;

# delete from userdata where id=?;

# MEXENDO DIRETAMENTE COM O CAMPO ID (MANIPULAR APENAS EM TESTE DE PROJETO).
# ALTER TABLE `trainingDB`.`userdata` DROP `id`; 
# ALTER TABLE `trainingDB`.`userdata` ADD `id` INT(255) NOT NULL AUTO_INCREMENT FIRST, ADD PRIMARY KEY (`id`);
#