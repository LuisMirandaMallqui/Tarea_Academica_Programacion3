package pe.edu.pucp.squirlearn.dao.persona;

import java.util.ArrayList;
import java.sql.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.persona.EstadoPersonaDaoImpl;
import pe.edu.pucp.squirlearn.model.persona.EstadoPersonaDto;

public class EstadoPersonaDaoTest {
    
//    private EstadoPersonaDao estadoPersonaDao;    
//    
//    public EstadoPersonaDaoTest() {
//        this.estadoPersonaDao = new EstadoPersonaDaoImpl();        
//    }
//    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaEstadoPersonaId = new ArrayList<>();
//        insertarEstadoPersonas(listaEstadoPersonaId);
//        eliminarTodo();
//    }
//    
//    private void insertarEstadoPersonas(ArrayList<Integer> listaEstadoPersonaId) {
//        EstadoPersonaDto estadoPersona = new EstadoPersonaDto();
//        estadoPersona.setNombre("Lorem ipsum nombre");
//        estadoPersona.setFechaCreacion(new Date(System.currentTimeMillis()));
//        estadoPersona.setUsuarioCreacion(1);
//        estadoPersona.setFechaModificacion(new Date(System.currentTimeMillis()));
//        estadoPersona.setUsuarioModificacion(1);
//        Integer resultado = this.estadoPersonaDao.insertar(estadoPersona);
//        assertTrue(resultado != 0);
//        listaEstadoPersonaId.add(resultado);
//        
//        estadoPersona.setEstadoPersonaId(null);
//        estadoPersona.setNombre("Lorem ipsum B nombre");
//        estadoPersona.setFechaCreacion(new Date(System.currentTimeMillis()));
//        estadoPersona.setUsuarioCreacion(1);
//        estadoPersona.setFechaModificacion(new Date(System.currentTimeMillis()));
//        estadoPersona.setUsuarioModificacion(1);
//        resultado = this.estadoPersonaDao.insertar(estadoPersona);
//        assertTrue(resultado != 0);
//        listaEstadoPersonaId.add(resultado);
//        
//        estadoPersona.setEstadoPersonaId(null);
//        estadoPersona.setNombre("Lorem ipsum C nombre");
//        estadoPersona.setFechaCreacion(new Date(System.currentTimeMillis()));
//        estadoPersona.setUsuarioCreacion(1);
//        estadoPersona.setFechaModificacion(new Date(System.currentTimeMillis()));
//        estadoPersona.setUsuarioModificacion(1);
//        resultado = this.estadoPersonaDao.insertar(estadoPersona);
//        assertTrue(resultado != 0);
//        listaEstadoPersonaId.add(resultado);        
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaEstadoPersonaId = new ArrayList<>();
//        insertarEstadoPersonas(listaEstadoPersonaId);
//        EstadoPersonaDto estadoPersona = this.estadoPersonaDao.obtenerPorId(listaEstadoPersonaId.get(0));
//        assertEquals(estadoPersona.getEstadoPersonaId(), listaEstadoPersonaId.get(0));
//        
//        estadoPersona = this.estadoPersonaDao.obtenerPorId(listaEstadoPersonaId.get(1));
//        assertEquals(estadoPersona.getEstadoPersonaId(), listaEstadoPersonaId.get(1));
//        
//        estadoPersona = this.estadoPersonaDao.obtenerPorId(listaEstadoPersonaId.get(2));
//        assertEquals(estadoPersona.getEstadoPersonaId(), listaEstadoPersonaId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaEstadoPersonaId = new ArrayList<>();
//        insertarEstadoPersonas(listaEstadoPersonaId);
//        
//        ArrayList<EstadoPersonaDto> listaEstadoPersonas = this.estadoPersonaDao.listarTodos();
//        assertEquals(listaEstadoPersonaId.size(), listaEstadoPersonas.size());
//        for (Integer i = 0; i < listaEstadoPersonaId.size(); i++) {
//            assertEquals(listaEstadoPersonaId.get(i), listaEstadoPersonas.get(i).getEstadoPersonaId());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaEstadoPersonaId = new ArrayList<>();
//        insertarEstadoPersonas(listaEstadoPersonaId);
//        
//        ArrayList<EstadoPersonaDto> listaEstadoPersonas = this.estadoPersonaDao.listarTodos();
//        assertEquals(listaEstadoPersonaId.size(), listaEstadoPersonas.size());
//        for (Integer i = 0; i < listaEstadoPersonaId.size(); i++) {
//            // Cambios dummy no nulos
//            this.estadoPersonaDao.modificar(listaEstadoPersonas.get(i));
//        }
//        
//        ArrayList<EstadoPersonaDto> listaEstadoPersonasModificados = this.estadoPersonaDao.listarTodos();
//        assertEquals( listaEstadoPersonas.size(), listaEstadoPersonasModificados.size());
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaEstadoPersonaId = new ArrayList<>();
//        insertarEstadoPersonas(listaEstadoPersonaId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<EstadoPersonaDto> listaEstadoPersonas = this.estadoPersonaDao.listarTodos();
//        for (Integer i = 0; i < listaEstadoPersonas.size(); i++) {
//            Integer resultado = this.estadoPersonaDao.eliminar(listaEstadoPersonas.get(i));
//            assertNotEquals(0, resultado);
//            EstadoPersonaDto estadoPersona = this.estadoPersonaDao.obtenerPorId(listaEstadoPersonas.get(i).getEstadoPersonaId());
//            assertNull(estadoPersona);
//        }
//    }
}
