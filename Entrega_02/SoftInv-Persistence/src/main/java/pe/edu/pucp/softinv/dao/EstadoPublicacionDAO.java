package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import pe.edu.pucp.softinv.model.EstadoPublicacionDTO;

public interface EstadoPublicacionDAO {
    public Integer insertar(EstadoPublicacionDTO obj);
    public EstadoPublicacionDTO obtenerPorId(Integer estadoPublicacionId);
    public ArrayList<EstadoPublicacionDTO> listarTodos();
    public Integer modificar(EstadoPublicacionDTO obj);
    public Integer eliminar(EstadoPublicacionDTO obj);
}
