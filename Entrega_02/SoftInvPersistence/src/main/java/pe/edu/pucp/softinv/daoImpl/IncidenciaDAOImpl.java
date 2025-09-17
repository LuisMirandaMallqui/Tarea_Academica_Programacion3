package pe.edu.pucp.softinv.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softinv.dao.IncidenciaDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.IncidenciaDTO;

public class IncidenciaDAOImpl implements IncidenciaDAO {
    private Connection conexion;
    private CallableStatement statement;
    private ResultSet resultSet;

    @Override
    public Integer insertar(IncidenciaDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IncidenciaDTO obtenerPorId(Integer incidenciaId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<IncidenciaDTO> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer modificar(IncidenciaDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer eliminar(IncidenciaDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
