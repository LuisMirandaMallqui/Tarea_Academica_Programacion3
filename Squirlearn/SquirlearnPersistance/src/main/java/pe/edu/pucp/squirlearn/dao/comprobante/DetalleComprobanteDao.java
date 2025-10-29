package pe.edu.pucp.squirlearn.dao.comprobante;

import java.util.ArrayList;
import pe.edu.pucp.squirlearn.model.comprobante.DetalleComprobanteDto;
import pe.edu.pucp.squirlearn.dao.IDAO;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto;

public interface DetalleComprobanteDao extends IDAO<DetalleComprobanteDto>{
    
    ArrayList<DetalleComprobanteDto> listarPorComprobante(Integer comprobanteId);
}
