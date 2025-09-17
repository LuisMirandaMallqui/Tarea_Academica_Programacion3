package pe.edu.pucp.softinv.daoImpl;

import pe.edu.pucp.softinv.dao.IncidenciaDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.IncidenciaDTO;
import pe.edu.pucp.softinv.model.PersonasDTO;

import java.sql.*;
import java.util.ArrayList;

public class IncidenciaDAOImpl implements IncidenciaDAO {

    @Override
    public Integer insertar(IncidenciaDTO i) {
        String sql = "INSERT INTO INCIDENCIA(PERSONA_CODIGO, DESCRIPCION) VALUES (?,?)";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, i.getPersonaId().getPersonaId());
            ps.setString(2, i.getDescripcion());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
            return 0;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public IncidenciaDTO obtenerPorId(Integer id) {
        String sql = "SELECT INCIDENCIA_ID, PERSONA_CODIGO, DESCRIPCION FROM INCIDENCIA WHERE INCIDENCIA_ID=?";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return map(rs);
            }
            return null;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public Integer modificar(IncidenciaDTO i) {
        String sql = "UPDATE INCIDENCIA SET PERSONA_CODIGO=?, DESCRIPCION=? WHERE INCIDENCIA_ID=?";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, i.getPersonaId().getPersonaId());
            ps.setString(2, i.getDescripcion());
            ps.setInt(3, i.getIncidenciaId());
            return ps.executeUpdate();
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public ArrayList<IncidenciaDTO> listarTodos() {
        String sql = "SELECT INCIDENCIA_ID, PERSONA_CODIGO, DESCRIPCION FROM INCIDENCIA";
        ArrayList<IncidenciaDTO> out = new ArrayList<>();
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(map(rs));
            return out;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public Integer eliminar(IncidenciaDTO i) {
        String sql = "DELETE FROM INCIDENCIA WHERE INCIDENCIA_ID=?";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, i.getIncidenciaId());
            return ps.executeUpdate();
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    private IncidenciaDTO map(ResultSet rs) throws Exception {
        IncidenciaDTO i = new IncidenciaDTO();
        i.setIncidenciaId(rs.getInt("INCIDENCIA_ID"));
        PersonasDTO p = new PersonasDTO();
        p.setPersonaId(rs.getInt("PERSONA_CODIGO"));
        i.setPersonaId(p);
        i.setDescripcion(rs.getString("DESCRIPCION"));
        return i;
    }
}
