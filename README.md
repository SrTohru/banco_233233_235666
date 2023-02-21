# 
"Base de datos"

banco_233233_235666
create database banco; 

use banco;

CREATE TABLE Direcciones (
    id bigint primary key auto_increment,
    calle varchar(50) not null,
    colonia varchar(50) not null,
    numExterior varchar(20) not null
);


CREATE TABLE Clientes (
	id bigint primary key auto_increment,
    nombre varchar(50) not null,
    apellidoPaterno varchar(50) not null,
    apellidoMaterno varchar(50) not null,
    usuario varchar(50) not null,
    nip varchar(100) not null,
    fechaNacimiento date not null,
    edad int default (TIMESTAMPDIFF(YEAR, fechaNacimiento, CURDATE())),
    idDireccion bigint not null,
    foreign key (idDireccion) references direcciones(id) 
);

CREATE TABLE Cuentas (
	id bigint primary key auto_increment,
    estado enum("cancelada","activa","eliminada") not null,
    fechaApertura date default(now()) not null,
    saldo decimal (10,2) not null,
    idCliente bigint not null,
    foreign key (idCliente) references Clientes (id)
);

CREATE TABLE Transferencias (
	id bigint primary key auto_increment,
    tipo enum("Deposito","Retiro") not null,
    estado enum ("pendiente","cancelada","exitosa") not null,
    fecha datetime default(now()) not null,
    monto decimal (6,2) not null,
    idCuenta bigint not null,
    foreign key (idCuenta) references Cuentas (id)
);

CREATE TABLE Retiros (
	id bigint primary key auto_increment,
    estado enum ("pendiente","cancelada","exitosa") not null,
    fecha datetime default(now()) not null,
    monto decimal (6,2) not null,
    folio varchar(50) not null,
    contraseña varchar(100) not null,
    idCuenta bigint not null,
   foreign key (idCuenta) references Cuentas (id)
);
CREATE TABLE acciones (
  id INT NOT NULL AUTO_INCREMENT,
  accion VARCHAR(200) NULL,
  fecha DATETIME NULL DEFAULT current_timestamp,
  PRIMARY KEY (id)
);

#Trigger
DELIMITER //
CREATE TRIGGER log_clientes
after insert on clientes
for each row 
BEGIN
    insert into acciones (accion) values ("Se creo un registro en clientes");
END//
delimiter ;

#Procedimiento almacenado
DELIMITER //
CREATE PROCEDURE actualizar_cliente(
    IN nombre_Cliente VARCHAR(50),
    IN apellidoPaterno_Cliente VARCHAR(50),
    IN apellidoMaterno_Cliente VARCHAR(50),
    IN usuario_Cliente  VARCHAR(50),
    IN nip_Cliente  VARCHAR(100),
    IN fechaNacimiento_Cliente  VARCHAR(50)
)
BEGIN
    UPDATE clientes
    SET nombre = nombre_Cliente, 
        apellidoPaterno = apellidoPaterno_Cliente, 
        apellidoMaterno = apellidoMaterno_Cliente, 
        usuario = usuario_Cliente,
        nip = nip_Cliente,
        fechaNacimiento = fechaNacimiento_Cliente
    WHERE id = id_Cliente;
END //
DELIMITER ;
