package pe.edu.pucp.squirlearn.dao.publicacion;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.publicacion.CalificacionDaoImpl;
import pe.edu.pucp.squirlearn.model.publicacion.CalificacionDto;

public class CalificacionDaoTest {
    
    private CalificacionDao calificacionDao;    
    
    public CalificacionDaoTest() {
        this.calificacionDao = new CalificacionDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaCalificacionId = new ArrayList<>();
        insertarCalificacions(listaCalificacionId);
        eliminarTodo();
    }
    
    private void insertarCalificacions(ArrayList<Integer> listaCalificacionId) {
        CalificacionDto calificacion = new CalificacionDto();
        calificacion.setNombre("Lorem ipsum nombre");
        calificacion.setFechaCreacion(new Date(System.currentTimeMillis()));
        calificacion.setUsuarioCreacion(1);
        calificacion.setFechaModificacion(new Date(System.currentTimeMillis()));
        calificacion.setUsuarioModificacion(1);
        Integer resultado = this.calificacionDao.insertar(calificacion);
        assertTrue(resultado != 0);
        listaCalificacionId.add(resultado);
        
        calificacion.setCalificacionId(null);
        calificacion.setNombre("Lorem ipsum B nombre");
        calificacion.setFechaCreacion(new Date(System.currentTimeMillis()));
        calificacion.setUsuarioCreacion(1);
        calificacion.setFechaModificacion(new Date(System.currentTimeMillis()));
        calificacion.setUsuarioModificacion(1);
        resultado = this.calificacionDao.insertar(calificacion);
        assertTrue(resultado != 0);
        listaCalificacionId.add(resultado);
        
        calificacion.setCalificacionId(null);
        calificacion.setNombre("Lorem ipsum C nombre");
        calificacion.setFechaCreacion(new Date(System.currentTimeMillis()));
        calificacion.setUsuarioCreacion(1);
        calificacion.setFechaModificacion(new Date(System.currentTimeMillis()));
        calificacion.setUsuarioModificacion(1);
        resultado = this.calificacionDao.insertar(calificacion);
        assertTrue(resultado != 0);
        listaCalificacionId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaCalificacionId = new ArrayList<>();
        insertarCalificacions(listaCalificacionId);
        CalificacionDto calificacion = this.calificacionDao.obtenerPorId(listaCalificacionId.get(0));
        assertEquals(calificacion.getCalificacionId(), listaCalificacionId.get(0));
        
        calificacion = this.calificacionDao.obtenerPorId(listaCalificacionId.get(1));
        assertEquals(calificacion.getCalificacionId(), listaCalificacionId.get(1));
        
        calificacion = this.calificacionDao.obtenerPorId(listaCalificacionId.get(2));
        assertEquals(calificacion.getCalificacionId(), listaCalificacionId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaCalificacionId = new ArrayList<>();
        insertarCalificacions(listaCalificacionId);
        
        ArrayList<CalificacionDto> listaCalificacions = this.calificacionDao.listarTodos();
        assertEquals(listaCalificacionId.size(), listaCalificacions.size());
        for (Integer i = 0; i < listaCalificacionId.size(); i++) {
            assertEquals(listaCalificacionId.get(i), listaCalificacions.get(i).getCalificacionId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaCalificacionId = new ArrayList<>();
        insertarCalificacions(listaCalificacionId);
        
        ArrayList<CalificacionDto> listaCalificacions = this.calificacionDao.listarTodos();
        assertEquals(listaCalificacionId.size(), listaCalificacions.size());
        for (Integer i = 0; i < listaCalificacionId.size(); i++) {
            // Cambios dummy no nulos
            this.calificacionDao.modificar(listaCalificacions.get(i));
        }
        
        ArrayList<CalificacionDto> listaCalificacionsModificados = this.calificacionDao.listarTodos();
        assertEquals( listaCalificacions.size(), listaCalificacionsModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaCalificacionId = new ArrayList<>();
        insertarCalificacions(listaCalificacionId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<CalificacionDto> listaCalificacions = this.calificacionDao.listarTodos();
        for (Integer i = 0; i < listaCalificacions.size(); i++) {
            Integer resultado = this.calificacionDao.eliminar(listaCalificacions.get(i));
            assertNotEquals(0, resultado);
            CalificacionDto calificacion = this.calificacionDao.obtenerPorId(listaCalificacions.get(i).getCalificacionId());
            assertNull(calificacion);
        }
    }
}
