use mascotas;
create table perros
(
    id_perro        INT NOT NULL AUTO_INCREMENT,
    nombre            varchar(20) not null,
    raza          varchar(25) not null,
    años           double not null,
    fecha_creacion    date        not null,
    fecha_eliminacion date,
    primary key (id_perro));

INSERT INTO perros
( nombre,
 raza,
 años,
 fecha_creacion)
VALUES ('Rex',
        'Pastor Aleman',
        '4',
        now());
