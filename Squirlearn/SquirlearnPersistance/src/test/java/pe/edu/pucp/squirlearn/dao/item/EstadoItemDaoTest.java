package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import java.sql.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.EstadoItemDaoImpl;
import pe.edu.pucp.squirlearn.model.item.EstadoItemDto;

public class EstadoItemDaoTest {
    
//    private EstadoItemDao estadoItemDao;    
//    
//    public EstadoItemDaoTest() {
//        this.estadoItemDao = new EstadoItemDaoImpl();        
//    }
//    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaEstadoItemId = new ArrayList<>();
//        insertarEstadoItems(listaEstadoItemId);
//        eliminarTodo();
//    }
//    
//    private void insertarEstadoItems(ArrayList<Integer> listaEstadoItemId) {
//        EstadoItemDto estadoItem = new EstadoItemDto();
//        estadoItem.setNombre("Lorem ipsum nombre");
//        estadoItem.setFechaCreacion(new Date(System.currentTimeMillis()));
//        estadoItem.setUsuarioCreacion(1);
//        estadoItem.setFechaModificacion(new Date(System.currentTimeMillis()));
//        estadoItem.setUsuarioModificacion(1);
//        Integer resultado = this.estadoItemDao.insertar(estadoItem);
//        assertTrue(resultado != 0);
//        listaEstadoItemId.add(resultado);
//        
//        estadoItem.setEstadoItemId(null);
//        estadoItem.setNombre("Lorem ipsum B nombre");
//        estadoItem.setFechaCreacion(new Date(System.currentTimeMillis()));
//        estadoItem.setUsuarioCreacion(1);
//        estadoItem.setFechaModificacion(new Date(System.currentTimeMillis()));
//        estadoItem.setUsuarioModificacion(1);
//        resultado = this.estadoItemDao.insertar(estadoItem);
//        assertTrue(resultado != 0);
//        listaEstadoItemId.add(resultado);
//        
//        estadoItem.setEstadoItemId(null);
//        estadoItem.setNombre("Lorem ipsum C nombre");
//        estadoItem.setFechaCreacion(new Date(System.currentTimeMillis()));
//        estadoItem.setUsuarioCreacion(1);
//        estadoItem.setFechaModificacion(new Date(System.currentTimeMillis()));
//        estadoItem.setUsuarioModificacion(1);
//        resultado = this.estadoItemDao.insertar(estadoItem);
//        assertTrue(resultado != 0);
//        listaEstadoItemId.add(resultado);        
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaEstadoItemId = new ArrayList<>();
//        insertarEstadoItems(listaEstadoItemId);
//        EstadoItemDto estadoItem = this.estadoItemDao.obtenerPorId(listaEstadoItemId.get(0));
//        assertEquals(estadoItem.getEstadoItemId(), listaEstadoItemId.get(0));
//        
//        estadoItem = this.estadoItemDao.obtenerPorId(listaEstadoItemId.get(1));
//        assertEquals(estadoItem.getEstadoItemId(), listaEstadoItemId.get(1));
//        
//        estadoItem = this.estadoItemDao.obtenerPorId(listaEstadoItemId.get(2));
//        assertEquals(estadoItem.getEstadoItemId(), listaEstadoItemId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaEstadoItemId = new ArrayList<>();
//        insertarEstadoItems(listaEstadoItemId);
//        
//        ArrayList<EstadoItemDto> listaEstadoItems = this.estadoItemDao.listarTodos();
//        assertEquals(listaEstadoItemId.size(), listaEstadoItems.size());
//        for (Integer i = 0; i < listaEstadoItemId.size(); i++) {
//            assertEquals(listaEstadoItemId.get(i), listaEstadoItems.get(i).getEstadoItemId());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaEstadoItemId = new ArrayList<>();
//        insertarEstadoItems(listaEstadoItemId);
//        
//        ArrayList<EstadoItemDto> listaEstadoItems = this.estadoItemDao.listarTodos();
//        assertEquals(listaEstadoItemId.size(), listaEstadoItems.size());
//        for (Integer i = 0; i < listaEstadoItemId.size(); i++) {
//            // Cambios dummy no nulos
//            this.estadoItemDao.modificar(listaEstadoItems.get(i));
//        }
//        
//        ArrayList<EstadoItemDto> listaEstadoItemsModificados = this.estadoItemDao.listarTodos();
//        assertEquals( listaEstadoItems.size(), listaEstadoItemsModificados.size());
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaEstadoItemId = new ArrayList<>();
//        insertarEstadoItems(listaEstadoItemId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<EstadoItemDto> listaEstadoItems = this.estadoItemDao.listarTodos();
//        for (Integer i = 0; i < listaEstadoItems.size(); i++) {
//            Integer resultado = this.estadoItemDao.eliminar(listaEstadoItems.get(i));
//            assertNotEquals(0, resultado);
//            EstadoItemDto estadoItem = this.estadoItemDao.obtenerPorId(listaEstadoItems.get(i).getEstadoItemId());
//            assertNull(estadoItem);
//        }
//    }
}
