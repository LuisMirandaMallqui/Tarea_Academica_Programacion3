package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import pe.edu.pucp.softinv.model.PublicacionDTO;

public interface PublicacionDAO {
    public Integer insertar(PublicacionDTO obj);
    public PublicacionDTO obtenerPorId(Integer publicacionId);
    public ArrayList<PublicacionDTO> listarTodos();
    public Integer modificar(PublicacionDTO obj);
    public Integer eliminar(PublicacionDTO obj);
}
