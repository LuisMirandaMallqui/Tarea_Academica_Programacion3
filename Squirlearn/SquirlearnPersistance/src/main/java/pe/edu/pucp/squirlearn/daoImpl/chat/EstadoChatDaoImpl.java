package pe.edu.pucp.squirlearn.daoImpl.chat;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.chat.EstadoChatDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.chat.EstadoChatDto;

public class EstadoChatDaoImpl extends DAOImplBase implements EstadoChatDao{

    private EstadoChatDto estadoChat;

    public EstadoChatDaoImpl() {
        super("estado_chats");
        this.estadoChat = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ESTADO_CHAT_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.estadoChat.getNombre());
        this.statement.setDate(2, (Date) this.estadoChat.getFechaCreacion());
        this.statement.setInt(3, this.estadoChat.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.estadoChat.getFechaModificacion());
        this.statement.setInt(5, this.estadoChat.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.estadoChat.getNombre());
        this.statement.setDate(2, (Date) this.estadoChat.getFechaCreacion());
        this.statement.setInt(3, this.estadoChat.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.estadoChat.getFechaModificacion());
        this.statement.setInt(5, this.estadoChat.getUsuarioModificacion());
        this.statement.setInt(6, this.estadoChat.getEstadoChatId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.estadoChat.getEstadoChatId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.estadoChat.getEstadoChatId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.estadoChat = new EstadoChatDto();
        this.estadoChat.setEstadoChatId(this.resultSet.getInt("ESTADO_CHAT_ID"));
        this.estadoChat.setNombre(this.resultSet.getString("NOMBRE"));
        this.estadoChat.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.estadoChat.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.estadoChat.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.estadoChat.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.estadoChat = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.estadoChat);
    }
    
    @Override
    public Integer insertar(EstadoChatDto estadoChat) {
        this.estadoChat = estadoChat;
        return super.insertar();
    }
    @Override
    public EstadoChatDto obtenerPorId(Integer id) {
        this.estadoChat = new EstadoChatDto();
        this.estadoChat.setEstadoChatId(id);
        super.obtenerPorId();
        return this.estadoChat;
    }

    @Override
    public ArrayList<EstadoChatDto> listarTodos() {
        return (ArrayList<EstadoChatDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(EstadoChatDto estadoChat) {
        this.estadoChat = estadoChat;
        return super.modificar();
    }

    @Override
    public Integer eliminar(EstadoChatDto estadoChat) {
        this.estadoChat = estadoChat;
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
