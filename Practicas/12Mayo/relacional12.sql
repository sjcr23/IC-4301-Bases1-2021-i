-- crear base de datos
drop database if exists movies;
create database movies;
use movies;

-- tablas
create table Movie(
	id int primary key,
    title varchar(30),
    release_date VARCHAR(30),
    category_id int,

    CONSTRAINT FK_llave_tipo FOREIGN KEY (category_id) REFERENCES Category(id)
);

create table Category(
    id int primary key,
	company_name varchar(20),
);

create table Rating(
	movie_id int primary key,
    r_value varchar(30),
    review varchar(30),
    u_id int (30),

    CONSTRAINT FK_movie_id FOREIGN KEY (movie_id) REFERENCES Movie(id),
    CONSTRAINT FK_user_id FOREIGN KEY (u_id) REFERENCES User(id)
);

create table User(
	id int primary key,
    username varchar(30),
    first_name varchar(30),
    last_name varchar(30)
);