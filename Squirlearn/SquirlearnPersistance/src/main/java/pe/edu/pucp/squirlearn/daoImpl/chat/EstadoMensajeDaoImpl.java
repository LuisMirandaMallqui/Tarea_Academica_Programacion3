package pe.edu.pucp.squirlearn.daoImpl.chat;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.chat.EstadoMensajeDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.chat.EstadoMensajeDto;

public class EstadoMensajeDaoImpl extends DAOImplBase implements EstadoMensajeDao{

    private EstadoMensajeDto estadoMensaje;

    public EstadoMensajeDaoImpl() {
        super("estados_mensajes");
        this.estadoMensaje = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ESTADOMSJ_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.estadoMensaje.getNombre());
        this.statement.setDate(2, (Date) this.estadoMensaje.getFechaCreacion());
        this.statement.setInt(3, this.estadoMensaje.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.estadoMensaje.getFechaModificacion());
        this.statement.setInt(5, this.estadoMensaje.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.estadoMensaje.getNombre());
        this.statement.setDate(2, (Date) this.estadoMensaje.getFechaCreacion());
        this.statement.setInt(3, this.estadoMensaje.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.estadoMensaje.getFechaModificacion());
        this.statement.setInt(5, this.estadoMensaje.getUsuarioModificacion());
        this.statement.setInt(6, this.estadoMensaje.getEstadoMsjId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.estadoMensaje.getEstadoMsjId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.estadoMensaje.getEstadoMsjId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.estadoMensaje = new EstadoMensajeDto();
        this.estadoMensaje.setEstadoMsjId(this.resultSet.getInt("ESTADO_MSJ_ID"));
        this.estadoMensaje.setNombre(this.resultSet.getString("NOMBRE"));
        this.estadoMensaje.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.estadoMensaje.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.estadoMensaje.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.estadoMensaje.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.estadoMensaje = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.estadoMensaje);
    }
    
    @Override
    public Integer insertar(EstadoMensajeDto estadoMensaje) {
        this.estadoMensaje = estadoMensaje;
        return super.insertar();
    }
    @Override
    public EstadoMensajeDto obtenerPorId(Integer id) {
        this.estadoMensaje = new EstadoMensajeDto();
        this.estadoMensaje.setEstadoMsjId(id);
        super.obtenerPorId();
        return this.estadoMensaje;
    }

    @Override
    public ArrayList<EstadoMensajeDto> listarTodos() {
        return (ArrayList<EstadoMensajeDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(EstadoMensajeDto estadoMensaje) {
        this.estadoMensaje = estadoMensaje;
        return super.modificar();
    }

    @Override
    public Integer eliminar(EstadoMensajeDto estadoMensaje) {
        this.estadoMensaje = estadoMensaje;
        return super.eliminar();
    }
}
