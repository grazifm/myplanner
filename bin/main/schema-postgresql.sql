--DROP TABLE IF EXISTS evento;

CREATE TABLE IF NOT EXISTS evento (
     id serial PRIMARY KEY,
     nome  varchar(50),
     localizacao   varchar(50),
     data varchar (50),
     horario varchar (50)
);

