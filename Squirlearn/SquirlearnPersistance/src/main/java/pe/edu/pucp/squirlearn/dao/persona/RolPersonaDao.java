package pe.edu.pucp.squirlearn.dao.persona;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.persona.RolPersonaDto;
import pe.edu.pucp.squirlearn.dao.IDAO;

public interface RolPersonaDao extends IDAO<RolPersonaDto>{
    ArrayList<RolPersonaDto> listarPorPersona(Integer personaId);
    public void insertarTablaInter(Integer idPersona, String correo);
}
