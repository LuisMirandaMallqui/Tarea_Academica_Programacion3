package pe.edu.pucp.softinv.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softinv.dao.PersonasDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.PersonasDTO;

public class PersonasDAOImpl implements PersonasDAO {
    private Connection conexion;
    private CallableStatement statement;
    private ResultSet resultSet;

    @Override
    public Integer insertar(PersonasDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PersonasDTO obtenerPorId(Integer personaId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<PersonasDTO> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer modificar(PersonasDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer eliminar(PersonasDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
