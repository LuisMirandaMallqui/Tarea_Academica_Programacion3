package pe.edu.pucp.squirlearn.dao.item;

import java.sql.Date;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.ColorDaoImpl;
import pe.edu.pucp.squirlearn.model.item.ColorDto;

public class ColorDaoTest {
    
//    private ColorDao colorDao;    
//    
//    public ColorDaoTest() {
//        this.colorDao = new ColorDaoImpl();        
//    }
//    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaColorId = new ArrayList<>();
//        insertarColors(listaColorId);
//        eliminarTodo();
//    }
//    
//    private void insertarColors(ArrayList<Integer> listaColorId) {
//        ColorDto color = new ColorDto();
//        color.setNombre("Lorem ipsum nombre");
//        color.setFechaCreacion(new Date(System.currentTimeMillis()));
//        color.setUsuarioCreacion(1);
//        color.setFechaModificacion(new Date(System.currentTimeMillis()));
//        color.setUsuarioModificacion(1);
//        Integer resultado = this.colorDao.insertar(color);
//        assertTrue(resultado != 0);
//        listaColorId.add(resultado);
//        
//        color.setColorId(null);
//        color.setNombre("Lorem ipsum B nombre");
//        color.setFechaCreacion(new Date(System.currentTimeMillis()));
//        color.setUsuarioCreacion(1);
//        color.setFechaModificacion(new Date(System.currentTimeMillis()));
//        color.setUsuarioModificacion(1);
//        resultado = this.colorDao.insertar(color);
//        assertTrue(resultado != 0);
//        listaColorId.add(resultado);
//        
//        color.setColorId(null);
//        color.setNombre("Lorem ipsum C nombre");
//        color.setFechaCreacion(new Date(System.currentTimeMillis()));
//        color.setUsuarioCreacion(1);
//        color.setFechaModificacion(new Date(System.currentTimeMillis()));
//        color.setUsuarioModificacion(1);
//        resultado = this.colorDao.insertar(color);
//        assertTrue(resultado != 0);
//        listaColorId.add(resultado);        
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaColorId = new ArrayList<>();
//        insertarColors(listaColorId);
//        ColorDto color = this.colorDao.obtenerPorId(listaColorId.get(0));
//        assertEquals(color.getColorId(), listaColorId.get(0));
//        
//        color = this.colorDao.obtenerPorId(listaColorId.get(1));
//        assertEquals(color.getColorId(), listaColorId.get(1));
//        
//        color = this.colorDao.obtenerPorId(listaColorId.get(2));
//        assertEquals(color.getColorId(), listaColorId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaColorId = new ArrayList<>();
//        insertarColors(listaColorId);
//        
//        ArrayList<ColorDto> listaColors = this.colorDao.listarTodos();
//        assertEquals(listaColorId.size(), listaColors.size());
//        for (Integer i = 0; i < listaColorId.size(); i++) {
//            assertEquals(listaColorId.get(i), listaColors.get(i).getColorId());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaColorId = new ArrayList<>();
//        insertarColors(listaColorId);
//        
//        ArrayList<ColorDto> listaColors = this.colorDao.listarTodos();
//        assertEquals(listaColorId.size(), listaColors.size());
//        for (Integer i = 0; i < listaColorId.size(); i++) {
//            // Cambios dummy no nulos
//            this.colorDao.modificar(listaColors.get(i));
//        }
//        
//        ArrayList<ColorDto> listaColorsModificados = this.colorDao.listarTodos();
//        assertEquals( listaColors.size(), listaColorsModificados.size());
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaColorId = new ArrayList<>();
//        insertarColors(listaColorId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<ColorDto> listaColors = this.colorDao.listarTodos();
//        for (Integer i = 0; i < listaColors.size(); i++) {
//            Integer resultado = this.colorDao.eliminar(listaColors.get(i));
//            assertNotEquals(0, resultado);
//            ColorDto color = this.colorDao.obtenerPorId(listaColors.get(i).getColorId());
//            assertNull(color);
//        }
//    }
}
