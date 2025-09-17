package pe.edu.pucp.softinv.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softinv.dao.EstadoPublicacionDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.EstadoPublicacionDTO;

public class EstadoPublicacionDAOImpl implements EstadoPublicacionDAO {
    private Connection conexion;
    private CallableStatement statement;
    private ResultSet resultSet;

    @Override
    public Integer insertar(EstadoPublicacionDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public EstadoPublicacionDTO obtenerPorId(Integer estadoPublicacionId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<EstadoPublicacionDTO> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer modificar(EstadoPublicacionDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer eliminar(EstadoPublicacionDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
