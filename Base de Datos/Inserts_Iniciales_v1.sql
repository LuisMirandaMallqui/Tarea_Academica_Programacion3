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



