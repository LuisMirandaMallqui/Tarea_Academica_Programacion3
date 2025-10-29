package pe.edu.pucp.squirlearn.dao.persona;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.persona.RolPersonaDaoImpl;
import pe.edu.pucp.squirlearn.model.persona.RolPersonaDto;

public class RolPersonaDaoTest {
    
    private RolPersonaDao rolPersonaDao;    
    
//    public RolPersonaDaoTest() {
//        this.rolPersonaDao = new RolPersonaDaoImpl();        
//    }
//    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ArrayList<Integer> listaRolPersonaId = new ArrayList<>();
//        insertarRolPersonas(listaRolPersonaId);
//        eliminarTodo();
//    }
//    
//    private void insertarRolPersonas(ArrayList<Integer> listaRolPersonaId) {
//        RolPersonaDto rolPersona = new RolPersonaDto();
//        rolPersona.setNombre("Lorem ipsum nombre");
//        rolPersona.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
//        rolPersona.setUsuarioCreacion(1);
//        rolPersona.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
//        rolPersona.setUsuarioModificacion(1);
//        Integer resultado = this.rolPersonaDao.insertar(rolPersona);
//        assertTrue(resultado != 0);
//        listaRolPersonaId.add(resultado);
//        
//        rolPersona.setRolPersonaId(null);
//        rolPersona.setNombre("Lorem ipsum B nombre");
//        rolPersona.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
//        rolPersona.setUsuarioCreacion(1);
//        rolPersona.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
//        rolPersona.setUsuarioModificacion(1);
//        resultado = this.rolPersonaDao.insertar(rolPersona);
//        assertTrue(resultado != 0);
//        listaRolPersonaId.add(resultado);
//        
//        rolPersona.setRolPersonaId(null);
//        rolPersona.setNombre("Lorem ipsum C nombre");
//        rolPersona.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
//        rolPersona.setUsuarioCreacion(1);
//        rolPersona.setFechaModificacion(new java.sql.Date(System.currentTimeMillis()));
//        rolPersona.setUsuarioModificacion(1);
//        resultado = this.rolPersonaDao.insertar(rolPersona);
//        assertTrue(resultado != 0);
//        listaRolPersonaId.add(resultado);        
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaRolPersonaId = new ArrayList<>();
//        insertarRolPersonas(listaRolPersonaId);
//        RolPersonaDto rolPersona = this.rolPersonaDao.obtenerPorId(listaRolPersonaId.get(0));
//        assertEquals(rolPersona.getRolPersonaId(), listaRolPersonaId.get(0));
//        
//        rolPersona = this.rolPersonaDao.obtenerPorId(listaRolPersonaId.get(1));
//        assertEquals(rolPersona.getRolPersonaId(), listaRolPersonaId.get(1));
//        
//        rolPersona = this.rolPersonaDao.obtenerPorId(listaRolPersonaId.get(2));
//        assertEquals(rolPersona.getRolPersonaId(), listaRolPersonaId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaRolPersonaId = new ArrayList<>();
//        insertarRolPersonas(listaRolPersonaId);
//        
//        ArrayList<RolPersonaDto> listaRolPersonas = this.rolPersonaDao.listarTodos();
//        assertEquals(listaRolPersonaId.size(), listaRolPersonas.size());
//        for (Integer i = 0; i < listaRolPersonaId.size(); i++) {
//            assertEquals(listaRolPersonaId.get(i), listaRolPersonas.get(i).getRolPersonaId());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ArrayList<Integer> listaRolPersonaId = new ArrayList<>();
//        insertarRolPersonas(listaRolPersonaId);
//        
//        ArrayList<RolPersonaDto> listaRolPersonas = this.rolPersonaDao.listarTodos();
//        assertEquals(listaRolPersonaId.size(), listaRolPersonas.size());
//        for (Integer i = 0; i < listaRolPersonaId.size(); i++) {
//            // Cambios dummy no nulos
//            this.rolPersonaDao.modificar(listaRolPersonas.get(i));
//        }
//        
//        ArrayList<RolPersonaDto> listaRolPersonasModificados = this.rolPersonaDao.listarTodos();
//        assertEquals( listaRolPersonas.size(), listaRolPersonasModificados.size());
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaRolPersonaId = new ArrayList<>();
//        insertarRolPersonas(listaRolPersonaId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo(){                
//        ArrayList<RolPersonaDto> listaRolPersonas = this.rolPersonaDao.listarTodos();
//        for (Integer i = 0; i < listaRolPersonas.size(); i++) {
//            Integer resultado = this.rolPersonaDao.eliminar(listaRolPersonas.get(i));
//            assertNotEquals(0, resultado);
//            RolPersonaDto rolPersona = this.rolPersonaDao.obtenerPorId(listaRolPersonas.get(i).getRolPersonaId());
//            assertNull(rolPersona);
//        }
//    }
}
