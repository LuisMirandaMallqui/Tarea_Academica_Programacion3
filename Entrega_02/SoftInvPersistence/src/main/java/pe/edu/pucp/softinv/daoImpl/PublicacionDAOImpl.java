package pe.edu.pucp.softinv.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softinv.dao.PublicacionDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.PublicacionDTO;

public class PublicacionDAOImpl implements PublicacionDAO {
    private Connection conexion;
    private CallableStatement statement;
    private ResultSet resultSet;

    @Override
    public Integer insertar(PublicacionDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PublicacionDTO obtenerPorId(Integer publicacionId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<PublicacionDTO> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer modificar(PublicacionDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer eliminar(PublicacionDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
