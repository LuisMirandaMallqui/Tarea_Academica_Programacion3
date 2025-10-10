package pe.edu.pucp.squirlearn.dao.chat;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.chat.EstadoChatDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.EstadoChatDto;

public class EstadoChatDaoTest {
    
    private EstadoChatDao estadoChatDao;    
    
    public EstadoChatDaoTest() {
        this.estadoChatDao = new EstadoChatDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaEstadoChatId = new ArrayList<>();
        insertarEstadoChats(listaEstadoChatId);
        eliminarTodo();
    }
    
    private void insertarEstadoChats(ArrayList<Integer> listaEstadoChatId) {
        EstadoChatDto estadoChat = new EstadoChatDto();
        estadoChat.setNombre("Lorem ipsum nombre");
        estadoChat.setFechaCreacion(new Date(System.currentTimeMillis()));
        estadoChat.setUsuarioCreacion(1);
        estadoChat.setFechaModificacion(new Date(System.currentTimeMillis()));
        estadoChat.setUsuarioModificacion(1);
        Integer resultado = this.estadoChatDao.insertar(estadoChat);
        assertTrue(resultado != 0);
        listaEstadoChatId.add(resultado);
        
        estadoChat.setEstadoChatId(null);
        estadoChat.setNombre("Lorem ipsum B nombre");
        estadoChat.setFechaCreacion(new Date(System.currentTimeMillis()));
        estadoChat.setUsuarioCreacion(1);
        estadoChat.setFechaModificacion(new Date(System.currentTimeMillis()));
        estadoChat.setUsuarioModificacion(1);
        resultado = this.estadoChatDao.insertar(estadoChat);
        assertTrue(resultado != 0);
        listaEstadoChatId.add(resultado);
        
        estadoChat.setEstadoChatId(null);
        estadoChat.setNombre("Lorem ipsum C nombre");
        estadoChat.setFechaCreacion(new Date(System.currentTimeMillis()));
        estadoChat.setUsuarioCreacion(1);
        estadoChat.setFechaModificacion(new Date(System.currentTimeMillis()));
        estadoChat.setUsuarioModificacion(1);
        resultado = this.estadoChatDao.insertar(estadoChat);
        assertTrue(resultado != 0);
        listaEstadoChatId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaEstadoChatId = new ArrayList<>();
        insertarEstadoChats(listaEstadoChatId);
        EstadoChatDto estadoChat = this.estadoChatDao.obtenerPorId(listaEstadoChatId.get(0));
        assertEquals(estadoChat.getEstadoChatId(), listaEstadoChatId.get(0));
        
        estadoChat = this.estadoChatDao.obtenerPorId(listaEstadoChatId.get(1));
        assertEquals(estadoChat.getEstadoChatId(), listaEstadoChatId.get(1));
        
        estadoChat = this.estadoChatDao.obtenerPorId(listaEstadoChatId.get(2));
        assertEquals(estadoChat.getEstadoChatId(), listaEstadoChatId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaEstadoChatId = new ArrayList<>();
        insertarEstadoChats(listaEstadoChatId);
        
        ArrayList<EstadoChatDto> listaEstadoChats = this.estadoChatDao.listarTodos();
        assertEquals(listaEstadoChatId.size(), listaEstadoChats.size());
        for (Integer i = 0; i < listaEstadoChatId.size(); i++) {
            assertEquals(listaEstadoChatId.get(i), listaEstadoChats.get(i).getEstadoChatId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaEstadoChatId = new ArrayList<>();
        insertarEstadoChats(listaEstadoChatId);
        
        ArrayList<EstadoChatDto> listaEstadoChats = this.estadoChatDao.listarTodos();
        assertEquals(listaEstadoChatId.size(), listaEstadoChats.size());
        for (Integer i = 0; i < listaEstadoChatId.size(); i++) {
            // Cambios dummy no nulos
            this.estadoChatDao.modificar(listaEstadoChats.get(i));
        }
        
        ArrayList<EstadoChatDto> listaEstadoChatsModificados = this.estadoChatDao.listarTodos();
        assertEquals( listaEstadoChats.size(), listaEstadoChatsModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaEstadoChatId = new ArrayList<>();
        insertarEstadoChats(listaEstadoChatId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<EstadoChatDto> listaEstadoChats = this.estadoChatDao.listarTodos();
        for (Integer i = 0; i < listaEstadoChats.size(); i++) {
            Integer resultado = this.estadoChatDao.eliminar(listaEstadoChats.get(i));
            assertNotEquals(0, resultado);
            EstadoChatDto estadoChat = this.estadoChatDao.obtenerPorId(listaEstadoChats.get(i).getEstadoChatId());
            assertNull(estadoChat);
        }
    }
}
