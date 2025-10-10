package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.SubcategoriaDaoImpl;
import pe.edu.pucp.squirlearn.model.item.SubcategoriaDto;

public class SubcategoriaDaoTest {
    
    private SubcategoriaDao subcategoriaDao;    
    
    public SubcategoriaDaoTest() {
        this.subcategoriaDao = new SubcategoriaDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaSubcategoriaId = new ArrayList<>();
        insertarSubcategorias(listaSubcategoriaId);
        eliminarTodo();
    }
    
    private void insertarSubcategorias(ArrayList<Integer> listaSubcategoriaId) {
        SubcategoriaDto subcategoria = new SubcategoriaDto();
        subcategoria.setSubcategoriaId(1);
        subcategoria.setNombre("Lorem ipsum nombre");
        subcategoria.setFechaCreacion(new Date(System.currentTimeMillis()));
        subcategoria.setUsuarioCreacion(1);
        subcategoria.setFechaModificacion(new Date(System.currentTimeMillis()));
        subcategoria.setUsuarioModificacion(1);
        Integer resultado = this.subcategoriaDao.insertar(subcategoria);
        assertTrue(resultado != 0);
        listaSubcategoriaId.add(resultado);
        
        subcategoria.setSubcategoriaId(2);
        subcategoria.setNombre("Lorem ipsum B nombre");
        subcategoria.setFechaCreacion(new Date(System.currentTimeMillis()));
        subcategoria.setUsuarioCreacion(1);
        subcategoria.setFechaModificacion(new Date(System.currentTimeMillis()));
        subcategoria.setUsuarioModificacion(1);
        resultado = this.subcategoriaDao.insertar(subcategoria);
        assertTrue(resultado != 0);
        listaSubcategoriaId.add(resultado);
        
        subcategoria.setSubcategoriaId(3);
        subcategoria.setNombre("Lorem ipsum C nombre");
        subcategoria.setFechaCreacion(new Date(System.currentTimeMillis()));
        subcategoria.setUsuarioCreacion(1);
        subcategoria.setFechaModificacion(new Date(System.currentTimeMillis()));
        subcategoria.setUsuarioModificacion(1);
        resultado = this.subcategoriaDao.insertar(subcategoria);
        assertTrue(resultado != 0);
        listaSubcategoriaId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaSubcategoriaId = new ArrayList<>();
        insertarSubcategorias(listaSubcategoriaId);
        SubcategoriaDto subcategoria = this.subcategoriaDao.obtenerPorId(listaSubcategoriaId.get(0));
        assertEquals(subcategoria.getSubcategoriaId(), listaSubcategoriaId.get(0));
        
        subcategoria = this.subcategoriaDao.obtenerPorId(listaSubcategoriaId.get(1));
        assertEquals(subcategoria.getSubcategoriaId(), listaSubcategoriaId.get(1));
        
        subcategoria = this.subcategoriaDao.obtenerPorId(listaSubcategoriaId.get(2));
        assertEquals(subcategoria.getSubcategoriaId(), listaSubcategoriaId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaSubcategoriaId = new ArrayList<>();
        insertarSubcategorias(listaSubcategoriaId);
        
        ArrayList<SubcategoriaDto> listaSubcategorias = this.subcategoriaDao.listarTodos();
        assertEquals(listaSubcategoriaId.size(), listaSubcategorias.size());
        for (Integer i = 0; i < listaSubcategoriaId.size(); i++) {
            assertEquals(listaSubcategoriaId.get(i), listaSubcategorias.get(i).getSubcategoriaId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaSubcategoriaId = new ArrayList<>();
        insertarSubcategorias(listaSubcategoriaId);
        
        ArrayList<SubcategoriaDto> listaSubcategorias = this.subcategoriaDao.listarTodos();
        assertEquals(listaSubcategoriaId.size(), listaSubcategorias.size());
        for (Integer i = 0; i < listaSubcategoriaId.size(); i++) {
            // Cambios dummy no nulos
            this.subcategoriaDao.modificar(listaSubcategorias.get(i));
        }
        
        ArrayList<SubcategoriaDto> listaSubcategoriasModificados = this.subcategoriaDao.listarTodos();
        assertEquals( listaSubcategorias.size(), listaSubcategoriasModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaSubcategoriaId = new ArrayList<>();
        insertarSubcategorias(listaSubcategoriaId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<SubcategoriaDto> listaSubcategorias = this.subcategoriaDao.listarTodos();
        for (Integer i = 0; i < listaSubcategorias.size(); i++) {
            Integer resultado = this.subcategoriaDao.eliminar(listaSubcategorias.get(i));
            assertNotEquals(0, resultado);
            SubcategoriaDto subcategoria = this.subcategoriaDao.obtenerPorId(listaSubcategorias.get(i).getSubcategoriaId());
            assertNull(subcategoria);
        }
    }
}
