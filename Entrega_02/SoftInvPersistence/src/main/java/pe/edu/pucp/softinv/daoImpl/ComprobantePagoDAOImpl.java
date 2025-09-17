package pe.edu.pucp.softinv.daoImpl;

import pe.edu.pucp.softinv.dao.ComprobantePagoDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.ComprobantePagoDTO;
import pe.edu.pucp.softinv.model.PersonasDTO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ComprobantePagoDAOImpl implements ComprobantePagoDAO {

    @Override
    public Integer insertar(ComprobantePagoDTO c) {
        String sql = "INSERT INTO COMPROBANTE_DE_PAGO(PERSONA_PERSONA_CODIGO, FECHA_PAGO, MONTO_PAGO, NUMERO_TRANSACCIÓN, DESCRIPCION) VALUES (?,?,?,?,?)";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, c.getPersonaId().getPersonaId());
            ps.setTimestamp(2, Timestamp.valueOf(c.getFecha()));
            ps.setDouble(3, c.getMontoPago());
            ps.setInt(4, c.getNumeroTransaccion());
            ps.setString(5, c.getDescripcion());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
            return 0;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public ComprobantePagoDTO obtenerPorId(Integer id) {
        String sql = "SELECT COMPROBANTE_DE_PAGO_ID, PERSONA_PERSONA_CODIGO, FECHA_PAGO, MONTO_PAGO, NUMERO_TRANSACCIÓN, DESCRIPCION FROM COMPROBANTE_DE_PAGO WHERE COMPROBANTE_DE_PAGO_ID=?";
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
    public Integer modificar(ComprobantePagoDTO c) {
        String sql = "UPDATE COMPROBANTE_DE_PAGO SET PERSONA_PERSONA_CODIGO=?, FECHA_PAGO=?, MONTO_PAGO=?, NUMERO_TRANSACCIÓN=?, DESCRIPCION=? WHERE COMPROBANTE_DE_PAGO_ID=?";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, c.getPersonaId().getPersonaId());
            ps.setTimestamp(2, Timestamp.valueOf(c.getFecha()));
            ps.setDouble(3, c.getMontoPago());
            ps.setInt(4, c.getNumeroTransaccion());
            ps.setString(5, c.getDescripcion());
            ps.setInt(6, c.getComprobanteDePagoId());
            return ps.executeUpdate();
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public ArrayList<ComprobantePagoDTO> listarTodos() {
        String sql = "SELECT COMPROBANTE_DE_PAGO_ID, PERSONA_PERSONA_CODIGO, FECHA_PAGO, MONTO_PAGO, NUMERO_TRANSACCIÓN, DESCRIPCION FROM COMPROBANTE_DE_PAGO";
        ArrayList<ComprobantePagoDTO> out = new ArrayList<>();
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(map(rs));
            return out;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public Integer eliminar(ComprobantePagoDTO c) {
        String sql = "DELETE FROM COMPROBANTE_DE_PAGO WHERE COMPROBANTE_DE_PAGO_ID=?";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, c.getComprobanteDePagoId());
            return ps.executeUpdate();
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    private ComprobantePagoDTO map(ResultSet rs) throws Exception {
        ComprobantePagoDTO c = new ComprobantePagoDTO();
        c.setComprobanteDePagoId(rs.getInt("COMPROBANTE_DE_PAGO_ID"));
        PersonasDTO p = new PersonasDTO();
        p.setPersonaId(rs.getInt("PERSONA_PERSONA_CODIGO"));
        c.setPersonaId(p);
        Timestamp t = rs.getTimestamp("FECHA_PAGO");
        c.setFecha(t != null ? t.toLocalDateTime() : LocalDateTime.now());
        c.setMontoPago(rs.getDouble("MONTO_PAGO"));
        c.setNumeroTransaccion(rs.getInt("NUMERO_TRANSACCIÓN"));
        c.setDescripcion(rs.getString("DESCRIPCION"));
        return c;
    }
}
