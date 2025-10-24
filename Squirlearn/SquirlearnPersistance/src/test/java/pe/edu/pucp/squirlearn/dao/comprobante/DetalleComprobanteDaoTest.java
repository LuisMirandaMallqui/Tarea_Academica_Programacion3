package pe.edu.pucp.squirlearn.dao.comprobante;

import java.util.ArrayList;
import java.sql.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.comprobante.DetalleComprobanteDaoImpl;
import pe.edu.pucp.squirlearn.model.comprobante.DetalleComprobanteDto;

public class DetalleComprobanteDaoTest {
    
    private DetalleComprobanteDao detalleComprobanteDao;    
    
    public DetalleComprobanteDaoTest() {
        this.detalleComprobanteDao = new DetalleComprobanteDaoImpl();        
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaDetalleComprobanteId = new ArrayList<>();
        insertarDetalleComprobantes(listaDetalleComprobanteId);
        eliminarTodo();
    }
    
    private void insertarDetalleComprobantes(ArrayList<Integer> listaDetalleComprobanteId) {
        DetalleComprobanteDto detalleComprobante = new DetalleComprobanteDto();
        detalleComprobante.setDescripcion("Lorem ipsum descripcion");
        detalleComprobante.setPrecio(1.0);
        detalleComprobante.setFechaModificacion(new Date(System.currentTimeMillis()));
        detalleComprobante.setUsuarioModificacion(1);
        Integer resultado = this.detalleComprobanteDao.insertar(detalleComprobante);
        assertTrue(resultado != 0);
        listaDetalleComprobanteId.add(resultado);
        
        detalleComprobante.setDetalleComId(null);
        detalleComprobante.setDescripcion("Lorem ipsum B descripcion");
        detalleComprobante.setPrecio(1.0);
        detalleComprobante.setFechaModificacion(new Date(System.currentTimeMillis()));
        detalleComprobante.setUsuarioModificacion(1);
        resultado = this.detalleComprobanteDao.insertar(detalleComprobante);
        assertTrue(resultado != 0);
        listaDetalleComprobanteId.add(resultado);
        
        detalleComprobante.setDetalleComId(null);
        detalleComprobante.setDescripcion("Lorem ipsum C descripcion");
        detalleComprobante.setPrecio(1.0);
        detalleComprobante.setFechaModificacion(new Date(System.currentTimeMillis()));
        detalleComprobante.setUsuarioModificacion(1);
        resultado = this.detalleComprobanteDao.insertar(detalleComprobante);
        assertTrue(resultado != 0);
        listaDetalleComprobanteId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaDetalleComprobanteId = new ArrayList<>();
        insertarDetalleComprobantes(listaDetalleComprobanteId);
        DetalleComprobanteDto detalleComprobante = this.detalleComprobanteDao.obtenerPorId(listaDetalleComprobanteId.get(0));
        assertEquals(detalleComprobante.getDetalleComId(), listaDetalleComprobanteId.get(0));
        
        detalleComprobante = this.detalleComprobanteDao.obtenerPorId(listaDetalleComprobanteId.get(1));
        assertEquals(detalleComprobante.getDetalleComId(), listaDetalleComprobanteId.get(1));
        
        detalleComprobante = this.detalleComprobanteDao.obtenerPorId(listaDetalleComprobanteId.get(2));
        assertEquals(detalleComprobante.getDetalleComId(), listaDetalleComprobanteId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaDetalleComprobanteId = new ArrayList<>();
        insertarDetalleComprobantes(listaDetalleComprobanteId);
        
        ArrayList<DetalleComprobanteDto> listaDetalleComprobantes = this.detalleComprobanteDao.listarTodos();
        assertEquals(listaDetalleComprobanteId.size(), listaDetalleComprobantes.size());
        for (Integer i = 0; i < listaDetalleComprobanteId.size(); i++) {
            assertEquals(listaDetalleComprobanteId.get(i), listaDetalleComprobantes.get(i).getDetalleComId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaDetalleComprobanteId = new ArrayList<>();
        insertarDetalleComprobantes(listaDetalleComprobanteId);
        
        ArrayList<DetalleComprobanteDto> listaDetalleComprobantes = this.detalleComprobanteDao.listarTodos();
        assertEquals(listaDetalleComprobanteId.size(), listaDetalleComprobantes.size());
        for (Integer i = 0; i < listaDetalleComprobanteId.size(); i++) {
            // Cambios dummy no nulos
            this.detalleComprobanteDao.modificar(listaDetalleComprobantes.get(i));
        }
        
        ArrayList<DetalleComprobanteDto> listaDetalleComprobantesModificados = this.detalleComprobanteDao.listarTodos();
        assertEquals( listaDetalleComprobantes.size(), listaDetalleComprobantesModificados.size());
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaDetalleComprobanteId = new ArrayList<>();
        insertarDetalleComprobantes(listaDetalleComprobanteId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<DetalleComprobanteDto> listaDetalleComprobantes = this.detalleComprobanteDao.listarTodos();
        for (Integer i = 0; i < listaDetalleComprobantes.size(); i++) {
            Integer resultado = this.detalleComprobanteDao.eliminar(listaDetalleComprobantes.get(i));
            assertNotEquals(0, resultado);
            DetalleComprobanteDto detalleComprobante = this.detalleComprobanteDao.obtenerPorId(listaDetalleComprobantes.get(i).getDetalleComId());
            assertNull(detalleComprobante);
        }
    }
}
