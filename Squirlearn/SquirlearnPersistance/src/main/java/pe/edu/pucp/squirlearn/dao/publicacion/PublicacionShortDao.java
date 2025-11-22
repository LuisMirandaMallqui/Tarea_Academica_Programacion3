/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.squirlearn.dao.publicacion;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.dao.IDAO;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionShortDto;

/**
 *
 * @author luism
 */
public interface PublicacionShortDao extends IDAO<PublicacionShortDto> {

    public ArrayList<PublicacionShortDto> listarPorFiltrosPublicacion(
            String terminoBusqueda,
            Boolean esVenta,
            Integer idCategoria,
            Integer idSubcategoria,
            Integer idColor,
            Integer idTamano,
            Integer idFormato,
            Integer idCondicion,
            Integer pagina,
            Integer cantidadPorPagina
    );

    public ArrayList<PublicacionShortDto> listarPorFiltrosPublicacion(
            Integer usuarioId,
            Integer cantidadPorPagina,
            Integer pagina,
            Integer estadoId
    );
    
    public Integer cantidadListarPorFiltrosPublicacion(
            Integer usuarioId,
            Integer estadoId
    );  
    
    public Integer cantidadListarPorFiltrosPublicacion(
            String terminoBusqueda,
            Boolean esVenta,
            Integer idCategoria,
            Integer idSubcategoria,
            Integer idColor,
            Integer idTamano,
            Integer idFormato,
            Integer idCondicion
    );  
}
