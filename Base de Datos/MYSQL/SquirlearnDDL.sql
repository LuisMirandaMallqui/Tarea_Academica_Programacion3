-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb3 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`colores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`colores` ;

CREATE TABLE IF NOT EXISTS `mydb`.`colores` (
	-- Primary Keys
	`COLOR_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del color.',
	-- Atributos 
	`NOMBRE` VARCHAR(100) NOT NULL COMMENT 'Nombre del color (ej. Rojo, Azul, Negro).',
	-- Auditoria 
	`USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
	`FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
	`USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
	`FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
PRIMARY KEY (`COLOR_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena los colores disponibles para los items.';


-- -----------------------------------------------------
-- Table `mydb`.`condiciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`condiciones` ;

CREATE TABLE IF NOT EXISTS `mydb`.`condiciones` (
	-- Primary Keys
	`CONDICION_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de la condición.',
	-- Atributos -- 
	`NOMBRE` VARCHAR(100) NOT NULL COMMENT 'Nombre de la condición del item (ej. Nuevo, Usado, Semi-nuevo).',
    -- Auditoria --
    `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
    `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
    `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
    `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
PRIMARY KEY (`CONDICION_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena las condiciones de los items (ej. Nuevo, Usado).';


-- -----------------------------------------------------
-- Table `mydb`.`estados_items`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`estados_items` ;

CREATE TABLE IF NOT EXISTS `mydb`.`estados_items` (
  -- Primary Keys
  `ESTADOITEM_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del estado del item.',
  -- Atributos
  `NOMBRE` VARCHAR(100) NOT NULL COMMENT 'Nombre del estado (ej. Disponible, Alquilado, Vendido).',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`ESTADOITEM_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena los estados de un item (ej. Disponible, Alquilado).';


-- -----------------------------------------------------
-- Table `mydb`.`formatos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`formatos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`formatos` (
  -- Primary Keys
  `FORMATO_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del formato.',
  -- Atributos
  `NOMBRE` VARCHAR(100) NOT NULL COMMENT 'Nombre del formato del item (ej. Físico, Digital).',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
PRIMARY KEY (`FORMATO_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena los formatos de los items (ej. Físico, Digital).';


-- -----------------------------------------------------
-- Table `mydb`.`categorias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`categorias` ;

CREATE TABLE IF NOT EXISTS `mydb`.`categorias` (
  -- Primary Keys
  `CATEGORIA_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de la categoría.',
  -- Atributos
  `NOMBRE` VARCHAR(100) NOT NULL COMMENT 'Nombre de la categoría principal (ej. Ropa, Libros, Electrónica).',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`CATEGORIA_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena las categorías principales de los items.';


-- -----------------------------------------------------
-- Table `mydb`.`subcategorias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`subcategorias` ;

CREATE TABLE IF NOT EXISTS `mydb`.`subcategorias` (
  -- Primary Keys
  `SUBCATEGORIA_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de la subcategoría.',
  `CATEGORIA_ID` INT NOT NULL COMMENT 'FK que referencia a la tabla categorías.',
  -- Atributos
  `NOMBRE` VARCHAR(100) NOT NULL COMMENT 'Nombre de la subcategoría (ej. Polos, Pantalones).',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`SUBCATEGORIA_ID`, `CATEGORIA_ID`),
  INDEX `fk_SUBCATEGORIA_CATEGORIA1_idx` (`CATEGORIA_ID` ASC) VISIBLE,
  CONSTRAINT `fk_SUBCATEGORIA_CATEGORIA1`
	FOREIGN KEY (`CATEGORIA_ID`)
    REFERENCES `mydb`.`categorias` (`CATEGORIA_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena las subcategorías, dependientes de una categoría.';


-- -----------------------------------------------------
-- Table `mydb`.`tamanos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tamanos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tamanos` (
  -- Primary Keys
  `TAMANO_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del tamaño.',
  -- Atributos
  `NOMBRE` VARCHAR(100) NOT NULL COMMENT 'Nombre del tamaño (ej. S, M, L, XL, 42).',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`TAMANO_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena los tamaños disponibles para los items.';


-- -----------------------------------------------------
-- Table `mydb`.`items`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`items` ;

CREATE TABLE IF NOT EXISTS `mydb`.`items` (
  -- Primary Keys
  `ITEM_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del item.',
  -- Foreign Keys
  `COLOR_ID` INT NOT NULL COMMENT 'FK que referencia a la tabla colores.',
  `ESTADO_ITEM_ID` INT NOT NULL COMMENT 'FK que referencia a la tabla estados_items.',
  `CONDICION_ID` INT NOT NULL COMMENT 'FK que referencia a la tabla condiciones.',
  `TAMANO_ID` INT NOT NULL COMMENT 'FK que referencia a la tabla tamanos.',
  `FORMATO_ID` INT NOT NULL COMMENT 'FK que referencia a la tabla formatos.',
  `subcategoria_ID_SUBCATEGORIA` INT NOT NULL COMMENT 'FK que referencia a la tabla subcategorias.',
  `subcategoria_CATEGORIA_ID` INT NOT NULL COMMENT 'FK que referencia a la tabla subcategorias (parte de la PK compuesta).',
  -- Atributos
  `NOMBRE` VARCHAR(100) NOT NULL COMMENT 'Nombre descriptivo del item.',
  `DESCRIPCION` VARCHAR(300) NOT NULL COMMENT 'Descripción detallada del item.',
  `PRECIO` DECIMAL(10,2) NOT NULL COMMENT 'Precio del item para venta o alquiler.',
  `ES_VENTA` TINYINT(3) UNSIGNED ZEROFILL NOT NULL COMMENT 'Flag (1=Venta, 0=Alquiler) que define la modalidad del item.',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`ITEM_ID`),
  INDEX `fk_ITEM_COLOR1_idx` (`COLOR_ID` ASC) VISIBLE,
  INDEX `fk_ITEM_ESTADO_ITEM1_idx` (`ESTADO_ITEM_ID` ASC) VISIBLE,
  INDEX `fk_ITEM_CONDICION1_idx` (`CONDICION_ID` ASC) VISIBLE,
  INDEX `fk_ITEM_TAMANO1_idx` (`TAMANO_ID` ASC) VISIBLE,
  INDEX `fk_ITEM_FORMATO1_idx` (`FORMATO_ID` ASC) VISIBLE,
  INDEX `fk_item_subcategoria1_idx` (`subcategoria_ID_SUBCATEGORIA` ASC, `subcategoria_CATEGORIA_ID` ASC) VISIBLE,
  CONSTRAINT `fk_ITEM_COLOR1`
    FOREIGN KEY (`COLOR_ID`)
    REFERENCES `mydb`.`colores` (`COLOR_ID`),
  CONSTRAINT `fk_ITEM_CONDICION1`
    FOREIGN KEY (`CONDICION_ID`)
    REFERENCES `mydb`.`condiciones` (`CONDICION_ID`),
  CONSTRAINT `fk_ITEM_ESTADO_ITEM1`
    FOREIGN KEY (`ESTADO_ITEM_ID`)
    REFERENCES `mydb`.`estados_items` (`ESTADOITEM_ID`),
  CONSTRAINT `fk_ITEM_FORMATO1`
    FOREIGN KEY (`FORMATO_ID`)
    REFERENCES `mydb`.`formatos` (`FORMATO_ID`),
  CONSTRAINT `fk_item_subcategoria1`
    FOREIGN KEY (`subcategoria_ID_SUBCATEGORIA` , `subcategoria_CATEGORIA_ID`)
    REFERENCES `mydb`.`subcategorias` (`SUBCATEGORIA_ID` , `CATEGORIA_ID`),
  CONSTRAINT `fk_ITEM_TAMANO1`
    FOREIGN KEY (`TAMANO_ID`)
    REFERENCES `mydb`.`tamanos` (`TAMANO_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Tabla principal que almacena los artículos (items) para venta o alquiler.';

-- -----------------------------------------------------
-- Table `mydb`.`estados_personas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`estados_personas` ;

CREATE TABLE IF NOT EXISTS `mydb`.`estados_personas` (
  -- Primary Keys
  `ESTADOPERSONA_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del estado.',
  -- Atributos
  `NOMBRE` VARCHAR(45) NOT NULL COMMENT 'Nombre del estado de la persona (ej. Activo, Inactivo, Bloqueado).',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`ESTADOPERSONA_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena los estados de una persona/usuario en el sistema.';

-- -----------------------------------------------------
-- Table `mydb`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`roles` ;

CREATE TABLE IF NOT EXISTS `mydb`.`roles` (
  -- Primary Keys
  `ROLPERSONA_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del rol.',
  -- Atributos
  `NOMBRE` VARCHAR(45) NOT NULL COMMENT 'Nombre del rol (ej. Administrador, Comprador, Vendedor).',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`ROLPERSONA_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena los roles que puede tener una persona en el sistema.';

-- -----------------------------------------------------
-- Table `mydb`.`personas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`personas` ;

CREATE TABLE IF NOT EXISTS `mydb`.`personas` (
  -- Primary Keys
  `PERSONA_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de la persona.',
  -- Foreign Keys
  `ESTADO_PERSONA_ID_ESTADOPERSONA` INT NOT NULL COMMENT 'FK que referencia al estado de la persona.',
  -- Atributos
  `NOMBRES` VARCHAR(100) NOT NULL COMMENT 'Nombres de la persona.',
  `PRIMER_APELLIDO` VARCHAR(100) NOT NULL COMMENT 'Apellido paterno de la persona.',
  `SEGUNDO_APELLIDO` VARCHAR(100) NOT NULL COMMENT 'Apellido materno de la persona.',
  `CODIGO` VARCHAR(8) NOT NULL COMMENT 'Código único de la persona (ej. Código PUCP).',
  `CORREO` VARCHAR(100) NOT NULL COMMENT 'Correo electrónico (debe ser único).',
  `CONTRASENA` VARCHAR(45) NOT NULL COMMENT 'Contraseña del usuario (debería estar encriptada).',
  `ULTIMA_ACTIVIDAD` DATETIME NOT NULL COMMENT 'Fecha y hora de la última actividad del usuario en este chat.',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`PERSONA_ID`),
  INDEX `fk_PERSONA_ESTADO_PERSONA1_idx` (`ESTADO_PERSONA_ID_ESTADOPERSONA` ASC) VISIBLE,
  CONSTRAINT `fk_PERSONA_ESTADO_PERSONA1`
    FOREIGN KEY (`ESTADO_PERSONA_ID_ESTADOPERSONA`)
    REFERENCES `mydb`.`estados_personas` (`ESTADOPERSONA_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Tabla principal que almacena los usuarios o personas del sistema.';

-- -----------------------------------------------------
-- Table `mydb`.`personas_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`personas_roles` ;

CREATE TABLE IF NOT EXISTS `mydb`.`personas_roles` (
  -- Primary Keys
  `PERSONA_ID` INT NOT NULL COMMENT 'FK que referencia a la tabla personas.',
  `ROLPERSONA_ID` INT NOT NULL COMMENT 'FK que referencia a la tabla roles.',
  -- Auditoria 
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`PERSONA_ID`, `ROLPERSONA_ID`) COMMENT 'Llave primaria compuesta para la relación M-M.',
  INDEX `fk_personas_roles_roles1_idx` (`ROLPERSONA_ID` ASC) VISIBLE,
  INDEX `fk_personas_roles_personas1_idx` (`PERSONA_ID` ASC) VISIBLE,
  CONSTRAINT `fk_personas_roles_personas1`
    FOREIGN KEY (`PERSONA_ID`)
    REFERENCES `mydb`.`personas` (`PERSONA_ID`),
  CONSTRAINT `fk_personas_roles_roles1`
    FOREIGN KEY (`ROLPERSONA_ID`)
    REFERENCES `mydb`.`roles` (`ROLPERSONA_ID`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Tabla intermedia para la relación M-M entre personas y roles.';

-- -----------------------------------------------------
-- Table `mydb`.`alquileres`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`alquileres` ;

CREATE TABLE IF NOT EXISTS `mydb`.`alquileres` (
  -- Primary Keys
  `ALQUILER_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del alquiler.',
  -- Foreign Keys
  `PERSONA_ID` INT NOT NULL COMMENT 'FK que referencia a la persona que alquila.',
  `ITEM_ID` INT NOT NULL COMMENT 'FK que referencia al item que está siendo alquilado.',
  -- Atributos
  `FECHA_INICIO` DATETIME NOT NULL COMMENT 'Fecha y hora de inicio del alquiler.',
  `FECHA_FIN` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de finalización (devolución) del alquiler.',
  `MONTO` DECIMAL(10,2) NOT NULL COMMENT 'Monto total pagado por el alquiler.',
  `DEVUELTO` TINYINT NOT NULL COMMENT 'Flag (1=Devuelto, 0=No devuelto) para estado de devolución.',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`ALQUILER_ID`),
  INDEX `fk_PERSONA_has_ITEM_ITEM1_idx` (`ITEM_ID` ASC) VISIBLE,
  INDEX `fk_PERSONA_has_ITEM_PERSONA1_idx` (`PERSONA_ID` ASC) VISIBLE,
  CONSTRAINT `fk_PERSONA_has_ITEM_ITEM1`
    FOREIGN KEY (`ITEM_ID`)
    REFERENCES `mydb`.`items` (`ITEM_ID`),
  CONSTRAINT `fk_PERSONA_has_ITEM_PERSONA1`
    FOREIGN KEY (`PERSONA_ID`)
    REFERENCES `mydb`.`personas` (`PERSONA_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena la relación de alquiler entre una persona y un item.';


-- -----------------------------------------------------
-- Table `mydb`.`estados_chats`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`estados_chats` ;

CREATE TABLE IF NOT EXISTS `mydb`.`estados_chats` (
  -- Primary Keys
  `ESTADOCHAT_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del estado del chat.',
  -- Atributos
  `NOMBRE` VARCHAR(45) NOT NULL COMMENT 'Nombre del estado (ej. Abierto, Cerrado, Archivado).',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`ESTADOCHAT_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena los estados posibles de una sala de chat.';


-- -----------------------------------------------------
-- Table `mydb`.`chats`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`chats` ;

CREATE TABLE IF NOT EXISTS `mydb`.`chats` (
  -- Primary Keys
  `CHAT_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de la sala de chat.',
  -- Foreign Keys
  `estado_chat_ID_ESTADOCHAT` INT NOT NULL COMMENT 'FK que referencia al estado actual del chat.',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`CHAT_ID`),
  INDEX `fk_CHAT_estado_chat1_idx` (`estado_chat_ID_ESTADOCHAT` ASC) VISIBLE,
  CONSTRAINT `fk_CHAT_estado_chat1`
    FOREIGN KEY (`estado_chat_ID_ESTADOCHAT`)
    REFERENCES `mydb`.`estados_chats` (`ESTADOCHAT_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena las salas de chat entre personas.';

-- -----------------------------------------------------
-- Table `mydb`.`formas_pago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`formas_pago` ;

CREATE TABLE IF NOT EXISTS `mydb`.`formas_pago` (
  -- Primary Keys
  `FORMAPAGO_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de la forma de pago.',
  -- Atributos 
  `NOMBRE` VARCHAR(45) NOT NULL COMMENT 'Nombre de la forma de pago (ej. Tarjeta de Crédito, Yape).',
  -- Auditoria
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  PRIMARY KEY (`FORMAPAGO_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Catalogo de formas de pago aceptadas por el sistema.';


-- -----------------------------------------------------
-- Table `mydb`.`monedas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`monedas` ;

CREATE TABLE IF NOT EXISTS `mydb`.`monedas` (
  -- Primary Key
  `MONEDA_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de la moneda.',
  -- Atributos
  `NOMBRE` VARCHAR(45) NOT NULL COMMENT 'Nombre de la moneda (ej. Soles, Dólares).',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`MONEDA_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Catalogo de monedas aceptadas por el sistema.';


-- -----------------------------------------------------
-- Table `mydb`.`comprobantes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`comprobantes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`comprobantes` (
  -- Primary Keys
  `COMPROBANTE_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del comprobante de pago.',
  -- Foreign Keys
  `PERSONA_ID_PERSONA` INT NOT NULL COMMENT 'FK que referencia a la persona que realiza el pago.',
  `FORMA_PAGO_ID_FORMAPAGO` INT NOT NULL COMMENT 'FK que referencia a la forma de pago utilizada.',
  `MONEDA_ID_MONEDA` INT NOT NULL COMMENT 'FK que referencia a la moneda del pago.',
  -- Atributos
  `TRANSACCION_ID` VARCHAR(45) NOT NULL COMMENT 'ID de la transacción devuelto por la pasarela de pago.',
  `FECHA_EMISION` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de emisión del comprobante.',
  `MONTO` DECIMAL(10,2) NOT NULL COMMENT 'Monto total pagado.',
  `IMPUESTO` DECIMAL(10,2) NULL DEFAULT NULL COMMENT 'Impuesto (IGV) aplicado al monto.',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`COMPROBANTE_ID`),
  INDEX `fk_COMPROBANTE_PERSONA1_idx` (`PERSONA_ID_PERSONA` ASC) VISIBLE,
  INDEX `fk_COMPROBANTE_FORMA_PAGO1_idx` (`FORMA_PAGO_ID_FORMAPAGO` ASC) VISIBLE,
  INDEX `fk_COMPROBANTE_MONEDA1_idx` (`MONEDA_ID_MONEDA` ASC) VISIBLE,
  CONSTRAINT `fk_COMPROBANTE_FORMA_PAGO1`
    FOREIGN KEY (`FORMA_PAGO_ID_FORMAPAGO`)
    REFERENCES `mydb`.`formas_pago` (`FORMAPAGO_ID`),
  CONSTRAINT `fk_COMPROBANTE_MONEDA1`
    FOREIGN KEY (`MONEDA_ID_MONEDA`)
    REFERENCES `mydb`.`monedas` (`MONEDA_ID`),
 CONSTRAINT `fk_COMPROBANTE_PERSONA1`
    FOREIGN KEY (`PERSONA_ID_PERSONA`)
    REFERENCES `mydb`.`personas` (`PERSONA_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena la cabecera de los comprobantes de pago (ventas/alquileres).';


-- -----------------------------------------------------
-- Table `mydb`.`detalles_comprobantes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`detalles_comprobantes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`detalles_comprobantes` (
  -- Primary Keys
  `DETALLECOM_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del detalle.',
  `COMPROBANTE_ID_COMPROBANTE` INT NOT NULL COMMENT 'FK que referencia a la cabecera del comprobante.',
  -- Foreign Keys
  `ITEM_ID_ITEM` INT NULL DEFAULT NULL COMMENT 'FK al item (si es una venta).',
  `ALQUILER_ID_ALQUILER` INT NULL DEFAULT NULL COMMENT 'FK al alquiler (si es un pago de alquiler).',
  -- Atributos
  `DESCRIPCION` VARCHAR(100) NOT NULL COMMENT 'Descripción de la línea de detalle (ej. Venta de Item X).',
  `PRECIO` DECIMAL(10,2) NOT NULL COMMENT 'Precio de esta línea de detalle.',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',

  PRIMARY KEY (`DETALLECOM_ID`, `COMPROBANTE_ID_COMPROBANTE`),
  INDEX `fk_DETALLE_COMPROBANTE_ITEM1_idx` (`ITEM_ID_ITEM` ASC) VISIBLE,
  INDEX `fk_DETALLE_COMPROBANTE_ALQUILER1_idx` (`ALQUILER_ID_ALQUILER` ASC) VISIBLE,
  INDEX `fk_DETALLE_COMPROBANTE_COMPROBANTE1_idx` (`COMPROBANTE_ID_COMPROBANTE` ASC) VISIBLE,
  CONSTRAINT `fk_DETALLE_COMPROBANTE_ALQUILER1`
    FOREIGN KEY (`ALQUILER_ID_ALQUILER`)
	REFERENCES `mydb`.`alquileres` (`ALQUILER_ID`),
  CONSTRAINT `fk_DETALLE_COMPROBANTE_COMPROBANTE1`
    FOREIGN KEY (`COMPROBANTE_ID_COMPROBANTE`)
    REFERENCES `mydb`.`comprobantes` (`COMPROBANTE_ID`),
  CONSTRAINT `fk_DETALLE_COMPROBANTE_ITEM1`
    FOREIGN KEY (`ITEM_ID_ITEM`)
    REFERENCES `mydb`.`items` (`ITEM_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena las líneas de detalle de cada comprobante.';


-- -----------------------------------------------------
-- Table `mydb`.`estados_mensajes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`estados_mensajes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`estados_mensajes` (
  -- Primary Keys
  `ESTADOMSJ_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del estado del mensaje.',
  -- Atributos
  `NOMBRE` VARCHAR(100) NOT NULL COMMENT 'Nombre del estado (ej. Enviado, Leído, Eliminado).',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`ESTADOMSJ_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena los estados de un mensaje de chat (ej. Enviado, Leído).';

-- -----------------------------------------------------
-- Table `mydb`.`estados_publicaciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`estados_publicaciones` ;

CREATE TABLE IF NOT EXISTS `mydb`.`estados_publicaciones` (
  -- Primary Keys
  `ESTADOPUBLI_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del estado.',
  -- Atributos
  `NOMBRE` VARCHAR(100) NOT NULL COMMENT 'Nombre del estado (ej. Borrador, Pendiente, Aprobada, Rechazada).',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`ESTADOPUBLI_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena los estados de una publicación (ej. Aprobada, Rechazada).';

-- -----------------------------------------------------
-- Table `mydb`.`publicaciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`publicaciones` ;

CREATE TABLE IF NOT EXISTS `mydb`.`publicaciones` (
  -- Primary Keys
  `PUBLICACION_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de la publicación.',
  -- Foreign Keys
  `ESTADO_PUBLICACION_ID` INT NOT NULL COMMENT 'FK que referencia al estado actual de la publicación.',
  `ITEM_ID_ITEM` INT NOT NULL COMMENT 'FK que referencia al item que se está publicando.',
  `PERSONA_ID` INT NOT NULL COMMENT 'FK que referencia a la persona (vendedor) que crea la publicación.',
  -- Atributos
  `FECHA_ALTA` DATETIME NULL DEFAULT NULL COMMENT 'Fecha en que la publicación es aprobada',
  `FECHA_BAJA` DATETIME NULL DEFAULT NULL COMMENT 'Fecha en que la publicación deja de visualizarse.',
  `CALIFICACION` INT NULL DEFAULT '0' COMMENT 'Calificación promedio de la publicación',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`PUBLICACION_ID`),
  INDEX `fk_PUBLICACION_ESTADO_PUBLICACION1_idx` (`ESTADO_PUBLICACION_ID` ASC) VISIBLE,
  INDEX `fk_PUBLICACION_ITEM1_idx` (`ITEM_ID_ITEM` ASC) VISIBLE,
  INDEX `fk_PUBLICACION_PERSONA1_idx` (`PERSONA_ID` ASC) VISIBLE,
  CONSTRAINT `fk_PUBLICACION_ESTADO_PUBLICACION1`
    FOREIGN KEY (`ESTADO_PUBLICACION_ID`)
    REFERENCES `mydb`.`estados_publicaciones` (`ESTADOPUBLI_ID`),
  CONSTRAINT `fk_PUBLICACION_ITEM1`
    FOREIGN KEY (`ITEM_ID_ITEM`)
	REFERENCES `mydb`.`items` (`ITEM_ID`),
  CONSTRAINT `fk_PUBLICACION_PERSONA1`
    FOREIGN KEY (`PERSONA_ID`)
    REFERENCES `mydb`.`personas` (`PERSONA_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena la publicación de un item hecha por una persona.';

-- -----------------------------------------------------
-- Table `mydb`.`historias_publicaciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`historias_publicaciones` ;

CREATE TABLE IF NOT EXISTS `mydb`.`historias_publicaciones` (
  -- Primary Keys
  `HISTORIAPUBLI_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del registro de historia.',
  `PUBLICACION_ID` INT NOT NULL COMMENT 'FK que referencia a la publicación modificada.',
  -- Atributos
  `USUARIO_MODIFICACION_PUBLICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Usuario que modifico la publicación',
  `FECHA_MODIFICACION_PUBLICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora del registro de la modificacion.',
  `ESTADO_ID_ANTERIOR` INT NULL DEFAULT NULL COMMENT 'FK que referencia al estado actual de la publicación.',
  `ITEM_ID_ITEM_ANTERIOR` INT NULL DEFAULT NULL COMMENT 'FK que referencia al item que se está publicando.',
  `ESTADO_ID_ACTUAL` INT NOT NULL COMMENT 'FK que referencia al estado actual de la publicación.',
  `ITEM_ID_ITEM_ACTUAL` INT NOT NULL COMMENT 'FK que referencia al item que se está publicando.',
  -- Auditoria
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`HISTORIAPUBLI_ID`, `PUBLICACION_ID`),
  INDEX `fk_HISTORIA_PUBLI_PUBLICACION1_idx` (`PUBLICACION_ID` ASC) VISIBLE,
  CONSTRAINT `fk_HISTORIA_PUBLI_PUBLICACION1`
    FOREIGN KEY (`PUBLICACION_ID`)
    REFERENCES `mydb`.`publicaciones` (`PUBLICACION_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Tabla bitácora que almacena el historial de cambios de una publicación.';

-- -----------------------------------------------------
-- Table `mydb`.`motivos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`motivos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`motivos` (
  -- Primary Keys
  `MOTIVO_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del motivo.',
  -- Atributos
  `NOMBRE` VARCHAR(45) NULL DEFAULT NULL COMMENT 'Nombre del motivo (ej. Reporte, Incidencia, Notificación).',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`MOTIVO_ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Catálogo de motivos para notificaciones o incidencias.';


-- -----------------------------------------------------
-- Table `mydb`.`notificaciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`notificaciones` ;

CREATE TABLE IF NOT EXISTS `mydb`.`notificaciones` (
  -- Primary Keys
  `NOTIFICACION_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de la notificación.',
  -- Foreign Keys
  `PERSONA_ID` INT NOT NULL COMMENT 'FK que referencia a la persona que recibe la notificación.',
  -- Atributos
  `FECHA` DATETIME NOT NULL COMMENT 'Fecha y hora en que se generó la notificación.',
  `MENSAJE` VARCHAR(255) NOT NULL COMMENT 'Contenido del mensaje de la notificación.',
  -- Auditoria
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`NOTIFICACION_ID`),
  INDEX `fk_NOTIFIFACION_PERSONA1_idx` (`PERSONA_ID` ASC) VISIBLE,
  CONSTRAINT `fk_NOTIFIFACION_PERSONA1`
    FOREIGN KEY (`PERSONA_ID`)
    REFERENCES `mydb`.`personas` (`PERSONA_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena notificaciones enviadas a los usuarios.';

-- -----------------------------------------------------
-- Table `mydb`.`incidencias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`incidencias` ;

CREATE TABLE IF NOT EXISTS `mydb`.`incidencias` (
  -- Primary Keys
  `INCIDENCIA_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único de la incidencia.',
  -- Foreing Keys
  `PERSONA_ID` INT NOT NULL COMMENT 'FK que referencia a la persona que reporta la incidencia.',
  `MOTIVO_ID_MOTIVO` INT NOT NULL COMMENT 'FK que referencia al motivo de la incidencia.',
  -- Atributos
  `DESCRIPCION` VARCHAR(100) NOT NULL COMMENT 'Descripción detallada de la incidencia.',
  `RESPUESTA` VARCHAR(100) NOT NULL COMMENT 'Respuesta a la incidencia.',
  `RESUELTO` TINYINT NULL DEFAULT '0' COMMENT 'Flag (1=Resuelto, 0=Pendiente) para el estado de la incidencia.',
  `FECHA_SOLUCION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora en que se solucionó la incidencia.',
  `USUARIO_SOLUCION` INT NULL DEFAULT NULL COMMENT 'ID del usuario (administrador) que solucionó la incidencia.',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`INCIDENCIA_ID`),
  INDEX `fk_INCIDENCIA_PERSONA1_idx` (`PERSONA_ID` ASC) VISIBLE,
  INDEX `fk_INCIDENCIA_MOTIVO1_idx` (`MOTIVO_ID_MOTIVO` ASC) VISIBLE,
  CONSTRAINT `fk_INCIDENCIA_MOTIVO1`
    FOREIGN KEY (`MOTIVO_ID_MOTIVO`)
    REFERENCES `mydb`.`motivos` (`MOTIVO_ID`),
  CONSTRAINT `fk_INCIDENCIA_PERSONA1`
    FOREIGN KEY (`PERSONA_ID`)
    REFERENCES `mydb`.`personas` (`PERSONA_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena las incidencias o reportes generados por los usuarios.';


-- -----------------------------------------------------
-- Table `mydb`.`mensajes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`mensajes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`mensajes` (
  -- Primary Keys
  `MENSAJE_ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identificador único del mensaje.',
  `CHAT_ID_CHAT` INT NOT NULL COMMENT 'FK que referencia a la sala de chat a la que pertenece.',
  -- Foreign Keys
  `ESTADO_MSJ_ID` INT NOT NULL COMMENT 'FK que referencia al estado del mensaje (enviado, leído).',
  `PERSONA_ID` INT NOT NULL COMMENT 'FK que referencia a la persona que envió el mensaje.',
  -- Atributos
  `FECHA_ENVIO` DATETIME NOT NULL COMMENT 'Fecha y hora de envío del mensaje.',
  `FECHA_LEIDO` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora en que el destinatario leyó el mensaje.',
  `MENSAJE` TEXT NOT NULL COMMENT 'Contenido del mensaje.',
  -- Auditoria
  `USUARIO_CREACION` VARCHAR(100) NOT NULL COMMENT 'Usuario que creó el registro.',
  `FECHA_CREACION` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha y hora de creación del registro.',
  `USUARIO_MODIFICACION` VARCHAR(100) NULL DEFAULT NULL COMMENT 'Último usuario que modificó el registro.',
  `FECHA_MODIFICACION` DATETIME NULL DEFAULT NULL COMMENT 'Fecha y hora de la última modificación.',
  PRIMARY KEY (`MENSAJE_ID`, `CHAT_ID_CHAT`),
  INDEX `fk_MENSAJE_CHAT1_idx` (`CHAT_ID_CHAT` ASC) VISIBLE,
  INDEX `fk_MENSAJE_PERSONA1_idx` (`PERSONA_ID` ASC) VISIBLE,
  INDEX `fk_MENSAJE_ESTADO_MSJ1_idx` (`ESTADO_MSJ_ID` ASC) VISIBLE,
  CONSTRAINT `fk_MENSAJE_CHAT1`
    FOREIGN KEY (`CHAT_ID_CHAT`)
    REFERENCES `mydb`.`chats` (`CHAT_ID`),
  CONSTRAINT `fk_MENSAJE_ESTADO_MSJ1`
    FOREIGN KEY (`ESTADO_MSJ_ID`)
    REFERENCES `mydb`.`estados_mensajes` (`ESTADOMSJ_ID`),
  CONSTRAINT `fk_MENSAJE_PERSONA1`
    FOREIGN KEY (`PERSONA_ID`)
    REFERENCES `mydb`.`personas` (`PERSONA_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Almacena cada mensaje individual enviado en una sala de chat.';





-- -----------------------------------------------------
-- Table `mydb`.`personas_chats`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`personas_chats` ;

CREATE TABLE IF NOT EXISTS `mydb`.`personas_chats` (
  -- Primary Keys
  `PERSONA_ID` INT NOT NULL COMMENT 'FK que referencia a la persona.',
  `CHAT_ID` INT NOT NULL COMMENT 'FK que referencia a la sala de chat.',
  --
  PRIMARY KEY (`PERSONA_ID`, `CHAT_ID`),
  INDEX `fk_PERSONA_has_CHAT_CHAT1_idx` (`CHAT_ID` ASC) VISIBLE,
  INDEX `fk_PERSONA_has_CHAT_PERSONA1_idx` (`PERSONA_ID` ASC) VISIBLE,
  CONSTRAINT `fk_PERSONA_has_CHAT_CHAT1`
    FOREIGN KEY (`CHAT_ID`)
    REFERENCES `mydb`.`chats` (`CHAT_ID`),
  CONSTRAINT `fk_PERSONA_has_CHAT_PERSONA1`
    FOREIGN KEY (`PERSONA_ID`)
    REFERENCES `mydb`.`personas` (`PERSONA_ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3
COMMENT = 'Tabla intermedia para la relación M-M entre personas y chats.';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;