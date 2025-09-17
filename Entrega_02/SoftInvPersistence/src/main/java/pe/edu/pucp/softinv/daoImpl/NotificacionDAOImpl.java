package pe.edu.pucp.softinv.daoImpl;

import pe.edu.pucp.softinv.dao.NotificacionDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.NotificacionDTO;
import pe.edu.pucp.softinv.model.PersonasDTO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class NotificacionDAOImpl implements NotificacionDAO {

    @Override
    public Integer insertar(NotificacionDTO n) {
        String sql = "INSERT INTO NOTIFACIÓN(PERSONA_CODIGO, MENSAJE, FECHA_ENVIO) VALUES (?,?,?)";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, n.getPersonaId().getPersonaId());
            ps.setString(2, n.getMensaje());
            ps.setTimestamp(3, Timestamp.valueOf(n.getFecha()));
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
            return 0;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public NotificacionDTO obtenerPorId(Integer id) {
        String sql = "SELECT NOTIFICACIÓN_ID, PERSONA_CODIGO, MENSAJE, FECHA_ENVIO FROM NOTIFACIÓN WHERE NOTIFICACIÓN_ID=?";
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
    public Integer modificar(NotificacionDTO n) {
        String sql = "UPDATE NOTIFACIÓN SET PERSONA_CODIGO=?, MENSAJE=?, FECHA_ENVIO=? WHERE NOTIFICACIÓN_ID=?";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, n.getPersonaId().getPersonaId());
            ps.setString(2, n.getMensaje());
            ps.setTimestamp(3, Timestamp.valueOf(n.getFecha()));
            ps.setInt(4, n.getNotificacionId());
            return ps.executeUpdate();
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public ArrayList<NotificacionDTO> listarTodos() {
        String sql = "SELECT NOTIFICACIÓN_ID, PERSONA_CODIGO, MENSAJE, FECHA_ENVIO FROM NOTIFACIÓN";
        ArrayList<NotificacionDTO> out = new ArrayList<>();
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(map(rs));
            return out;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public Integer eliminar(NotificacionDTO n) {
        String sql = "DELETE FROM NOTIFACIÓN WHERE NOTIFICACIÓN_ID=?";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, n.getNotificacionId());
            return ps.executeUpdate();
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    private NotificacionDTO map(ResultSet rs) throws Exception {
        NotificacionDTO n = new NotificacionDTO();
        n.setNotificacionId(rs.getInt("NOTIFICACIÓN_ID"));
        PersonasDTO p = new PersonasDTO();
        p.setPersonaId(rs.getInt("PERSONA_CODIGO"));
        n.setPersonaId(p);
        n.setMensaje(rs.getString("MENSAJE"));
        Timestamp t = rs.getTimestamp("FECHA_ENVIO");
        n.setFecha(t != null ? t.toLocalDateTime() : LocalDateTime.now());
        return n;
    }
}
