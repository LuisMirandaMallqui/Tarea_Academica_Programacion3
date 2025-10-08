package pe.edu.pucp.squirlearn.dao.comprobante;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.comprobante.MonedaPagoDaoImpl;
import pe.edu.pucp.squirlearn.model.comprobante.MonedaPagoDto;

public class MonedaPagoDaoTest {
    
    private MonedaPagoDao monedaPagoDao;    
    
    public MonedaPagoDaoTest() {
        this.monedaPagoDao = new MonedaPagoDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaMonedaPagoId = new ArrayList<>();
        insertarMonedaPagos(listaMonedaPagoId);
        eliminarTodo();
    }
    
    private void insertarMonedaPagos(ArrayList<Integer> listaMonedaPagoId) {
        MonedaPagoDto monedaPago = new MonedaPagoDto();
        monedaPago.setNombre("Lorem ipsum nombre");
        monedaPago.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
        monedaPago.setUsuarioCreacion(1);
        monedaPago.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
        monedaPago.setUsuarioModificacion(1);
        Integer resultado = this.monedaPagoDao.insertar(monedaPago);
        assertTrue(resultado != 0);
        listaMonedaPagoId.add(resultado);
        
        monedaPago.setMonedaId(null);
        monedaPago.setNombre("Lorem ipsum B nombre");
        monedaPago.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
        monedaPago.setUsuarioCreacion(1);
        monedaPago.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
        monedaPago.setUsuarioModificacion(1);
        resultado = this.monedaPagoDao.insertar(monedaPago);
        assertTrue(resultado != 0);
        listaMonedaPagoId.add(resultado);
        
        monedaPago.setMonedaId(null);
        monedaPago.setNombre("Lorem ipsum C nombre");
        monedaPago.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
        monedaPago.setUsuarioCreacion(1);
        monedaPago.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
        monedaPago.setUsuarioModificacion(1);
        resultado = this.monedaPagoDao.insertar(monedaPago);
        assertTrue(resultado != 0);
        listaMonedaPagoId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaMonedaPagoId = new ArrayList<>();
        insertarMonedaPagos(listaMonedaPagoId);
        MonedaPagoDto monedaPago = this.monedaPagoDao.obtenerPorId(listaMonedaPagoId.get(0));
        assertEquals(monedaPago.getMonedaId(), listaMonedaPagoId.get(0));
        
        monedaPago = this.monedaPagoDao.obtenerPorId(listaMonedaPagoId.get(1));
        assertEquals(monedaPago.getMonedaId(), listaMonedaPagoId.get(1));
        
        monedaPago = this.monedaPagoDao.obtenerPorId(listaMonedaPagoId.get(2));
        assertEquals(monedaPago.getMonedaId(), listaMonedaPagoId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaMonedaPagoId = new ArrayList<>();
        insertarMonedaPagos(listaMonedaPagoId);
        
        ArrayList<MonedaPagoDto> listaMonedaPagos = this.monedaPagoDao.listarTodos();
        assertEquals(listaMonedaPagoId.size(), listaMonedaPagos.size());
        for (Integer i = 0; i < listaMonedaPagoId.size(); i++) {
            assertEquals(listaMonedaPagoId.get(i), listaMonedaPagos.get(i).getMonedaId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaMonedaPagoId = new ArrayList<>();
        insertarMonedaPagos(listaMonedaPagoId);
        
        ArrayList<MonedaPagoDto> listaMonedaPagos = this.monedaPagoDao.listarTodos();
        assertEquals(listaMonedaPagoId.size(), listaMonedaPagos.size());
        for (Integer i = 0; i < listaMonedaPagoId.size(); i++) {
            // Cambios dummy no nulos
            this.monedaPagoDao.modificar(listaMonedaPagos.get(i));
        }
        
        ArrayList<MonedaPagoDto> listaMonedaPagosModificados = this.monedaPagoDao.listarTodos();
        assertEquals( listaMonedaPagos.size(), listaMonedaPagosModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaMonedaPagoId = new ArrayList<>();
        insertarMonedaPagos(listaMonedaPagoId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<MonedaPagoDto> listaMonedaPagos = this.monedaPagoDao.listarTodos();
        for (Integer i = 0; i < listaMonedaPagos.size(); i++) {
            Integer resultado = this.monedaPagoDao.eliminar(listaMonedaPagos.get(i));
            assertNotEquals(0, resultado);
            MonedaPagoDto monedaPago = this.monedaPagoDao.obtenerPorId(listaMonedaPagos.get(i).getMonedaId());
            assertNull(monedaPago);
        }
    }
}
