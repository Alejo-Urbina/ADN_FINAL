create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table cliente (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 cedula varchar(20) not null,
 genero varchar(20) not null,
 fecha_nacimiento datetime null,
 primary key (id)
);