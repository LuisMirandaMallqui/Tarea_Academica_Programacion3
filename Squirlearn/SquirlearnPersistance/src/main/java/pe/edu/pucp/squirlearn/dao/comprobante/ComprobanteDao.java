package pe.edu.pucp.squirlearn.dao.comprobante;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto;
import pe.edu.pucp.squirlearn.dao.IDAO;

public interface ComprobanteDao extends IDAO<ComprobanteDto>{
    
    public ArrayList<ComprobanteDto> listarPorDueno(Integer personaId);

}
