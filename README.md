# CONTROL 2 - TBD
# CRUD para una tabla, utilizando servicios separados de front y back end.

# Nota:
# En el archivo DatabaseContext se deben actualizar las credenciales con su usuario y contraseña de pg Admin 4

# Para poder agregar datos de forma manual se provee el siguiente script:

create table film(
id serial, 
titulo varchar(50),
categoria varchar(50),
duracion integer
);

INSERT INTO film (titulo, categoria, duracion)
VALUES
('titulo1','categoria1',1000),
('titulo2','categoria2',2000),
('titulo3','categoria3',3000),
('titulo4','categoria4',4000),
('titulo5','categoria5',5000),
('titulo6','categoria6',6000);
