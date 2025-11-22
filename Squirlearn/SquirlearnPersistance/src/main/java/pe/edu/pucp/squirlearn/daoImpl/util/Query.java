/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.squirlearn.daoImpl.util;

import java.util.List;

/**
 *
 * @author luism
 */
public class Query {
    // Se agregan estas constantes como medida de seguridad en caso lleguen parametros no validos
    public static final int PAGINA_POR_DEFECTO = 1;
    public static final int TAMANO_PAGINA_POR_DEFECTO = 10;

    public static void aplicarPaginacion(StringBuilder sql, List<Object> parametros, Integer pagina, Integer cantidadPorPagina) {
        // Validamos y saneamos los inputs primero
        int pag = (pagina != null && pagina > 0) ? pagina : PAGINA_POR_DEFECTO;
        int cant = (cantidadPorPagina != null && cantidadPorPagina > 0) ? cantidadPorPagina : TAMANO_PAGINA_POR_DEFECTO;

        int offset = (pag - 1) * cant;
        sql.append(" LIMIT ? OFFSET ? ");
        parametros.add(cant);
        parametros.add(offset);
    }
}
