package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.ItemDaoImpl;
import pe.edu.pucp.squirlearn.model.item.ItemDto;

public class ItemDaoTest {
    
//    private ItemDao itemDao;    
//    
//    public ItemDaoTest() {
//        this.itemDao = new ItemDaoImpl();        
//    }
//    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaItemId = new ArrayList<>();
//        insertarItems(listaItemId);
//        eliminarTodo();
//    }
//    
//    private void insertarItems(ArrayList<Integer> listaItemId) {
//        ItemDto item = new ItemDto();
//        item.setItemId(1);
//        item.setPrecio(1.0);
//        item.setNombre("Lorem ipsum nombre");
//        item.setEsVenta(Boolean.TRUE);
//        Integer resultado = this.itemDao.insertar(item);
//        assertTrue(resultado != 0);
//        listaItemId.add(resultado);
//        
//        item.setItemId(2);
//        item.setPrecio(1.0);
//        item.setNombre("Lorem ipsum B nombre");
//        item.setEsVenta(Boolean.TRUE);
//        resultado = this.itemDao.insertar(item);
//        assertTrue(resultado != 0);
//        listaItemId.add(resultado);
//        
//        item.setItemId(3);
//        item.setPrecio(1.0);
//        item.setNombre("Lorem ipsum C nombre");
//        item.setEsVenta(Boolean.TRUE);
//        resultado = this.itemDao.insertar(item);
//        assertTrue(resultado != 0);
//        listaItemId.add(resultado);        
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaItemId = new ArrayList<>();
//        insertarItems(listaItemId);
//        ItemDto item = this.itemDao.obtenerPorId(listaItemId.get(0));
//        assertEquals(item.getItemId(), listaItemId.get(0));
//        
//        item = this.itemDao.obtenerPorId(listaItemId.get(1));
//        assertEquals(item.getItemId(), listaItemId.get(1));
//        
//        item = this.itemDao.obtenerPorId(listaItemId.get(2));
//        assertEquals(item.getItemId(), listaItemId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaItemId = new ArrayList<>();
//        insertarItems(listaItemId);
//        
//        ArrayList<ItemDto> listaItems = this.itemDao.listarTodos();
//        assertEquals(listaItemId.size(), listaItems.size());
//        for (Integer i = 0; i < listaItemId.size(); i++) {
//            assertEquals(listaItemId.get(i), listaItems.get(i).getItemId());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaItemId = new ArrayList<>();
//        insertarItems(listaItemId);
//        
//        ArrayList<ItemDto> listaItems = this.itemDao.listarTodos();
//        assertEquals(listaItemId.size(), listaItems.size());
//        for (Integer i = 0; i < listaItemId.size(); i++) {
//            // Cambios dummy no nulos
//            this.itemDao.modificar(listaItems.get(i));
//        }
//        
//        ArrayList<ItemDto> listaItemsModificados = this.itemDao.listarTodos();
//        assertEquals( listaItems.size(), listaItemsModificados.size());
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaItemId = new ArrayList<>();
//        insertarItems(listaItemId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<ItemDto> listaItems = this.itemDao.listarTodos();
//        for (Integer i = 0; i < listaItems.size(); i++) {
//            Integer resultado = this.itemDao.eliminar(listaItems.get(i));
//            assertNotEquals(0, resultado);
//            ItemDto item = this.itemDao.obtenerPorId(listaItems.get(i).getItemId());
//            assertNull(item);
//        }
//    }
}
