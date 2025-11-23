USE [mydb];
GO

-- Variable para el usuario (se debe declarar primero por ser SSQL)
DECLARE @admin_user VARCHAR(100) = 'root';

-- -----------------------------------------------------
-- GRUPO 1: CATÁLOGOS SIMPLES 
-- -----------------------------------------------------

-- Insertar colores
INSERT INTO dbo.colores(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Rojo', @admin_user, GETDATE()),
('Azul', @admin_user, GETDATE()),
('Negro', @admin_user, GETDATE()),
('No aplica', @admin_user, GETDATE());

-- Insertar condiciones
INSERT INTO dbo.condiciones(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Nuevo', @admin_user, GETDATE()),
('Seminuevo', @admin_user, GETDATE()),
('Antiguo', @admin_user, GETDATE()),
('No aplica', @admin_user, GETDATE());

-- Insertar estados de item
INSERT INTO dbo.estados_items(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Disponible', @admin_user, GETDATE()),
('Alquilado', @admin_user, GETDATE()),
('Vendido', @admin_user, GETDATE());

-- Insertar formatos
INSERT INTO dbo.formatos(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Físico', @admin_user, GETDATE()),
('Digital', @admin_user, GETDATE());

-- Insertar categorías
INSERT INTO dbo.categorias(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Libros', @admin_user, GETDATE()),
('Cursos', @admin_user, GETDATE()),
('Apuntes de clase', @admin_user, GETDATE()),
('Clase grabada', @admin_user, GETDATE()),
('Instrumentos', @admin_user, GETDATE()),
('Otros', @admin_user, GETDATE());

-- Insertar tamaños
INSERT INTO dbo.tamanos(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Grande', @admin_user, GETDATE()),
('Mediano', @admin_user, GETDATE()),
('Chico', @admin_user, GETDATE()),
('No aplica', @admin_user, GETDATE());

-- Insertar estados de persona
INSERT INTO dbo.estados_personas(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Activo', @admin_user, GETDATE()),
('Suspendido', @admin_user, GETDATE()),
('Eliminado', @admin_user, GETDATE());

-- Insertar roles
INSERT INTO dbo.roles(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Usuario', @admin_user, GETDATE()),
('Administrador', @admin_user, GETDATE());

-- Insertar catálogos de pago
INSERT INTO dbo.formas_pago(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES 
('Tarjeta de Crédito', @admin_user, GETDATE()),
('Yape', @admin_user, GETDATE());

INSERT INTO dbo.monedas(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES 
('Soles', @admin_user, GETDATE()),
('Dólares', @admin_user, GETDATE()),
('Euros', @admin_user, GETDATE());

INSERT INTO dbo.estados_publicaciones(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES 
('Pendiente', @admin_user, GETDATE()),
('Aprobada', @admin_user, GETDATE()),
('Rechazada', @admin_user, GETDATE()),
('Eliminada', @admin_user, GETDATE()),
('Borrador', @admin_user, GETDATE()),
('Transaccionada', @admin_user, GETDATE());

INSERT INTO dbo.estados_chats(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES 
('Activo', @admin_user, GETDATE()),
('Eliminado', @admin_user, GETDATE());

INSERT INTO dbo.estados_mensajes(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES 
('Enviado', @admin_user, GETDATE()),
('Recibido', @admin_user, GETDATE()),
('Leido', @admin_user, GETDATE());

INSERT INTO dbo.motivos(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES 
('Suspención de cuenta', @admin_user, GETDATE()),
('Rechazo de publicación', @admin_user, GETDATE()),
('Aceptación de publicación', @admin_user, GETDATE()),
('Nueva incidencia', @admin_user, GETDATE()),
('Solución de incidencia', @admin_user, GETDATE()),
('Datos incorrectos', @admin_user, GETDATE()),
('Problemas con otro usuario', @admin_user, GETDATE()),
('Problemas con la venta', @admin_user, GETDATE()),
('Problemas con el alquiler', @admin_user, GETDATE());

-- -----------------------------------------------------
-- GRUPO 2: DEPENDENCIAS
-- -----------------------------------------------------
INSERT INTO dbo.subcategorias (NOMBRE, CATEGORIA_ID, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Académico', 1, @admin_user, GETDATE()),
('Científico', 1, @admin_user, GETDATE()),
('Literario', 1, @admin_user, GETDATE()),
('Técnico', 1, @admin_user, GETDATE()),
('Arte y Cultura', 1, @admin_user, GETDATE()),
('Historia', 1, @admin_user, GETDATE()),
('Filosofía y Ensayo', 1, @admin_user, GETDATE()),
('Otros', 1, @admin_user, GETDATE()),
('Practica calificada', 2, @admin_user, GETDATE()),
('Practica dirigida', 2, @admin_user, GETDATE()),
('Examen ', 2, @admin_user, GETDATE()),
('Laboratorio', 2, @admin_user, GETDATE()),
('Apuntes de clase', 3, @admin_user, GETDATE()),
('Resumenes', 3, @admin_user, GETDATE()),
('Guias de practica', 3, @admin_user, GETDATE()),
('Otros', 3, @admin_user, GETDATE()),
('Estudios generales ciencias', 4, @admin_user, GETDATE()),
('Estudios generales letras', 4, @admin_user, GETDATE()),
('Facultad de ciencias e ingineria', 4, @admin_user, GETDATE()),
('Facultad de economia', 4, @admin_user, GETDATE()),
('Facultad de derecho', 4, @admin_user, GETDATE()),
('Facultad psicologia', 4, @admin_user, GETDATE()),
('Facultad gestión y alta dirección', 4, @admin_user, GETDATE()),
('Facultad educación', 4, @admin_user, GETDATE()),
('Facultad ciencias sociales', 4, @admin_user, GETDATE()),
('Facultad comunicación', 4, @admin_user, GETDATE()),
('Facultad artes', 4, @admin_user, GETDATE()),
('Facultad arquitectura', 4, @admin_user, GETDATE()),
('Facultad ciencias sociales', 4, @admin_user, GETDATE()),
('Cálculo y medición', 5, @admin_user, GETDATE()),
('Dibujo técnico', 5, @admin_user, GETDATE()),
('Accesorios electrónicos', 5, @admin_user, GETDATE()),
('Laboratorio químico', 5, @admin_user, GETDATE()),
('Arte y diseño', 5, @admin_user, GETDATE()),
('Otros', 5, @admin_user, GETDATE()),
('Accesorios', 6, @admin_user, GETDATE()),
('Mochila', 6, @admin_user, GETDATE()),
('Prenda de vestir', 6, @admin_user, GETDATE());


-- -----------------------------------------------------
-- GRUPO 3: DATOS PRINCIPALES (Personas e Items)
-- -----------------------------------------------------
INSERT INTO dbo.personas(
 NOMBRES, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CODIGO, CORREO, CONTRASENA,ESTADO_PERSONA_ID_ESTADOPERSONA,USUARIO_CREACION,ULTIMA_ACTIVIDAD, FECHA_CREACION)
VALUES
('María Fernanda', 'Lopez', 'Ramirez', '20231547', 'a20231547@pucp.edu.pe','Spvo5ABNInGO7Gg2aeqQBg==',1,'María Fernanda Lopez Ramirez',GETDATE(), GETDATE()),
('José Luis', 'Castro', 'Vargas', '20228459', 'a20228459@pucp.edu.pe','hlVjUau1t7ERxvFnjNVMCQ==',2,'José Luis Castro Vargas',GETDATE(), GETDATE()),
('Andrea Carolina', 'Torres', 'Mendoza', '20235681', 'a20235681@pucp.edu.pe','3FcGRQ5NUzDyfiDsrsVJvcgnPicDD/5b',3,'Andrea Carolina Torres Mendoza',GETDATE(), GETDATE()),
('Diego Armando', 'Quispe', 'Huamán', '20217732', 'a20217732@pucp.edu.pe','A3YQJaMQou2v86QND4NUPQ==',1,'Diego Armando Quispe Huamán',GETDATE(), GETDATE()),
('Lucía Alejandra', 'Salazar', 'Flores', '20229418', 'a20229418@pucp.edu.pe','fjEtTSbThzPXqY3tlBk1ug==',2,'Lucía Alejandra Salazar Flores',GETDATE(), GETDATE()),
('Carlos Alberto', 'Rojas', 'Cáceres', '20219845', 'a20219845@pucp.edu.pe','3rGB9O3A7pqO7Gg2aeqQBg==',3,'Carlos Alberto Rojas Cáceres',GETDATE(), GETDATE()),
('Gabriela Sofía', 'Paredes', 'Chavez', '20237591', 'a20237591@pucp.edu.pe','XEWJN3g8qbQRxvFnjNVMCQ==',1,'Gabriela Sofía Paredes Chavez',GETDATE(), GETDATE()),
('Fernando Enrique', 'Huerta', 'Guzmán', '20226789', 'a20226789@pucp.edu.pe','PpFdTTMZhHUJTDRcFKJL3A==',2,'Fernando Enrique Huerta Guzmán',GETDATE(), GETDATE()),
('Valeria Isabel', 'Martínez', 'Zamora', '20231852', 'a20231852@pucp.edu.pe','wbQcLGtNYAwRxvFnjNVMCQ==',3,'Valeria Isabel Martínez Zamora',GETDATE(), GETDATE()),
('Santiago Nicolás', 'Gonzales', 'Linares', '20238417', 'a20238417@pucp.edu.pe','eeXeaiIyr1QJTDRcFKJL3A==',1,'Santiago Nicolás Gonzales Linares',GETDATE(), GETDATE());

INSERT INTO dbo.items(
    COLOR_ID, ESTADO_ITEM_ID, CONDICION_ID, TAMANO_ID, FORMATO_ID, 
    subcategoria_ID_SUBCATEGORIA, subcategoria_CATEGORIA_ID,
    NOMBRE, DESCRIPCION, PRECIO, ES_VENTA,
    USUARIO_CREACION, FECHA_CREACION
) VALUES 
(3, 1, 1, 2, 1, 1, 1, 'FISICA 1', 'Apuntes del curso Fisica 1', 15.00, 1, 'José Luis Castro Vargas', GETDATE()),
(2, 1, 1, 3, 1, 1, 1, 'PROGRAMACION 3', 'Libro de Programación 3', 25.00, 1, 'Andrea Carolina Torres Mendoza', GETDATE()),
(1, 1, 2, 2, 1, 1, 1, 'QUIMICA BASICA', 'Material adicional de Química', 35.00, 1, 'Diego Armando Quispe Huamán', GETDATE()),
(2, 1, 1, 2, 2, 1, 1, 'LIBRO DE MATEMATICA', 'Calculadora científica', 20.00, 1, 'Lucía Alejandra Salazar Flores', GETDATE()),
(2, 2, 1, 2, 2, 1, 1, 'MATEMATICA AVANZADA', 'Cuaderno de ejercicios Matemática', 10.00, 1, 'Carlos Alberto Rojas Cáceres', GETDATE()),
(3, 1, 1, 2, 1, 1, 1, 'FISICA AVANZADA', 'Guía de temas para el examen de Física', 40.00, 1, 'Gabriela Sofía Paredes Chavez', GETDATE()),
(3, 1, 1, 3, 1, 1, 1, 'ALGEBRA GEOMETRIA', 'Texto sobre álgebra y geometría', 30.00, 1, 'Fernando Enrique Huerta Guzmán', GETDATE()),
(1, 1, 1, 2, 2, 1, 1, 'HISTORIA 2', 'Notas de clase Historia 2', 22.50, 1, 'Valeria Isabel Martínez Zamora', GETDATE()),
(3, 1, 2, 3, 1, 1, 1, 'BIOLOGIA AVANZADA', 'Libro de Biología Avanzada', 50.00, 1, 'Gabriela Sofía Paredes Chavez', GETDATE()),
(1, 1, 1, 2, 2, 1, 1, 'PSICOLOGIA BASICA', 'Material didáctico Psicología', 60.00, 1, 'José Luis Castro Vargas', GETDATE());

-- Insertar un nuevo chat
INSERT INTO dbo.chats (
    estado_chat_ID_ESTADOCHAT,USUARIO_CREACION, FECHA_CREACION
)
VALUES 
(1,@admin_user, GETDATE()),
(2,@admin_user, GETDATE()),
(1,@admin_user, GETDATE()),
(2,@admin_user, GETDATE());

-- -----------------------------------------------------
-- GRUPO 4: RELACIONES M-M (Muchos-a-Muchos)
-- -----------------------------------------------------
INSERT INTO dbo.personas_roles(PERSONA_ID, ROLPERSONA_ID, USUARIO_CREACION, FECHA_CREACION) VALUES
(1, 2, @admin_user, GETDATE()),
(2, 2, @admin_user, GETDATE()),
(3, 1, @admin_user, GETDATE()),
(4, 1, @admin_user, GETDATE()),
(5, 1, @admin_user, GETDATE()),
(6, 2, @admin_user, GETDATE()),
(7, 1, @admin_user, GETDATE()),
(8, 1, @admin_user, GETDATE()),
(9, 1, @admin_user, GETDATE()),
(10, 1, @admin_user, GETDATE());

-- -----------------------------------------------------
-- GRUPO 5: TRANSACCIONES (Publicaciones, Alquileres, etc.)
-- -----------------------------------------------------
INSERT INTO dbo.publicaciones(
    ESTADO_PUBLICACION_ID, ITEM_ID_ITEM, PERSONA_ID, CALIFICACION, USUARIO_CREACION, FECHA_CREACION
) VALUES 
(1, 1, 2, 4, 'José Luis Castro Vargas', GETDATE()),
(2, 2, 3, 5, 'Andrea Carolina Torres Mendoza', GETDATE()),
(1, 3, 4, 3, 'Diego Armando Quispe Huamán', GETDATE()),
(2, 4, 5, 4, 'Lucía Alejandra Salazar Flores', GETDATE()),
(1, 5, 6, 2, 'Carlos Alberto Rojas Cáceres', GETDATE()),
(2, 6, 7, 3, 'Gabriela Sofía Paredes Chavez', GETDATE()),
(1, 7, 8, 5, 'Fernando Enrique Huerta Guzmán', GETDATE()),
(2, 8, 9, 4, 'Valeria Isabel Martínez Zamora', GETDATE()),
(1, 9, 7, 4, 'Gabriela Sofía Paredes Chavez', GETDATE()),
(2, 10, 2, 5, 'José Luis Castro Vargas', GETDATE());

INSERT INTO dbo.alquileres(
    PERSONA_ID, ITEM_ID, FECHA_INICIO, MONTO, DEVUELTO, USUARIO_CREACION, FECHA_CREACION
) VALUES (
    2, 1, GETDATE(), 15.00, 0, @admin_user, GETDATE() 
);


INSERT INTO dbo.comprobantes(
    PERSONA_ID_PERSONA, FORMA_PAGO_ID_FORMAPAGO, MONEDA_ID_MONEDA,
    TRANSACCION_ID,MONTO, IMPUESTO,
    USUARIO_CREACION, FECHA_CREACION
) VALUES 
(2, 1, 1, 'TXN_12345ABC', 15.00, 2.70,'José Luis Castro Vargas', GETDATE()),
(2, 2, 2, 'TXN_002', 25.00, 4.50,'José Luis Castro Vargas', GETDATE()),
(3, 1, 1, 'TXN_003', 35.00, 9.00,'Andrea Carolina Torres Mendoza', GETDATE()),
(4, 2, 3, 'TXN_004', 20.00, 15.00,'Diego Armando Quispe Huamán', GETDATE()),
(5, 1, 2, 'TXN_005', 10.00, 6.00,'Lucía Alejandra Salazar Flores', GETDATE()),
(6, 1, 1, 'TXN_006', 40.00, 7.50,'Carlos Alberto Rojas Cáceres', GETDATE()),
(7, 2, 3, 'TXN_007', 30.00, 3.00,'Gabriela Sofía Paredes Chavez', GETDATE()),
(8, 1, 2, 'TXN_008', 22.50, 12.00,'Fernando Enrique Huerta Guzmán', GETDATE()),
(9, 2, 1, 'TXN_009', 50.00, 6.00,'Valeria Isabel Martínez Zamora', GETDATE()),
(10, 1, 1, 'TXN_010', 60.00, 18.00,'Santiago Nicolás Gonzales Linares', GETDATE());

-- Insertar más alquileres
INSERT INTO dbo.alquileres(
    PERSONA_ID, ITEM_ID, FECHA_INICIO, FECHA_FIN, MONTO, DEVUELTO, USUARIO_CREACION, FECHA_CREACION
) VALUES 
(2, 1, GETDATE(), NULL, 15.00, 0, @admin_user, GETDATE()),
(2, 2, GETDATE(), NULL, 25.00, 0, @admin_user, GETDATE()),
(3, 3, GETDATE(), NULL, 35.00, 0, @admin_user, GETDATE()),
(4, 4, GETDATE(), NULL, 20.00, 0, @admin_user, GETDATE()),
(5, 5, GETDATE(), NULL, 10.00, 0, @admin_user, GETDATE()),
(6, 6, GETDATE(), NULL, 40.00, 0, @admin_user, GETDATE()),
(7, 7, GETDATE(), NULL, 30.00, 0, @admin_user, GETDATE()),
(8, 8, GETDATE(), NULL, 22.50, 0, @admin_user, GETDATE()),
(9, 9, GETDATE(), NULL, 50.00, 0, @admin_user, GETDATE()),
(2, 10, GETDATE(), NULL, 60.00, 0, @admin_user, GETDATE());

-- Insertar Detalle de Comprobante 
INSERT INTO dbo.detalles_comprobantes(
    COMPROBANTE_ID_COMPROBANTE, ALQUILER_ID_ALQUILER, ITEM_ID_ITEM,
    DESCRIPCION, PRECIO,
    USUARIO_CREACION, FECHA_CREACION
) VALUES 
(1, 1, 1, 'Apuntes del curso Fisica 1', 15.00,'José Luis Castro Vargas', GETDATE()),
(2, 2, 1, 'Libro de Programación 3', 25.00,'José Luis Castro Vargas', GETDATE()),
(3, 3, 1, 'Material adicional de Química', 35.00,'Andrea Carolina Torres Mendoza', GETDATE()),
(4, 4, 1, 'Calculadora científica', 20.00,'Diego Armando Quispe Huamán', GETDATE()),
(5, 5, 1, 'Cuaderno de ejercicios Matemática', 10.00,'Lucía Alejandra Salazar Flores', GETDATE()),
(6, 6, 1, 'Guía de temas para el examen de Física', 40.00,'Carlos Alberto Rojas Cáceres', GETDATE()),
(7, 7, 1, 'Texto sobre álgebra y geometría', 30.00,'Gabriela Sofía Paredes Chavez', GETDATE()),
(8, 8, 1, 'Notas de clase Historia 2', 22.50,'Fernando Enrique Huerta Guzmán', GETDATE()),
(9, 9, 1, 'Libro de Biología Avanzada', 50.00,'Valeria Isabel Martínez Zamora', GETDATE()),
(10, 10, 1, 'Material didáctico Psicología', 60.00,'Santiago Nicolás Gonzales Linares', GETDATE());

-- Mensajes para los chats previos
INSERT INTO dbo.mensajes(
    CHAT_ID_CHAT, ESTADO_MSJ_ID, PERSONA_ID, 
    FECHA_ENVIO, FECHA_LEIDO, MENSAJE, USUARIO_CREACION, FECHA_CREACION
) VALUES 
(1, 1, 2, GETDATE(), NULL, 'Hola, ¿cómo estás?',@admin_user, GETDATE()), 
(1, 1, 1, GETDATE(), NULL, '¡Hola! Todo bien, ¿y tú?',@admin_user, GETDATE()), 
(2, 2, 3, GETDATE(), NULL, 'Este es un mensaje de prueba.',@admin_user, GETDATE()), 
(1, 1, 1, GETDATE(), NULL, 'Recuerda estudiar para el examen de física.',@admin_user, GETDATE()), 
(3, 1, 4, GETDATE(), NULL, '¿Nos vemos mañana?', @admin_user, GETDATE()), 
(3, 2, 3, GETDATE(), NULL, 'Aquí tienes el archivo que me pediste.',@admin_user, GETDATE()), 
(3, 1, 4, GETDATE(), NULL, '¿Puedo ayudarte con algo?', @admin_user, GETDATE()), 
(4, 1, 5, GETDATE(), NULL, 'Hola, ¿ya terminaste el informe?', @admin_user, GETDATE()), 
(4, 1, 6, GETDATE(), NULL, 'Sí, ya lo terminé, lo enviaré mañana.',@admin_user, GETDATE()), 
(4, 1, 5, GETDATE(), NULL, 'Confirmado, nos vemos a las 3 PM.',@admin_user, GETDATE());

-- Notificaciones enviadas
INSERT INTO dbo.notificaciones(
    PERSONA_ID, FECHA, MENSAJE
) VALUES 
(2, GETDATE(), 'Tu cuenta ha sido suspendida temporalmente.'), 
(3, GETDATE(), 'Tu publicación ha sido rechazada debido a los criterios de calidad.'), 
(4, GETDATE(), 'Tu publicación ha sido aceptada y ahora está visible en el sistema.'), 
(5, GETDATE(), 'Se ha creado una nueva incidencia relacionada con tu solicitud.'), 
(6, GETDATE(), 'La incidencia que reportaste ha sido solucionada con éxito.'), 
(7, GETDATE(), 'Los datos que proporcionaste no son correctos, por favor actualízalos.'), 
(8, GETDATE(), 'Se han reportado problemas con otro usuario en tu cuenta, por favor revisa.'), 
(9, GETDATE(), 'Se ha identificado un problema con la venta que realizaste, por favor contáctanos.'), 
(10, GETDATE(), 'Existen problemas con el alquiler asociado a tu cuenta, por favor revisa los detalles.'), 
(3, GETDATE(), 'Tu cuenta tiene datos incorrectos, actualiza la información para continuar.');

-- Incidencias para los eventos
INSERT INTO dbo.incidencias(
    PERSONA_ID, MOTIVO_ID_MOTIVO,
    DESCRIPCION,RESPUESTA_ADMIN, RESUELTO, 
    FECHA_SOLUCION, USUARIO_SOLUCION,
    USUARIO_CREACION, FECHA_CREACION
) VALUES 
-- Incidencia 1: (Reporta Persona 5, Motivo 4)
(5, 4, 'El usuario no responde los mensajes.','Cuenta suspendida', 0, NULL, NULL, @admin_user, GETDATE()),
-- Incidencia 2: (Reporta Persona 8, Motivo 7) - RESUELTA
(8, 7, 'El vendedor entregó un libro dañado.','Cuenta suspendida', 1, GETDATE(), 3, @admin_user, GETDATE()),
-- Incidencia 3: (Reporta Persona 9, Motivo 8)
(9, 8, 'El pago de mi venta fue duplicado.','Se le hara la devolución del cargo adicional', 0, NULL, NULL, @admin_user, GETDATE()),
-- Incidencia 4: (Reporta Persona 10, Motivo 9)
(10, 9, 'No puedo contactar al dueño del item.','Se le informo al vendedor a su cuenta', 0, NULL, NULL, @admin_user, GETDATE());
GO