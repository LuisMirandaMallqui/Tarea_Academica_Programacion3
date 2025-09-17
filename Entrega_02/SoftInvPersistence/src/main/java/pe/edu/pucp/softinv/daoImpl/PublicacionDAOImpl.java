package pe.edu.pucp.softinv.daoImpl;

import pe.edu.pucp.softinv.dao.PublicacionDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PublicacionDAOImpl implements PublicacionDAO {

    @Override
    public Integer insertar(PublicacionDTO p) {
        String sql = "INSERT INTO PUBLICACION(MATERIAL_MATERIAL_ID, ESTADO_PUBLICACION_ID, PERSONA_CODIGO, VALORACION, FECHA_PUBLICACION, PRECIO) VALUES (?,?,?,?,?,?)";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, p.getMaterialId().getMaterialId());
            ps.setInt(2, p.getEstadoPublicacionId().getEstadoPublicacionId());
            ps.setInt(3, p.getPersonaId().getPersonaId());
            ps.setInt(4, p.getValoracion());
            ps.setTimestamp(5, Timestamp.valueOf(p.getFecha()));
            ps.setDouble(6, p.getPrecio());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
            return 0;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public PublicacionDTO obtenerPorId(Integer id) {
        String sql = "SELECT PUBLICACION_ID, MATERIAL_MATERIAL_ID, ESTADO_PUBLICACION_ID, PERSONA_CODIGO, VALORACION, FECHA_PUBLICACION, PRECIO FROM PUBLICACION WHERE PUBLICACION_ID=?";
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
    public Integer modificar(PublicacionDTO p) {
        String sql = "UPDATE PUBLICACION SET MATERIAL_MATERIAL_ID=?, ESTADO_PUBLICACION_ID=?, PERSONA_CODIGO=?, VALORACION=?, FECHA_PUBLICACION=?, PRECIO=? WHERE PUBLICACION_ID=?";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, p.getMaterialId().getMaterialId());
            ps.setInt(2, p.getEstadoPublicacionId().getEstadoPublicacionId());
            ps.setInt(3, p.getPersonaId().getPersonaId());
            ps.setInt(4, p.getValoracion());
            ps.setTimestamp(5, Timestamp.valueOf(p.getFecha()));
            ps.setDouble(6, p.getPrecio());
            ps.setInt(7, p.getPublicacionId());
            return ps.executeUpdate();
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public ArrayList<PublicacionDTO> listarTodos() {
        String sql = "SELECT PUBLICACION_ID, MATERIAL_MATERIAL_ID, ESTADO_PUBLICACION_ID, PERSONA_CODIGO, VALORACION, FECHA_PUBLICACION, PRECIO FROM PUBLICACION";
        ArrayList<PublicacionDTO> out = new ArrayList<>();
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(map(rs));
            return out;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public Integer eliminar(PublicacionDTO p) {
        String sql = "DELETE FROM PUBLICACION WHERE PUBLICACION_ID=?";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, p.getPublicacionId());
            return ps.executeUpdate();
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    private PublicacionDTO map(ResultSet rs) throws Exception {
        PublicacionDTO p = new PublicacionDTO();
        p.setPublicacionId(rs.getInt("PUBLICACION_ID"));
        MaterialDTO m = new MaterialDTO();
        m.setMaterialId(rs.getInt("MATERIAL_MATERIAL_ID"));
        p.setMaterialId(m);
        EstadoPublicacionDTO e = new EstadoPublicacionDTO();
        e.setEstadoPublicacionId(rs.getInt("ESTADO_PUBLICACION_ID"));
        p.setEstadoPublicacionId(e);
        PersonasDTO per = new PersonasDTO();
        per.setPersonaId(rs.getInt("PERSONA_CODIGO"));
        p.setPersonaId(per);
        p.setValoracion(rs.getInt("VALORACION"));
        Timestamp t = rs.getTimestamp("FECHA_PUBLICACION");
        p.setFecha(t != null ? t.toLocalDateTime() : LocalDateTime.now());
        p.setPrecio(rs.getDouble("PRECIO"));
        return p;
    }
}
