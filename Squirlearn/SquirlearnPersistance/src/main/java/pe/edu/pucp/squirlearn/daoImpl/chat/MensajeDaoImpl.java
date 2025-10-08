package pe.edu.pucp.squirlearn.daoImpl.chat;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.chat.MensajeDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.chat.MensajeDto;

public class MensajeDaoImpl extends DAOImplBase implements MensajeDao{

    private MensajeDto mensaje;

    public MensajeDaoImpl() {
        super("mensajes");
        this.mensaje = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("MENSAJE_ID", true, true));
        this.listaColumnas.add(new Columna("CHAT", false, false));
        this.listaColumnas.add(new Columna("FECHA_ENVIO", false, false));
        this.listaColumnas.add(new Columna("FECHA_LEIDO", false, false));
        this.listaColumnas.add(new Columna("MENSAJE", false, false));
        this.listaColumnas.add(new Columna("ESTADO_MENSAJE", false, false));
        this.listaColumnas.add(new Columna("PERSONA", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.mensaje.getChat().getChatId());
        this.statement.setDate(2, (Date) this.mensaje.getFechaEnvio());
        this.statement.setDate(3, (Date) this.mensaje.getFechaLeido());
        this.statement.setString(4, this.mensaje.getMensaje());
        this.statement.setInt(5, this.mensaje.getEstadoMensaje().getEstadoMsjId());
        this.statement.setInt(6, this.mensaje.getPersona().getPersonaId());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setInt(1, this.mensaje.getChat().getChatId());
        this.statement.setDate(2, (Date) this.mensaje.getFechaEnvio());
        this.statement.setDate(3, (Date) this.mensaje.getFechaLeido());
        this.statement.setString(4, this.mensaje.getMensaje());
        this.statement.setInt(5, this.mensaje.getEstadoMensaje().getEstadoMsjId());
        this.statement.setInt(6, this.mensaje.getPersona().getPersonaId());
        this.statement.setInt(7, this.mensaje.getMensajeId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.mensaje.getMensajeId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.mensaje.getMensajeId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.mensaje = new MensajeDto();
        this.mensaje.setMensajeId(this.resultSet.getInt("MENSAJE_ID"));
        this.mensaje.setFechaEnvio(this.resultSet.getDate("FECHA_ENVIO"));
        this.mensaje.setFechaLeido(this.resultSet.getDate("FECHA_LEIDO"));
        this.mensaje.setMensaje(this.resultSet.getString("MENSAJE"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.mensaje = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.mensaje);
    }
    
    @Override
    public Integer insertar(MensajeDto mensaje) {
        this.mensaje = mensaje;
        return super.insertar();
    }
    @Override
    public MensajeDto obtenerPorId(Integer id) {
        this.mensaje = new MensajeDto();
        this.mensaje.setMensajeId(id);
        super.obtenerPorId();
        return this.mensaje;
    }

    @Override
    public ArrayList<MensajeDto> listarTodos() {
        return (ArrayList<MensajeDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(MensajeDto mensaje) {
        this.mensaje = mensaje;
        return super.modificar();
    }

    @Override
    public Integer eliminar(MensajeDto mensaje) {
        this.mensaje = mensaje;
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
