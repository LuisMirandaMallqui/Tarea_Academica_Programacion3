package pe.edu.pucp.squirlearn.dao.comprobante;

import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.comprobante.FormaPagoDaoImpl;
import pe.edu.pucp.squirlearn.model.comprobante.FormaPagoDto;

public class FormaPagoDaoTest {
    
    private FormaPagoDao formaPagoDao;    
    
    public FormaPagoDaoTest() {
        this.formaPagoDao = new FormaPagoDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaFormaPagoId = new ArrayList<>();
        insertarFormaPagos(listaFormaPagoId);
        eliminarTodo();
    }
    
    private void insertarFormaPagos(ArrayList<Integer> listaFormaPagoId) {
        FormaPagoDto formaPago = new FormaPagoDto();
        formaPago.setNombre("Lorem ipsum nombre");
        formaPago.setFechaCreacion(new Date(System.currentTimeMillis()));
        formaPago.setUsuarioCreacion(1);
        formaPago.setFechaModificacion(new Date(System.currentTimeMillis()));
        formaPago.setUsuarioModificacion(1);
        Integer resultado = this.formaPagoDao.insertar(formaPago);
        assertTrue(resultado != 0);
        listaFormaPagoId.add(resultado);
        
        formaPago.setFormaPagoId(null);
        formaPago.setNombre("Lorem ipsum B nombre");
        formaPago.setFechaCreacion(new Date(System.currentTimeMillis()));
        formaPago.setUsuarioCreacion(1);
        formaPago.setFechaModificacion(new Date(System.currentTimeMillis()));
        formaPago.setUsuarioModificacion(1);
        resultado = this.formaPagoDao.insertar(formaPago);
        assertTrue(resultado != 0);
        listaFormaPagoId.add(resultado);
        
        formaPago.setFormaPagoId(null);
        formaPago.setNombre("Lorem ipsum C nombre");
        formaPago.setFechaCreacion(new Date(System.currentTimeMillis()));
        formaPago.setUsuarioCreacion(1);
        formaPago.setFechaModificacion(new Date(System.currentTimeMillis()));
        formaPago.setUsuarioModificacion(1);
        resultado = this.formaPagoDao.insertar(formaPago);
        assertTrue(resultado != 0);
        listaFormaPagoId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaFormaPagoId = new ArrayList<>();
        insertarFormaPagos(listaFormaPagoId);
        FormaPagoDto formaPago = this.formaPagoDao.obtenerPorId(listaFormaPagoId.get(0));
        assertEquals(formaPago.getFormaPagoId(), listaFormaPagoId.get(0));
        
        formaPago = this.formaPagoDao.obtenerPorId(listaFormaPagoId.get(1));
        assertEquals(formaPago.getFormaPagoId(), listaFormaPagoId.get(1));
        
        formaPago = this.formaPagoDao.obtenerPorId(listaFormaPagoId.get(2));
        assertEquals(formaPago.getFormaPagoId(), listaFormaPagoId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaFormaPagoId = new ArrayList<>();
        insertarFormaPagos(listaFormaPagoId);
        
        ArrayList<FormaPagoDto> listaFormaPagos = this.formaPagoDao.listarTodos();
        assertEquals(listaFormaPagoId.size(), listaFormaPagos.size());
        for (Integer i = 0; i < listaFormaPagoId.size(); i++) {
            assertEquals(listaFormaPagoId.get(i), listaFormaPagos.get(i).getFormaPagoId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaFormaPagoId = new ArrayList<>();
        insertarFormaPagos(listaFormaPagoId);
        
        ArrayList<FormaPagoDto> listaFormaPagos = this.formaPagoDao.listarTodos();
        assertEquals(listaFormaPagoId.size(), listaFormaPagos.size());
        for (Integer i = 0; i < listaFormaPagoId.size(); i++) {
            // Cambios dummy no nulos
            this.formaPagoDao.modificar(listaFormaPagos.get(i));
        }
        
        ArrayList<FormaPagoDto> listaFormaPagosModificados = this.formaPagoDao.listarTodos();
        assertEquals( listaFormaPagos.size(), listaFormaPagosModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaFormaPagoId = new ArrayList<>();
        insertarFormaPagos(listaFormaPagoId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<FormaPagoDto> listaFormaPagos = this.formaPagoDao.listarTodos();
        for (Integer i = 0; i < listaFormaPagos.size(); i++) {
            Integer resultado = this.formaPagoDao.eliminar(listaFormaPagos.get(i));
            assertNotEquals(0, resultado);
            FormaPagoDto formaPago = this.formaPagoDao.obtenerPorId(listaFormaPagos.get(i).getFormaPagoId());
            assertNull(formaPago);
        }
    }
}
