USE [mydb];
GO

-- -------------------------------------------------------------------------------------------
-- REPORTES
-- -------------------------------------------------------------------------------------------

/* REPORTE CORRESPONDIENTE AL RF20 - Reporte Mejores Calificaciones */
IF OBJECT_ID('dbo.REPORTE_CALIFICACIONES', 'P') IS NOT NULL 
    DROP PROCEDURE dbo.REPORTE_CALIFICACIONES;
GO

CREATE PROCEDURE dbo.REPORTE_CALIFICACIONES
AS
BEGIN
    SET NOCOUNT ON; -- para quitar el mensaje de filas afectadas y que sea mas limpia la salida

    SELECT  s.PERSONA_ID, 
            s.NOMBRES, 
            s.PRIMER_APELLIDO,
            s.CODIGO, 
            -- En SQL Server, AVG de enteros devuelve entero entonces toca castear
            -- Debemos convertir a DECIMAL para obtener decimales (ej. 4.5) antes de redondear.
            ROUND(AVG(CAST(p.CALIFICACION AS DECIMAL(10,2))), 1) AS CALIFICACION,
            CASE 
                WHEN AVG(CAST(p.CALIFICACION AS DECIMAL(10,2))) >= 4 THEN 'EXCELENTE'
                WHEN AVG(CAST(p.CALIFICACION AS DECIMAL(10,2))) >= 3 THEN 'BUENO'
                WHEN AVG(CAST(p.CALIFICACION AS DECIMAL(10,2))) >= 2 THEN 'REGULAR'
                WHEN AVG(CAST(p.CALIFICACION AS DECIMAL(10,2))) >= 1 THEN 'BAJO'
                ELSE 'MUY BAJO'
            END AS CATEGORIA
    FROM dbo.personas s
    JOIN dbo.publicaciones p ON s.PERSONA_ID = p.PERSONA_ID
    GROUP BY s.PERSONA_ID, s.NOMBRES, s.PRIMER_APELLIDO, s.CODIGO
    ORDER BY CALIFICACION DESC;
END
GO

/* REPORTE CORRESPONDIENTE AL RF19 - Reporte Ventas */
IF OBJECT_ID('dbo.REPORTE_VENTA', 'P') IS NOT NULL 
    DROP PROCEDURE dbo.REPORTE_VENTA;
GO

CREATE PROCEDURE dbo.REPORTE_VENTA
    @_persona INT -- Parámetros con @
AS
BEGIN
    SET NOCOUNT ON;

    SELECT  c.TRANSACCION_ID, 
            i.NOMBRE,
            c.FECHA_EMISION,
            c.PERSONA_ID_PERSONA AS comprador,
            d.PRECIO
    FROM dbo.publicaciones p
    JOIN dbo.items i ON i.ITEM_ID = p.ITEM_ID_ITEM
    JOIN dbo.detalles_comprobantes d ON d.ITEM_ID_ITEM = i.ITEM_ID
    JOIN dbo.comprobantes c ON c.COMPROBANTE_ID = d.COMPROBANTE_ID_COMPROBANTE
    WHERE p.PERSONA_ID = @_persona;
END
GO

/* REPORTE ALQUILER */
IF OBJECT_ID('dbo.REPORTE_ALQUILER', 'P') IS NOT NULL 
    DROP PROCEDURE dbo.REPORTE_ALQUILER;
GO

CREATE PROCEDURE dbo.REPORTE_ALQUILER
    @_persona INT,
    @_inicio DATE,
    @_fin DATE
AS
BEGIN
    SET NOCOUNT ON;

    SELECT  c.TRANSACCION_ID, 
            i.NOMBRE,
            c.FECHA_EMISION,
            c.PERSONA_ID_PERSONA AS comprador,
            d.PRECIO
    FROM dbo.publicaciones p
    JOIN dbo.items i ON i.ITEM_ID = p.ITEM_ID_ITEM
    JOIN dbo.alquileres a ON a.ITEM_ID = i.ITEM_ID
    JOIN dbo.detalles_comprobantes d ON a.ALQUILER_ID = d.ALQUILER_ID_ALQUILER
    JOIN dbo.comprobantes c ON c.COMPROBANTE_ID = d.COMPROBANTE_ID_COMPROBANTE
    WHERE p.PERSONA_ID = @_persona 
      AND c.FECHA_EMISION >= @_inicio 
      AND c.FECHA_EMISION <= @_fin; 
END
GO

/* REPORTE CORRESPONDIENTE AL RF18 - Reporte mas transacciones (Ofertador) */
IF OBJECT_ID('dbo.REPORTE_TRANSACCCIONES_OFERTADOR', 'P') IS NOT NULL 
    DROP PROCEDURE dbo.REPORTE_TRANSACCCIONES_OFERTADOR;
GO

CREATE PROCEDURE dbo.REPORTE_TRANSACCCIONES_OFERTADOR
    @_inicio DATE,
    @_fin DATE
AS
BEGIN
    SET NOCOUNT ON;

    SELECT  s.PERSONA_ID,
            s.NOMBRES,
            s.PRIMER_APELLIDO, 
            s.CODIGO,
            COUNT(*) AS NUM_TRANSACCIONES,
            SUM(d.PRECIO) AS TOTAL 
    FROM dbo.publicaciones p
    JOIN dbo.items i ON i.ITEM_ID = p.ITEM_ID_ITEM
    JOIN dbo.alquileres a ON a.ITEM_ID = i.ITEM_ID 
    JOIN dbo.detalles_comprobantes d ON d.ITEM_ID_ITEM = i.ITEM_ID 
                                   AND a.ALQUILER_ID = d.ALQUILER_ID_ALQUILER
    JOIN dbo.comprobantes c ON c.COMPROBANTE_ID = d.COMPROBANTE_ID_COMPROBANTE
    JOIN dbo.personas s ON s.PERSONA_ID = p.PERSONA_ID
    WHERE c.FECHA_EMISION >= @_inicio AND c.FECHA_EMISION <= @_fin
    -- En SQL Server, todas las columnas del SELECT que no son agregaciones (SUM, COUNT) deben ir en el GROUP BY
    GROUP BY s.PERSONA_ID, s.NOMBRES, s.PRIMER_APELLIDO, s.CODIGO; 
END
GO

/* REPORTE TRANSACCIONES RECEPTOR */
IF OBJECT_ID('dbo.REPORTE_TRANSACCCIONES_RECEPTOR', 'P') IS NOT NULL 
    DROP PROCEDURE dbo.REPORTE_TRANSACCCIONES_RECEPTOR;
GO

CREATE PROCEDURE dbo.REPORTE_TRANSACCCIONES_RECEPTOR
    @_inicio DATE,
    @_fin DATE
AS
BEGIN
    SET NOCOUNT ON;

    SELECT  s.PERSONA_ID,
            s.NOMBRES,
            s.PRIMER_APELLIDO, 
            s.CODIGO,
            COUNT(*) AS NUM_TRANSACCIONES,
            SUM(c.MONTO) AS TOTAL
    FROM dbo.personas s
    JOIN dbo.comprobantes c ON c.PERSONA_ID_PERSONA = s.PERSONA_ID
    WHERE c.FECHA_EMISION >= @_inicio AND c.FECHA_EMISION <= @_fin
    -- Group By explícito, este es requerido en SQL Server
    GROUP BY s.PERSONA_ID, s.NOMBRES, s.PRIMER_APELLIDO, s.CODIGO; 
END
GO