package pe.edu.pucp.squirlearn.dao.inciNoti;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.inciNoti.NotificacionDaoImpl;
import pe.edu.pucp.squirlearn.model.inciNoti.NotificacionDto;

public class NotificacionDaoTest {
    
    private NotificacionDao notificacionDao;    
    
    public NotificacionDaoTest() {
        this.notificacionDao = new NotificacionDaoImpl();        
    }
    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaNotificacionId = new ArrayList<>();
//        insertarNotificacions(listaNotificacionId);
//        eliminarTodo();
//    }
//    
//    private void insertarNotificacions(ArrayList<Integer> listaNotificacionId) {
//        NotificacionDto notificacion = new NotificacionDto();
//        notificacion.setFecha(new java.sql.Date(System.currentTimeMillis()));
//        notificacion.setMensaje("Lorem ipsum mensaje");
//        Integer resultado = this.notificacionDao.insertar(notificacion);
//        assertTrue(resultado != 0);
//        listaNotificacionId.add(resultado);
//        
//        notificacion.setNotificacionId(null);
//        notificacion.setFecha(new java.sql.Date(System.currentTimeMillis()));
//        notificacion.setMensaje("Lorem ipsum B mensaje");
//        resultado = this.notificacionDao.insertar(notificacion);
//        assertTrue(resultado != 0);
//        listaNotificacionId.add(resultado);
//        
//        notificacion.setNotificacionId(null);
//        notificacion.setFecha(new java.sql.Date(System.currentTimeMillis()));
//        notificacion.setMensaje("Lorem ipsum C mensaje");
//        resultado = this.notificacionDao.insertar(notificacion);
//        assertTrue(resultado != 0);
//        listaNotificacionId.add(resultado);        
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaNotificacionId = new ArrayList<>();
//        insertarNotificacions(listaNotificacionId);
//        NotificacionDto notificacion = this.notificacionDao.obtenerPorId(listaNotificacionId.get(0));
//        assertEquals(notificacion.getNotificacionId(), listaNotificacionId.get(0));
//        
//        notificacion = this.notificacionDao.obtenerPorId(listaNotificacionId.get(1));
//        assertEquals(notificacion.getNotificacionId(), listaNotificacionId.get(1));
//        
//        notificacion = this.notificacionDao.obtenerPorId(listaNotificacionId.get(2));
//        assertEquals(notificacion.getNotificacionId(), listaNotificacionId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaNotificacionId = new ArrayList<>();
//        insertarNotificacions(listaNotificacionId);
//        
//        ArrayList<NotificacionDto> listaNotificacions = this.notificacionDao.listarTodos();
//        assertEquals(listaNotificacionId.size(), listaNotificacions.size());
//        for (Integer i = 0; i < listaNotificacionId.size(); i++) {
//            assertEquals(listaNotificacionId.get(i), listaNotificacions.get(i).getNotificacionId());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaNotificacionId = new ArrayList<>();
//        insertarNotificacions(listaNotificacionId);
//        
//        ArrayList<NotificacionDto> listaNotificacions = this.notificacionDao.listarTodos();
//        assertEquals(listaNotificacionId.size(), listaNotificacions.size());
//        for (Integer i = 0; i < listaNotificacionId.size(); i++) {
//            // Cambios dummy no nulos
//            this.notificacionDao.modificar(listaNotificacions.get(i));
//        }
//        
//        ArrayList<NotificacionDto> listaNotificacionsModificados = this.notificacionDao.listarTodos();
//        assertEquals( listaNotificacions.size(), listaNotificacionsModificados.size());
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaNotificacionId = new ArrayList<>();
//        insertarNotificacions(listaNotificacionId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<NotificacionDto> listaNotificacions = this.notificacionDao.listarTodos();
//        for (Integer i = 0; i < listaNotificacions.size(); i++) {
//            Integer resultado = this.notificacionDao.eliminar(listaNotificacions.get(i));
//            assertNotEquals(0, resultado);
//            NotificacionDto notificacion = this.notificacionDao.obtenerPorId(listaNotificacions.get(i).getNotificacionId());
//            assertNull(notificacion);
//        }
//    }
}
