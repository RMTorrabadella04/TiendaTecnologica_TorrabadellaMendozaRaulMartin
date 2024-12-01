CREATE DATABASE tiendaonline;

USE tiendaonline;

-- Tablas de los Productos y sus Caracteristicas

CREATE TABLE Producto (
    id INT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    inventario INT NOT NULL,
    categoria_nombre VARCHAR(255) NOT NULL
);

CREATE TABLE Caracteristicas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    producto_id INT NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    valor VARCHAR(50) NOT NULL,
    FOREIGN KEY (producto_id) REFERENCES Producto(id)
);

CREATE TABLE Imagenes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    producto_id INT NOT NULL,
    url VARCHAR(255) NOT NULL,
    FOREIGN KEY (producto_id) REFERENCES Producto(id)
);

-- Tablas de los Usuarios y su Historial de Compra

CREATE TABLE Usuario (
    id INT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    calle VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    ciudad VARCHAR(255) NOT NULL,
    pais VARCHAR(255) NOT NULL
);


CREATE TABLE HistorialCompra (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT NOT NULL,
    producto_id INT NOT NULL,
    cantidad INT NOT NULL,
    fecha DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id),
    FOREIGN KEY (producto_id) REFERENCES Producto(id)
);
