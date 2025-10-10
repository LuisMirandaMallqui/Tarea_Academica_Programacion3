package pe.edu.pucp.squirlearn.daoImpl.inciNoti;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.inciNoti.IncidenciaDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.inciNoti.IncidenciaDto;

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
        this.statement.setInt(1, this.incidencia.getIncidenciaDto());
        this.statement.setString(2, this.incidencia.getDescripcion());
        this.statement.setDate(3, (Date) this.incidencia.getFechaCreacion());
        this.statement.setDate(4, (Date) this.incidencia.getFechaSolucion());
        this.statement.setInt(5, this.incidencia.getUsuarioCreacion());
        this.statement.setInt(6, this.incidencia.getUsuarioSolucion());
        this.statement.setDate(7, (Date) this.incidencia.getFechaModificacion());
        this.statement.setInt(8, this.incidencia.getUsuarioModificacion());
        this.statement.setInt(9, this.incidencia.getNotificacion().getNotificacionId());
        this.statement.setInt(10, this.incidencia.getPersona().getPersonaId());
        this.statement.setInt(11, this.incidencia.getMotivo().getMotivoId());
        this.statement.setBoolean(12, this.incidencia.getResuelto());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setInt(1, this.incidencia.getIncidenciaDto());
        this.statement.setString(2, this.incidencia.getDescripcion());
        this.statement.setDate(3, (Date) this.incidencia.getFechaCreacion());
        this.statement.setDate(4, (Date) this.incidencia.getFechaSolucion());
        this.statement.setInt(5, this.incidencia.getUsuarioCreacion());
        this.statement.setInt(6, this.incidencia.getUsuarioSolucion());
        this.statement.setDate(7, (Date) this.incidencia.getFechaModificacion());
        this.statement.setInt(8, this.incidencia.getUsuarioModificacion());
        this.statement.setInt(9, this.incidencia.getNotificacion().getNotificacionId());
        this.statement.setInt(10, this.incidencia.getPersona().getPersonaId());
        this.statement.setInt(11, this.incidencia.getMotivo().getMotivoId());
        this.statement.setBoolean(12, this.incidencia.getResuelto());
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
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.incidencia = new IncidenciaDto();
        this.incidencia.setIncidenciaDto(this.resultSet.getInt("INCIDENCIA_DTO"));
        this.incidencia.setDescripcion(this.resultSet.getString("DESCRIPCION"));
        this.incidencia.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.incidencia.setFechaSolucion(this.resultSet.getDate("FECHA_SOLUCION"));
        this.incidencia.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.incidencia.setUsuarioSolucion(this.resultSet.getInt("USUARIO_SOLUCION"));
        this.incidencia.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.incidencia.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
        this.incidencia.setResuelto(this.resultSet.getBoolean("RESUELTO"));
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


// ====== PLANTILLA PARA PROCEDIMIENTOS ALMACENADOS ======
public void ejecutarProcedimientoPlantilla() {
    Object parametros = null; // TODO: builder/DTO de parámetros
    String sql = "{call MI_SP_EJEMPLO ()}"; // TODO: SP real y firma
    Boolean conTransaccion = true;
    this.ejecutarProcedimientoAlmacenado(sql, this::incluirValorDeParametrosPlantilla, parametros, conTransaccion);
}

private void incluirValorDeParametrosPlantilla(Object objetoParametros) {
    // TODO: castear objetoParametros y hacer setXxx en this.statement
    // this.statement.setInt(1, ...);
    // this.statement.setString(2, ...);
}

public void ejecutarProcedimientoSinParametros(String nombreSP, boolean conTransaccion) {
    String sql = "{call " + nombreSP + "()}";
    this.ejecutarProcedimientoAlmacenado(sql, conTransaccion);
}
// ====== FIN PLANTILLA PARA PROCEDIMIENTOS ALMACENADOS ======
}
