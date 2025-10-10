package pe.edu.pucp.squirlearn.dao.chat;

import java.sql.Date;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.chat.EstadoMensajeDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.EstadoMensajeDto;

public class EstadoMensajeDaoTest {
    
    private EstadoMensajeDao estadoMensajeDao;    
    
    public EstadoMensajeDaoTest() {
        this.estadoMensajeDao = new EstadoMensajeDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaEstadoMensajeId = new ArrayList<>();
        insertarEstadoMensajes(listaEstadoMensajeId);
        eliminarTodo();
    }
    
    private void insertarEstadoMensajes(ArrayList<Integer> listaEstadoMensajeId) {
        EstadoMensajeDto estadoMensaje = new EstadoMensajeDto();
        estadoMensaje.setNombre("Lorem ipsum nombre");
        estadoMensaje.setFechaCreacion(new Date(System.currentTimeMillis()));
        estadoMensaje.setUsuarioCreacion(1);
        estadoMensaje.setFechaModificacion(new Date(System.currentTimeMillis()));
        estadoMensaje.setUsuarioModificacion(1);
        Integer resultado = this.estadoMensajeDao.insertar(estadoMensaje);
        assertTrue(resultado != 0);
        listaEstadoMensajeId.add(resultado);
        
        estadoMensaje.setEstadoMsjId(null);
        estadoMensaje.setNombre("Lorem ipsum B nombre");
        estadoMensaje.setFechaCreacion(new Date(System.currentTimeMillis()));
        estadoMensaje.setUsuarioCreacion(1);
        estadoMensaje.setFechaModificacion(new Date(System.currentTimeMillis()));
        estadoMensaje.setUsuarioModificacion(1);
        resultado = this.estadoMensajeDao.insertar(estadoMensaje);
        assertTrue(resultado != 0);
        listaEstadoMensajeId.add(resultado);
        
        estadoMensaje.setEstadoMsjId(null);
        estadoMensaje.setNombre("Lorem ipsum C nombre");
        estadoMensaje.setFechaCreacion(new Date(System.currentTimeMillis()));
        estadoMensaje.setUsuarioCreacion(1);
        estadoMensaje.setFechaModificacion(new Date(System.currentTimeMillis()));
        estadoMensaje.setUsuarioModificacion(1);
        resultado = this.estadoMensajeDao.insertar(estadoMensaje);
        assertTrue(resultado != 0);
        listaEstadoMensajeId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaEstadoMensajeId = new ArrayList<>();
        insertarEstadoMensajes(listaEstadoMensajeId);
        EstadoMensajeDto estadoMensaje = this.estadoMensajeDao.obtenerPorId(listaEstadoMensajeId.get(0));
        assertEquals(estadoMensaje.getEstadoMsjId(), listaEstadoMensajeId.get(0));
        
        estadoMensaje = this.estadoMensajeDao.obtenerPorId(listaEstadoMensajeId.get(1));
        assertEquals(estadoMensaje.getEstadoMsjId(), listaEstadoMensajeId.get(1));
        
        estadoMensaje = this.estadoMensajeDao.obtenerPorId(listaEstadoMensajeId.get(2));
        assertEquals(estadoMensaje.getEstadoMsjId(), listaEstadoMensajeId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaEstadoMensajeId = new ArrayList<>();
        insertarEstadoMensajes(listaEstadoMensajeId);
        
        ArrayList<EstadoMensajeDto> listaEstadoMensajes = this.estadoMensajeDao.listarTodos();
        assertEquals(listaEstadoMensajeId.size(), listaEstadoMensajes.size());
        for (Integer i = 0; i < listaEstadoMensajeId.size(); i++) {
            assertEquals(listaEstadoMensajeId.get(i), listaEstadoMensajes.get(i).getEstadoMsjId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaEstadoMensajeId = new ArrayList<>();
        insertarEstadoMensajes(listaEstadoMensajeId);
        
        ArrayList<EstadoMensajeDto> listaEstadoMensajes = this.estadoMensajeDao.listarTodos();
        assertEquals(listaEstadoMensajeId.size(), listaEstadoMensajes.size());
        for (Integer i = 0; i < listaEstadoMensajeId.size(); i++) {
            // Cambios dummy no nulos
            this.estadoMensajeDao.modificar(listaEstadoMensajes.get(i));
        }
        
        ArrayList<EstadoMensajeDto> listaEstadoMensajesModificados = this.estadoMensajeDao.listarTodos();
        assertEquals( listaEstadoMensajes.size(), listaEstadoMensajesModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaEstadoMensajeId = new ArrayList<>();
        insertarEstadoMensajes(listaEstadoMensajeId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<EstadoMensajeDto> listaEstadoMensajes = this.estadoMensajeDao.listarTodos();
        for (Integer i = 0; i < listaEstadoMensajes.size(); i++) {
            Integer resultado = this.estadoMensajeDao.eliminar(listaEstadoMensajes.get(i));
            assertNotEquals(0, resultado);
            EstadoMensajeDto estadoMensaje = this.estadoMensajeDao.obtenerPorId(listaEstadoMensajes.get(i).getEstadoMsjId());
            assertNull(estadoMensaje);
        }
    }
}
