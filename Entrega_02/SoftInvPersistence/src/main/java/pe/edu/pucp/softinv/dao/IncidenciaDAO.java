package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import pe.edu.pucp.softinv.model.IncidenciaDTO;

public interface IncidenciaDAO {
    public Integer insertar(IncidenciaDTO obj);
    public IncidenciaDTO obtenerPorId(Integer incidenciaId);
    public ArrayList<IncidenciaDTO> listarTodos();
    public Integer modificar(IncidenciaDTO obj);
    public Integer eliminar(IncidenciaDTO obj);
}
