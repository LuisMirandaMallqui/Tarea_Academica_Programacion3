package pe.edu.pucp.squirlearn.dao.chat;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.chat.PersonaChatDto;
import pe.edu.pucp.squirlearn.dao.IDAO;

public interface PersonaChatDao extends IDAO<PersonaChatDto>{
    
    ArrayList<PersonaChatDto> listarPorPersona(Integer personaId);

}
