package pe.edu.pucp.squirlearn.daoImpl.chat;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.function.Consumer;
import pe.edu.pucp.squirlearn.daoImpl.util.Columna;
import pe.edu.pucp.squirlearn.dao.chat.PersonaChatDao;
import pe.edu.pucp.squirlearn.daoImpl.DAOImplBase;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;
import pe.edu.pucp.squirlearn.model.chat.PersonaChatDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class PersonaChatDaoImpl extends DAOImplBase implements PersonaChatDao{

    private PersonaChatDto personaChat;

    public PersonaChatDaoImpl() {
        super("personas_chats");
        this.personaChat = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("PERSONA_ID", false, false));
        this.listaColumnas.add(new Columna("CHAT_ID", false, false));
}

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        int i = 1;
        this.statement.setInt(i++, this.personaChat.getPersona().getPersonaId());                                     // PERSONA_ID=?
        this.statement.setInt(i++, this.personaChat.getChat().getChatId());   
    }


    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
                               // CHAT_ID=?
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

        // Persona anidada
        PersonaDto persona = new PersonaDto();
        persona.setPersonaId(this.resultSet.getInt("PERSONA_ID"));
        this.personaChat.setPersona(persona);

        // Chat anidado
        ChatDto chat = new ChatDto();
        chat.setChatId(this.resultSet.getInt("CHAT_ID"));
        this.personaChat.setChat(chat);

        // Escalar
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

    @Override
    public ArrayList<PersonaChatDto> listarPorPersona(Integer personaId) {
        String sql = this.generarSQLParaListarTodos() + " WHERE PERSONA_ID=?";
        Consumer<PreparedStatement> incluir = ps -> {
            try { 
                ps.setInt(1, personaId); 
            } catch (SQLException e) { 
                throw new RuntimeException(e); 
            }
        };
        return (ArrayList<PersonaChatDto>) (ArrayList) this.listarTodos(sql, incluir, null);
    }

}
