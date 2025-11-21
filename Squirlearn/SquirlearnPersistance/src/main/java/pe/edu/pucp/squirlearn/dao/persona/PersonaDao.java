package pe.edu.pucp.squirlearn.dao.persona;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;
import pe.edu.pucp.squirlearn.dao.IDAO;

public interface PersonaDao extends IDAO<PersonaDto>{
 
    PersonaDto buscarPorCorreo(String correo);
    PersonaDto obtenerPorCodigo(String codigo);
    Boolean existeUsuarioEnBD(PersonaDto per);

}
