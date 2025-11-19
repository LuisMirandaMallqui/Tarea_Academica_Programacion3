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
        this.listaColumnas.add(new Columna("INCIDENCIA_ID", true, true));
        this.listaColumnas.add(new Columna("NOTIFICACION_ID", false, false));
        this.listaColumnas.add(new Columna("PERSONA_ID", false, false));
        this.listaColumnas.add(new Columna("MOTIVO_ID_MOTIVO", false, false));
        this.listaColumnas.add(new Columna("DESCRIPCION", false, false));
        this.listaColumnas.add(new Columna("RESUELTO", false, false));
        this.listaColumnas.add(new Columna("USUARIO_SOLUCION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setInt(i++, this.incidencia.getNotificacion().getNotificacionId());
        this.statement.setInt(i++, this.incidencia.getPersona().getPersonaId());
        this.statement.setInt(i++, this.incidencia.getMotivo().getMotivoId());
        this.statement.setString(i++, this.incidencia.getDescripcion());
        this.statement.setInt(i++, this.incidencia.getResuelto()==null?0:1);
        if (this.incidencia.getUsuarioSolucion() == null) 
            this.statement.setNull(i++, java.sql.Types.INTEGER);
        else this.statement.setInt(i++, incidencia.getUsuarioSolucion());
        this.statement.setString(i++, this.incidencia.getUsuarioCreacion());
    }
    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setInt(i++, this.incidencia.getNotificacion().getNotificacionId());
        this.statement.setInt(i++, this.incidencia.getPersona().getPersonaId());
        this.statement.setInt(i++, this.incidencia.getMotivo().getMotivoId());
        this.statement.setString(i++, this.incidencia.getDescripcion());
        this.statement.setInt(i++, this.incidencia.getResuelto()==null?0:1);
        if (this.incidencia.getUsuarioSolucion() == null) 
            this.statement.setNull(i++, java.sql.Types.INTEGER);
        else this.statement.setInt(i++, incidencia.getUsuarioSolucion());
        this.statement.setString(i++, this.incidencia.getUsuarioCreacion());
        this.statement.setInt(i++, this.incidencia.getIncidenciaId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.incidencia = new IncidenciaDto();

        this.incidencia.setIncidenciaId(this.resultSet.getInt("INCIDENCIA_ID"));
        // Notificacion
        NotificacionDto notif = new NotificacionDto();
        notif.setNotificacionId(this.resultSet.getInt("NOTIFICACION_ID"));
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
        this.incidencia.setDescripcion(this.resultSet.getString("DESCRIPCION"));
        this.incidencia.setResuelto(this.resultSet.getInt("RESUELTO"));
        this.incidencia.setUsuarioSolucion( this.resultSet.getInt("USUARIO_SOLUCION"));
        this.incidencia.setUsuarioCreacion(this.resultSet.getString("USUARIO_CREACION"));
    }


    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.incidencia.getIncidenciaId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.incidencia.getIncidenciaId());
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
        this.incidencia.setIncidenciaId(id);
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
