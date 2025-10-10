package pe.edu.pucp.squirlearn.daoImpl.inciNoti;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.inciNoti.NotificacionDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.inciNoti.NotificacionDto;

public class NotificacionDaoImpl extends DAOImplBase implements NotificacionDao{

    private NotificacionDto notificacion;

    public NotificacionDaoImpl() {
        super("notificacions");
        this.notificacion = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("NOTIFICACION_ID", true, true));
        this.listaColumnas.add(new Columna("FECHA", false, false));
        this.listaColumnas.add(new Columna("MENSAJE", false, false));
        this.listaColumnas.add(new Columna("PERSONA", false, false));
        this.listaColumnas.add(new Columna("MOTIVO", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setDate(1, (Date) this.notificacion.getFecha());
        this.statement.setString(2, this.notificacion.getMensaje());
        this.statement.setInt(3, this.notificacion.getPersona().getPersonaId());
        this.statement.setInt(4, this.notificacion.getMotivo().getMotivoId());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setDate(1, (Date) this.notificacion.getFecha());
        this.statement.setString(2, this.notificacion.getMensaje());
        this.statement.setInt(3, this.notificacion.getPersona().getPersonaId());
        this.statement.setInt(4, this.notificacion.getMotivo().getMotivoId());
        this.statement.setInt(5, this.notificacion.getNotificacionId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.notificacion.getNotificacionId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.notificacion.getNotificacionId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.notificacion = new NotificacionDto();
        this.notificacion.setNotificacionId(this.resultSet.getInt("NOTIFICACION_ID"));
        this.notificacion.setFecha(this.resultSet.getDate("FECHA"));
        this.notificacion.setMensaje(this.resultSet.getString("MENSAJE"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.notificacion = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.notificacion);
    }
    
    @Override
    public Integer insertar(NotificacionDto notificacion) {
        this.notificacion = notificacion;
        return super.insertar();
    }
    @Override
    public NotificacionDto obtenerPorId(Integer id) {
        this.notificacion = new NotificacionDto();
        this.notificacion.setNotificacionId(id);
        super.obtenerPorId();
        return this.notificacion;
    }

    @Override
    public ArrayList<NotificacionDto> listarTodos() {
        return (ArrayList<NotificacionDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(NotificacionDto notificacion) {
        this.notificacion = notificacion;
        return super.modificar();
    }

    @Override
    public Integer eliminar(NotificacionDto notificacion) {
        this.notificacion = notificacion;
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
