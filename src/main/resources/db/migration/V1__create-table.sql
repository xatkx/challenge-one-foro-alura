
create table usuarios (
id Bigint not null auto_increment,
nombre varchar(256) not null unique,
email varchar(256) not null unique,
contrasena varchar(256) not null,
primary key(id));

create table cursos (
id Bigint not null auto_increment,
nombre varchar(256) not null unique,
category varchar(256) not null unique,
primary key(id));

create table topicos (
id Bigint not null auto_increment,
titulo varchar(256) not null unique,
mensaje varchar(256) not null unique,
fechaCreacion varchar(256) not null,
estatus varchar(256) not null,
autor bigint not null,
curso bigint not null,
primary key(id),
foreign key(autor) references usuarios(id),
foreign key(curso) references cursos(id)
);