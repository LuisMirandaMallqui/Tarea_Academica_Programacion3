package pe.edu.pucp.squirlearn.daoImpl.inciNoti;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.inciNoti.IncidenciaDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.inciNoti.IncidenciaDto;
import pe.edu.pucp.squirlearn.model.inciNoti.MotivoDto;
import pe.edu.pucp.squirlearn.model.inciNoti.NotificacionDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class IncidenciaDaoImpl extends DAOImplBase implements IncidenciaDao{

    private IncidenciaDto incidencia;

    public IncidenciaDaoImpl() {
        super("incidencias");
        this.incidencia = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("INCIDENCIA_DTO", false, false));
        this.listaColumnas.add(new Columna("DESCRIPCION", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_SOLUCION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_SOLUCION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("NOTIFICACION", false, false));
        this.listaColumnas.add(new Columna("PERSONA", false, false));
        this.listaColumnas.add(new Columna("MOTIVO", false, false));
        this.listaColumnas.add(new Columna("RESUELTO", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int notifId = safeFkId(
            (this.incidencia.getNotificacion() == null ? null : this.incidencia.getNotificacion().getNotificacionId()),
            "notificaciones", "NOTIFICACION_ID"
        );
        int personaId = safeFkId(
            (this.incidencia.getPersona() == null ? null : this.incidencia.getPersona().getPersonaId()),
            "personas", "PERSONA_ID"
        );
        int motivoId = safeFkId(
            (this.incidencia.getMotivo() == null ? null : this.incidencia.getMotivo().getMotivoId()),
            "motivos", "MOTIVO_ID"
        );

        int i = 1;
        this.statement.setString(i++, this.incidencia.getDescripcion());
        this.statement.setDate(i++, this.incidencia.getFechaSolucion());
        this.statement.setInt(i++, notifId);
        this.statement.setInt(i++, personaId);
        this.statement.setInt(i++, motivoId);
        this.statement.setObject(i++, this.incidencia.getUsuarioSolucion(), java.sql.Types.INTEGER);
        this.statement.setInt(i++, this.incidencia.getResuelto());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.incidencia = new pe.edu.pucp.squirlearn.model.inciNoti.IncidenciaDto();

        // Notificacion
        NotificacionDto notif = new NotificacionDto();
        notif.setNotificacionId(this.resultSet.getInt("NOTIFIFACION_ID"));
        this.incidencia.setNotificacion(notif);

        // Persona
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(this.resultSet.getInt("PERSONA_ID"));
        this.incidencia.setPersona(persona);

        // Motivo
        MotivoDto motivo = new MotivoDto();
        motivo.setMotivoId(this.resultSet.getInt("MOTIVO_ID_MOTIVO"));
        this.incidencia.setMotivo(motivo);

        // Escalares
        this.incidencia.setIncidenciaId(this.resultSet.getInt("INCIDENCIA_ID"));
        this.incidencia.setDescripcion(this.resultSet.getString("DESCRIPCION"));
        this.incidencia.setFechaSolucion(this.resultSet.getDate("FECHA_SOLUCION"));
        this.incidencia.setUsuarioCreacion(this.resultSet.getString("USUARIO_CREACION"));
        this.incidencia.setUsuarioSolucion((Integer) this.resultSet.getObject("USUARIO_SOLUCION"));
        this.incidencia.setResuelto(this.resultSet.getInt("RESUELTO"));
    }


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        // TODO set PK
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        // TODO set PK
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.incidencia = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.incidencia);
    }
    
    @Override
    public Integer insertar(IncidenciaDto incidencia) {
        this.incidencia = incidencia;
        return super.insertar();
    }
    @Override
    public IncidenciaDto obtenerPorId(Integer id) {
        this.incidencia = new IncidenciaDto();
        // TODO set PK
        super.obtenerPorId();
        return this.incidencia;
    }

    @Override
    public ArrayList<IncidenciaDto> listarTodos() {
        return (ArrayList<IncidenciaDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(IncidenciaDto incidencia) {
        this.incidencia = incidencia;
        return super.modificar();
    }

    @Override
    public Integer eliminar(IncidenciaDto incidencia) {
        this.incidencia = incidencia;
        return super.eliminar();
    }
    
    @Override
    public ArrayList<IncidenciaDto> listarPorResolucion(Boolean resuelto) {
        String sql = this.generarSQLParaListarTodos() + " WHERE RESUELTO=?";
        Consumer<PreparedStatement> incluir = ps -> { 
            try { 
                ps.setInt(1, (resuelto != null && resuelto) ? 1 : 0); 
            } catch (SQLException e) {
                throw new RuntimeException(e); 
            } 
        };
        return (ArrayList<IncidenciaDto>) (ArrayList) this.listarTodos(sql, incluir, null);
    }

}
