package pe.edu.pucp.squirlearn.dao.alquiler;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.alquiler.AlquilerDaoImpl;
import pe.edu.pucp.squirlearn.model.alquiler.AlquilerDto;

public class AlquilerDaoTest {
    
    private AlquilerDao alquilerDAO;    
    
    public AlquilerDaoTest() {
        this.alquilerDAO = new AlquilerDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaAlquilerId = new ArrayList<>();
        insertarAlquilers(listaAlquilerId);
        eliminarTodo();
    }
    
    private void insertarAlquilers(ArrayList<Integer> listaAlquilerId) {
        AlquilerDto alquiler = new AlquilerDto();
        alquiler.setAlquilerId(null);
        alquiler.setPersona(null);
        alquiler.setFechaInicio(new java.sql.Date(System.currentTimeMillis()));
        alquiler.setFechaFin(new java.sql.Date(System.currentTimeMillis()));
        alquiler.setDevuelto(Boolean.TRUE);
        alquiler.setMonto(1.0);
        alquiler.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
        alquiler.setUsuarioCreacion(1);
        alquiler.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
        alquiler.setUsuarioModificacion(1);
        Integer resultado = this.alquilerDAO.insertar(alquiler);
        assertTrue(resultado != 0);
        listaAlquilerId.add(resultado);
        
        alquiler.setAlquilerId(null);
        alquiler.setFechaInicio(new java.sql.Date(System.currentTimeMillis()));
        alquiler.setFechaFin(new java.sql.Date(System.currentTimeMillis()));
        alquiler.setDevuelto(Boolean.TRUE);
        alquiler.setMonto(1.0);
        alquiler.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
        alquiler.setUsuarioCreacion(1);
        alquiler.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
        alquiler.setUsuarioModificacion(1);
        resultado = this.alquilerDAO.insertar(alquiler);
        assertTrue(resultado != 0);
        listaAlquilerId.add(resultado);
        
        alquiler.setAlquilerId(null);
        alquiler.setFechaInicio(new java.sql.Date(System.currentTimeMillis()));
        alquiler.setFechaFin(new java.sql.Date(System.currentTimeMillis()));
        alquiler.setDevuelto(Boolean.TRUE);
        alquiler.setMonto(1.0);
        alquiler.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
        alquiler.setUsuarioCreacion(1);
        alquiler.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
        alquiler.setUsuarioModificacion(1);
        resultado = this.alquilerDAO.insertar(alquiler);
        assertTrue(resultado != 0);
        listaAlquilerId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaAlquilerId = new ArrayList<>();
        insertarAlquilers(listaAlquilerId);
        AlquilerDto alquiler = this.alquilerDAO.obtenerPorId(listaAlquilerId.get(0));
        assertEquals(alquiler.getAlquilerId(), listaAlquilerId.get(0));
        
        alquiler = this.alquilerDAO.obtenerPorId(listaAlquilerId.get(1));
        assertEquals(alquiler.getAlquilerId(), listaAlquilerId.get(1));
        
        alquiler = this.alquilerDAO.obtenerPorId(listaAlquilerId.get(2));
        assertEquals(alquiler.getAlquilerId(), listaAlquilerId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaAlquilerId = new ArrayList<>();
        insertarAlquilers(listaAlquilerId);
        
        ArrayList<AlquilerDto> listaAlquilers = this.alquilerDAO.listarTodos();
        assertEquals(listaAlquilerId.size(), listaAlquilers.size());
        for (Integer i = 0; i < listaAlquilerId.size(); i++) {
            assertEquals(listaAlquilerId.get(i), listaAlquilers.get(i).getAlquilerId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaAlquilerId = new ArrayList<>();
        insertarAlquilers(listaAlquilerId);
        
        ArrayList<AlquilerDto> listaAlquilers = this.alquilerDAO.listarTodos();
        assertEquals(listaAlquilerId.size(), listaAlquilers.size());
        for (Integer i = 0; i < listaAlquilerId.size(); i++) {
            // Cambios dummy no nulos
            this.alquilerDAO.modificar(listaAlquilers.get(i));
        }
        
        ArrayList<AlquilerDto> listaAlquilersModificados = this.alquilerDAO.listarTodos();
        assertEquals( listaAlquilers.size(), listaAlquilersModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaAlquilerId = new ArrayList<>();
        insertarAlquilers(listaAlquilerId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<AlquilerDto> listaAlquilers = this.alquilerDAO.listarTodos();
        for (Integer i = 0; i < listaAlquilers.size(); i++) {
            Integer resultado = this.alquilerDAO.eliminar(listaAlquilers.get(i));
            assertNotEquals(0, resultado);
            AlquilerDto alquiler = this.alquilerDAO.obtenerPorId(listaAlquilers.get(i).getAlquilerId());
            assertNull(alquiler);
        }
    }
}
