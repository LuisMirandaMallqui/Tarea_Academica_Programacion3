package pe.edu.pucp.squirlearn.dao.inciNoti;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.inciNoti.MotivoDaoImpl;
import pe.edu.pucp.squirlearn.model.inciNoti.MotivoDto;

public class MotivoDaoTest {
    
    private MotivoDao motivoDao;    
    
    public MotivoDaoTest() {
        this.motivoDao = new MotivoDaoImpl();        
    }
    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaMotivoId = new ArrayList<>();
//        insertarMotivos(listaMotivoId);
//        eliminarTodo();
//    }
//    
//    private void insertarMotivos(ArrayList<Integer> listaMotivoId) {
//        MotivoDto motivo = new MotivoDto();
//        motivo.setNombre("Lorem ipsum nombre");
//        motivo.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
//        motivo.setUsuarioCreacion(1);
//        motivo.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
//        motivo.setUsuarioModificacion(1);
//        Integer resultado = this.motivoDao.insertar(motivo);
//        assertTrue(resultado != 0);
//        listaMotivoId.add(resultado);
//        
//        motivo.setMotivoId(null);
//        motivo.setNombre("Lorem ipsum B nombre");
//        motivo.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
//        motivo.setUsuarioCreacion(1);
//        motivo.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
//        motivo.setUsuarioModificacion(1);
//        resultado = this.motivoDao.insertar(motivo);
//        assertTrue(resultado != 0);
//        listaMotivoId.add(resultado);
//        
//        motivo.setMotivoId(null);
//        motivo.setNombre("Lorem ipsum C nombre");
//        motivo.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
//        motivo.setUsuarioCreacion(1);
//        motivo.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
//        motivo.setUsuarioModificacion(1);
//        resultado = this.motivoDao.insertar(motivo);
//        assertTrue(resultado != 0);
//        listaMotivoId.add(resultado);        
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaMotivoId = new ArrayList<>();
//        insertarMotivos(listaMotivoId);
//        MotivoDto motivo = this.motivoDao.obtenerPorId(listaMotivoId.get(0));
//        assertEquals(motivo.getMotivoId(), listaMotivoId.get(0));
//        
//        motivo = this.motivoDao.obtenerPorId(listaMotivoId.get(1));
//        assertEquals(motivo.getMotivoId(), listaMotivoId.get(1));
//        
//        motivo = this.motivoDao.obtenerPorId(listaMotivoId.get(2));
//        assertEquals(motivo.getMotivoId(), listaMotivoId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaMotivoId = new ArrayList<>();
//        insertarMotivos(listaMotivoId);
//        
//        ArrayList<MotivoDto> listaMotivos = this.motivoDao.listarTodos();
//        assertEquals(listaMotivoId.size(), listaMotivos.size());
//        for (Integer i = 0; i < listaMotivoId.size(); i++) {
//            assertEquals(listaMotivoId.get(i), listaMotivos.get(i).getMotivoId());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaMotivoId = new ArrayList<>();
//        insertarMotivos(listaMotivoId);
//        
//        ArrayList<MotivoDto> listaMotivos = this.motivoDao.listarTodos();
//        assertEquals(listaMotivoId.size(), listaMotivos.size());
//        for (Integer i = 0; i < listaMotivoId.size(); i++) {
//            // Cambios dummy no nulos
//            this.motivoDao.modificar(listaMotivos.get(i));
//        }
//        
//        ArrayList<MotivoDto> listaMotivosModificados = this.motivoDao.listarTodos();
//        assertEquals( listaMotivos.size(), listaMotivosModificados.size());
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaMotivoId = new ArrayList<>();
//        insertarMotivos(listaMotivoId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<MotivoDto> listaMotivos = this.motivoDao.listarTodos();
//        for (Integer i = 0; i < listaMotivos.size(); i++) {
//            Integer resultado = this.motivoDao.eliminar(listaMotivos.get(i));
//            assertNotEquals(0, resultado);
//            MotivoDto motivo = this.motivoDao.obtenerPorId(listaMotivos.get(i).getMotivoId());
//            assertNull(motivo);
//        }
//    }
}
