package pe.edu.pucp.squirlearn.dao.inciNoti;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.inciNoti.NotificacionDto;
import pe.edu.pucp.squirlearn.dao.IDAO;

public interface NotificacionDao extends IDAO<NotificacionDto>{
    
    ArrayList<NotificacionDto> listarPorPersona(Integer personaId);
}
