--DROP TABLE IF EXISTS evento;

CREATE TABLE IF NOT EXISTS evento (
     id serial PRIMARY KEY,
     nome  varchar(50),
     localizacao varchar(50),
     data varchar (50),
     horario varchar (50)
);

CREATE TABLE IF NOT EXISTS livro (
	id serial PRIMARY KEY,
	titulo varchar(60),
	autor varchar(60),
	status varchar (30)

);

CREATE TABLE IF NOT EXISTS filme (
	id serial PRIMARY KEY,
	titulo varchar(60),
	status varchar (30),
	streaming varchar (50)

);

CREATE TABLE IF NOT EXISTS serie (
	id serial PRIMARY KEY,
	titulo varchar(60),
	status varchar (30),
	streaming varchar (50),
	temporada varchar (20)

);