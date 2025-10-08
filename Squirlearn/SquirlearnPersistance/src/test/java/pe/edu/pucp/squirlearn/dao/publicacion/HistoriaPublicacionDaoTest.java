package pe.edu.pucp.squirlearn.dao.publicacion;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.publicacion.HistoriaPublicacionDaoImpl;
import pe.edu.pucp.squirlearn.model.publicacion.HistoriaPublicacionDto;

public class HistoriaPublicacionDaoTest {
    
    private HistoriaPublicacionDao historiaPublicacionDao;    
    
    public HistoriaPublicacionDaoTest() {
        this.historiaPublicacionDao = new HistoriaPublicacionDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaHistoriaPublicacionId = new ArrayList<>();
        insertarHistoriaPublicacions(listaHistoriaPublicacionId);
        eliminarTodo();
    }
    
    private void insertarHistoriaPublicacions(ArrayList<Integer> listaHistoriaPublicacionId) {
        HistoriaPublicacionDto historiaPublicacion = new HistoriaPublicacionDto();
        historiaPublicacion.setHistoriaPubliId(1);
        historiaPublicacion.setFechaModificacion(new Date(System.currentTimeMillis()));
        historiaPublicacion.setUsuarioModificacion(1);
        Integer resultado = this.historiaPublicacionDao.insertar(historiaPublicacion);
        assertTrue(resultado != 0);
        listaHistoriaPublicacionId.add(resultado);
        
        historiaPublicacion.setHistoriaPubliId(2);
        historiaPublicacion.setFechaModificacion(new Date(System.currentTimeMillis()));
        historiaPublicacion.setUsuarioModificacion(1);
        resultado = this.historiaPublicacionDao.insertar(historiaPublicacion);
        assertTrue(resultado != 0);
        listaHistoriaPublicacionId.add(resultado);
        
        historiaPublicacion.setHistoriaPubliId(3);
        historiaPublicacion.setFechaModificacion(new Date(System.currentTimeMillis()));
        historiaPublicacion.setUsuarioModificacion(1);
        resultado = this.historiaPublicacionDao.insertar(historiaPublicacion);
        assertTrue(resultado != 0);
        listaHistoriaPublicacionId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaHistoriaPublicacionId = new ArrayList<>();
        insertarHistoriaPublicacions(listaHistoriaPublicacionId);
        HistoriaPublicacionDto historiaPublicacion = this.historiaPublicacionDao.obtenerPorId(listaHistoriaPublicacionId.get(0));
        assertEquals(historiaPublicacion.getHistoriaPubliId(), listaHistoriaPublicacionId.get(0));
        
        historiaPublicacion = this.historiaPublicacionDao.obtenerPorId(listaHistoriaPublicacionId.get(1));
        assertEquals(historiaPublicacion.getHistoriaPubliId(), listaHistoriaPublicacionId.get(1));
        
        historiaPublicacion = this.historiaPublicacionDao.obtenerPorId(listaHistoriaPublicacionId.get(2));
        assertEquals(historiaPublicacion.getHistoriaPubliId(), listaHistoriaPublicacionId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaHistoriaPublicacionId = new ArrayList<>();
        insertarHistoriaPublicacions(listaHistoriaPublicacionId);
        
        ArrayList<HistoriaPublicacionDto> listaHistoriaPublicacions = this.historiaPublicacionDao.listarTodos();
        assertEquals(listaHistoriaPublicacionId.size(), listaHistoriaPublicacions.size());
        for (Integer i = 0; i < listaHistoriaPublicacionId.size(); i++) {
            assertEquals(listaHistoriaPublicacionId.get(i), listaHistoriaPublicacions.get(i).getHistoriaPubliId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaHistoriaPublicacionId = new ArrayList<>();
        insertarHistoriaPublicacions(listaHistoriaPublicacionId);
        
        ArrayList<HistoriaPublicacionDto> listaHistoriaPublicacions = this.historiaPublicacionDao.listarTodos();
        assertEquals(listaHistoriaPublicacionId.size(), listaHistoriaPublicacions.size());
        for (Integer i = 0; i < listaHistoriaPublicacionId.size(); i++) {
            // Cambios dummy no nulos
            this.historiaPublicacionDao.modificar(listaHistoriaPublicacions.get(i));
        }
        
        ArrayList<HistoriaPublicacionDto> listaHistoriaPublicacionsModificados = this.historiaPublicacionDao.listarTodos();
        assertEquals( listaHistoriaPublicacions.size(), listaHistoriaPublicacionsModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaHistoriaPublicacionId = new ArrayList<>();
        insertarHistoriaPublicacions(listaHistoriaPublicacionId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<HistoriaPublicacionDto> listaHistoriaPublicacions = this.historiaPublicacionDao.listarTodos();
        for (Integer i = 0; i < listaHistoriaPublicacions.size(); i++) {
            Integer resultado = this.historiaPublicacionDao.eliminar(listaHistoriaPublicacions.get(i));
            assertNotEquals(0, resultado);
            HistoriaPublicacionDto historiaPublicacion = this.historiaPublicacionDao.obtenerPorId(listaHistoriaPublicacions.get(i).getHistoriaPubliId());
            assertNull(historiaPublicacion);
        }
    }
}
