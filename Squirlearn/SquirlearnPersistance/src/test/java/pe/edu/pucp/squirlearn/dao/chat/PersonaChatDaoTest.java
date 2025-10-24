package pe.edu.pucp.squirlearn.dao.chat;

import java.util.ArrayList;
import java.sql.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.chat.PersonaChatDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.PersonaChatDto;

public class PersonaChatDaoTest {
    
    private PersonaChatDao personaChatDao;    
    
    public PersonaChatDaoTest() {
        this.personaChatDao = new PersonaChatDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaPersonaChatId = new ArrayList<>();
        insertarPersonaChats(listaPersonaChatId);
        eliminarTodo();
    }
    
    private void insertarPersonaChats(ArrayList<Integer> listaPersonaChatId) {
        PersonaChatDto personaChat = new PersonaChatDto();
        personaChat.setUltimaActividad(new Date(System.currentTimeMillis()));
        Integer resultado = this.personaChatDao.insertar(personaChat);
        assertTrue(resultado != 0);
        listaPersonaChatId.add(resultado);
        
        personaChat.setUltimaActividad(new Date(System.currentTimeMillis()));
        resultado = this.personaChatDao.insertar(personaChat);
        assertTrue(resultado != 0);
        listaPersonaChatId.add(resultado);
        
        personaChat.setUltimaActividad(new Date(System.currentTimeMillis()));
        resultado = this.personaChatDao.insertar(personaChat);
        assertTrue(resultado != 0);
        listaPersonaChatId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        
    }
    
    @Test
    public void testListarTodos() {
        
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaPersonaChatId = new ArrayList<>();
        insertarPersonaChats(listaPersonaChatId);
        
        ArrayList<PersonaChatDto> listaPersonaChats = this.personaChatDao.listarTodos();
        assertEquals(listaPersonaChatId.size(), listaPersonaChats.size());
        for (Integer i = 0; i < listaPersonaChatId.size(); i++) {
            // Cambios dummy no nulos
            this.personaChatDao.modificar(listaPersonaChats.get(i));
        }
        
        ArrayList<PersonaChatDto> listaPersonaChatsModificados = this.personaChatDao.listarTodos();
        assertEquals( listaPersonaChats.size(), listaPersonaChatsModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaPersonaChatId = new ArrayList<>();
        insertarPersonaChats(listaPersonaChatId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        
        
    }
}
