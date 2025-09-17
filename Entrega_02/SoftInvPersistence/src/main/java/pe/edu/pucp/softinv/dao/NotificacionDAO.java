package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import pe.edu.pucp.softinv.model.NotificacionDTO;

public interface NotificacionDAO {
    public Integer insertar(NotificacionDTO obj);
    public NotificacionDTO obtenerPorId(Integer notificacionId);
    public ArrayList<NotificacionDTO> listarTodos();
    public Integer modificar(NotificacionDTO obj);
    public Integer eliminar(NotificacionDTO obj);
}
