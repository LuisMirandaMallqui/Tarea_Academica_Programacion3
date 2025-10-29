
DELIMITER $$
/*CATEGORIAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_CATEGORIAS_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_CATEGORIAS_UPDATE_AUDITORIA $$

/*COLORES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_COLORES_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_COLORES_UPDATE_AUDITORIA $$

/*CONDICIONES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_CONDICIONES_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_CONDICIONES_UPDATE_AUDITORIA $$

/*ESTADOS_CHATS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_ESTADOS_CHATS_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_ESTADOS_CHATS_UPDATE_AUDITORIA $$

/*ESTADOS_ITEMS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_ESTADOS_ITEMS_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_ESTADOS_ITEMS_UPDATE_AUDITORIA $$

/*ESTADOS_MENSAJES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_ESTADOS_MENSAJES_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_ESTADOS_MENSAJES_UPDATE_AUDITORIA $$

/*ESTADOS_PERSONAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_ESTADOS_PERSONAS_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_ESTADOS_PERSONAS_UPDATE_AUDITORIA $$

/*ESTADOS_PUBLICACIONES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_ESTADOS_PUBLICACIONES_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_ESTADOS_PUBLICACIONES_UPDATE_AUDITORIA $$

/*FORMAS_PAGO*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_FORMAS_PAGO_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_FORMAS_PAGO_UPDATE_AUDITORIA $$

/*FORMATOS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_FORMATOS_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_FORMATOS_UPDATE_AUDITORIA $$

/*MONEDAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_MONEDAS_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_MONEDAS_UPDATE_AUDITORIA $$

/*MOTIVOS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_MOTIVOS_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_MOTIVOS_UPDATE_AUDITORIA $$

/*PERSONAS_ROLES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_PERSONAS_ROLES_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_PERSONAS_ROLES_UPDATE_AUDITORIA $$

/*SUBCATEGORIAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_SUBCATEGORIAS_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_SUBCATEGORIAS_UPDATE_AUDITORIA $$

/*TAMANOS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_TAMANOS_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_TAMANOS_UPDATE_AUDITORIA $$

/*ALQUILERES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_ALQUILERES_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_ALQUILERES_UPDATE_AUDITORIA $$

/*CHATS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_CHATS_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_CHATS_UPDATE_AUDITORIA $$

/*COMPROBANTES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_COMPROBANTES_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_COMPROBANTES_UPDATE_AUDITORIA $$

/*DETALLES_COMPROBANTES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_DETALLES_COMPROBANTES_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_DETALLES_COMPROBANTES_UPDATE_AUDITORIA $$

/*HISTORIAS_PUBLICACIONES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_HISTORIAS_PUBLICACIONES_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_HISTORIAS_PUBLICACIONES_UPDATE_AUDITORIA $$

/*INCIDENCIAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_INCIDENCIAS_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_INCIDENCIAS_UPDATE_AUDITORIA $$

/*PERSONAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_PERSONAS_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_PERSONAS_UPDATE_AUDITORIA $$

/*PUBLICACIONES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_PUBLICACIONES_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_PUBLICACIONES_UPDATE_AUDITORIA $$ 
DROP TRIGGER IF EXISTS TRG_PUBLICACIONES_UPDATE_BAJA $$

/*MENSAJES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_MENSAJES_INSERT_CREACION $$ 
DROP TRIGGER IF EXISTS TRG_MENSAJES_UPDATE_LEIDO $$

/*NOTIFICACIONES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TRIGGER IF EXISTS TRG_NOTIFICACIONES_UPDATE_AUDITORIA $$

/*ITEMS*/
DROP TRIGGER IF EXISTS TRG_ITEMS_INSERT_CREACION $$
DROP TRIGGER IF EXISTS TRG_ITEMS_UPDATE_AUDITORIA $$

/*ROLES*/
DROP TRIGGER IF EXISTS TRG_ROLES_INSERT_CREACION $$
DROP TRIGGER IF EXISTS TRG_ROLES_UPDATE_AUDITORIA $$
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
CREATE TRIGGER TRG_FORMAS_PAGO_INSERT_CREACION
BEFORE INSERT ON formas_pago
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
	SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_FORMAS_PAGO_UPDATE_AUDITORIA
BEFORE UPDATE ON formas_pago
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*FORMATOS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_FORMATOS_INSERT_CREACION
BEFORE INSERT ON formatos
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_FORMATOS_UPDATE_AUDITORIA
BEFORE UPDATE ON formatos
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*MONEDAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_MONEDAS_INSERT_CREACION
BEFORE INSERT ON monedas
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
	SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_MONEDAS_UPDATE_AUDITORIA
BEFORE UPDATE ON monedas
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION =  CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*MOTIVOS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_MOTIVOS_INSERT_CREACION
BEFORE INSERT ON motivos
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_MOTIVOS_UPDATE_AUDITORIA
BEFORE UPDATE ON motivos
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*PERSONAS_ROLES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_PERSONAS_ROLES_INSERT_CREACION
BEFORE INSERT ON personas_roles
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_PERSONAS_ROLES_UPDATE_AUDITORIA
BEFORE UPDATE ON personas_roles
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*SUBCATEGORIAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_SUBCATEGORIAS_INSERT_CREACION
BEFORE INSERT ON subcategorias
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_SUBCATEGORIAS_UPDATE_AUDITORIA
BEFORE UPDATE ON subcategorias
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*TAMANOS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_TAMANOS_INSERT_CREACION
BEFORE INSERT ON tamanos
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
	SET NEW.USUARIO_CREACION = CURRENT_USER();
END $$

CREATE TRIGGER TRG_TAMANOS_UPDATE_AUDITORIA
BEFORE UPDATE ON tamanos
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$


/*ALQUILERES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
-- no se considera creacion, se llena desde front

CREATE TRIGGER TRG_ALQUILERES_UPDATE_AUDITORIA
BEFORE UPDATE ON alquileres
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();-- TRACKEAR AL USUARIO QUE MODIFICA LA ENTRADA
END $$

/*CHATS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------

/*COMPROBANTES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_COMPROBANTES_INSERT_CREACION
BEFORE INSERT ON comprobantes
FOR EACH ROW
BEGIN
	SET NEW.FECHA_CREACION = NOW();
	-- Usuario_creacion viene desde el frente 
END $$

CREATE TRIGGER TRG_COMPROBANTES_UPDATE_AUDITORIA
BEFORE UPDATE ON comprobantes
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();
END $$	



/*DETALLES_COMPROBANTES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_DETALLES_COMPROBANTES_INSERT_CREACION
BEFORE INSERT ON detalles_comprobantes
FOR EACH ROW
BEGIN
	SET NEW.FECHA_CREACION = NOW();
	-- Usuario_creacion viene desde el frente 
END $$

CREATE TRIGGER TRG_DETALLES_COMPROBANTES_UPDATE_AUDITORIA
BEFORE UPDATE ON detalles_comprobantes
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER(); 
END $$

/*HISTORIAS_PUBLICACIONES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_HISTORIAS_PUBLICACIONES_INSERT_CREACION
BEFORE INSERT ON historias_publicaciones
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    SET NEW.USUARIO_CREACION = NEW.USUARIO_MODIFICACION_PUBLICACION;
END $$

CREATE TRIGGER TRG_HISTORIAS_PUBLICACIONES_UPDATE_AUDITORIA
BEFORE UPDATE ON historias_publicaciones
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();
END $$

/*INCIDENCIAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_INCIDENCIAS_INSERT_CREACION
BEFORE INSERT ON incidencias
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
	-- Usuario_creacion viene desde el frente
END $$

CREATE TRIGGER TRG_INCIDENCIAS_UPDATE_AUDITORIA
BEFORE UPDATE ON incidencias
FOR EACH ROW
BEGIN
    IF NEW.RESUELTO <> OLD.RESUELTO THEN
		IF NEW.RESUELTO = 1 THEN
			SET NEW.FECHA_SOLUCION = NOW();
		END IF;
	END IF;    
    SET NEW.FECHA_MODIFICACION = NOW();
	SET NEW.USUARIO_MODIFICACION = CURRENT_USER();
END $$

/*PERSONAS*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_PERSONAS_INSERT_CREACION
BEFORE INSERT ON personas
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    -- Usuario creacion del front 
END $$

CREATE TRIGGER TRG_PERSONAS_UPDATE_AUDITORIA
BEFORE UPDATE ON personas
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
	SET NEW.USUARIO_MODIFICACION = CURRENT_USER(); 
END $$

/*PUBLICACIONES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_PUBLICACIONES_INSERT_CREACION
BEFORE INSERT ON publicaciones
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
    -- viene desde el frente
END $$

CREATE TRIGGER TRG_PUBLICACIONES_UPDATE_AUDITORIA
BEFORE UPDATE ON publicaciones
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER(); 
END $$

CREATE TRIGGER TRG_PUBLICACIONES_UPDATE_BAJA
BEFORE UPDATE ON publicaciones
FOR EACH ROW
BEGIN
	DECLARE v_id_aprobado  INT;
    IF NEW.ESTADO_PUBLICACION_ID <> OLD.ESTADO_PUBLICACION_ID THEN
		SELECT ep.ESTADOPUBLI_ID
			INTO v_id_aprobado
			FROM estados_publicaciones ep
		WHERE UPPER(ep.NOMBRE) IN ('Eliminada')
		LIMIT 1;
		IF v_id_aprobado IS NOT NULL AND NEW.ESTADO_PUBLICACION_ID = v_id_aprobado THEN
            SET NEW.FECHA_BAJA = NOW();
		END IF;
	END IF;
END $$

/*MENSAJES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_MENSAJES_INSERT_CREACION
BEFORE INSERT ON mensajes
FOR EACH ROW 
BEGIN
	IF NEW.ESTADO_MSJ_ID = 1 THEN
        SET NEW.FECHA_ENVIO = NOW();
    END IF;
END $$

CREATE TRIGGER TRG_MENSAJES_UPDATE_LEIDO
BEFORE UPDATE ON mensajes
FOR EACH ROW
BEGIN
    IF NEW.ESTADO_MSJ_ID = 3 THEN
        SET NEW.FECHA_LEIDO = NOW();
    END IF;
END $$

/*NOTIFICACIONES*/ -- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TRIGGER TRG_NOTIFICACIONES_UPDATE_AUDITORIA
BEFORE UPDATE ON notificaciones
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();    
END $$

/*ITEMS*/
CREATE TRIGGER TRG_ITEMS_INSERT_CREACION
BEFORE INSERT ON items
FOR EACH ROW 
BEGIN
	SET NEW.FECHA_CREACION = NOW();
	-- Usuario_crecion viene desde el front
END $$

CREATE TRIGGER TRG_ITEMS_UPDATE_AUDITORIA
BEFORE UPDATE ON items
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();
END $$

/*ROLES*/
CREATE TRIGGER TRG_ROLES_INSERT_CREACION
BEFORE INSERT ON roles
FOR EACH ROW 
BEGIN
	SET NEW.USUARIO_CREACION = CURRENT_USER();
	SET NEW.FECHA_CREACION = NOW();
END $$

CREATE TRIGGER TRG_ROLES_UPDATE_AUDITORIA
BEFORE UPDATE ON roles
FOR EACH ROW
BEGIN
   	SET NEW.FECHA_MODIFICACION = NOW();
    SET NEW.USUARIO_MODIFICACION = CURRENT_USER();
END $$
DELIMITER ;