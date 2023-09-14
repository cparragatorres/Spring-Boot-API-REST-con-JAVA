

create table pacientes(
    id bigint not null auto_increment,
    nombre varchar(100) not null,
    email varchar(100) not null unique,
    telefono varchar(20) not null,
    documento_identidad varchar(14) not null unique,
    distrito varchar(100) not null,
    ciudad varchar(100) not null,
    numero varchar(20),
    complemento varchar(100),
    urbanizacion varchar(100) not null,
    codigo_postal varchar(9) not null,
    provincia varchar(100) not null,

    primary key(id)
);