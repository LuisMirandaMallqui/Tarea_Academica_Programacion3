package pe.edu.pucp.squirlearn.dao.chat;

import java.util.ArrayList;
import java.sql.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.chat.MensajeDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.MensajeDto;

public class MensajeDaoTest {
    
    private MensajeDao mensajeDao;    
    
    public MensajeDaoTest() {
        this.mensajeDao = new MensajeDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaMensajeId = new ArrayList<>();
        insertarMensajes(listaMensajeId);
        eliminarTodo();
    }
    
    private void insertarMensajes(ArrayList<Integer> listaMensajeId) {
        MensajeDto mensaje = new MensajeDto();
        mensaje.setFechaEnvio(new Date(System.currentTimeMillis()));
        mensaje.setFechaLeido(new Date(System.currentTimeMillis()));
        mensaje.setMensaje("Lorem ipsum mensaje");
        Integer resultado = this.mensajeDao.insertar(mensaje);
        assertTrue(resultado != 0);
        listaMensajeId.add(resultado);
        
        mensaje.setMensajeId(null);
        mensaje.setFechaEnvio(new Date(System.currentTimeMillis()));
        mensaje.setFechaLeido(new Date(System.currentTimeMillis()));
        mensaje.setMensaje("Lorem ipsum B mensaje");
        resultado = this.mensajeDao.insertar(mensaje);
        assertTrue(resultado != 0);
        listaMensajeId.add(resultado);
        
        mensaje.setMensajeId(null);
        mensaje.setFechaEnvio(new Date(System.currentTimeMillis()));
        mensaje.setFechaLeido(new Date(System.currentTimeMillis()));
        mensaje.setMensaje("Lorem ipsum C mensaje");
        resultado = this.mensajeDao.insertar(mensaje);
        assertTrue(resultado != 0);
        listaMensajeId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaMensajeId = new ArrayList<>();
        insertarMensajes(listaMensajeId);
        MensajeDto mensaje = this.mensajeDao.obtenerPorId(listaMensajeId.get(0));
        assertEquals(mensaje.getMensajeId(), listaMensajeId.get(0));
        
        mensaje = this.mensajeDao.obtenerPorId(listaMensajeId.get(1));
        assertEquals(mensaje.getMensajeId(), listaMensajeId.get(1));
        
        mensaje = this.mensajeDao.obtenerPorId(listaMensajeId.get(2));
        assertEquals(mensaje.getMensajeId(), listaMensajeId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaMensajeId = new ArrayList<>();
        insertarMensajes(listaMensajeId);
        
        ArrayList<MensajeDto> listaMensajes = this.mensajeDao.listarTodos();
        assertEquals(listaMensajeId.size(), listaMensajes.size());
        for (Integer i = 0; i < listaMensajeId.size(); i++) {
            assertEquals(listaMensajeId.get(i), listaMensajes.get(i).getMensajeId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaMensajeId = new ArrayList<>();
        insertarMensajes(listaMensajeId);
        
        ArrayList<MensajeDto> listaMensajes = this.mensajeDao.listarTodos();
        assertEquals(listaMensajeId.size(), listaMensajes.size());
        for (Integer i = 0; i < listaMensajeId.size(); i++) {
            // Cambios dummy no nulos
            this.mensajeDao.modificar(listaMensajes.get(i));
        }
        
        ArrayList<MensajeDto> listaMensajesModificados = this.mensajeDao.listarTodos();
        assertEquals( listaMensajes.size(), listaMensajesModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaMensajeId = new ArrayList<>();
        insertarMensajes(listaMensajeId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<MensajeDto> listaMensajes = this.mensajeDao.listarTodos();
        for (Integer i = 0; i < listaMensajes.size(); i++) {
            Integer resultado = this.mensajeDao.eliminar(listaMensajes.get(i));
            assertNotEquals(0, resultado);
            MensajeDto mensaje = this.mensajeDao.obtenerPorId(listaMensajes.get(i).getMensajeId());
            assertNull(mensaje);
        }
    }
}
