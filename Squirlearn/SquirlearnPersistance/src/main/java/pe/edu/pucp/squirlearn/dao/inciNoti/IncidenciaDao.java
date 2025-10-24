package pe.edu.pucp.squirlearn.dao.inciNoti;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.inciNoti.IncidenciaDto;
import pe.edu.pucp.squirlearn.dao.IDAO;

public interface IncidenciaDao extends IDAO<IncidenciaDto>{
 
    ArrayList<IncidenciaDto> listarPorResolucion(Boolean resuelto);
}
