package pe.edu.pucp.squirlearn.daoImpl.chat;


import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.chat.EstadoChatDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.chat.EstadoChatDto;

public class EstadoChatDaoImpl extends DAOImplBase implements EstadoChatDao{

    private EstadoChatDto estadoChat;

    public EstadoChatDaoImpl() {
        super("estados_chats");
        this.estadoChat = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ESTADOCHAT_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));



}

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.estadoChat.getNombre());
}

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        int i = 1;
        this.statement.setString(i++, this.estadoChat.getNombre());
this.statement.setInt(i++, this.estadoChat.getEstadoChatId()); // WHERE
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.estadoChat = new pe.edu.pucp.squirlearn.model.chat.EstadoChatDto();
        this.estadoChat.setEstadoChatId(this.resultSet.getInt("ESTADOCHAT_ID"));
        this.estadoChat.setNombre(this.resultSet.getString("NOMBRE"));
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

}
