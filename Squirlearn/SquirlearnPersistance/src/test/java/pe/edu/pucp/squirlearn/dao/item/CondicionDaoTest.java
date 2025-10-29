package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.CondicionDaoImpl;
import pe.edu.pucp.squirlearn.model.item.CondicionDto;

public class CondicionDaoTest {
    
//    private CondicionDao condicionDao;    
//    
//    public CondicionDaoTest() {
//        this.condicionDao = new CondicionDaoImpl();        
//    }
//    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaCondicionId = new ArrayList<>();
//        insertarCondicions(listaCondicionId);
//        eliminarTodo();
//    }
//    
//    private void insertarCondicions(ArrayList<Integer> listaCondicionId) {
//        CondicionDto condicion = new CondicionDto();
//        condicion.setNombre("Lorem ipsum nombre");
//        condicion.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
//        condicion.setUsuarioCreacion(1);
//        condicion.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
//        condicion.setUsuarioModificacion(1);
//        Integer resultado = this.condicionDao.insertar(condicion);
//        assertTrue(resultado != 0);
//        listaCondicionId.add(resultado);
//        
//        condicion.setCondicionId(null);
//        condicion.setNombre("Lorem ipsum B nombre");
//        condicion.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
//        condicion.setUsuarioCreacion(1);
//        condicion.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
//        condicion.setUsuarioModificacion(1);
//        resultado = this.condicionDao.insertar(condicion);
//        assertTrue(resultado != 0);
//        listaCondicionId.add(resultado);
//        
//        condicion.setCondicionId(null);
//        condicion.setNombre("Lorem ipsum C nombre");
//        condicion.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
//        condicion.setUsuarioCreacion(1);
//        condicion.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
//        condicion.setUsuarioModificacion(1);
//        resultado = this.condicionDao.insertar(condicion);
//        assertTrue(resultado != 0);
//        listaCondicionId.add(resultado);        
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaCondicionId = new ArrayList<>();
//        insertarCondicions(listaCondicionId);
//        CondicionDto condicion = this.condicionDao.obtenerPorId(listaCondicionId.get(0));
//        assertEquals(condicion.getCondicionId(), listaCondicionId.get(0));
//        
//        condicion = this.condicionDao.obtenerPorId(listaCondicionId.get(1));
//        assertEquals(condicion.getCondicionId(), listaCondicionId.get(1));
//        
//        condicion = this.condicionDao.obtenerPorId(listaCondicionId.get(2));
//        assertEquals(condicion.getCondicionId(), listaCondicionId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaCondicionId = new ArrayList<>();
//        insertarCondicions(listaCondicionId);
//        
//        ArrayList<CondicionDto> listaCondicions = this.condicionDao.listarTodos();
//        assertEquals(listaCondicionId.size(), listaCondicions.size());
//        for (Integer i = 0; i < listaCondicionId.size(); i++) {
//            assertEquals(listaCondicionId.get(i), listaCondicions.get(i).getCondicionId());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaCondicionId = new ArrayList<>();
//        insertarCondicions(listaCondicionId);
//        
//        ArrayList<CondicionDto> listaCondicions = this.condicionDao.listarTodos();
//        assertEquals(listaCondicionId.size(), listaCondicions.size());
//        for (Integer i = 0; i < listaCondicionId.size(); i++) {
//            // Cambios dummy no nulos
//            this.condicionDao.modificar(listaCondicions.get(i));
//        }
//        
//        ArrayList<CondicionDto> listaCondicionsModificados = this.condicionDao.listarTodos();
//        assertEquals( listaCondicions.size(), listaCondicionsModificados.size());
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaCondicionId = new ArrayList<>();
//        insertarCondicions(listaCondicionId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<CondicionDto> listaCondicions = this.condicionDao.listarTodos();
//        for (Integer i = 0; i < listaCondicions.size(); i++) {
//            Integer resultado = this.condicionDao.eliminar(listaCondicions.get(i));
//            assertNotEquals(0, resultado);
//            CondicionDto condicion = this.condicionDao.obtenerPorId(listaCondicions.get(i).getCondicionId());
//            assertNull(condicion);
//        }
//    }
}
