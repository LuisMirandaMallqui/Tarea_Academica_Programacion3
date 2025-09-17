package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import pe.edu.pucp.softinv.model.ComprobantePagoDTO;

public interface ComprobantePagoDAO {
    public Integer insertar(ComprobantePagoDTO obj);
    public ComprobantePagoDTO obtenerPorId(Integer comprobanteDePagoId);
    public ArrayList<ComprobantePagoDTO> listarTodos();
    public Integer modificar(ComprobantePagoDTO obj);
    public Integer eliminar(ComprobantePagoDTO obj);
}
