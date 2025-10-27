-- Variable para el usuario 
SET @admin_user = 'admin';

-- -----------------------------------------------------
-- GRUPO 1: CATÁLOGOS SIMPLES 
-- -----------------------------------------------------
-- Insertar colores
INSERT INTO colores(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Rojo', @admin_user, NOW()),
('Azul', @admin_user, NOW()),
('Negro', @admin_user, NOW());

 -- Insertar condiciones
INSERT INTO condiciones(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Nuevo', @admin_user, NOW()),
('Seminuevo', @admin_user, NOW()),
('Antiguo', @admin_user, NOW());

-- Insertar estados de item
INSERT INTO estados_items(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Disponible', @admin_user, NOW()),
('Alquilado', @admin_user, NOW()),
('Vendido', @admin_user, NOW());

-- Insertar formatos
INSERT INTO formatos(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Físico', @admin_user, NOW()),
('Digital', @admin_user, NOW());

-- Insertar categorías
INSERT INTO categorias(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Libros', @admin_user, NOW()),
('Evaluaciones', @admin_user, NOW()),
('Electrónicos', @admin_user, NOW()),
('Útiles y accesorios', @admin_user, NOW());
-- Insertar tamaños
INSERT INTO tamanos(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Grande', @admin_user, NOW()),
('Mediano', @admin_user, NOW()),
('Chico', @admin_user, NOW());

-- Insertar estados de persona
INSERT INTO estados_personas(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Activo', @admin_user, NOW()),
('Suspendido', @admin_user, NOW()),
('Eliminado', @admin_user, NOW());

-- Insertar roles
INSERT INTO roles_personas(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES
('Vendedor', @admin_user, NOW()),
('Comprador', @admin_user, NOW()),
('Administrador', @admin_user, NOW());

-- Insertar catálogos de pago
INSERT INTO formas_pago(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES 
('Tarjeta de Crédito', @admin_user, NOW()),
('Yape', @admin_user, NOW());
INSERT INTO monedas(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES 
('Soles', @admin_user, NOW()),
('Dólares', @admin_user, NOW()),
('Euros', @admin_user, NOW());
INSERT INTO estados_publicaciones(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES 
('Pendiente', @admin_user, NOW()),
('Aprobada', @admin_user, NOW()),
('Rechazada', @admin_user, NOW()),
('Eliminada', @admin_user, NOW());
INSERT INTO estados_chats(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES 
('Activo', @admin_user, NOW()),
('Eliminado', @admin_user, NOW());
INSERT INTO estados_mensajes(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES 
('Enviado', @admin_user, NOW()),
('Recibido', @admin_user, NOW()),
('Leido', @admin_user, NOW());
INSERT INTO motivos(NOMBRE, USUARIO_CREACION, FECHA_CREACION) VALUES 
('Suspención de cuenta', @admin_user, NOW()),
('Rechazo de publicación', @admin_user, NOW()),
('Aceptación de publicación', @admin_user, NOW()),
('Nueva incidencia', @admin_user, NOW()),
('Solución de incidencia', @admin_user, NOW()),
('Datos incorrectos', @admin_user, NOW()),
('Problemas con otro usuario', @admin_user, NOW()),
('Problemas con la venta', @admin_user,NOW()),
('Problemas con el alquiler', @admin_user,NOW());
-- -----------------------------------------------------
-- GRUPO 2: CATÁLOGOS CON DEPENDENCIAS
-- -----------------------------------------------------
-- Insertar subcategorías (depende de 'categorias')
INSERT INTO subcategorias (NOMBRE, CATEGORIA_ID, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Ciencias e ingeniería', 1, @admin_user, NOW()),
('Ciencias Sociales', 1, @admin_user, NOW()),
('Artes y Humanidades', 1, @admin_user, NOW()),
('Negocios y Gestión', 1, @admin_user, NOW()),
('Idiomas', 1, @admin_user, NOW()),
('Práctica calificada', 2, @admin_user, NOW()),
('Práctica dirigida', 2, @admin_user, NOW()),
('Exámen 1', 2, @admin_user, NOW()),
('Exámen 2', 2, @admin_user, NOW()),
('Exámen especial', 2, @admin_user, NOW()),
('Control de lectura', 2, @admin_user, NOW()),
('Calculadora', 3, @admin_user, NOW()),
('Componente electrónico', 3, @admin_user, NOW()),
('Multímetro', 3, @admin_user, NOW()),
('Teclado', 3, @admin_user, NOW()),
('Auriculares', 3, @admin_user, NOW()),
('Mochila', 4, @admin_user, NOW()),
('Estuche', 4, @admin_user, NOW()),
('Material de escritorio', 4, @admin_user, NOW()),
('Ropa', 4, @admin_user, NOW());


-- -----------------------------------------------------
-- GRUPO 3: DATOS PRINCIPALES (Personas e Items)
-- -----------------------------------------------------
INSERT INTO personas(
 NOMBRES, PRIMER_APELLIDO, SEGUNDO_APELLIDO, CODIGO, CORREO, CONTRASENA)
VALUES
('María Fernanda', 'Lopez', 'Ramirez', '20231547', 'a20231547@pucp.edu.pe','pacoflaco123'),
('José Luis', 'Castro', 'Vargas', '20228459', 'a20228459@pucp.edu.pe','joselu123'),
('Andrea Carolina', 'Torres', 'Mendoza', '20235681', 'a20235681@pucp.edu.pe','andreatorres'),
('Diego Armando', 'Quispe', 'Huamán', '20217732', 'a20217732@pucp.edu.pe','diegoquispe'),
('Lucía Alejandra', 'Salazar', 'Flores', '20229418', 'a20229418@pucp.edu.pe','luciaalej'),
('Carlos Alberto', 'Rojas', 'Cáceres', '20219845', 'a20219845@pucp.edu.pe','carlberto'),
('Gabriela Sofía', 'Paredes', 'Chavez', '20237591', 'a20237591@pucp.edu.pe','gabsof'),
('Fernando Enrique', 'Huerta', 'Guzmán', '20226789', 'a20226789@pucp.edu.pe','feriq'),
('Valeria Isabel', 'Martínez', 'Zamora', '20231852', 'a20231852@pucp.edu.pe','valeri'),
('Santiago Nicolás', 'Gonzales', 'Linares', '20238417', 'a20238417@pucp.edu.pe','santi123');

INSERT INTO items(
    COLOR_ID, ESTADO_ITEM_ID, CONDICION_ID, TAMANO_ID, FORMATO_ID, 
    subcategoria_ID_SUBCATEGORIA, subcategoria_CATEGORIA_ID,
    NOMBRE, DESCRIPCION, PRECIO, ES_VENTA, 
    USUARIO_CREACION, FECHA_CREACION
) VALUES (
    3, 1, 1, 2, 1,  
    1, 1, -- (FK a subcategorias: ID 1 'Ciencias e Ingenieria', Cat 1 'Libros')
    'FISICA 1', 'Apuntes del curso Fisica 1', 30.00, 1, -- (Es Venta = 1)
    @admin_user, NOW()
);

-- -----------------------------------------------------
-- GRUPO 4: RELACIONES M-M (Muchos-a-Muchos)
-- -----------------------------------------------------
INSERT INTO personas_roles(PERSONA_ID, ROLPERSONA_ID, USUARIO_CREACION, FECHA_CREACION) VALUES
(2, 1, 1, NOW()), 
(2, 2, 1, NOW()); 

-- -----------------------------------------------------
-- GRUPO 5: TRANSACCIONES (Publicaciones, Alquileres, etc.)
-- -----------------------------------------------------
INSERT INTO publicaciones(
    ESTADO_PUBLICACION_ID, ITEM_ID_ITEM, PERSONA_ID, 
    FECHA_ALTA, CALIFICACION, 
    USUARIO_CREACION, FECHA_CREACION
) VALUES (
    1, 1, 2, 
    NOW(), 0, 
    'Luis', NOW() 
);

INSERT INTO alquileres(
    PERSONA_ID, ITEM_ID, FECHA_INICIO, MONTO, DEVUELTO,
    USUARIO_CREACION, FECHA_CREACION
) VALUES (
    2, 1, NOW(), 15.00, 0, -- (Devuelto = 0)
    1, NOW() -- (Creado por el Admin ID 1)
);


INSERT INTO comprobantes(
    PERSONA_ID_PERSONA, FORMA_PAGO_ID_FORMAPAGO, MONEDA_ID_MONEDA,
    TRANSACCION_ID, FECHA_EMISION, MONTO, IMPUESTO,
    USUARIO_CREACION, FECHA_CREACION
) VALUES (
    2, 1, 1, -- (Persona 2, Tarjeta, Soles)
    'TXN_12345ABC', NOW(), 17.70, 2.70,
    @admin_user, NOW() 
);

-- Insertar Detalle de Comprobante 
INSERT INTO detalles_comprobantes(
    COMPROBANTE_ID_COMPROBANTE, ALQUILER_ID_ALQUILER, ITEM_ID_ITEM,
    DESCRIPCION, PRECIO
) VALUES (
    1, 1, 1, -- (Comprobante 1, Alquiler 1, No es venta de item)
    'Apuntes del curso Fisica 1', 15.00
);