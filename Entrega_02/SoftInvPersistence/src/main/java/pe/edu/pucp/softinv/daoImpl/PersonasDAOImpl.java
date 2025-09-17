package pe.edu.pucp.softinv.daoImpl;

import pe.edu.pucp.softinv.dao.PersonasDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.PersonasDTO;

import java.sql.*;
import java.util.ArrayList;

public class PersonasDAOImpl implements PersonasDAO {

    @Override
    public Integer insertar(PersonasDTO p) {
        String sql = "INSERT INTO PERSONA(" +
                "ES_ADMINISTRADOR, NOMBRES, PRIMER_APELLIDO, SEGUNDO_APELLIDO, " +
                "CORREO_ELECTRONICO, CODIGO_UNIVERSITARIO, TIPO_DOCUMENTO_ID, NUMERO_DOCUMENTO, CONTRASEÑA" +
                ") VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setBoolean(1, Boolean.TRUE.equals(p.getEsAdministador()));
            ps.setString(2, p.getNombres());
            ps.setString(3, p.getPrimerApellido());
            ps.setString(4, p.getSegundoApellido());
            ps.setString(5, p.getCorreoElectronico());
            ps.setString(6, p.getCodigoUniversitario());
            ps.setString(7, p.getTipoDocumento());
            ps.setString(8, p.getNumeroDocumento());
            ps.setString(9, p.getContraseña());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
            return 0;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public PersonasDTO obtenerPorId(Integer id) {
        String sql = "SELECT PERSONA_CODIGO, ES_ADMINISTRADOR, NOMBRES, PRIMER_APELLIDO, SEGUNDO_APELLIDO, " +
                "CORREO_ELECTRONICO, CODIGO_UNIVERSITARIO, TIPO_DOCUMENTO_ID, NUMERO_DOCUMENTO, CONTRASEÑA " +
                "FROM PERSONA WHERE PERSONA_CODIGO=?";
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
    public Integer modificar(PersonasDTO p) {
        String sql = "UPDATE PERSONA SET " +
                "ES_ADMINISTRADOR=?, NOMBRES=?, PRIMER_APELLIDO=?, SEGUNDO_APELLIDO=?, " +
                "CORREO_ELECTRONICO=?, CODIGO_UNIVERSITARIO=?, TIPO_DOCUMENTO_ID=?, NUMERO_DOCUMENTO=?, CONTRASEÑA=? " +
                "WHERE PERSONA_CODIGO=?";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setBoolean(1, Boolean.TRUE.equals(p.getEsAdministador()));
            ps.setString(2, p.getNombres());
            ps.setString(3, p.getPrimerApellido());
            ps.setString(4, p.getSegundoApellido());
            ps.setString(5, p.getCorreoElectronico());
            ps.setString(6, p.getCodigoUniversitario());
            ps.setString(7, p.getTipoDocumento());
            ps.setString(8, p.getNumeroDocumento());
            ps.setString(9, p.getContraseña());
            ps.setInt(10, p.getPersonaId());
            return ps.executeUpdate();
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public ArrayList<PersonasDTO> listarTodos() {
        String sql = "SELECT PERSONA_CODIGO, ES_ADMINISTRADOR, NOMBRES, PRIMER_APELLIDO, SEGUNDO_APELLIDO, " +
                "CORREO_ELECTRONICO, CODIGO_UNIVERSITARIO, TIPO_DOCUMENTO_ID, NUMERO_DOCUMENTO, CONTRASEÑA FROM PERSONA";
        ArrayList<PersonasDTO> out = new ArrayList<>();
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) out.add(map(rs));
            return out;
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    @Override
    public Integer eliminar(PersonasDTO p) {
        String sql = "DELETE FROM PERSONA WHERE PERSONA_CODIGO=?";
        try (Connection cn = DBManager.getInstance().getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, p.getPersonaId());
            return ps.executeUpdate();
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }

    private PersonasDTO map(ResultSet rs) throws Exception {
        PersonasDTO p = new PersonasDTO();
        p.setPersonaId(rs.getInt("PERSONA_CODIGO"));
        p.setEsAdministador(rs.getBoolean("ES_ADMINISTRADOR"));
        p.setNombres(rs.getString("NOMBRES"));
        p.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
        p.setSegundoApellido(rs.getString("SEGUNDO_APELLIDO"));
        p.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
        p.setCodigoUniversitario(rs.getString("CODIGO_UNIVERSITARIO"));
        p.setTipoDocumento(rs.getString("TIPO_DOCUMENTO_ID"));
        p.setNumeroDocumento(rs.getString("NUMERO_DOCUMENTO"));
        p.setContraseña(rs.getString("CONTRASEÑA"));
        return p;
    }
}
