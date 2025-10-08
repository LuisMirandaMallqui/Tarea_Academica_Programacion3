package pe.edu.pucp.squirlearn.daoImpl.chat;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.chat.PersonaChatDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.chat.PersonaChatDto;

public class PersonaChatDaoImpl extends DAOImplBase implements PersonaChatDao{

    private PersonaChatDto personaChat;

    public PersonaChatDaoImpl() {
        super("persona_chats");
        this.personaChat = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("PERSONA", false, false));
        this.listaColumnas.add(new Columna("CHAT", false, false));
        this.listaColumnas.add(new Columna("ULTIMA_ACTIVIDAD", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.personaChat.getPersona().getPersonaId());
        this.statement.setInt(2, this.personaChat.getChat().getChatId());
        this.statement.setDate(3, (Date) this.personaChat.getUltimaActividad());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setInt(1, this.personaChat.getPersona().getPersonaId());
        this.statement.setInt(2, this.personaChat.getChat().getChatId());
        this.statement.setDate(3, (Date) this.personaChat.getUltimaActividad());
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
        this.personaChat = new PersonaChatDto();
        this.personaChat.setUltimaActividad(this.resultSet.getDate("ULTIMA_ACTIVIDAD"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.personaChat = null;
    }

    @Override
    protected void agregarObjetoALaLista(java.util.List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.personaChat);
    }
    
    @Override
    public Integer insertar(PersonaChatDto personaChat) {
        this.personaChat = personaChat;
        return super.insertar();
    }
    @Override
    public PersonaChatDto obtenerPorId(Integer id) {
        this.personaChat = new PersonaChatDto();
        // TODO set PK
        super.obtenerPorId();
        return this.personaChat;
    }

    @Override
    public ArrayList<PersonaChatDto> listarTodos() {
        return (ArrayList<PersonaChatDto>) super.listarTodos();
    }

    @Override
    public Integer modificar(PersonaChatDto personaChat) {
        this.personaChat = personaChat;
        return super.modificar();
    }

    @Override
    public Integer eliminar(PersonaChatDto personaChat) {
        this.personaChat = personaChat;
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
