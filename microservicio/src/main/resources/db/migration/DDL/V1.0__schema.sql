
create table cliente (
 id int(50) not null auto_increment,
 nombre varchar(100) not null,
 cedula varchar(20) not null,
 genero varchar(20) not null,
 precio_entrada float(5),
 fecha_nacimiento datetime not null,
 primary key (id)
);

create table voleto (
 id int(50) not null auto_increment,
 precio_entrada float(5),
 fecha_ingreso datetime,
 id_cliente varchar(8) not null,
 foreign key (id_cliente) REFERENCES cliente (id),
 primary key (id)
);