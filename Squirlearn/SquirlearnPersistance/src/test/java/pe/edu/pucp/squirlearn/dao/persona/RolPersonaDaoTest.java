package pe.edu.pucp.squirlearn.dao.persona;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.persona.RolPersonaDaoImpl;
import pe.edu.pucp.squirlearn.model.persona.RolPersonaDto;

public class RolPersonaDaoTest {
    
    private RolPersonaDao rolPersonaDao;    
    
    public RolPersonaDaoTest() {
        this.rolPersonaDao = new RolPersonaDaoImpl();        
    }
    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        
//        RolPersonaDto rol = new RolPersonaDto();
//        rol.setNombre("Alumno");
//        Integer resultado = this.rolPersonaDao.insertar(rol);
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        
//        // AJUSTA este ID a uno que exista en tu BD
//        RolPersonaDto rol = this.rolPersonaDao.obtenerPorId(1);
//        
//        if (rol != null) {
//            System.out.println(rol.getRolPersonaId());
//            System.out.println(rol.getNombre());
//        }
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        
//        ArrayList<RolPersonaDto> listaRoles = this.rolPersonaDao.listarTodos();
//        for (Integer i = 0; i < listaRoles.size(); i++) {
//            System.out.println("Dato: ");
//            System.out.println(listaRoles.get(i).getRolPersonaId());
//            System.out.println(listaRoles.get(i).getNombre());
//        }
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        
//        RolPersonaDto rol = new RolPersonaDto();
//        // AJUSTA este ID a uno que realmente exista
//        rol.setRolPersonaId(1);
//        rol.setNombre("Alumno Modificado");
//        
//        Integer resultado = this.rolPersonaDao.modificar(rol);
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        
//        RolPersonaDto rol = new RolPersonaDto();
//        // AJUSTA este ID al que quieras borrar
//        rol.setRolPersonaId(5);
//        this.rolPersonaDao.eliminar(rol);
//    }
}


