package pe.edu.pucp.squirlearn.dao.chat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.chat.ChatDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.ChatDto;

public class ChatDaoTest {
    
    private ChatDao chatDAO;    
    
    public ChatDaoTest() {
        this.chatDAO = new ChatDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaChatId = new ArrayList<>();
        insertarChats(listaChatId);
        eliminarTodo();
    }
    
    private void insertarChats(ArrayList<Integer> listaChatId) {
        ChatDto chat = new ChatDto();
        chat.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
        chat.setUsuarioCreacion(1);
        chat.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
        chat.setUsuarioModificacion(1);
        Integer resultado = this.chatDAO.insertar(chat);
        assertTrue(resultado != 0);
        listaChatId.add(resultado);
        
        chat.setChatId(null);
        chat.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
        chat.setUsuarioCreacion(1);
        chat.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
        chat.setUsuarioModificacion(1);
        resultado = this.chatDAO.insertar(chat);
        assertTrue(resultado != 0);
        listaChatId.add(resultado);
        
        chat.setChatId(null);
        chat.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
        chat.setUsuarioCreacion(1);
        chat.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
        chat.setUsuarioModificacion(1);
        resultado = this.chatDAO.insertar(chat);
        assertTrue(resultado != 0);
        listaChatId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaChatId = new ArrayList<>();
        insertarChats(listaChatId);
        ChatDto chat = this.chatDAO.obtenerPorId(listaChatId.get(0));
        assertEquals(chat.getChatId(), listaChatId.get(0));
        
        chat = this.chatDAO.obtenerPorId(listaChatId.get(1));
        assertEquals(chat.getChatId(), listaChatId.get(1));
        
        chat = this.chatDAO.obtenerPorId(listaChatId.get(2));
        assertEquals(chat.getChatId(), listaChatId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaChatId = new ArrayList<>();
        insertarChats(listaChatId);
        
        ArrayList<ChatDto> listaChats = this.chatDAO.listarTodos();
        assertEquals(listaChatId.size(), listaChats.size());
        for (Integer i = 0; i < listaChatId.size(); i++) {
            assertEquals(listaChatId.get(i), listaChats.get(i).getChatId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaChatId = new ArrayList<>();
        insertarChats(listaChatId);
        
        ArrayList<ChatDto> listaChats = this.chatDAO.listarTodos();
        assertEquals(listaChatId.size(), listaChats.size());
        for (Integer i = 0; i < listaChatId.size(); i++) {
            // Cambios dummy no nulos
            this.chatDAO.modificar(listaChats.get(i));
        }
        
        ArrayList<ChatDto> listaChatsModificados = this.chatDAO.listarTodos();
        assertEquals( listaChats.size(), listaChatsModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaChatId = new ArrayList<>();
        insertarChats(listaChatId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<ChatDto> listaChats = this.chatDAO.listarTodos();
        for (Integer i = 0; i < listaChats.size(); i++) {
            Integer resultado = this.chatDAO.eliminar(listaChats.get(i));
            assertNotEquals(0, resultado);
            ChatDto chat = this.chatDAO.obtenerPorId(listaChats.get(i).getChatId());
            assertNull(chat);
        }
    }
}
