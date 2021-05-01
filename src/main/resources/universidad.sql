-- crear base de datos

show databases;

drop database if exists universidad;
create database universidad;
use universidad;

drop table if exists estudiante;
drop table if exists curso;
drop table if exists profesor;

-- tablas
create table estudiante(
	id int primary key,
    nombre varchar(30),
    apellido varchar(30),
    fecha_nacimiento DATE,
    total_creditos int check (total_creditos > 0)
);


create table curso(
    id int primary key,
	nombre varchar(20),
    creditos int,
    departamento VARCHAR(50)
);

create table profesor(
	id int primary key,
    nombre varchar(30),
    apellido varchar(30),
    ciudad varchar(30)
);

-- Insertar Estudiantes

insert into estudiante(id, nombre, apellido, fecha_nacimiento, total_creditos) values(0, "nombre-0", "apellido-0", '1976-09-23', 30);
insert into estudiante(id, nombre, apellido, fecha_nacimiento, total_creditos) values(1, "nombre-1", "apellido-1", '1980-11-29', 04);
insert into estudiante(id, nombre, apellido, fecha_nacimiento, total_creditos) values(2, "nombre-2", "apellido-2", '1980-11-29', 12);
insert into estudiante(id, nombre, apellido, fecha_nacimiento, total_creditos) values(3, "nombre-3", "apellido-3", '1984-12-21', 14);
insert into estudiante(id, nombre, apellido, fecha_nacimiento, total_creditos) values(4, "nombre-4", "apellido-4", '1993-10-20', 23);
insert into estudiante(id, nombre, apellido, fecha_nacimiento, total_creditos) values(5, "nombre-5", "apellido-5", '1980-01-22', 15);
insert into estudiante(id, nombre, apellido, fecha_nacimiento, total_creditos) values(6, "nombre-6", "apellido-6", '1987-03-24', 12);
insert into estudiante(id, nombre, apellido, fecha_nacimiento, total_creditos) values(7, "nombre-7", "apellido-7", '1979-06-27', 10);
insert into estudiante(id, nombre, apellido, fecha_nacimiento, total_creditos) values(8, "nombre-8", "apellido-8", '1989-07-26', 11);
insert into estudiante(id, nombre, apellido, fecha_nacimiento, total_creditos) values(9, "nombre-9", "apellido-9", '1990-08-21', 18);

-- Insertar Cursos

insert into curso(id, nombre, creditos, departamento) values(0, "curso-0", 1 ,'departamento-1');
insert into curso(id, nombre, creditos, departamento) values(1, "curso-1", 2 ,'departamento-2');
insert into curso(id, nombre, creditos, departamento) values(2, "curso-2", 3 ,'departamento-3');
insert into curso(id, nombre, creditos, departamento) values(3, "curso-3", 0 ,'departamento-4');
insert into curso(id, nombre, creditos, departamento) values(4, "curso-4", 3 ,'departamento-5');
insert into curso(id, nombre, creditos, departamento) values(5, "curso-5", 2 ,'departamento-6');
insert into curso(id, nombre, creditos, departamento) values(6, "curso-6", 0 ,'departamento-7');
insert into curso(id, nombre, creditos, departamento) values(7, "curso-7", 4 ,'departamento-8');
insert into curso(id, nombre, creditos, departamento) values(8, "curso-8", 2 ,'departamento-9');
insert into curso(id, nombre, creditos, departamento) values(9, "curso-9", 3 ,'departamento-0');

-- Insertar Profesor

insert into profesor(id, nombre, apellido, ciudad) values(0, "nombre-0", "apellido-0", "ciudad-0");
insert into profesor(id, nombre, apellido, ciudad) values(1, "nombre-1", "apellido-1", "ciudad-1");
insert into profesor(id, nombre, apellido, ciudad) values(2, "nombre-2", "apellido-2", "ciudad-2");
insert into profesor(id, nombre, apellido, ciudad) values(3, "nombre-3", "apellido-3", "ciudad-3");
insert into profesor(id, nombre, apellido, ciudad) values(4, "nombre-4", "apellido-4", "ciudad-4");
insert into profesor(id, nombre, apellido, ciudad) values(5, "nombre-5", "apellido-5", "ciudad-5");
insert into profesor(id, nombre, apellido, ciudad) values(6, "nombre-6", "apellido-6", "ciudad-6");
insert into profesor(id, nombre, apellido, ciudad) values(7, "nombre-7", "apellido-7", "ciudad-7");
insert into profesor(id, nombre, apellido, ciudad) values(8, "nombre-8", "apellido-8", "ciudad-8");
insert into profesor(id, nombre, apellido, ciudad) values(9, "nombre-9", "apellido-9", "ciudad-9");