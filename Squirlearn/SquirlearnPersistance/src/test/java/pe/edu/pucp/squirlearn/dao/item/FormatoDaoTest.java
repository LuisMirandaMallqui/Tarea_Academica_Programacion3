package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.FormatoDaoImpl;
import pe.edu.pucp.squirlearn.model.item.FormatoDto;

public class FormatoDaoTest {
    
    private FormatoDao formatoDao;    
    
    public FormatoDaoTest() {
        this.formatoDao = new FormatoDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaFormatoId = new ArrayList<>();
        insertarFormatos(listaFormatoId);
        eliminarTodo();
    }
    
    private void insertarFormatos(ArrayList<Integer> listaFormatoId) {
        FormatoDto formato = new FormatoDto();
        formato.setNombre("Lorem ipsum nombre");
        formato.setFechaCreacion(new Date(System.currentTimeMillis()));
        formato.setUsuarioCreacion(1);
        formato.setFechaModificacion(new Date(System.currentTimeMillis()));
        formato.setUsuarioModificacion(1);
        Integer resultado = this.formatoDao.insertar(formato);
        assertTrue(resultado != 0);
        listaFormatoId.add(resultado);
        
        formato.setFormatoId(null);
        formato.setNombre("Lorem ipsum B nombre");
        formato.setFechaCreacion(new Date(System.currentTimeMillis()));
        formato.setUsuarioCreacion(1);
        formato.setFechaModificacion(new Date(System.currentTimeMillis()));
        formato.setUsuarioModificacion(1);
        resultado = this.formatoDao.insertar(formato);
        assertTrue(resultado != 0);
        listaFormatoId.add(resultado);
        
        formato.setFormatoId(null);
        formato.setNombre("Lorem ipsum C nombre");
        formato.setFechaCreacion(new Date(System.currentTimeMillis()));
        formato.setUsuarioCreacion(1);
        formato.setFechaModificacion(new Date(System.currentTimeMillis()));
        formato.setUsuarioModificacion(1);
        resultado = this.formatoDao.insertar(formato);
        assertTrue(resultado != 0);
        listaFormatoId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaFormatoId = new ArrayList<>();
        insertarFormatos(listaFormatoId);
        FormatoDto formato = this.formatoDao.obtenerPorId(listaFormatoId.get(0));
        assertEquals(formato.getFormatoId(), listaFormatoId.get(0));
        
        formato = this.formatoDao.obtenerPorId(listaFormatoId.get(1));
        assertEquals(formato.getFormatoId(), listaFormatoId.get(1));
        
        formato = this.formatoDao.obtenerPorId(listaFormatoId.get(2));
        assertEquals(formato.getFormatoId(), listaFormatoId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaFormatoId = new ArrayList<>();
        insertarFormatos(listaFormatoId);
        
        ArrayList<FormatoDto> listaFormatos = this.formatoDao.listarTodos();
        assertEquals(listaFormatoId.size(), listaFormatos.size());
        for (Integer i = 0; i < listaFormatoId.size(); i++) {
            assertEquals(listaFormatoId.get(i), listaFormatos.get(i).getFormatoId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaFormatoId = new ArrayList<>();
        insertarFormatos(listaFormatoId);
        
        ArrayList<FormatoDto> listaFormatos = this.formatoDao.listarTodos();
        assertEquals(listaFormatoId.size(), listaFormatos.size());
        for (Integer i = 0; i < listaFormatoId.size(); i++) {
            // Cambios dummy no nulos
            this.formatoDao.modificar(listaFormatos.get(i));
        }
        
        ArrayList<FormatoDto> listaFormatosModificados = this.formatoDao.listarTodos();
        assertEquals( listaFormatos.size(), listaFormatosModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaFormatoId = new ArrayList<>();
        insertarFormatos(listaFormatoId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<FormatoDto> listaFormatos = this.formatoDao.listarTodos();
        for (Integer i = 0; i < listaFormatos.size(); i++) {
            Integer resultado = this.formatoDao.eliminar(listaFormatos.get(i));
            assertNotEquals(0, resultado);
            FormatoDto formato = this.formatoDao.obtenerPorId(listaFormatos.get(i).getFormatoId());
            assertNull(formato);
        }
    }
}
