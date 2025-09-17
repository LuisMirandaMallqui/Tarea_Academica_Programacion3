package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import pe.edu.pucp.softinv.model.PersonasDTO;

public interface PersonasDAO {
    public Integer insertar(PersonasDTO obj);
    public PersonasDTO obtenerPorId(Integer personaId);
    public ArrayList<PersonasDTO> listarTodos();
    public Integer modificar(PersonasDTO obj);
    public Integer eliminar(PersonasDTO obj);
}
