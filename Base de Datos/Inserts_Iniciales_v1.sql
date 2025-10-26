<<<<<<< Updated upstream
-- INSERTS DE TABLAS QUE ACOMPAÑ
----------------------------------------------------
-- INSERT DE PERSONAS PUCP
INSERT INTO personas_pucp ( NOMBRES, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CODIGO, CORREO)
VALUES
('María Fernanda', 'Lopez', 'Ramirez', '20231547', 'a20231547@pucp.edu.pe'),
('José Luis', 'Castro', 'Vargas', '20228459', 'a20228459@pucp.edu.pe'),
('Andrea Carolina', 'Torres', 'Mendoza', '20235681', 'a20235681@pucp.edu.pe'),
('Diego Armando', 'Quispe', 'Huamán', '20217732', 'a20217732@pucp.edu.pe'),
('Lucía Alejandra', 'Salazar', 'Flores', '20229418', 'a20229418@pucp.edu.pe'),
('Carlos Alberto', 'Rojas', 'Cáceres', '20219845', 'a20219845@pucp.edu.pe'),
('Gabriela Sofía', 'Paredes', 'Chavez', '20237591', 'a20237591@pucp.edu.pe'),
('Fernando Enrique', 'Huerta', 'Guzmán', '20226789', 'a20226789@pucp.edu.pe'),
('Valeria Isabel', 'Martínez', 'Zamora', '20231852', 'a20231852@pucp.edu.pe'),
('Santiago Nicolás', 'Gonzales', 'Linares', '20238417', 'a20238417@pucp.edu.pe');

-- INSERT DE TARJETAS
INSERT INTO tarjetas (NUMERO, CCV, FECHA_VENCIMIENTO)
VALUES
('4556738901246789', '321', '2027-05-31 00:00:00'),
('5234789012569874', '842', '2026-11-30 00:00:00'),
('4023987645123456', '097', '2028-01-31 00:00:00'),
('5198765432109876', '654', '2029-09-30 00:00:00'),
('4532123498765432', '778', '2026-07-31 00:00:00'),
('5367123498751234', '130', '2030-02-28 00:00:00'),
('4716123487654321', '245', '2028-06-30 00:00:00'),
('5178123476543210', '382', '2027-10-31 00:00:00'),
('4485123498012345', '519', '2029-12-31 00:00:00'),
('5123123498765123', '604', '2030-04-30 00:00:00');

-- INSERT DE YAPE
INSERT INTO yape (NUMERO, CODIGO_APROBACION)
VALUES
('912345678', '654321'),
('934567890', '123456'),
('976543210', '789012'),
('998765432', '345678'),
('923456789', '987654');

--------------------------------------------------
-- INSERTS DE TABLAS MAESTRAS
--------------------------------------------------
-- INSERT DE ESTADOS_PERSONAS
INSERT INTO estados_personas (NOMBRE)
VALUES
('Activo'),
('Suspendido'),
('Eliminado');

-- INSERT DE ESTADOS_CHATS
INSERT INTO estados_chats (NOMBRE)
VALUES
('Activo'),
('Eliminado');

-- INSERT DE ESTADOS_ITEMS
INSERT INTO estados_items (NOMBRE)
VALUES
('Disponible'),
('Vendido'),
('Alquilado');

-- INSERT DE ESTADOS_MENSAJES
INSERT INTO estados_mensajes (NOMBRE)
VALUES
('Enviado'),
('Recibido'),
('Leido');

-- INSERT DE ESTADOS_PUBLICACIONES
INSERT INTO estados_publicaciones (NOMBRE)
VALUES
('Pendiente'),
('Aprobada'),
('Rechazada'),
('Eliminada');

-- INSERT DE CONDICIONES
INSERT INTO condiciones (NOMBRE)
VALUES
('Nuevo'),
('Seminuevo'),
('Antiguo');

-- INSERT DE COLORES
INSERT INTO colores (NOMBRE)
VALUES
('Rojo'),
('Azul'),
('Verde'),
('Morado'),
('Amarillo'),
('Negro'),
('Blanco'),
('Gris'),
('Celeste');

-- INSERT DE FORMAS DE PAGO
INSERT INTO formas_pago (NOMBRE)
VALUES
('Tarjeta'),
('Yape');

-- INSERT DE FORMATOS
INSERT INTO formatos (NOMBRE)
VALUES
('Físico'),
('Digital');

-- INSERT DE MONEDAS
INSERT INTO monedas (NOMBRE)
VALUES
('Soles'),
('Dólares'),
('Euros');

-- INSERT DE ROLES DE PERSONAS
INSERT INTO roles_personas (NOMBRE)
VALUES
('Comprador'),
('Vendedor');

-- INSERT DE TAMAÑOS
INSERT INTO tamanos (NOMBRE)
VALUES
('Grande'),
('Mediano'),
('Chico');

-- INSERT DE CATEGORÍAS
INSERT INTO categorias (NOMBRE)
VALUES
('Libros'),
('Evaluaciones'),
('Electrónicos'),
('Útiles y accesorios');

-- INSERT DE SUB-CATEGORÍAS
INSERT INTO subcategorias (NOMBRE,CATEGORIA_ID)
VALUES
('Ciencias e ingeniería',1),
('Ciencias Sociales',1),
('Artes y Humanidades',1),
('Negocios y Gestión',1),
('Idiomas',1),
('Práctica calificada',2),
('Práctica dirigida',2),
('Exámen 1',2),
('Exámen 2',2),
('Exámen especial',2),
('Control de lectura',2),
('Calculadora',3),
('Componente electrónico',3),
('Multímetro',3),
('Teclado',3),
('Auriculares',3),
('Mochila',4),
('Estuche',4),
('Material de escritorio',4),
('Ropa',4);

-- INSERT DE MOTIVOS
INSERT INTO motivos (NOMBRE)
VALUES
('Suspención de cuenta'),
('Rechazo de publicación'),
('Aceptación de publicación'),
('Nueva incidencia'),
('Solución de incidencia'),
('Datos incorrectos'),
('Problemas con otro usuario'),
('Problemas con la venta'),
('Problemas con el alquiler');



=======
-- Usamos una variable para el usuario administrador del sistema
SET @admin_user = 'ADMIN_SISTEMA';

-- -----------------------------------------------------
-- GRUPO 1: CATÁLOGOS SIMPLES (Sin dependencias)
-- (Auditoría con VARCHAR)
-- -----------------------------------------------------

-- Insertar colores
INSERT INTO colores(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Rojo', @admin_user, NOW()),
('Azul', @admin_user, NOW()),
('Negro', @admin_user, NOW());
-- (Asumimos que generan IDs 1, 2, 3)

-- Insertar condiciones
INSERT INTO condiciones(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Nuevo (10/10)', @admin_user, NOW()),
('Usado (7/10)', @admin_user, NOW()),
('Desgastado (4/10)', @admin_user, NOW());
-- (Asumimos que generan IDs 1, 2, 3)

-- Insertar estados de item
INSERT INTO estados_items(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Disponible', @admin_user, NOW()),
('Alquilado', @admin_user, NOW()),
('Vendido', @admin_user, NOW());
-- (Asumimos que generan IDs 1, 2, 3)

-- Insertar formatos
INSERT INTO formatos(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Físico', @admin_user, NOW()),
('Digital', @admin_user, NOW());
-- (Asumimos que generan IDs 1, 2)

-- Insertar categorías
INSERT INTO categorias(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Ropa', @admin_user, NOW()),
('Libros', @admin_user, NOW()),
('Electrónica', @admin_user, NOW());
-- (Asumimos que generan IDs 1, 2, 3)

-- Insertar tamaños
INSERT INTO tamanos(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('S', @admin_user, NOW()),
('M', @admin_user, NOW()),
('L', @admin_user, NOW());
-- (Asumimos que generan IDs 1, 2, 3)

-- Insertar estados de persona
INSERT INTO estados_personas(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Activo', @admin_user, NOW()),
('Bloqueado', @admin_user, NOW());
-- (Asumimos que generan IDs 1, 2)

-- Insertar roles
INSERT INTO roles_personas(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Vendedor', @admin_user, NOW()),
('Comprador', @admin_user, NOW()),
('Administrador', @admin_user, NOW());
-- (Asumimos que generan IDs 1, 2, 3)

-- Insertar catálogos de pago
INSERT INTO formas_pago(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES ('Tarjeta de Crédito', @admin_user, NOW());
INSERT INTO monedas(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES ('Soles (PEN)', @admin_user, NOW());
INSERT INTO estados_publicaciones(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES ('Pendiente de Aprobación', @admin_user, NOW()), ('Activa', @admin_user, NOW());
INSERT INTO estados_chats(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES ('Abierto', @admin_user, NOW());
INSERT INTO estados_mensajes(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES ('Enviado', @admin_user, NOW());
INSERT INTO motivos(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES ('Reporte de Publicación', @admin_user, NOW());

-- -----------------------------------------------------
-- GRUPO 2: CATÁLOGOS CON DEPENDENCIAS
-- (Auditoría con VARCHAR)
-- -----------------------------------------------------

-- Insertar subcategorías (depende de 'categorias')
-- (Como SUBCATEGORIA_ID es AUTO_INCREMENT, no lo especificamos)
INSERT INTO subcategorias(CATEGORIA_ID, NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
(1, 'Polos', @admin_user, NOW()),  -- (ID 1, Cat 1 'Ropa')
(1, 'Pantalones', @admin_user, NOW()), -- (ID 2, Cat 1 'Ropa')
(2, 'Ciencia Ficción', @admin_user, NOW()); -- (ID 3, Cat 2 'Libros')
-- (Asumimos que generan SUBCATEGORIA_ID 1, 2, 3)


-- -----------------------------------------------------
-- GRUPO 3: DATOS PRINCIPALES (Personas e Items)
-- -----------------------------------------------------

-- Insertar una Persona (Auditoría con INT)
-- Asumimos que el ID 1 de 'estados_personas' es 'Activo'
-- Asumimos que la creación la hace un admin (ID 1)
INSERT INTO personas(
    ESTADO_PERSONA_ID_ESTADOPERSONA, NOMBRES, PRIMER_APELLIDO, SEGUNDO_APELLIDO, 
    CODIGO, CORREO, CONTRASENA, 
    USUARIO_CREACION, FECHA_CREACION
) VALUES (
    1, 'Luis', 'Miranda', 'Mallqui', 
    '20223796', 'luis.miranda@pucp.edu.pe', 'claveEncriptada123', 
    1, -- (ID 1, asumimos que es un 'ADMIN')
    NOW()
);
-- (Este INSERT genera un nuevo PERSONA_ID, asumamos que es el ID 2)
-- (Asumimos que el admin es la PERSONA_ID = 1)

-- Insertar un Item (Auditoría con VARCHAR)
-- Asumimos IDs de los catálogos insertados arriba
INSERT INTO items(
    COLOR_ID, ESTADO_ITEM_ID, CONDICION_ID, TAMANO_ID, FORMATO_ID, 
    subcategoria_ID_SUBCATEGORIA, subcategoria_CATEGORIA_ID,
    NOMBRE, DESCRIPCION, PRECIO, ES_VENTA, 
    USUARIO_CREACION, FECHA_CREACION
) VALUES (
    3, 1, 1, 2, 1,  -- (Negro, Disponible, Nuevo, M, Físico)
    1, 1, -- (FK a subcategorias: ID 1 'Polos', Cat 1 'Ropa')
    'Polo Algodón Pima', 'Polo color negro talla M de algodón pima', 70.00, 1, -- (Es Venta = 1)
    @admin_user, NOW()
);
-- (Este INSERT genera un nuevo ITEM_ID, asumamos que es el ID 1)


-- -----------------------------------------------------
-- GRUPO 4: RELACIONES M-M (Muchos-a-Muchos)
-- (Auditoría con INT)
-- -----------------------------------------------------

-- Asignar roles a la persona creada (ID 2)
-- Asumimos que los roles son 1='Vendedor', 2='Comprador'
-- Asumimos que la asignación la hace el admin (ID 1)
INSERT INTO personas_roles(PERSONA_ID, ROLPERSONA_ID, USUARIO_CREACION, FECHA_CREACION) VALUES
(2, 1, 1, NOW()), -- (Asignamos rol Vendedor a Luis)
(2, 2, 1, NOW()); -- (Asignamos rol Comprador a Luis)

-- -----------------------------------------------------
-- GRUPO 5: TRANSACCIONES (Publicaciones, Alquileres, etc.)
-- -----------------------------------------------------

-- Insertar una Publicación (Auditoría con VARCHAR)
-- La persona 2 ('Luis') publica el item 1 ('Polo')
-- Asumimos ID 1 de 'estados_publicaciones' es 'Pendiente'
INSERT INTO publicaciones(
    ESTADO_PUBLICACION_ID, ITEM_ID_ITEM, PERSONA_ID, 
    FECHA_ALTA, CALIFICACION, 
    USUARIO_CREACION, FECHA_CREACION
) VALUES (
    1, 1, 2, 
    NOW(), 0, 
    'USER_2', NOW() -- (Aquí podría ir el código o ID de la persona 2)
);
-- (Genera PUBLICACION_ID = 1)

-- Insertar un Alquiler (Auditoría con INT)
-- Asumimos que la persona 1 (Admin) alquila el item 1 a la persona 2 (Luis)
INSERT INTO alquileres(
    PERSONA_ID, ITEM_ID, FECHA_INICIO, MONTO, DEVUELTO,
    USUARIO_CREACION, FECHA_CREACION
) VALUES (
    2, 1, NOW(), 15.00, 0, -- (Devuelto = 0)
    1, NOW() -- (Creado por el Admin ID 1)
);
-- (Genera ALQUILER_ID = 1)

-- Insertar un Comprobante (Auditoría con VARCHAR)
-- La persona 2 paga por el alquiler 1
INSERT INTO comprobantes(
    PERSONA_ID_PERSONA, FORMA_PAGO_ID_FORMAPAGO, MONEDA_ID_MONEDA,
    TRANSACCION_ID, FECHA_EMISION, MONTO, IMPUESTO,
    USUARIO_CREACION, FECHA_CREACION
) VALUES (
    2, 1, 1, -- (Persona 2, Tarjeta, Soles)
    'TXN_12345ABC', NOW(), 17.70, 2.70,
    @admin_user, NOW() -- (El sistema genera el comprobante)
);
-- (Genera COMPROBANTE_ID = 1)

-- Insertar Detalle de Comprobante (Falta auditoría de creación)
INSERT INTO detalles_comprobantes(
    COMPROBANTE_ID_COMPROBANTE, ALQUILER_ID_ALQUILER, ITEM_ID_ITEM,
    DESCRIPCION, PRECIO
) VALUES (
    1, 1, NULL, -- (Comprobante 1, Alquiler 1, No es venta de item)
    'Alquiler de Polo Algodón Pima (3 días)', 15.00
);
>>>>>>> Stashed changes
