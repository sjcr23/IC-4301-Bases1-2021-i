--  Creación del Esquema de la Tabla:
--      Se elimina si ya existe y se crea si no existe.
--      Se utiliza los caracteres UTF-8

DROP schema IF EXISTS movies;

CREATE schema IF NOT EXISTS movies default CHARACTER SET utf8;
USE movies;

--  Creación de las Tablas:

DROP TABLE IF EXISTS Categories;
CREATE TABLE IF NOT EXISTS Categories(
	ctgr_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ctgr_name VARCHAR(100) NOT NULL
);
CREATE UNIQUE INDEX name_idx ON Categories(ctgr_name ASC);


DROP TABLE IF EXISTS Movies;
CREATE TABLE IF NOT EXISTS Movies(
	mv_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    mv_title VARCHAR(100) NOT NULL,
    mv_release_date DATETIME,
    mv_ctgr_id INT NOT NULL,
   
    CONSTRAINT fk_id FOREIGN KEY(mv_ctgr_id) REFERENCES Categories(ctgr_id)
);
CREATE UNIQUE INDEX title_idx on Movies(mv_title asc);


DROP TABLE IF EXISTS Users;
CREATE TABLE IF NOT EXISTS Users(
	usr_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    usr_user_name VARCHAR(100) NOT NULL,
    usr_f_name VARCHAR(100),
    usr_l_name VARCHAR(100)
);
ALTER TABLE Users ADD fulltext(usr_f_name);
ALTER TABLE Users ADD fulltext(usr_l_name);


DROP TABLE IF EXISTS Ratings;
CREATE TABLE IF NOT EXISTS Ratings(
	rt_mv_id INT NOT NULL,
    rt_score INT NOT NULL,
    rt_review VARCHAR(200),
    rt_usr_id INT NOT NULL,
    CONSTRAINT fk_mv_id  FOREIGN KEY(rt_mv_id)  references Movies(mv_id),
	CONSTRAINT fk_usr_id FOREIGN KEY(rt_usr_id) references Users(usr_id)
);
CREATE UNIQUE INDEX movie_idx ON Ratings (rt_mv_id asc);
CREATE UNIQUE INDEX user_idx  ON Ratings (rt_usr_id asc);

--  Inserciones en las Tablas:
INSERT INTO Categories(ctgr_name) VALUES ('Comedia');
INSERT INTO Categories(ctgr_name) VALUES ('Accion');
INSERT INTO Categories(ctgr_name) VALUES ('Drama');
INSERT INTO Categories(ctgr_name) VALUES ('Suspenso');
INSERT INTO Categories(ctgr_name) VALUES ('Terror');

INSERT INTO Users(usr_user_name, usr_f_name, usr_l_name) VALUES ('sjcr_23','Josue','Castro');
INSERT INTO Users(usr_user_name, usr_f_name, usr_l_name) VALUES ('sjcr_23','Josue','Castro');
INSERT INTO Users(usr_user_name, usr_f_name, usr_l_name) VALUES ('sjcr_23','Josue','Castro');
INSERT INTO Users(usr_user_name, usr_f_name, usr_l_name) VALUES ('sjcr_23','Josue','Castro');
INSERT INTO Users(usr_user_name, usr_f_name, usr_l_name) VALUES ('sjcr_23','Josue','Castro');

INSERT INTO Movies(mv_title, mv_release_date, mv_ctgr_id) VALUES ('Los 3 Chiflados','2001-01-01',1);
INSERT INTO Movies(mv_title, mv_release_date, mv_ctgr_id) VALUES ('Star Wars IV','2002-02-02',2);
INSERT INTO Movies(mv_title, mv_release_date, mv_ctgr_id) VALUES ('Titanic','2003-03-03',3);
INSERT INTO Movies(mv_title, mv_release_date, mv_ctgr_id) VALUES ('Búsqueda Implacable','2004-04-04',4);
INSERT INTO Movies(mv_title, mv_release_date, mv_ctgr_id) VALUES ('MA1103: Cálculo y Álgebra Lineal','2005-05-05',5);

INSERT INTO Ratings(rt_mv_id, rt_usr_id, rt_score, rt_review) VALUES (1,1,1,'XD');
INSERT INTO Ratings(rt_mv_id, rt_usr_id, rt_score, rt_review) VALUES (2,2,2,'Ta buena');
INSERT INTO Ratings(rt_mv_id, rt_usr_id, rt_score, rt_review) VALUES (3,3,3,'Mucho texto');
INSERT INTO Ratings(rt_mv_id, rt_usr_id, rt_score, rt_review) VALUES (4,4,4,'¿Sherlock Holmes X Rambo?');
INSERT INTO Ratings(rt_mv_id, rt_usr_id, rt_score, rt_review) VALUES (5,5,5,'aiuda :c');


--  Consultas de las Tablas:
SELECT * FROM Categories;
SELECT * FROM Users;
SELECT * FROM Movies;
SELECT * FROM Ratings;
