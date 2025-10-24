package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import java.sql.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.CategoriaDaoImpl;
import pe.edu.pucp.squirlearn.model.item.CategoriaDto;

public class CategoriaDaoTest {
    
    private CategoriaDao categoriaDao;    
    
    public CategoriaDaoTest() {
        this.categoriaDao = new CategoriaDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaCategoriaId = new ArrayList<>();
        insertarCategorias(listaCategoriaId);
        eliminarTodo();
    }
    
    private void insertarCategorias(ArrayList<Integer> listaCategoriaId) {
        CategoriaDto categoria = new CategoriaDto();
        categoria.setNombre("Lorem ipsum nombre");
        categoria.setFechaCreacion(new Date(System.currentTimeMillis()));
        categoria.setUsuarioCreacion(1);
        categoria.setFechaModificacion(new Date(System.currentTimeMillis()));
        categoria.setUsuarioModificacion(1);
        Integer resultado = this.categoriaDao.insertar(categoria);
        assertTrue(resultado != 0);
        listaCategoriaId.add(resultado);
        
        categoria.setCategoriaId(null);
        categoria.setNombre("Lorem ipsum B nombre");
        categoria.setFechaCreacion(new Date(System.currentTimeMillis()));
        categoria.setUsuarioCreacion(1);
        categoria.setFechaModificacion(new Date(System.currentTimeMillis()));
        categoria.setUsuarioModificacion(1);
        resultado = this.categoriaDao.insertar(categoria);
        assertTrue(resultado != 0);
        listaCategoriaId.add(resultado);
        
        categoria.setCategoriaId(null);
        categoria.setNombre("Lorem ipsum C nombre");
        categoria.setFechaCreacion(new Date(System.currentTimeMillis()));
        categoria.setUsuarioCreacion(1);
        categoria.setFechaModificacion(new Date(System.currentTimeMillis()));
        categoria.setUsuarioModificacion(1);
        resultado = this.categoriaDao.insertar(categoria);
        assertTrue(resultado != 0);
        listaCategoriaId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaCategoriaId = new ArrayList<>();
        insertarCategorias(listaCategoriaId);
        CategoriaDto categoria = this.categoriaDao.obtenerPorId(listaCategoriaId.get(0));
        assertEquals(categoria.getCategoriaId(), listaCategoriaId.get(0));
        
        categoria = this.categoriaDao.obtenerPorId(listaCategoriaId.get(1));
        assertEquals(categoria.getCategoriaId(), listaCategoriaId.get(1));
        
        categoria = this.categoriaDao.obtenerPorId(listaCategoriaId.get(2));
        assertEquals(categoria.getCategoriaId(), listaCategoriaId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaCategoriaId = new ArrayList<>();
        insertarCategorias(listaCategoriaId);
        
        ArrayList<CategoriaDto> listaCategorias = this.categoriaDao.listarTodos();
        assertEquals(listaCategoriaId.size(), listaCategorias.size());
        for (Integer i = 0; i < listaCategoriaId.size(); i++) {
            assertEquals(listaCategoriaId.get(i), listaCategorias.get(i).getCategoriaId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaCategoriaId = new ArrayList<>();
        insertarCategorias(listaCategoriaId);
        
        ArrayList<CategoriaDto> listaCategorias = this.categoriaDao.listarTodos();
        assertEquals(listaCategoriaId.size(), listaCategorias.size());
        for (Integer i = 0; i < listaCategoriaId.size(); i++) {
            // Cambios dummy no nulos
            this.categoriaDao.modificar(listaCategorias.get(i));
        }
        
        ArrayList<CategoriaDto> listaCategoriasModificados = this.categoriaDao.listarTodos();
        assertEquals( listaCategorias.size(), listaCategoriasModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaCategoriaId = new ArrayList<>();
        insertarCategorias(listaCategoriaId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<CategoriaDto> listaCategorias = this.categoriaDao.listarTodos();
        for (Integer i = 0; i < listaCategorias.size(); i++) {
            Integer resultado = this.categoriaDao.eliminar(listaCategorias.get(i));
            assertNotEquals(0, resultado);
            CategoriaDto categoria = this.categoriaDao.obtenerPorId(listaCategorias.get(i).getCategoriaId());
            assertNull(categoria);
        }
    }
}
