package pe.edu.pucp.squirlearn.dao.publicacion;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.publicacion.PublicacionDaoImpl;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionDto;

public class PublicacionDaoTest {
    
    private PublicacionDao publicacionDao;    
    
    public PublicacionDaoTest() {
        this.publicacionDao = new PublicacionDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaPublicacionId = new ArrayList<>();
        insertarPublicacions(listaPublicacionId);
        eliminarTodo();
    }
    
    private void insertarPublicacions(ArrayList<Integer> listaPublicacionId) {
        PublicacionDto publicacion = new PublicacionDto();
        publicacion.setPublicacionId(1);
        publicacion.setFechaAlta(new Date(System.currentTimeMillis()));
        publicacion.setFechaBaja(new Date(System.currentTimeMillis()));
        Integer resultado = this.publicacionDao.insertar(publicacion);
        assertTrue(resultado != 0);
        listaPublicacionId.add(resultado);
        
        publicacion.setPublicacionId(2);
        publicacion.setFechaAlta(new Date(System.currentTimeMillis()));
        publicacion.setFechaBaja(new Date(System.currentTimeMillis()));
        resultado = this.publicacionDao.insertar(publicacion);
        assertTrue(resultado != 0);
        listaPublicacionId.add(resultado);
        
        publicacion.setPublicacionId(3);
        publicacion.setFechaAlta(new Date(System.currentTimeMillis()));
        publicacion.setFechaBaja(new Date(System.currentTimeMillis()));
        resultado = this.publicacionDao.insertar(publicacion);
        assertTrue(resultado != 0);
        listaPublicacionId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaPublicacionId = new ArrayList<>();
        insertarPublicacions(listaPublicacionId);
        PublicacionDto publicacion = this.publicacionDao.obtenerPorId(listaPublicacionId.get(0));
        assertEquals(publicacion.getPublicacionId(), listaPublicacionId.get(0));
        
        publicacion = this.publicacionDao.obtenerPorId(listaPublicacionId.get(1));
        assertEquals(publicacion.getPublicacionId(), listaPublicacionId.get(1));
        
        publicacion = this.publicacionDao.obtenerPorId(listaPublicacionId.get(2));
        assertEquals(publicacion.getPublicacionId(), listaPublicacionId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaPublicacionId = new ArrayList<>();
        insertarPublicacions(listaPublicacionId);
        
        ArrayList<PublicacionDto> listaPublicacions = this.publicacionDao.listarTodos();
        assertEquals(listaPublicacionId.size(), listaPublicacions.size());
        for (Integer i = 0; i < listaPublicacionId.size(); i++) {
            assertEquals(listaPublicacionId.get(i), listaPublicacions.get(i).getPublicacionId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaPublicacionId = new ArrayList<>();
        insertarPublicacions(listaPublicacionId);
        
        ArrayList<PublicacionDto> listaPublicacions = this.publicacionDao.listarTodos();
        assertEquals(listaPublicacionId.size(), listaPublicacions.size());
        for (Integer i = 0; i < listaPublicacionId.size(); i++) {
            // Cambios dummy no nulos
            this.publicacionDao.modificar(listaPublicacions.get(i));
        }
        
        ArrayList<PublicacionDto> listaPublicacionsModificados = this.publicacionDao.listarTodos();
        assertEquals( listaPublicacions.size(), listaPublicacionsModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaPublicacionId = new ArrayList<>();
        insertarPublicacions(listaPublicacionId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<PublicacionDto> listaPublicacions = this.publicacionDao.listarTodos();
        for (Integer i = 0; i < listaPublicacions.size(); i++) {
            Integer resultado = this.publicacionDao.eliminar(listaPublicacions.get(i));
            assertNotEquals(0, resultado);
            PublicacionDto publicacion = this.publicacionDao.obtenerPorId(listaPublicacions.get(i).getPublicacionId());
            assertNull(publicacion);
        }
    }
}
