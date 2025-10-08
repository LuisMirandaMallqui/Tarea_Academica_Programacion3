package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.TamanoDaoImpl;
import pe.edu.pucp.squirlearn.model.item.TamanoDto;

public class TamanoDaoTest {
    
    private TamanoDao tamanoDao;    
    
    public TamanoDaoTest() {
        this.tamanoDao = new TamanoDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaTamañoId = new ArrayList<>();
        insertarTamaños(listaTamañoId);
        eliminarTodo();
    }
    
    private void insertarTamaños(ArrayList<Integer> listaTamañoId) {
        TamanoDto tamaño = new TamanoDto();
        tamaño.setTamanoId(1);
        tamaño.setNombre("Lorem ipsum nombre");
        tamaño.setFechaCreacion(new Date(System.currentTimeMillis()));
        tamaño.setUsuarioCreacion(1);
        tamaño.setFechaModificacion(new Date(System.currentTimeMillis()));
        tamaño.setUsuarioModificacion(1);
        Integer resultado = this.tamanoDao.insertar(tamaño);
        assertTrue(resultado != 0);
        listaTamañoId.add(resultado);
        
        tamaño.setTamanoId(2);
        tamaño.setNombre("Lorem ipsum B nombre");
        tamaño.setFechaCreacion(new Date(System.currentTimeMillis()));
        tamaño.setUsuarioCreacion(1);
        tamaño.setFechaModificacion(new Date(System.currentTimeMillis()));
        tamaño.setUsuarioModificacion(1);
        resultado = this.tamanoDao.insertar(tamaño);
        assertTrue(resultado != 0);
        listaTamañoId.add(resultado);
        
        tamaño.setTamanoId(3);
        tamaño.setNombre("Lorem ipsum C nombre");
        tamaño.setFechaCreacion(new Date(System.currentTimeMillis()));
        tamaño.setUsuarioCreacion(1);
        tamaño.setFechaModificacion(new Date(System.currentTimeMillis()));
        tamaño.setUsuarioModificacion(1);
        resultado = this.tamanoDao.insertar(tamaño);
        assertTrue(resultado != 0);
        listaTamañoId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaTamañoId = new ArrayList<>();
        insertarTamaños(listaTamañoId);
        TamanoDto tamaño = this.tamanoDao.obtenerPorId(listaTamañoId.get(0));
        assertEquals(tamaño.getTamanoId(), listaTamañoId.get(0));
        
        tamaño = this.tamanoDao.obtenerPorId(listaTamañoId.get(1));
        assertEquals(tamaño.getTamanoId(), listaTamañoId.get(1));
        
        tamaño = this.tamanoDao.obtenerPorId(listaTamañoId.get(2));
        assertEquals(tamaño.getTamanoId(), listaTamañoId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaTamañoId = new ArrayList<>();
        insertarTamaños(listaTamañoId);
        
        ArrayList<TamanoDto> listaTamaños = this.tamanoDao.listarTodos();
        assertEquals(listaTamañoId.size(), listaTamaños.size());
        for (Integer i = 0; i < listaTamañoId.size(); i++) {
            assertEquals(listaTamañoId.get(i), listaTamaños.get(i).getTamanoId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaTamañoId = new ArrayList<>();
        insertarTamaños(listaTamañoId);
        
        ArrayList<TamanoDto> listaTamaños = this.tamanoDao.listarTodos();
        assertEquals(listaTamañoId.size(), listaTamaños.size());
        for (Integer i = 0; i < listaTamañoId.size(); i++) {
            // Cambios dummy no nulos
            this.tamanoDao.modificar(listaTamaños.get(i));
        }
        
        ArrayList<TamanoDto> listaTamañosModificados = this.tamanoDao.listarTodos();
        assertEquals( listaTamaños.size(), listaTamañosModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaTamañoId = new ArrayList<>();
        insertarTamaños(listaTamañoId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<TamanoDto> listaTamaños = this.tamanoDao.listarTodos();
        for (Integer i = 0; i < listaTamaños.size(); i++) {
            Integer resultado = this.tamanoDao.eliminar(listaTamaños.get(i));
            assertNotEquals(0, resultado);
            TamanoDto tamano = this.tamanoDao.obtenerPorId(listaTamaños.get(i).getTamanoId());
            assertNull(tamano);
        }
    }
}
