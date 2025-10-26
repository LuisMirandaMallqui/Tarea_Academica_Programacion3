-- INSERT DE ESTADOS_PERSONAS
INSERT INTO estados_personas (NOMBRE, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Activo', 'admin', NOW()),
('Suspendido', 'admin', NOW()),
('Eliminado', 'admin', NOW());

-- INSERT DE ESTADOS_CHATS
INSERT INTO estados_chats (NOMBRE, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Activo', 'admin', NOW()),
('Eliminado', 'admin', NOW());

-- INSERT DE ESTADOS_ITEMS
INSERT INTO estados_items (NOMBRE, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Disponible', 'admin', NOW()),
('Vendido', 'admin', NOW()),
('Alquilado', 'admin', NOW());

-- INSERT DE ESTADOS_MENSAJES
INSERT INTO estados_mensajes (NOMBRE, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Enviado', 'admin', NOW()),
('Recibido', 'admin', NOW()),
('Leido', 'admin', NOW());

-- INSERT DE ESTADOS_PUBLICACIONES
INSERT INTO estados_publicaciones (NOMBRE, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Pendiente', 'admin', NOW()),
('Aprobada', 'admin', NOW()),
('Rechazada', 'admin', NOW()),
('Eliminada', 'admin', NOW());

-- INSERT DE CONDICIONES
INSERT INTO condiciones (NOMBRE, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Nuevo', 'admin', NOW()),
('Seminuevo', 'admin', NOW()),
('Antiguo', 'admin', NOW());

-- INSERT DE COLORES
INSERT INTO colores (NOMBRE, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Rojo', 'admin', NOW()),
('Azul', 'admin', NOW()),
('Verde', 'admin', NOW()),
('Morado', 'admin', NOW()),
('Amarillo', 'admin', NOW()),
('Negro', 'admin', NOW()),
('Blanco', 'admin', NOW()),
('Gris', 'admin', NOW()),
('Celeste', 'admin', NOW());

-- INSERT DE FORMAS DE PAGO
INSERT INTO formas_pago (NOMBRE, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Tarjeta', 'admin', NOW()),
('Yape', 'admin', NOW());

-- INSERT DE FORMATOS
INSERT INTO formatos (NOMBRE, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Físico', 'admin', NOW()),
('Digital', 'admin', NOW());

-- INSERT DE MONEDAS
INSERT INTO monedas (NOMBRE, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Soles', 'admin', NOW()),
('Dólares', 'admin', NOW()),
('Euros', 'admin', NOW());

-- INSERT DE ROLES DE PERSONAS
INSERT INTO roles_personas (NOMBRE, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Comprador', 'admin', NOW()),
('Vendedor', 'admin', NOW());

-- INSERT DE TAMAÑOS
INSERT INTO tamanos (NOMBRE, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Grande', 'admin', NOW()),
('Mediano', 'admin', NOW()),
('Chico', 'admin', NOW());

-- INSERT DE CATEGORÍAS
INSERT INTO categorias (NOMBRE, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Libros', 'admin', NOW()),
('Evaluaciones', 'admin', NOW()),
('Electrónicos', 'admin', NOW()),
('Útiles y accesorios', 'admin', NOW());

-- INSERT DE SUB-CATEGORÍAS
INSERT INTO subcategorias (NOMBRE, CATEGORIA_ID, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Ciencias e ingeniería', 1, 'admin', NOW()),
('Ciencias Sociales', 1, 'admin', NOW()),
('Artes y Humanidades', 1, 'admin', NOW()),
('Negocios y Gestión', 1, 'admin', NOW()),
('Idiomas', 1, 'admin', NOW()),
('Práctica calificada', 2, 'admin', NOW()),
('Práctica dirigida', 2, 'admin', NOW()),
('Exámen 1', 2, 'admin', NOW()),
('Exámen 2', 2, 'admin', NOW()),
('Exámen especial', 2, 'admin', NOW()),
('Control de lectura', 2, 'admin', NOW()),
('Calculadora', 3, 'admin', NOW()),
('Componente electrónico', 3, 'admin', NOW()),
('Multímetro', 3, 'admin', NOW()),
('Teclado', 3, 'admin', NOW()),
('Auriculares', 3, 'admin', NOW()),
('Mochila', 4, 'admin', NOW()),
('Estuche', 4, 'admin', NOW()),
('Material de escritorio', 4, 'admin', NOW()),
('Ropa', 4, 'admin', NOW());

-- INSERT DE MOTIVOS
INSERT INTO motivos (NOMBRE, USUARIO_CREACION, FECHA_CREACION)
VALUES
('Suspención de cuenta', 'admin', NOW()),
('Rechazo de publicación', 'admin', NOW()),
('Aceptación de publicación', 'admin', NOW()),
('Nueva incidencia', 'admin', NOW()),
('Solución de incidencia', 'admin', NOW()),
('Datos incorrectos', 'admin', NOW()),
('Problemas con otro usuario', 'admin', NOW()),
('Problemas con la venta', 'admin',