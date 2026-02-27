-- ============================================
-- SCRIPT DE CONFIGURACIÓN - NEPTUNO
-- ============================================

-- Crear base de datos y usuario
CREATE DATABASE IF NOT EXISTS neptuno CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS 'neptuno_app'@'localhost' IDENTIFIED BY 'neptuno123';
GRANT ALL PRIVILEGES ON neptuno.* TO 'neptuno_app'@'localhost';
FLUSH PRIVILEGES;

USE neptuno;

-- ============================================
-- TABLAS
-- ============================================

CREATE TABLE IF NOT EXISTS categorias (
    idCategoria     INT PRIMARY KEY,
    nombreCategoria VARCHAR(50),
    descripcion     VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS proveedores (
    idProveedor     INT PRIMARY KEY,
    nombreCompania  VARCHAR(100),
    nombreContacto  VARCHAR(50),
    cargoContacto   VARCHAR(50),
    direccion       VARCHAR(100),
    ciudad          VARCHAR(50),
    region          VARCHAR(50),
    codPostal       VARCHAR(10),
    pais            VARCHAR(50),
    telefono        VARCHAR(25),
    fax             VARCHAR(25)
);

CREATE TABLE IF NOT EXISTS companiasEnvios (
    idCompania      INT PRIMARY KEY,
    nombreCompania  VARCHAR(100),
    telefono        VARCHAR(25)
);

CREATE TABLE IF NOT EXISTS empleados (
    idEmpleado        INT PRIMARY KEY,
    apellidos         VARCHAR(50),
    nombre            VARCHAR(50),
    cargo             VARCHAR(50),
    tratamiento       VARCHAR(25),
    fechaNacimiento   VARCHAR(20),
    fechaContratacion VARCHAR(20),
    direccion         VARCHAR(100),
    ciudad            VARCHAR(50),
    region            VARCHAR(50),
    codPostal         VARCHAR(10),
    pais              VARCHAR(50),
    telDomicilio      VARCHAR(25),
    extension         VARCHAR(10),
    email             VARCHAR(100),
    password          VARCHAR(100),
    login             VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS clientes (
    idCliente       VARCHAR(10) PRIMARY KEY,
    nombreCompania  VARCHAR(100),
    nombreContacto  VARCHAR(50),
    cargoContacto   VARCHAR(50),
    direccion       VARCHAR(100),
    ciudad          VARCHAR(50),
    region          VARCHAR(50),
    codPostal       VARCHAR(10),
    pais            VARCHAR(50),
    telefono        VARCHAR(25),
    fax             VARCHAR(25),
    jefe            VARCHAR(50),
    login           VARCHAR(50),
    password        VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS productos (
    idProducto           INT PRIMARY KEY,
    nombreProducto       VARCHAR(100),
    idProveedor          INT,
    idCategoria          INT,
    cantidadPorUnidad    VARCHAR(50),
    precioUnidad         DOUBLE,
    unidadesEnExistencia INT,
    unidadesEnPedido     INT,
    nivelNuevoPedido     INT,
    suspendido           BOOLEAN,
    FOREIGN KEY (idProveedor) REFERENCES proveedores(idProveedor),
    FOREIGN KEY (idCategoria) REFERENCES categorias(idCategoria)
);

-- ============================================
-- DATOS INICIALES - CATEGORIAS
-- ============================================

INSERT INTO categorias VALUES
(1, 'Bebidas',     'Cervezas, refrescos, licores'),
(2, 'Condimentos', 'Salsas, aderezos y especias'),
(3, 'Lácteos',     'Quesos y derivados'),
(4, 'Carnes',      'Carnes y aves'),
(5, 'Mariscos',    'Pescados y mariscos');

-- ============================================
-- DATOS INICIALES - PROVEEDORES
-- ============================================

INSERT INTO proveedores VALUES
(1, 'Proveedor Alpha',  'Ana García',    'Gerente',    'Calle 1',   'Madrid',       'Madrid',    '28001', 'España',    '91-111-1111', '91-111-1112'),
(2, 'Proveedor Beta',   'Luis Martínez', 'Director',   'Av. 2',     'Barcelona',    'Cataluña',  '08001', 'España',    '93-222-2222', '93-222-2223'),
(3, 'Proveedor Gamma',  'María López',   'Vendedora',  'Plaza 3',   'Sevilla',      'Andalucía', '41001', 'España',    '95-333-3333', '95-333-3334');

-- ============================================
-- DATOS INICIALES - COMPANIAS ENVIOS
-- ============================================

INSERT INTO companiasEnvios VALUES
(1, 'Envíos Rápidos S.A.',  '900-111-111'),
(2, 'Transportes Norte',    '900-222-222'),
(3, 'Logística Express',    '900-333-333');

-- ============================================
-- DATOS INICIALES - EMPLEADOS
-- ============================================

INSERT INTO empleados VALUES
(1, 'Pérez',    'Carlos',  'Gerente de Ventas', 'Sr.',  '1980-05-15', '2010-03-01', 'Calle Mayor 10', 'Madrid',    'Madrid',    '28001', 'España', '91-100-0001', '101', 'carlos.perez@neptuno.com',  'pass123', 'carlosperez'),
(2, 'González', 'Laura',   'Representante',     'Sra.', '1990-08-22', '2015-06-15', 'Av. del Sol 5',  'Barcelona', 'Cataluña',  '08002', 'España', '93-200-0002', '102', 'laura.gonzalez@neptuno.com','pass456', 'lauragonzalez'),
(3, 'Ruiz',     'Miguel',  'Coordinador',       'Sr.',  '1985-11-30', '2012-09-10', 'Plaza Nueva 3',  'Sevilla',   'Andalucía', '41002', 'España', '95-300-0003', '103', 'miguel.ruiz@neptuno.com',   'pass789', 'miguelruiz');

-- ============================================
-- DATOS INICIALES - PRODUCTOS
-- ============================================

INSERT INTO productos VALUES
(1, 'Cerveza Neptuno',   1, 1, '24 latas x 33cl',  1.80, 100, 0, 20, false),
(2, 'Salsa Picante',     2, 2, '12 frascos x 300g', 2.50,  60, 0, 15, false),
(3, 'Queso Manchego',    3, 3, '1 pieza x 500g',    6.00,  40, 0, 10, false),
(4, 'Chorizo Ibérico',   1, 4, '1 pieza x 250g',    4.50,  80, 0, 25, false),
(5, 'Merluza Congelada', 2, 5, '1 kg',              5.20,  50, 0, 10, false);

-- ============================================
-- DATOS INICIALES - CLIENTES (con login y password)
-- ============================================

INSERT INTO clientes VALUES
('CLI01', 'Empresa Uno S.L.',    'Juan Sánchez',   'Director',    'Calle Luna 1',  'Madrid',    'Madrid',    '28010', 'España', '91-400-0001', NULL, 'Pedro Álvarez', 'juansanchez', 'clave123'),
('CLI02', 'Negocios Dos S.A.',   'Elena Moreno',   'Gerente',     'Av. Sol 22',    'Valencia',  'Valencia',  '46001', 'España', '96-400-0002', NULL, 'Rosa Fernández','elenamoreno',  'clave456'),
('CLI03', 'Distribuciones Tres', 'Pablo Romero',   'Comercial',   'Plaza Mayor 5', 'Bilbao',    'País Vasco','48001', 'España', '94-400-0003', NULL, 'Ana Jiménez',  'pabloromero',  'clave789');
