package pe.edu.pucp.softinv.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softinv.dao.NotificacionDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.NotificacionDTO;

public class NotificacionDAOImpl implements NotificacionDAO {
    private Connection conexion;
    private CallableStatement statement;
    private ResultSet resultSet;

    @Override
    public Integer insertar(NotificacionDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public NotificacionDTO obtenerPorId(Integer notificacionId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<NotificacionDTO> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer modificar(NotificacionDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer eliminar(NotificacionDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
