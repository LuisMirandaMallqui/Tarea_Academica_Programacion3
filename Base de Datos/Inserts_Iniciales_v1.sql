-- Variable para el usuario 
SET @admin_user = 'admin';

-- -----------------------------------------------------
-- GRUPO 1: CATÁLOGOS SIMPLES 
-- -----------------------------------------------------
-- Insertar colores
INSERT INTO colores(NOMBRE) VALUES
('Rojo'),
('Azul'),
('Negro');

 -- Insertar condiciones
INSERT INTO condiciones(NOMBRE) VALUES
('Nuevo'),
('Seminuevo'),
('Antiguo');

-- Insertar estados de item
INSERT INTO estados_items(NOMBRE) VALUES
('Disponible'),
('Alquilado'),
('Vendido');

-- Insertar formatos
INSERT INTO formatos(NOMBRE) VALUES
('Físico'),
('Digital');

-- Insertar categorías
INSERT INTO categorias(NOMBRE) VALUES
('Libros'),
('Evaluaciones'),
('Electrónicos'),
('Útiles y accesorios');
-- Insertar tamaños
INSERT INTO tamanos(NOMBRE) VALUES
('Grande'),
('Mediano'),
('Chico');

-- Insertar estados de persona
INSERT INTO estados_personas(NOMBRE) VALUES
('Activo'),
('Suspendido'),
('Eliminado');

-- Insertar roles
INSERT INTO roles(NOMBRE) VALUES
('Vendedor'),
('Comprador'),
('Administrador');

-- Insertar catálogos de pago
INSERT INTO formas_pago(NOMBRE) VALUES 
('Tarjeta de Crédito'),
('Yape');
INSERT INTO monedas(NOMBRE) VALUES 
('Soles'),
('Dólares'),
('Euros');
INSERT INTO estados_publicaciones(NOMBRE) VALUES 
('Pendiente'),
('Aprobada'),
('Rechazada'),
('Eliminada');
INSERT INTO estados_chats(NOMBRE) VALUES 
('Activo'),
('Eliminado');
INSERT INTO estados_mensajes(NOMBRE) VALUES 
('Enviado'),
('Recibido'),
('Leido');
INSERT INTO motivos(NOMBRE) VALUES 
('Suspención de cuenta'),
('Rechazo de publicación'),
('Aceptación de publicación'),
('Nueva incidencia'),
('Solución de incidencia'),
('Datos incorrectos'),
('Problemas con otro usuario'),
('Problemas con la venta'),
('Problemas con el alquiler');
-- -----------------------------------------------------
-- GRUPO 2: DEPENDENCIAS
-- -----------------------------------------------------
INSERT INTO subcategorias (NOMBRE, CATEGORIA_ID)
VALUES
('Ciencias e ingeniería', 1),
('Ciencias Sociales', 1),
('Artes y Humanidades', 1),
('Negocios y Gestión', 1),
('Idiomas', 1),
('Práctica calificada', 2),
('Práctica dirigida', 2),
('Exámen 1', 2),
('Exámen 2', 2),
('Exámen especial', 2),
('Control de lectura', 2),
('Calculadora', 3),
('Componente electrónico', 3),
('Multímetro', 3),
('Teclado', 3),
('Auriculares', 3),
('Mochila', 4),
('Estuche', 4),
('Material de escritorio', 4),
('Ropa', 4);


-- -----------------------------------------------------
-- GRUPO 3: DATOS PRINCIPALES (Personas e Items)
-- -----------------------------------------------------
INSERT INTO personas(
 NOMBRES, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CODIGO, CORREO, CONTRASENA,ESTADO_PERSONA_ID_ESTADOPERSONA)
VALUES
('María Fernanda', 'Lopez', 'Ramirez', '20231547', 'a20231547@pucp.edu.pe','pacoflaco123',1),
('José Luis', 'Castro', 'Vargas', '20228459', 'a20228459@pucp.edu.pe','joselu123',2),
('Andrea Carolina', 'Torres', 'Mendoza', '20235681', 'a20235681@pucp.edu.pe','andreatorres',3),
('Diego Armando', 'Quispe', 'Huamán', '20217732', 'a20217732@pucp.edu.pe','diegoquispe',1),
('Lucía Alejandra', 'Salazar', 'Flores', '20229418', 'a20229418@pucp.edu.pe','luciaalej',2),
('Carlos Alberto', 'Rojas', 'Cáceres', '20219845', 'a20219845@pucp.edu.pe','carlberto',3),
('Gabriela Sofía', 'Paredes', 'Chavez', '20237591', 'a20237591@pucp.edu.pe','gabsof',1),
('Fernando Enrique', 'Huerta', 'Guzmán', '20226789', 'a20226789@pucp.edu.pe','feriq',2),
('Valeria Isabel', 'Martínez', 'Zamora', '20231852', 'a20231852@pucp.edu.pe','valeri',3),
('Santiago Nicolás', 'Gonzales', 'Linares', '20238417', 'a20238417@pucp.edu.pe','santi123',1);

INSERT INTO items(
    COLOR_ID, ESTADO_ITEM_ID, CONDICION_ID, TAMANO_ID, FORMATO_ID, 
    subcategoria_ID_SUBCATEGORIA, subcategoria_CATEGORIA_ID,
    NOMBRE, DESCRIPCION, PRECIO, ES_VENTA
) VALUES    
(3, 1, 1, 2, 1, 1, 1, 'FISICA 1', 'Apuntes del curso Fisica 1', 15.00, 1),
(2, 1, 1, 3, 1, 1, 1, 'PROGRAMACION 3', 'Libro de Programación 3', 25.00, 1),
(1, 1, 2, 2, 1, 1, 1, 'QUIMICA BASICA', 'Material adicional de Química', 35.00, 1),
(2, 1, 1, 2, 2, 1, 1, 'LIBRO DE MATEMATICA', 'Calculadora científica', 20.00, 1),
(2, 2, 1, 2, 2, 1, 1, 'MATEMATICA AVANZADA', 'Cuaderno de ejercicios Matemática', 10.00, 1),
(3, 1, 1, 2, 1, 1, 1, 'FISICA AVANZADA', 'Guía de temas para el examen de Física', 40.00, 1),
(3, 1, 1, 3, 1, 1, 1, 'ALGEBRA GEOMETRIA', 'Texto sobre álgebra y geometría', 30.00, 1),
(1, 1, 1, 2, 2, 1, 1, 'HISTORIA 2', 'Notas de clase Historia 2', 22.50, 1),
(3, 1, 2, 3, 1, 1, 1, 'BIOLOGIA AVANZADA', 'Libro de Biología Avanzada', 50.00, 1),
(1, 1, 1, 2, 2, 1, 1, 'PSICOLOGIA BASICA', 'Material didáctico Psicología', 60.00, 1);
    
-- Insertar un nuevo chat (primera vez que se crea)
INSERT INTO chats (
    estado_chat_ID_ESTADOCHAT
)
VALUES 
(1),
(2),
(1),
(2);

-- -----------------------------------------------------
-- GRUPO 4: RELACIONES M-M (Muchos-a-Muchos)
-- -----------------------------------------------------
INSERT INTO personas_roles(PERSONA_ID, ROLPERSONA_ID) VALUES
(1, 1), 
(2, 2),
(3, 3),
(4, 1),
(5, 2),
(6, 3),
(7, 1),
(8, 2),
(9, 3),
(10, 1);

-- -----------------------------------------------------
-- GRUPO 5: TRANSACCIONES (Publicaciones, Alquileres, etc.)
-- -----------------------------------------------------
INSERT INTO publicaciones(
    ESTADO_PUBLICACION_ID, ITEM_ID_ITEM, PERSONA_ID, CALIFICACION, USUARIO_CREACION, FECHA_CREACION
) VALUES 
(1, 1, 2, 4),   -- Publicación 1, "FISICA 1", Persona 2, con calificación 4
(2, 2, 3, 5),   -- Publicación 2, "PROGRAMACION 3", Persona 3, con calificación 5
(1, 3, 4, 3),   -- Publicación 3, "QUIMICA BASICA", Persona 4, con calificación 3
(2, 4, 5, 4),   -- Publicación 4, "CALCULADORA CIENTIFICA", Persona 5, con calificación 4
(1, 5, 6, 2),   -- Publicación 5, "MATEMATICA AVANZADA", Persona 6, con calificación 2
(2, 6, 7, 3),   -- Publicación 6, "FISICA AVANZADA", Persona 7, con calificación 3
(1, 7, 8, 5),   -- Publicación 7, "ALGEBRA GEOMETRIA", Persona 8, con calificación 5
(2, 8, 9, 4),   -- Publicación 8, "HISTORIA 2", Persona 9, con calificación 4
(1, 9, 7,4),  -- Publicación 9, "BIOLOGIA AVANZADA", Persona 10, con calificación 4
(2, 10, 2, 5);  -- Publicación 10, "PSICOLOGIA BASICA", Persona 2, con calificación 5

INSERT INTO alquileres(
    PERSONA_ID, ITEM_ID, FECHA_INICIO, MONTO, DEVUELTO
) VALUES (
    2, 1, NOW(), 15.00, 0 
);


INSERT INTO comprobantes(
    PERSONA_ID_PERSONA, FORMA_PAGO_ID_FORMAPAGO, MONEDA_ID_MONEDA,
    TRANSACCION_ID,MONTO, IMPUESTO
) VALUES 
(2, 1, 1, 'TXN_12345ABC', 15.00, 2.70),  -- Persona 2, Tarjeta de Crédito, Soles
(2, 2, 2, 'TXN_002', 25.00, 4.50),      -- Persona 2, Yape, Dólares
(3, 1, 1, 'TXN_003', 35.00, 9.00),      -- Persona 3, Tarjeta de Crédito, Soles
(4, 2, 3, 'TXN_004', 20.00, 15.00),     -- Persona 4, Yape, Euros
(5, 1, 2, 'TXN_005', 10.00, 6.00),      -- Persona 5, Tarjeta de Crédito, Dólares
(6, 1, 1, 'TXN_006', 40.00, 7.50),      -- Persona 6, Tarjeta de Crédito, Soles
(7, 2, 3, 'TXN_007', 30.00, 3.00),      -- Persona 7, Yape, Euros
(8, 1, 2, 'TXN_008', 22.50, 12.00),     -- Persona 8, Tarjeta de Crédito, Dólares
(9, 2, 1, 'TXN_009', 50.00, 6.00),      -- Persona 9, Yape, Soles
(10, 1, 1, 'TXN_010', 60.00, 18.00);    -- Persona 10, Tarjeta de Crédito, Soles

INSERT INTO alquileres(
    PERSONA_ID, ITEM_ID, FECHA_INICIO, FECHA_FIN, MONTO, DEVUELTO
) VALUES 
(2, 1, NOW(), NULL, 15.00, 0),  -- Alquiler 1, Persona 2, Item 1
(2, 2, NOW(), NULL, 25.00, 0),  -- Alquiler 2, Persona 2, Item 2
(3, 3, NOW(), NULL, 35.00, 0),  -- Alquiler 3, Persona 3, Item 3
(4, 4, NOW(), NULL, 20.00, 0),  -- Alquiler 4, Persona 4, Item 4
(5, 5, NOW(), NULL, 10.00, 0),  -- Alquiler 5, Persona 5, Item 5
(6, 6, NOW(), NULL, 40.00, 0),  -- Alquiler 6, Persona 6, Item 6
(7, 7, NOW(), NULL, 30.00, 0),  -- Alquiler 7, Persona 7, Item 7
(8, 8, NOW(), NULL, 22.50, 0),  -- Alquiler 8, Persona 8, Item 8
(9, 9, NOW(), NULL, 50.00, 0),  -- Alquiler 9, Persona 9, Item 9
(2, 10, NOW(), NULL, 60.00, 0); -- Alquiler 10, Persona 2, Item 10

-- Insertar Detalle de Comprobante 
INSERT INTO detalles_comprobantes(
    COMPROBANTE_ID_COMPROBANTE, ALQUILER_ID_ALQUILER, ITEM_ID_ITEM,
    DESCRIPCION, PRECIO
) VALUES 
(1, 1, 1, 'Apuntes del curso Fisica 1', 15.00),
(2, 2, 1, 'Libro de Programación 3', 25.00),
(3, 3, 1, 'Material adicional de Química', 35.00),
(4, 4, 1, 'Calculadora científica', 20.00),
(5, 5, 1, 'Cuaderno de ejercicios Matemática', 10.00),
(6, 6, 1, 'Guía de temas para el examen de Física', 40.00),
(7, 7, 1, 'Texto sobre álgebra y geometría', 30.00),
(8, 8, 1, 'Notas de clase Historia 2', 22.50),
(9, 9, 1, 'Libro de Biología Avanzada', 50.00),
(10, 10, 1, 'Material didáctico Psicología', 60.00);

INSERT INTO historias_publicaciones(
    PUBLICACION_ID
) VALUES 
(1),  -- Historia de la publicación 1
(2),  -- Historia de la publicación 2
(3),  -- Historia de la publicación 3
(4),  -- Historia de la publicación 4
(5),  -- Historia de la publicación 5
(6),  -- Historia de la publicación 6
(7),  -- Historia de la publicación 7
(8),  -- Historia de la publicación 8
(9),  -- Historia de la publicación 9
(10); -- Historia de la publicación 10

-- Insertar mensajes para los chats previos (sin campos de auditoría)
INSERT INTO mensajes(
    CHAT_ID_CHAT, ESTADO_MSJ_ID, PERSONA_ID, 
    FECHA_ENVIO, FECHA_LEIDO, MENSAJE
) VALUES 
(1, 1, 2, NOW(), NULL, 'Hola, ¿cómo estás?'),    -- Mensaje 1 en Chat 1, enviado por Persona 2
(1, 1, 1, NOW(), NULL, '¡Hola! Todo bien, ¿y tú?'), -- Mensaje 2 en Chat 2, enviado por Persona 3
(2, 2, 3, NOW(), NULL, 'Este es un mensaje de prueba.'), -- Mensaje 3 en Chat 3, enviado por Persona 4
(1, 1, 1, NOW(), NULL, 'Recuerda estudiar para el examen de física.'), -- Mensaje 4 en Chat 4, enviado por Persona 5
(3, 1, 4, NOW(), NULL, '¿Nos vemos mañana?'),  -- Mensaje 5 en Chat 5, enviado por Persona 6
(3, 2, 3, NOW(), NULL, 'Aquí tienes el archivo que me pediste.'), -- Mensaje 6 en Chat 6, enviado por Persona 7
(3, 1, 4, NOW(), NULL, '¿Puedo ayudarte con algo?'), -- Mensaje 7 en Chat 7, enviado por Persona 8
(4, 1, 5, NOW(), NULL, 'Hola, ¿ya terminaste el informe?'), -- Mensaje 8 en Chat 8, enviado por Persona 9
(4, 1, 6, NOW(), NULL, 'Sí, ya lo terminé, lo enviaré mañana.'), -- Mensaje 9 en Chat 9, enviado por Persona 10
(4, 1, 5, NOW(), NULL, 'Confirmado, nos vemos a las 3 PM.'); -- Mensaje 10 en Chat 10, enviado por Persona 2

INSERT INTO notificaciones(
    PERSONA_ID, MOTIVO_ID_MOTIVO, FECHA, MENSAJE
) VALUES 
(2, 1, NOW(), 'Tu cuenta ha sido suspendida temporalmente.'),  -- Notificación 1: Persona 2, motivo "Suspensión de cuenta"
(3, 2, NOW(), 'Tu publicación ha sido rechazada debido a los criterios de calidad.'),  -- Notificación 2: Persona 3, motivo "Rechazo de publicación"
(4, 3, NOW(), 'Tu publicación ha sido aceptada y ahora está visible en el sistema.'),  -- Notificación 3: Persona 4, motivo "Aceptación de publicación"
(5, 4, NOW(), 'Se ha creado una nueva incidencia relacionada con tu solicitud.'),  -- Notificación 4: Persona 5, motivo "Nueva incidencia"
(6, 5, NOW(), 'La incidencia que reportaste ha sido solucionada con éxito.'),  -- Notificación 5: Persona 6, motivo "Solución de incidencia"
(7, 6, NOW(), 'Los datos que proporcionaste no son correctos, por favor actualízalos.'),  -- Notificación 6: Persona 7, motivo "Datos incorrectos"
(8, 7, NOW(), 'Se han reportado problemas con otro usuario en tu cuenta, por favor revisa.'),  -- Notificación 7: Persona 8, motivo "Problemas con otro usuario"
(9, 8, NOW(), 'Se ha identificado un problema con la venta que realizaste, por favor contáctanos.'),  -- Notificación 8: Persona 9, motivo "Problemas con la venta"
(10, 9, NOW(), 'Existen problemas con el alquiler asociado a tu cuenta, por favor revisa los detalles.'),  -- Notificación 9: Persona 10, motivo "Problemas con el alquiler"
(3, 6, NOW(), 'Tu cuenta tiene datos incorrectos, actualiza la información para continuar.')  -- Notificación 10: Persona 3, motivo "Datos incorrectos"
;



