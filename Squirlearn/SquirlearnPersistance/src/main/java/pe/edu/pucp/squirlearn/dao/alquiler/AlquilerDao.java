package pe.edu.pucp.squirlearn.dao.alquiler;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.alquiler.AlquilerDto;
import pe.edu.pucp.squirlearn.dao.IDAO;

public interface AlquilerDao extends IDAO<AlquilerDto>{
    
    ArrayList<AlquilerDto> listarPorDueno(Integer personaId);

}
