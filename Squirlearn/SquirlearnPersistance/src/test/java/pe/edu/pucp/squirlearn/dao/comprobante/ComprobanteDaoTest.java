package pe.edu.pucp.squirlearn.dao.comprobante;

import java.util.ArrayList;
import java.sql.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.comprobante.ComprobanteDaoImpl;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto;

public class ComprobanteDaoTest {
    
    private ComprobanteDao comprobanteDao;    
    
    public ComprobanteDaoTest() {
        this.comprobanteDao = new ComprobanteDaoImpl();        
    }
    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaComprobanteId = new ArrayList<>();
//        insertarComprobantes(listaComprobanteId);
//        eliminarTodo();
//    }
//    
//    private void insertarComprobantes(ArrayList<Integer> listaComprobanteId) {
//        ComprobanteDto comprobante = new ComprobanteDto();
//        comprobante.setMonto(1.0);
//        comprobante.setTransaccion("Lorem ipsum transaccion");
//        comprobante.setFechaEmision(new Date(System.currentTimeMillis()));
//        comprobante.setImpuesto(1.0);
//        comprobante.setFechaModificacion(new Date(System.currentTimeMillis()));
//        comprobante.setUsuarioModificacion(1);
//        Integer resultado = this.comprobanteDao.insertar(comprobante);
//        assertTrue(resultado != 0);
//        listaComprobanteId.add(resultado);
//        
//        comprobante.setComprobanteId(null);
//        comprobante.setMonto(1.0);
//        comprobante.setTransaccion("Lorem ipsum B transaccion");
//        comprobante.setFechaEmision(new Date(System.currentTimeMillis()));
//        comprobante.setImpuesto(1.0);
//        comprobante.setFechaModificacion(new Date(System.currentTimeMillis()));
//        comprobante.setUsuarioModificacion(1);
//        resultado = this.comprobanteDao.insertar(comprobante);
//        assertTrue(resultado != 0);
//        listaComprobanteId.add(resultado);
//        
//        comprobante.setComprobanteId(null);
//        comprobante.setMonto(1.0);
//        comprobante.setTransaccion("Lorem ipsum C transaccion");
//        comprobante.setFechaEmision(new Date(System.currentTimeMillis()));
//        comprobante.setImpuesto(1.0);
//        comprobante.setFechaModificacion(new Date(System.currentTimeMillis()));
//        comprobante.setUsuarioModificacion(1);
//        resultado = this.comprobanteDao.insertar(comprobante);
//        assertTrue(resultado != 0);
//        listaComprobanteId.add(resultado);        
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaComprobanteId = new ArrayList<>();
//        insertarComprobantes(listaComprobanteId);
//        ComprobanteDto comprobante = this.comprobanteDao.obtenerPorId(listaComprobanteId.get(0));
//        assertEquals(comprobante.getComprobanteId(), listaComprobanteId.get(0));
//        
//        comprobante = this.comprobanteDao.obtenerPorId(listaComprobanteId.get(1));
//        assertEquals(comprobante.getComprobanteId(), listaComprobanteId.get(1));
//        
//        comprobante = this.comprobanteDao.obtenerPorId(listaComprobanteId.get(2));
//        assertEquals(comprobante.getComprobanteId(), listaComprobanteId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaComprobanteId = new ArrayList<>();
//        insertarComprobantes(listaComprobanteId);
//        
//        ArrayList<ComprobanteDto> listaComprobantes = this.comprobanteDao.listarTodos();
//        assertEquals(listaComprobanteId.size(), listaComprobantes.size());
//        for (Integer i = 0; i < listaComprobanteId.size(); i++) {
//            assertEquals(listaComprobanteId.get(i), listaComprobantes.get(i).getComprobanteId());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaComprobanteId = new ArrayList<>();
//        insertarComprobantes(listaComprobanteId);
//        
//        ArrayList<ComprobanteDto> listaComprobantes = this.comprobanteDao.listarTodos();
//        assertEquals(listaComprobanteId.size(), listaComprobantes.size());
//        for (Integer i = 0; i < listaComprobanteId.size(); i++) {
//            // Cambios dummy no nulos
//            this.comprobanteDao.modificar(listaComprobantes.get(i));
//        }
//        
//        ArrayList<ComprobanteDto> listaComprobantesModificados = this.comprobanteDao.listarTodos();
//        assertEquals( listaComprobantes.size(), listaComprobantesModificados.size());
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaComprobanteId = new ArrayList<>();
//        insertarComprobantes(listaComprobanteId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<ComprobanteDto> listaComprobantes = this.comprobanteDao.listarTodos();
//        for (Integer i = 0; i < listaComprobantes.size(); i++) {
//            Integer resultado = this.comprobanteDao.eliminar(listaComprobantes.get(i));
//            assertNotEquals(0, resultado);
//            ComprobanteDto comprobante = this.comprobanteDao.obtenerPorId(listaComprobantes.get(i).getComprobanteId());
//            assertNull(comprobante);
//        }
//    }
}
