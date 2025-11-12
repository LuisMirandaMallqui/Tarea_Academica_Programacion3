package pe.edu.pucp.squirlearn.dao.publicacion;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionDto;
import pe.edu.pucp.squirlearn.dao.IDAO;

public interface PublicacionDao extends IDAO<PublicacionDto>{

    ArrayList<PublicacionDto> listarPorEstado(Integer estadoId);

    public ArrayList<PublicacionDto> listarPorFiltrosPublicacion(
            String terminoBusqueda,
            Boolean esVenta,
            Integer idCategoria,
            Integer idSubcategoria,
            Integer idColores,
            Integer idTamanos,
            Integer idFormatos,
            Integer idCondicion,
            Integer idEstado
    );
    
}


