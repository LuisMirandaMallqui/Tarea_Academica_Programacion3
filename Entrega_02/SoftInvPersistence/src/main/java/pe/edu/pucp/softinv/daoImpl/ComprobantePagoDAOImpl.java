package pe.edu.pucp.softinv.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softinv.dao.ComprobantePagoDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.ComprobantePagoDTO;

public class ComprobantePagoDAOImpl implements ComprobantePagoDAO {
    private Connection conexion;
    private CallableStatement statement;
    private ResultSet resultSet;

    @Override
    public Integer insertar(ComprobantePagoDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ComprobantePagoDTO obtenerPorId(Integer comprobanteDePagoId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<ComprobantePagoDTO> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer modificar(ComprobantePagoDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Integer eliminar(ComprobantePagoDTO obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
