package pe.edu.pucp.squirlearn.daoImpl.chat;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.chat.ChatDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;

public class ChatDaoImpl extends DAOImplBase implements ChatDao{

    private ChatDto chat;

    public ChatDaoImpl() {
        super("chats");
        this.chat = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("CHAT_ID", true, true));
        this.listaColumnas.add(new Columna("ESTADO_CHAT", false, false));
        this.listaColumnas.add(new Columna("FECHA_CREACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_CREACION", false, false));
        this.listaColumnas.add(new Columna("FECHA_MODIFICACION", false, false));
        this.listaColumnas.add(new Columna("USUARIO_MODIFICACION", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.chat.getEstadoChat().getEstadoChatId());
        this.statement.setDate(2, (Date) this.chat.getFechaCreacion());
        this.statement.setInt(3, this.chat.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.chat.getFechaModificacion());
        this.statement.setInt(5, this.chat.getUsuarioModificacion());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setInt(1, this.chat.getEstadoChat().getEstadoChatId());
        this.statement.setDate(2, (Date) this.chat.getFechaCreacion());
        this.statement.setInt(3, this.chat.getUsuarioCreacion());
        this.statement.setDate(4, (Date) this.chat.getFechaModificacion());
        this.statement.setInt(5, this.chat.getUsuarioModificacion());
        this.statement.setInt(6, this.chat.getChatId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.chat.getChatId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.chat.getChatId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.chat = new ChatDto();
        this.chat.setChatId(this.resultSet.getInt("CHAT_ID"));
        this.chat.setFechaCreacion(this.resultSet.getDate("FECHA_CREACION"));
        this.chat.setUsuarioCreacion(this.resultSet.getInt("USUARIO_CREACION"));
        this.chat.setFechaModificacion(this.resultSet.getDate("FECHA_MODIFICACION"));
        this.chat.setUsuarioModificacion(this.resultSet.getInt("USUARIO_MODIFICACION"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.chat = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.chat);
    }
    
    @Override
    public Integer insertar(ChatDto chat) {
        this.chat = chat;
        return super.insertar();
    }
    @Override
    public ChatDto obtenerPorId(Integer id) {
        this.chat = new ChatDto();
        this.chat.setChatId(id);
        super.obtenerPorId();
        return this.chat;
    }

    @Override
    public ArrayList<ChatDto> listarTodos() {
        return (ArrayList<ChatDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(ChatDto chat) {
        this.chat = chat;
        return super.modificar();
    }

    @Override
    public Integer eliminar(ChatDto chat) {
        this.chat = chat;
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
