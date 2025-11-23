/* En SQL Server no usamos variables de sesión con '@' para 
   configurar el modo estricto al inicio de un script DDL de la misma forma.
   Las configuraciones de integridad se manejan por defecto o en la creación de tablas.
*/

-- 1. Verificar si la base de datos ya existe
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'mydb')
BEGIN
    -- 2. Crear la base de datos
    -- COLLATE define el juego de caracteres (equivalente a utf8)
    CREATE DATABASE [mydb] COLLATE Latin1_General_100_CI_AS_SC_UTF8; 
END
GO

-- 3. Usar la base de datos
USE [mydb];
GO

-- 4. Configuraciones estándar de sesión (Recomendado en MSSQL)
SET ANSI_NULLS ON;
SET QUOTED_IDENTIFIER ON;
GO

USE [mydb];
GO

-- 1. Deshabilitar todas las restricciones (Foreign Keys) temporalmente
-- Esto permite borrar tablas sin importar el orden, pero es mejor borrar en orden.
-- Vamos a hacerlo de la forma limpia: BORRAR TODO EN ORDEN.

-- NIVEL 4 (Nietos / Tablas dependientes finales)
IF OBJECT_ID('dbo.mensajes', 'U') IS NOT NULL DROP TABLE dbo.mensajes;
IF OBJECT_ID('dbo.detalles_comprobantes', 'U') IS NOT NULL DROP TABLE dbo.detalles_comprobantes;
IF OBJECT_ID('dbo.personas_chats', 'U') IS NOT NULL DROP TABLE dbo.personas_chats;
IF OBJECT_ID('dbo.personas_roles', 'U') IS NOT NULL DROP TABLE dbo.personas_roles;
IF OBJECT_ID('dbo.historias_publicaciones', 'U') IS NOT NULL DROP TABLE dbo.historias_publicaciones;

-- NIVEL 3 (Hijos intermedios)
IF OBJECT_ID('dbo.comprobantes', 'U') IS NOT NULL DROP TABLE dbo.comprobantes;
IF OBJECT_ID('dbo.alquileres', 'U') IS NOT NULL DROP TABLE dbo.alquileres;
IF OBJECT_ID('dbo.publicaciones', 'U') IS NOT NULL DROP TABLE dbo.publicaciones;
IF OBJECT_ID('dbo.incidencias', 'U') IS NOT NULL DROP TABLE dbo.incidencias;
IF OBJECT_ID('dbo.notificaciones', 'U') IS NOT NULL DROP TABLE dbo.notificaciones;
IF OBJECT_ID('dbo.chats', 'U') IS NOT NULL DROP TABLE dbo.chats;

-- NIVEL 2 (Hijos directos de catálogos)
IF OBJECT_ID('dbo.items', 'U') IS NOT NULL DROP TABLE dbo.items;
IF OBJECT_ID('dbo.personas', 'U') IS NOT NULL DROP TABLE dbo.personas;
IF OBJECT_ID('dbo.subcategorias', 'U') IS NOT NULL DROP TABLE dbo.subcategorias;

-- NIVEL 1 (Padres Supremos / Catálogos Base)
IF OBJECT_ID('dbo.roles', 'U') IS NOT NULL DROP TABLE dbo.roles;
IF OBJECT_ID('dbo.estados_personas', 'U') IS NOT NULL DROP TABLE dbo.estados_personas;
IF OBJECT_ID('dbo.estados_items', 'U') IS NOT NULL DROP TABLE dbo.estados_items;
IF OBJECT_ID('dbo.estados_publicaciones', 'U') IS NOT NULL DROP TABLE dbo.estados_publicaciones;
IF OBJECT_ID('dbo.estados_chats', 'U') IS NOT NULL DROP TABLE dbo.estados_chats;
IF OBJECT_ID('dbo.estados_mensajes', 'U') IS NOT NULL DROP TABLE dbo.estados_mensajes;
IF OBJECT_ID('dbo.formas_pago', 'U') IS NOT NULL DROP TABLE dbo.formas_pago;
IF OBJECT_ID('dbo.monedas', 'U') IS NOT NULL DROP TABLE dbo.monedas;
IF OBJECT_ID('dbo.motivos', 'U') IS NOT NULL DROP TABLE dbo.motivos;
IF OBJECT_ID('dbo.tamanos', 'U') IS NOT NULL DROP TABLE dbo.tamanos;
IF OBJECT_ID('dbo.colores', 'U') IS NOT NULL DROP TABLE dbo.colores;
IF OBJECT_ID('dbo.condiciones', 'U') IS NOT NULL DROP TABLE dbo.condiciones;
IF OBJECT_ID('dbo.formatos', 'U') IS NOT NULL DROP TABLE dbo.formatos;
IF OBJECT_ID('dbo.categorias', 'U') IS NOT NULL DROP TABLE dbo.categorias;
GO



-- -----------------------------------------------------
-- Table [colores]
-- -----------------------------------------------------

CREATE TABLE dbo.colores (
    -- Primary Keys
    [COLOR_ID] INT NOT NULL IDENTITY(1,1), -- Identificador único del color
    -- Atributos
    [NOMBRE] VARCHAR(100) NOT NULL, -- Nombre del color
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    CONSTRAINT [PK_colores] PRIMARY KEY CLUSTERED ([COLOR_ID] ASC)
);
GO

-- -----------------------------------------------------
-- Table [condiciones]
-- -----------------------------------------------------

CREATE TABLE dbo.condiciones (
    [CONDICION_ID] INT NOT NULL IDENTITY(1,1), -- Identificador único
    [NOMBRE] VARCHAR(100) NOT NULL, -- Nombre de la condición
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    CONSTRAINT [PK_condiciones] PRIMARY KEY CLUSTERED ([CONDICION_ID] ASC)
);
GO

-- -----------------------------------------------------
-- Table [estados_items]
-- -----------------------------------------------------

CREATE TABLE dbo.estados_items (
    [ESTADOITEM_ID] INT NOT NULL IDENTITY(1,1),
    [NOMBRE] VARCHAR(100) NOT NULL,
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    CONSTRAINT [PK_estados_items] PRIMARY KEY CLUSTERED ([ESTADOITEM_ID] ASC)
);
GO

-- -----------------------------------------------------
-- Table [formatos]
-- -----------------------------------------------------

CREATE TABLE dbo.formatos (
    [FORMATO_ID] INT NOT NULL IDENTITY(1,1),
    [NOMBRE] VARCHAR(100) NOT NULL,
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    CONSTRAINT [PK_formatos] PRIMARY KEY CLUSTERED ([FORMATO_ID] ASC)
);
GO

-- -----------------------------------------------------
-- Table [categorias]
-- -----------------------------------------------------

CREATE TABLE dbo.categorias (
    [CATEGORIA_ID] INT NOT NULL IDENTITY(1,1),
    [NOMBRE] VARCHAR(100) NOT NULL,
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    CONSTRAINT [PK_categorias] PRIMARY KEY CLUSTERED ([CATEGORIA_ID] ASC)
);
GO

-- -----------------------------------------------------
-- Table [subcategorias]
-- -----------------------------------------------------

CREATE TABLE dbo.subcategorias (
    [SUBCATEGORIA_ID] INT NOT NULL IDENTITY(1,1),
    [CATEGORIA_ID] INT NOT NULL, -- FK
    [NOMBRE] VARCHAR(100) NOT NULL,
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    
    -- Llave Primaria Compuesta
    CONSTRAINT [PK_subcategorias] PRIMARY KEY CLUSTERED ([SUBCATEGORIA_ID] ASC, [CATEGORIA_ID] ASC),
    
    -- Llave Foránea
    CONSTRAINT [fk_SUBCATEGORIA_CATEGORIA1] FOREIGN KEY ([CATEGORIA_ID])
        REFERENCES dbo.categorias ([CATEGORIA_ID])
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION
);
GO

USE [mydb];
GO

-- -----------------------------------------------------
-- Table [tamanos]
-- -----------------------------------------------------

CREATE TABLE dbo.tamanos (
    [TAMANO_ID] INT NOT NULL IDENTITY(1,1),
    [NOMBRE] VARCHAR(100) NOT NULL, -- ej. S, M, L, XL, 42
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    CONSTRAINT [PK_tamanos] PRIMARY KEY CLUSTERED ([TAMANO_ID] ASC)
);
GO

-- -----------------------------------------------------
-- Table [estados_personas]
-- -----------------------------------------------------

CREATE TABLE dbo.estados_personas (
    [ESTADOPERSONA_ID] INT NOT NULL IDENTITY(1,1),
    [NOMBRE] VARCHAR(45) NOT NULL, -- ej. Activo, Inactivo
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    CONSTRAINT [PK_estados_personas] PRIMARY KEY CLUSTERED ([ESTADOPERSONA_ID] ASC)
);
GO

-- -----------------------------------------------------
-- Table [roles]
-- -----------------------------------------------------

CREATE TABLE dbo.roles (
    [ROLPERSONA_ID] INT NOT NULL IDENTITY(1,1),
    [NOMBRE] VARCHAR(45) NOT NULL, -- ej. Administrador, Vendedor
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    CONSTRAINT [PK_roles] PRIMARY KEY CLUSTERED ([ROLPERSONA_ID] ASC)
);
GO

-- -----------------------------------------------------
-- Table [items]
-- -----------------------------------------------------
/* Esta tabla tiene dependencias con:
   colores, estados_items, condiciones, tamanos, formatos y subcategorias.
   Asegúrate de haber ejecutado el script anterior antes que este.
*/

CREATE TABLE dbo.items (
    [ITEM_ID] INT NOT NULL IDENTITY(1,1),
    
    -- Foreign Keys Columns
    [COLOR_ID] INT NOT NULL,
    [ESTADO_ITEM_ID] INT NOT NULL,
    [CONDICION_ID] INT NOT NULL,
    [TAMANO_ID] INT NOT NULL,
    [FORMATO_ID] INT NOT NULL,
    -- FK Compuesta hacia subcategorias
    [subcategoria_ID_SUBCATEGORIA] INT NOT NULL,
    [subcategoria_CATEGORIA_ID] INT NOT NULL,
    
    -- Atributos
    [NOMBRE] VARCHAR(100) NOT NULL,
    [DESCRIPCION] VARCHAR(300) NOT NULL,
    [PRECIO] DECIMAL(10,2) NOT NULL,
    
    -- En MSSQL no existe UNSIGNED ZEROFILL. Usamos TINYINT o BIT.
    [ES_VENTA] TINYINT NOT NULL, 
    
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    
    CONSTRAINT [PK_items] PRIMARY KEY CLUSTERED ([ITEM_ID] ASC),
    
    -- Definición de Foreign Keys
    CONSTRAINT [fk_ITEM_COLOR1] FOREIGN KEY ([COLOR_ID])
        REFERENCES dbo.colores ([COLOR_ID]),
        
    CONSTRAINT [fk_ITEM_CONDICION1] FOREIGN KEY ([CONDICION_ID])
        REFERENCES dbo.condiciones ([CONDICION_ID]),
        
    CONSTRAINT [fk_ITEM_ESTADO_ITEM1] FOREIGN KEY ([ESTADO_ITEM_ID])
        REFERENCES dbo.estados_items ([ESTADOITEM_ID]),
        
    CONSTRAINT [fk_ITEM_FORMATO1] FOREIGN KEY ([FORMATO_ID])
        REFERENCES dbo.formatos ([FORMATO_ID]),
        
    CONSTRAINT [fk_ITEM_TAMANO1] FOREIGN KEY ([TAMANO_ID])
        REFERENCES dbo.tamanos ([TAMANO_ID]),
        
    -- FK Compuesta (Dos columnas referencian a dos columnas en la tabla padre)
    CONSTRAINT [fk_item_subcategoria1] FOREIGN KEY ([subcategoria_ID_SUBCATEGORIA], [subcategoria_CATEGORIA_ID])
        REFERENCES dbo.subcategorias ([SUBCATEGORIA_ID], [CATEGORIA_ID])
);
GO

-- Creación de índices para mejorar rendimiento en FKs (Opcional pero recomendado en MSSQL)
CREATE INDEX [IX_items_COLOR_ID] ON dbo.items ([COLOR_ID]);
CREATE INDEX [IX_items_ESTADO_ITEM_ID] ON dbo.items ([ESTADO_ITEM_ID]);
CREATE INDEX [IX_items_CONDICION_ID] ON dbo.items ([CONDICION_ID]);
CREATE INDEX [IX_items_TAMANO_ID] ON dbo.items ([TAMANO_ID]);
CREATE INDEX [IX_items_FORMATO_ID] ON dbo.items ([FORMATO_ID]);
CREATE INDEX [IX_items_subcategoria] ON dbo.items ([subcategoria_ID_SUBCATEGORIA], [subcategoria_CATEGORIA_ID]);
GO
-- -----------------------------------------------------
-- Table [personas]
-- -----------------------------------------------------
/* Requiere que exista la tabla 'estados_personas' (creada en el script anterior) */

CREATE TABLE dbo.personas (
    -- Primary Keys
    [PERSONA_ID] INT NOT NULL IDENTITY(1,1),
    
    -- Foreign Keys
    [ESTADO_PERSONA_ID_ESTADOPERSONA] INT NOT NULL,
    
    -- Atributos
    [NOMBRES] VARCHAR(100) NOT NULL,
    [PRIMER_APELLIDO] VARCHAR(100) NOT NULL,
    [SEGUNDO_APELLIDO] VARCHAR(100) NOT NULL,
    [CODIGO] VARCHAR(8) NOT NULL,
    [CORREO] VARCHAR(100) NOT NULL,
    [CONTRASENA] VARCHAR(45) NOT NULL,
    [ULTIMA_ACTIVIDAD] DATETIME NOT NULL,
    
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    
    CONSTRAINT [PK_personas] PRIMARY KEY CLUSTERED ([PERSONA_ID] ASC),
    
    -- Constraint de Unicidad para el Correo (Recomendado según tu comentario)
    CONSTRAINT [UQ_personas_correo] UNIQUE ([CORREO]),
    
    -- Foreign Key
    CONSTRAINT [fk_PERSONA_ESTADO_PERSONA1] FOREIGN KEY ([ESTADO_PERSONA_ID_ESTADOPERSONA])
        REFERENCES dbo.estados_personas ([ESTADOPERSONA_ID])
);
GO

-- Índice para la FK de Estado (Mejora rendimiento en filtros por estado)
CREATE INDEX [IX_personas_ESTADO] ON dbo.personas ([ESTADO_PERSONA_ID_ESTADOPERSONA]);
GO


-- -----------------------------------------------------
-- Table [personas_roles]
-- -----------------------------------------------------
/* Tabla intermedia N:M. Requiere 'personas' y 'roles' */

CREATE TABLE dbo.personas_roles (
    -- Primary Keys (Que a la vez son FKs)
    [PERSONA_ID] INT NOT NULL,
    [ROLPERSONA_ID] INT NOT NULL,
    
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    
    -- Llave Primaria Compuesta (Composite PK)
    CONSTRAINT [PK_personas_roles] PRIMARY KEY CLUSTERED ([PERSONA_ID] ASC, [ROLPERSONA_ID] ASC),
    
    -- Foreign Keys
    CONSTRAINT [fk_personas_roles_personas1] FOREIGN KEY ([PERSONA_ID])
        REFERENCES dbo.personas ([PERSONA_ID]),
        
    CONSTRAINT [fk_personas_roles_roles1] FOREIGN KEY ([ROLPERSONA_ID])
        REFERENCES dbo.roles ([ROLPERSONA_ID])
);
GO

-- Índice para buscar roles por ID de rol rápidamente
CREATE INDEX [IX_personas_roles_ROLPERSONA_ID] ON dbo.personas_roles ([ROLPERSONA_ID]);
GO


-- -----------------------------------------------------
-- Table [alquileres]
-- -----------------------------------------------------
/* Requiere 'personas' e 'items' */

CREATE TABLE dbo.alquileres (
    -- Primary Keys
    [ALQUILER_ID] INT NOT NULL IDENTITY(1,1),
    
    -- Foreign Keys
    [PERSONA_ID] INT NOT NULL,
    [ITEM_ID] INT NOT NULL,
    
    -- Atributos
    [FECHA_INICIO] DATETIME NOT NULL,
    [FECHA_FIN] DATETIME NULL,
    [MONTO] DECIMAL(10,2) NOT NULL,
    [DEVUELTO] TINYINT NOT NULL, -- 1=Sí, 0=No
    
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    -- En SQL Server usamos GETDATE() en lugar de CURRENT_TIMESTAMP (aunque ambos funcionan, GETDATE es el nativo)
    [FECHA_CREACION] DATETIME NOT NULL DEFAULT GETDATE(),
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    
    CONSTRAINT [PK_alquileres] PRIMARY KEY CLUSTERED ([ALQUILER_ID] ASC),
    
    -- Foreign Keys
    CONSTRAINT [fk_alquileres_items] FOREIGN KEY ([ITEM_ID])
        REFERENCES dbo.items ([ITEM_ID]),
        
    CONSTRAINT [fk_alquileres_personas] FOREIGN KEY ([PERSONA_ID])
        REFERENCES dbo.personas ([PERSONA_ID])
);
GO

-- Índices para las FKs (Vital para reportes de "Alquileres por Persona" o "Historial de Item")
CREATE INDEX [IX_alquileres_PERSONA_ID] ON dbo.alquileres ([PERSONA_ID]);
CREATE INDEX [IX_alquileres_ITEM_ID] ON dbo.alquileres ([ITEM_ID]);
GO

-- -----------------------------------------------------
-- Table [estados_chats]
-- -----------------------------------------------------

CREATE TABLE dbo.estados_chats (
    [ESTADOCHAT_ID] INT NOT NULL IDENTITY(1,1),
    [NOMBRE] VARCHAR(45) NOT NULL,
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    CONSTRAINT [PK_estados_chats] PRIMARY KEY CLUSTERED ([ESTADOCHAT_ID] ASC)
);
GO

-- -----------------------------------------------------
-- Table [chats]
-- -----------------------------------------------------

CREATE TABLE dbo.chats (
    [CHAT_ID] INT NOT NULL IDENTITY(1,1),
    [estado_chat_ID_ESTADOCHAT] INT NOT NULL,
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    
    CONSTRAINT [PK_chats] PRIMARY KEY CLUSTERED ([CHAT_ID] ASC),
    CONSTRAINT [fk_CHAT_estado_chat1] FOREIGN KEY ([estado_chat_ID_ESTADOCHAT])
        REFERENCES dbo.estados_chats ([ESTADOCHAT_ID])
);
GO
-- Index para FK
CREATE INDEX [IX_chats_estado_chat] ON dbo.chats ([estado_chat_ID_ESTADOCHAT]);
GO

-- -----------------------------------------------------
-- Table [formas_pago]
-- -----------------------------------------------------

CREATE TABLE dbo.formas_pago (
    [FORMAPAGO_ID] INT NOT NULL IDENTITY(1,1),
    [NOMBRE] VARCHAR(45) NOT NULL,
    -- Auditoria
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    CONSTRAINT [PK_formas_pago] PRIMARY KEY CLUSTERED ([FORMAPAGO_ID] ASC)
);
GO

-- -----------------------------------------------------
-- Table [monedas]
-- -----------------------------------------------------

CREATE TABLE dbo.monedas (
    [MONEDA_ID] INT NOT NULL IDENTITY(1,1),
    [NOMBRE] VARCHAR(45) NOT NULL,
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    CONSTRAINT [PK_monedas] PRIMARY KEY CLUSTERED ([MONEDA_ID] ASC)
);
GO

-- -----------------------------------------------------
-- Table [comprobantes]
-- -----------------------------------------------------


CREATE TABLE dbo.comprobantes (
    [COMPROBANTE_ID] INT NOT NULL IDENTITY(1,1),
    [PERSONA_ID_PERSONA] INT NOT NULL,
    [FORMA_PAGO_ID_FORMAPAGO] INT NOT NULL,
    [MONEDA_ID_MONEDA] INT NOT NULL,
    [TRANSACCION_ID] VARCHAR(45) NOT NULL,
    [FECHA_EMISION] DATETIME NOT NULL DEFAULT GETDATE(),
    [MONTO] DECIMAL(10,2) NOT NULL,
    [IMPUESTO] DECIMAL(10,2) NULL,
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    
    CONSTRAINT [PK_comprobantes] PRIMARY KEY CLUSTERED ([COMPROBANTE_ID] ASC),
    
    CONSTRAINT [fk_COMPROBANTE_FORMA_PAGO1] FOREIGN KEY ([FORMA_PAGO_ID_FORMAPAGO])
        REFERENCES dbo.formas_pago ([FORMAPAGO_ID]),
    CONSTRAINT [fk_COMPROBANTE_MONEDA1] FOREIGN KEY ([MONEDA_ID_MONEDA])
        REFERENCES dbo.monedas ([MONEDA_ID]),
    CONSTRAINT [fk_COMPROBANTE_PERSONA1] FOREIGN KEY ([PERSONA_ID_PERSONA])
        REFERENCES dbo.personas ([PERSONA_ID])
);
GO
-- Indices para FKs (Vitales para búsquedas)
CREATE INDEX [IX_comprobantes_PERSONA] ON dbo.comprobantes ([PERSONA_ID_PERSONA]);
CREATE INDEX [IX_comprobantes_FORMA_PAGO] ON dbo.comprobantes ([FORMA_PAGO_ID_FORMAPAGO]);
CREATE INDEX [IX_comprobantes_MONEDA] ON dbo.comprobantes ([MONEDA_ID_MONEDA]);
GO

-- -----------------------------------------------------
-- Table [detalles_comprobantes]
-- -----------------------------------------------------


CREATE TABLE dbo.detalles_comprobantes (
    [DETALLECOM_ID] INT NOT NULL IDENTITY(1,1),
    [COMPROBANTE_ID_COMPROBANTE] INT NOT NULL,
    [ITEM_ID_ITEM] INT NULL,
    [ALQUILER_ID_ALQUILER] INT NULL,
    [DESCRIPCION] VARCHAR(100) NOT NULL,
    [PRECIO] DECIMAL(10,2) NOT NULL,
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,

    CONSTRAINT [PK_detalles_comprobantes] PRIMARY KEY CLUSTERED ([DETALLECOM_ID] ASC, [COMPROBANTE_ID_COMPROBANTE] ASC),
    
    CONSTRAINT [fk_DETALLE_COMPROBANTE_ALQUILER1] FOREIGN KEY ([ALQUILER_ID_ALQUILER])
        REFERENCES dbo.alquileres ([ALQUILER_ID]),
    CONSTRAINT [fk_DETALLE_COMPROBANTE_COMPROBANTE1] FOREIGN KEY ([COMPROBANTE_ID_COMPROBANTE])
        REFERENCES dbo.comprobantes ([COMPROBANTE_ID]),
    CONSTRAINT [fk_DETALLE_COMPROBANTE_ITEM1] FOREIGN KEY ([ITEM_ID_ITEM])
        REFERENCES dbo.items ([ITEM_ID])
);
GO
-- Indices para FKs
CREATE INDEX [IX_detalles_comprobantes_ITEM] ON dbo.detalles_comprobantes ([ITEM_ID_ITEM]);
CREATE INDEX [IX_detalles_comprobantes_ALQUILER] ON dbo.detalles_comprobantes ([ALQUILER_ID_ALQUILER]);
CREATE INDEX [IX_detalles_comprobantes_COMPROBANTE] ON dbo.detalles_comprobantes ([COMPROBANTE_ID_COMPROBANTE]);
GO

-- -----------------------------------------------------
-- Table [estados_mensajes]
-- -----------------------------------------------------

CREATE TABLE dbo.estados_mensajes (
    [ESTADOMSJ_ID] INT NOT NULL IDENTITY(1,1),
    [NOMBRE] VARCHAR(100) NOT NULL,
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    CONSTRAINT [PK_estados_mensajes] PRIMARY KEY CLUSTERED ([ESTADOMSJ_ID] ASC)
);
GO

-- -----------------------------------------------------
-- Table [estados_publicaciones]
-- -----------------------------------------------------


CREATE TABLE dbo.estados_publicaciones (
    [ESTADOPUBLI_ID] INT NOT NULL IDENTITY(1,1),
    [NOMBRE] VARCHAR(100) NOT NULL,
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    CONSTRAINT [PK_estados_publicaciones] PRIMARY KEY CLUSTERED ([ESTADOPUBLI_ID] ASC)
);
GO

-- -----------------------------------------------------
-- Table [publicaciones]
-- -----------------------------------------------------


CREATE TABLE dbo.publicaciones (
    [PUBLICACION_ID] INT NOT NULL IDENTITY(1,1),
    [ESTADO_PUBLICACION_ID] INT NOT NULL,
    [ITEM_ID_ITEM] INT NOT NULL,
    [PERSONA_ID] INT NOT NULL,
    [FECHA_ALTA] DATETIME NULL,
    [FECHA_BAJA] DATETIME NULL,
    [CALIFICACION] INT NULL DEFAULT 0,
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    
    CONSTRAINT [PK_publicaciones] PRIMARY KEY CLUSTERED ([PUBLICACION_ID] ASC),
    
    CONSTRAINT [fk_PUBLICACION_ESTADO_PUBLICACION1] FOREIGN KEY ([ESTADO_PUBLICACION_ID])
        REFERENCES dbo.estados_publicaciones ([ESTADOPUBLI_ID]),
    CONSTRAINT [fk_PUBLICACION_ITEM1] FOREIGN KEY ([ITEM_ID_ITEM])
        REFERENCES dbo.items ([ITEM_ID]),
    CONSTRAINT [fk_PUBLICACION_PERSONA1] FOREIGN KEY ([PERSONA_ID])
        REFERENCES dbo.personas ([PERSONA_ID])
);
GO
-- Indices para FKs
CREATE INDEX [IX_publicaciones_ESTADO] ON dbo.publicaciones ([ESTADO_PUBLICACION_ID]);
CREATE INDEX [IX_publicaciones_ITEM] ON dbo.publicaciones ([ITEM_ID_ITEM]);
CREATE INDEX [IX_publicaciones_PERSONA] ON dbo.publicaciones ([PERSONA_ID]);
GO

-- -----------------------------------------------------
-- Table [historias_publicaciones]
-- -----------------------------------------------------


CREATE TABLE dbo.historias_publicaciones (
    [HISTORIAPUBLI_ID] INT NOT NULL IDENTITY(1,1),
    [PUBLICACION_ID] INT NOT NULL,
    [USUARIO_MODIFICACION_PUBLICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION_PUBLICACION] DATETIME NULL,
    [ESTADO_ID_ANTERIOR] INT NULL,
    [ITEM_ID_ITEM_ANTERIOR] INT NULL,
    [ESTADO_ID_ACTUAL] INT NOT NULL,
    [ITEM_ID_ITEM_ACTUAL] INT NOT NULL,
    -- Auditoria
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    
    CONSTRAINT [PK_historias_publicaciones] PRIMARY KEY CLUSTERED ([HISTORIAPUBLI_ID] ASC, [PUBLICACION_ID] ASC),
    CONSTRAINT [fk_HISTORIA_PUBLI_PUBLICACION1] FOREIGN KEY ([PUBLICACION_ID])
        REFERENCES dbo.publicaciones ([PUBLICACION_ID])
);
GO
-- Index para FK
CREATE INDEX [IX_historias_publicaciones_PUBLICACION] ON dbo.historias_publicaciones ([PUBLICACION_ID]);
GO

-- -----------------------------------------------------
-- Table [motivos]
-- -----------------------------------------------------


CREATE TABLE dbo.motivos (
    [MOTIVO_ID] INT NOT NULL IDENTITY(1,1),
    [NOMBRE] VARCHAR(45) NULL,
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    CONSTRAINT [PK_motivos] PRIMARY KEY CLUSTERED ([MOTIVO_ID] ASC)
);
GO

-- -----------------------------------------------------
-- Table [notificaciones]
-- -----------------------------------------------------


CREATE TABLE dbo.notificaciones (
    [NOTIFICACION_ID] INT NOT NULL IDENTITY(1,1),
    [PERSONA_ID] INT NOT NULL,
    [FECHA] DATETIME NOT NULL,
    [MENSAJE] VARCHAR(255) NOT NULL,
    -- Auditoria
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    
    CONSTRAINT [PK_notificaciones] PRIMARY KEY CLUSTERED ([NOTIFICACION_ID] ASC),
    CONSTRAINT [fk_NOTIFIFACION_PERSONA1] FOREIGN KEY ([PERSONA_ID])
        REFERENCES dbo.personas ([PERSONA_ID])
);
GO
-- Index para FK
CREATE INDEX [IX_notificaciones_PERSONA] ON dbo.notificaciones ([PERSONA_ID]);
GO

-- -----------------------------------------------------
-- Table [incidencias]
-- -----------------------------------------------------


CREATE TABLE dbo.incidencias (
    [INCIDENCIA_ID] INT NOT NULL IDENTITY(1,1),
    [PERSONA_ID] INT NOT NULL,
    [MOTIVO_ID_MOTIVO] INT NOT NULL,
    [DESCRIPCION] VARCHAR(255) NOT NULL,
    [RESPUESTA_ADMIN] VARCHAR(255) NOT NULL,
    [RESUELTO] TINYINT NULL DEFAULT 0,
    [FECHA_SOLUCION] DATETIME NULL,
    [USUARIO_SOLUCION] INT NULL,
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL,
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    
    CONSTRAINT [PK_incidencias] PRIMARY KEY CLUSTERED ([INCIDENCIA_ID] ASC),
    
    CONSTRAINT [fk_INCIDENCIA_MOTIVO1] FOREIGN KEY ([MOTIVO_ID_MOTIVO])
        REFERENCES dbo.motivos ([MOTIVO_ID]),
    CONSTRAINT [fk_INCIDENCIA_PERSONA1] FOREIGN KEY ([PERSONA_ID])
        REFERENCES dbo.personas ([PERSONA_ID])
);
GO
-- Indices para FKs
CREATE INDEX [IX_incidencias_PERSONA] ON dbo.incidencias ([PERSONA_ID]);
CREATE INDEX [IX_incidencias_MOTIVO] ON dbo.incidencias ([MOTIVO_ID_MOTIVO]);
GO

-- -----------------------------------------------------
-- Table [mensajes]
-- -----------------------------------------------------


CREATE TABLE dbo.mensajes (
    [MENSAJE_ID] INT NOT NULL IDENTITY(1,1),
    [CHAT_ID_CHAT] INT NOT NULL,
    [ESTADO_MSJ_ID] INT NOT NULL,
    [PERSONA_ID] INT NOT NULL,
    [FECHA_ENVIO] DATETIME NOT NULL,
    [FECHA_LEIDO] DATETIME NULL,
    [MENSAJE] VARCHAR(MAX) NOT NULL, -- Uso de MAX para textos largos
    -- Auditoria
    [USUARIO_CREACION] VARCHAR(100) NOT NULL,
    [FECHA_CREACION] DATETIME NOT NULL DEFAULT GETDATE(),
    [USUARIO_MODIFICACION] VARCHAR(100) NULL,
    [FECHA_MODIFICACION] DATETIME NULL,
    
    CONSTRAINT [PK_mensajes] PRIMARY KEY CLUSTERED ([MENSAJE_ID] ASC, [CHAT_ID_CHAT] ASC),
    
    CONSTRAINT [fk_MENSAJE_CHAT1] FOREIGN KEY ([CHAT_ID_CHAT])
        REFERENCES dbo.chats ([CHAT_ID]),
    CONSTRAINT [fk_MENSAJE_ESTADO_MSJ1] FOREIGN KEY ([ESTADO_MSJ_ID])
        REFERENCES dbo.estados_mensajes ([ESTADOMSJ_ID]),
    CONSTRAINT [fk_MENSAJE_PERSONA1] FOREIGN KEY ([PERSONA_ID])
        REFERENCES dbo.personas ([PERSONA_ID])
);
GO
-- Indices para FKs
CREATE INDEX [IX_mensajes_CHAT] ON dbo.mensajes ([CHAT_ID_CHAT]);
CREATE INDEX [IX_mensajes_ESTADO] ON dbo.mensajes ([ESTADO_MSJ_ID]);
CREATE INDEX [IX_mensajes_PERSONA] ON dbo.mensajes ([PERSONA_ID]);
GO

-- -----------------------------------------------------
-- Table [personas_chats]
-- -----------------------------------------------------


CREATE TABLE dbo.personas_chats (
    [PERSONA_ID] INT NOT NULL,
    [CHAT_ID] INT NOT NULL,
    
    CONSTRAINT [PK_personas_chats] PRIMARY KEY CLUSTERED ([PERSONA_ID] ASC, [CHAT_ID] ASC),
    
    CONSTRAINT [fk_PERSONA_has_CHAT_CHAT1] FOREIGN KEY ([CHAT_ID])
        REFERENCES dbo.chats ([CHAT_ID]),
    CONSTRAINT [fk_PERSONA_has_CHAT_PERSONA1] FOREIGN KEY ([PERSONA_ID])
        REFERENCES dbo.personas ([PERSONA_ID])
);
GO
-- Indices para FKs
CREATE INDEX [IX_personas_chats_PERSONA] ON dbo.personas_chats ([PERSONA_ID]);
CREATE INDEX [IX_personas_chats_CHAT] ON dbo.personas_chats ([CHAT_ID]);
GO