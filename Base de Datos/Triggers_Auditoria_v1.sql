DELIMITER $$
-- luis kmiranda
-- ------------------------------------------------------------------
-- Tablas Maestras
-- -------------------------------------------------------------------

/*CATEGORIAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_CATEGORIAS_INSERT_CREACION
BEFORE INSERT ON categorias
FOR EACH ROW
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    SET NEW.USUARIO_CREACION = CURRENT_USER(); 
END $$

CREATE TRIGGER TRG_CATEGORIAS_UPDATE_AUDITORIA
BEFORE UPDATE ON categorias
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER(); -- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*COLORES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_COLORES_INSERT_CREACION
BEFORE INSERT ON colores
FOR EACH ROW
BEGIN
	SET NEW.FECHA_CREACION = NOW();
	SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_COLORES_UPDATE_AUDITORIA
BEFORE UPDATE ON colores
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER(); -- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*CONDICIONES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_CONDICIONES_INSERT_CREACION
BEFORE INSERT ON condiciones
FOR EACH ROW
BEGIN
	SET NEW.FECHA_CREACION = NOW();
	SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_CONDICIONES_UPDATE_AUDITORIA
BEFORE UPDATE ON condiciones
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER(); -- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$


/*ESTADOS_CHATS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_ESTADOS_CHATS_INSERT_CREACION
BEFORE INSERT ON estados_chats
FOR EACH ROW
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_ESTADOS_CHATS_UPDATE_AUDITORIA
BEFORE UPDATE ON estados_chats
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*ESTADOS_ITEMS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_ESTADOS_ITEMS_INSERT_CREACION
BEFORE INSERT ON estados_items
FOR EACH ROW
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_ESTADOS_ITEMS_UPDATE_AUDITORIA
BEFORE UPDATE ON estados_items
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*ESTADOS_MENSAJES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_ESTADOS_MENSAJES_INSERT_CREACION
BEFORE INSERT ON estados_mensajes
FOR EACH ROW
BEGIN
	SET NEW.FECHA_CREACION = NOW();
	SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_ESTADOS_MENSAJES_UPDATE_AUDITORIA
BEFORE UPDATE ON estados_mensajes
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*ESTADOS_PERSONAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_ESTADOS_PERSONAS_INSERT_CREACION
BEFORE INSERT ON estados_personas
FOR EACH ROW
BEGIN
	SET NEW.FECHA_CREACION = NOW();
	SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_ESTADOS_PERSONAS_UPDATE_AUDITORIA
BEFORE UPDATE ON estados_personas
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*ESTADOS_PUBLICACIONES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_ESTADOS_PUBLICACIONES_INSERT_CREACION
BEFORE INSERT ON estados_publicaciones
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_ESTADOS_PUBLICACIONES_UPDATE_AUDITORIA
BEFORE UPDATE ON estados_publicaciones
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*FORMAS_PAGO*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_FORMAS_PAGO_CREACION
BEFORE INSERT ON formas_pago
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
	SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_FORMAS_PAGO_AUDITORIA
BEFORE UPDATE ON formas_pago
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*FORMATOS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_FORMATOS_CREACION
BEFORE INSERT ON formatos
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_FORMATOS_AUDITORIA
BEFORE UPDATE ON formatos
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*MONEDAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_MONEDAS_CREACION
BEFORE INSERT ON monedas
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
	SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_MONEDAS_AUDITORIA
BEFORE UPDATE ON monedas
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION =  CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*MOTIVOS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_MOTIVOS_CREACION
BEFORE INSERT ON motivos
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_MOTIVOS_AUDITORIA
BEFORE UPDATE ON motivos
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*ROLES_PERSONAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_ROLES_PERSONAS_CREACION
BEFORE INSERT ON roles_personas
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_ROLES_PERSONAS_AUDITORIA
BEFORE UPDATE ON roles_personas
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*SUBCATEGORIAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_SUBCATEGORIAS_CREACION
BEFORE INSERT ON subcategorias
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_SUBCATEGORIAS_AUDITORIA
BEFORE UPDATE ON subcategorias
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*TAMANOS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_TAMANOS_CREACION
BEFORE INSERT ON tamanos
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
	SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_TAMANOS_AUDITORIA
BEFORE UPDATE ON tamanos
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

-- ------------------------------------------------------------------
-- Tablas transaccionales
-- -------------------------------------------------------------------

/*ALQUILERES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_ALQUILERES_INSERT_CREACION
BEFORE INSERT ON alquileres
FOR EACH ROW
BEGIN
	SET NEW.FECHA_CREACION = NOW();
END $$

CREATE TRIGGER TRG_ALQUILERES_UPDATE_AUDITORIA
BEFORE UPDATE ON alquileres
FOR EACH ROW
BEGIN
	SET NEW.FECHA_MODIFICACION = NOW();
END $$

/*CHATS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_CHATS_INSERT_CREACION
BEFORE INSERT ON chats
FOR EACH ROW
BEGIN
	SET NEW.FECHA_CREACION = NOW();
END $$

CREATE TRIGGER TRG_CHATS_UPDATE_AUDITORIA
BEFORE UPDATE ON chats
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
END $$



/*COMPROBANTES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_COMPROBANTES_INSERT_CREACION
BEFORE INSERT ON comprobantes
FOR EACH ROW
BEGIN
	SET NEW.FECHA_EMISION = NOW();
END $$

CREATE TRIGGER TRG_COMPROBANTES_UPDATE_AUDITORIA
BEFORE UPDATE ON comprobantes
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICIACION = CURRENT_USER();
END $$	



/*DETALLES_COMPROBANTES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
-- no se considera trigger de inserción

CREATE TRIGGER TRG_DETALLES_COMPROBANTES_UPDATE_AUDITORIA
BEFORE UPDATE ON detalles_comprobantes
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER(); 
END $$

/*HISTORIAS_PUBLICACIONES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
-- no considere trigger de inserción

CREATE TRIGGER TRG_HISTORIAS_PUBLICACIONES_AUDITORIA
BEFORE INSERT ON historias_publicaciones
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
END $$

/*INCIDENCIAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_INCIDENCIAS_CREACION
BEFORE INSERT ON incidencias
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
END $$

CREATE TRIGGER TRG_INCIDENCIAS_AUDITORIA
BEFORE UPDATE ON incidencias
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    IF NEW.RESUELTO = 1 THEN
        SET NEW.FECHA_SOLUCION = NOW();
    END IF;
END $$

/*PERSONAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_PERSONAS_CREACION
BEFORE INSERT ON personas
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
END $$

CREATE TRIGGER TRG_PERSONAS_AUDITORIA
BEFORE UPDATE ON personas
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
END $$

/*PUBLICACIONES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_PUBLICACIONES_CREACION
BEFORE INSERT ON publicaciones
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_ALTA = NOW();
END $$

CREATE TRIGGER TRG_PUBLICACIONES_BAJA
BEFORE UPDATE ON publicaciones
FOR EACH ROW
BEGIN
    IF NEW.ESTADO_PUBLICACION_ID = 4 THEN
        SET NEW.FECHA_BAJA = NOW();
    END IF;
END $$

/*MENSAJES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_MENSAJES_CREACION
BEFORE INSERT ON mensajes
FOR EACH ROW 
BEGIN
	IF NEW.ESTADO_MSJ_ID = 1 THEN
        SET NEW.FECHA_ENVIO = NOW();
    END IF;
END $$

CREATE TRIGGER TRG_MENSAJES_LEIDO
BEFORE UPDATE ON mensajes
FOR EACH ROW
BEGIN
    IF NEW.ESTADO_MSJ_ID = 3 THEN
        SET NEW.FECHA_LEIDO = NOW();
    END IF;
END $$

/*NOTIFICACIONES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_NOTIFICACIONES_CREACION
BEFORE INSERT ON notificaciones
FOR EACH ROW 
BEGIN
	SET NEW.FECHA = NOW();
END $$

DELIMITER ;