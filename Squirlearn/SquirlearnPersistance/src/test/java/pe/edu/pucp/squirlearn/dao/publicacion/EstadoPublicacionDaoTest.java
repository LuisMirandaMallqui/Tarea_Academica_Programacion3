package pe.edu.pucp.squirlearn.dao.publicacion;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.publicacion.EstadoPublicacionDaoImpl;
import pe.edu.pucp.squirlearn.model.publicacion.EstadoPublicacionDto;

public class EstadoPublicacionDaoTest {
    
    private EstadoPublicacionDao estadoPublicacionDao;    
    
    public EstadoPublicacionDaoTest() {
        this.estadoPublicacionDao = new EstadoPublicacionDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaEstadoPublicacionId = new ArrayList<>();
        insertarEstadoPublicacions(listaEstadoPublicacionId);
        eliminarTodo();
    }
    
    private void insertarEstadoPublicacions(ArrayList<Integer> listaEstadoPublicacionId) {
        EstadoPublicacionDto estadoPublicacion = new EstadoPublicacionDto();
        estadoPublicacion.setNombre("Lorem ipsum nombre");
        estadoPublicacion.setFechaCreacion(new Date(System.currentTimeMillis()));
        estadoPublicacion.setUsuarioCreacion(1);
        estadoPublicacion.setFechaModificacion(new Date(System.currentTimeMillis()));
        estadoPublicacion.setUsuarioModificacion(1);
        Integer resultado = this.estadoPublicacionDao.insertar(estadoPublicacion);
        assertTrue(resultado != 0);
        listaEstadoPublicacionId.add(resultado);
        
        estadoPublicacion.setEstadoPublicacionId(null);
        estadoPublicacion.setNombre("Lorem ipsum B nombre");
        estadoPublicacion.setFechaCreacion(new Date(System.currentTimeMillis()));
        estadoPublicacion.setUsuarioCreacion(1);
        estadoPublicacion.setFechaModificacion(new Date(System.currentTimeMillis()));
        estadoPublicacion.setUsuarioModificacion(1);
        resultado = this.estadoPublicacionDao.insertar(estadoPublicacion);
        assertTrue(resultado != 0);
        listaEstadoPublicacionId.add(resultado);
        
        estadoPublicacion.setEstadoPublicacionId(null);
        estadoPublicacion.setNombre("Lorem ipsum C nombre");
        estadoPublicacion.setFechaCreacion(new Date(System.currentTimeMillis()));
        estadoPublicacion.setUsuarioCreacion(1);
        estadoPublicacion.setFechaModificacion(new Date(System.currentTimeMillis()));
        estadoPublicacion.setUsuarioModificacion(1);
        resultado = this.estadoPublicacionDao.insertar(estadoPublicacion);
        assertTrue(resultado != 0);
        listaEstadoPublicacionId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaEstadoPublicacionId = new ArrayList<>();
        insertarEstadoPublicacions(listaEstadoPublicacionId);
        EstadoPublicacionDto estadoPublicacion = this.estadoPublicacionDao.obtenerPorId(listaEstadoPublicacionId.get(0));
        assertEquals(estadoPublicacion.getEstadoPublicacionId(), listaEstadoPublicacionId.get(0));
        
        estadoPublicacion = this.estadoPublicacionDao.obtenerPorId(listaEstadoPublicacionId.get(1));
        assertEquals(estadoPublicacion.getEstadoPublicacionId(), listaEstadoPublicacionId.get(1));
        
        estadoPublicacion = this.estadoPublicacionDao.obtenerPorId(listaEstadoPublicacionId.get(2));
        assertEquals(estadoPublicacion.getEstadoPublicacionId(), listaEstadoPublicacionId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaEstadoPublicacionId = new ArrayList<>();
        insertarEstadoPublicacions(listaEstadoPublicacionId);
        
        ArrayList<EstadoPublicacionDto> listaEstadoPublicacions = this.estadoPublicacionDao.listarTodos();
        assertEquals(listaEstadoPublicacionId.size(), listaEstadoPublicacions.size());
        for (Integer i = 0; i < listaEstadoPublicacionId.size(); i++) {
            assertEquals(listaEstadoPublicacionId.get(i), listaEstadoPublicacions.get(i).getEstadoPublicacionId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaEstadoPublicacionId = new ArrayList<>();
        insertarEstadoPublicacions(listaEstadoPublicacionId);
        
        ArrayList<EstadoPublicacionDto> listaEstadoPublicacions = this.estadoPublicacionDao.listarTodos();
        assertEquals(listaEstadoPublicacionId.size(), listaEstadoPublicacions.size());
        for (Integer i = 0; i < listaEstadoPublicacionId.size(); i++) {
            // Cambios dummy no nulos
            this.estadoPublicacionDao.modificar(listaEstadoPublicacions.get(i));
        }
        
        ArrayList<EstadoPublicacionDto> listaEstadoPublicacionsModificados = this.estadoPublicacionDao.listarTodos();
        assertEquals( listaEstadoPublicacions.size(), listaEstadoPublicacionsModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaEstadoPublicacionId = new ArrayList<>();
        insertarEstadoPublicacions(listaEstadoPublicacionId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<EstadoPublicacionDto> listaEstadoPublicacions = this.estadoPublicacionDao.listarTodos();
        for (Integer i = 0; i < listaEstadoPublicacions.size(); i++) {
            Integer resultado = this.estadoPublicacionDao.eliminar(listaEstadoPublicacions.get(i));
            assertNotEquals(0, resultado);
            EstadoPublicacionDto estadoPublicacion = this.estadoPublicacionDao.obtenerPorId(listaEstadoPublicacions.get(i).getEstadoPublicacionId());
            assertNull(estadoPublicacion);
        }
    }
}
