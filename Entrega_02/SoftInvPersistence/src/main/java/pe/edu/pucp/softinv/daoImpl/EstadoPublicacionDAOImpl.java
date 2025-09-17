package pe.edu.pucp.softinv.daoImpl;

import pe.edu.pucp.softinv.dao.EstadoPublicacionDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.EstadoPublicacionDTO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EstadoPublicacionDAOImpl implements EstadoPublicacionDAO {

    @Override
    public Integer insertar(EstadoPublicacionDTO e) {
        String sql = "INSERT INTO ESTADO_PUBLICACION(DESCRIPCION, FECHA_INGRESO) VALUES (?,?)";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, e.getDescripcion());
            ps.setTimestamp(2, Timestamp.valueOf(e.getFechaIngreso()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
            return 0;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public EstadoPublicacionDTO obtenerPorId(Integer id) {
        String sql = "SELECT ESTADO_PUBLICACION_ID, DESCRIPCION, FECHA_INGRESO FROM ESTADO_PUBLICACION WHERE ESTADO_PUBLICACION_ID=?";
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
    public Integer modificar(EstadoPublicacionDTO e) {
        String sql = "UPDATE ESTADO_PUBLICACION SET DESCRIPCION=?, FECHA_INGRESO=? WHERE ESTADO_PUBLICACION_ID=?";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, e.getDescripcion());
            ps.setTimestamp(2, Timestamp.valueOf(e.getFechaIngreso()));
            ps.setInt(3, e.getEstadoPublicacionId());
            return ps.executeUpdate();
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public ArrayList<EstadoPublicacionDTO> listarTodos() {
        String sql = "SELECT ESTADO_PUBLICACION_ID, DESCRIPCION, FECHA_INGRESO FROM ESTADO_PUBLICACION";
        ArrayList<EstadoPublicacionDTO> out = new ArrayList<>();
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(map(rs));
            return out;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public Integer eliminar(EstadoPublicacionDTO e) {
        String sql = "DELETE FROM ESTADO_PUBLICACION WHERE ESTADO_PUBLICACION_ID=?";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, e.getEstadoPublicacionId());
            return ps.executeUpdate();
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    private EstadoPublicacionDTO map(ResultSet rs) throws Exception {
        EstadoPublicacionDTO e = new EstadoPublicacionDTO();
        e.setEstadoPublicacionId(rs.getInt("ESTADO_PUBLICACION_ID"));
        e.setDescripcion(rs.getString("DESCRIPCION"));
        Timestamp t = rs.getTimestamp("FECHA_INGRESO");
        e.setFechaIngreso(t != null ? t.toLocalDateTime() : LocalDateTime.now());
        return e;
    }
}
