package pe.edu.pucp.squirlearn.dao.persona;

import java.util.ArrayList;
import java.sql.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.persona.EstadoPersonaDaoImpl;
import pe.edu.pucp.squirlearn.model.persona.EstadoPersonaDto;

public class EstadoPersonaDaoTest {
    
    private EstadoPersonaDao estadoPersonaDao;    
    
    public EstadoPersonaDaoTest() {
        this.estadoPersonaDao = new EstadoPersonaDaoImpl();        
    }
    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        
//        EstadoPersonaDto estado = new EstadoPersonaDto();
//        estado.setNombre("Activo");
//        
//        Integer resultado = this.estadoPersonaDao.insertar(estado);
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        
//        // AJUSTA este ID a uno que exista en tu BD
//        EstadoPersonaDto estado = this.estadoPersonaDao.obtenerPorId(1);
//        
//        if (estado != null) {
//            System.out.println(estado.getEstadoPersonaId());
//            System.out.println(estado.getNombre());
//        }
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        
//        ArrayList<EstadoPersonaDto> listaEstados = this.estadoPersonaDao.listarTodos();
//        for (Integer i = 0; i < listaEstados.size(); i++) {
//            System.out.println("Dato: ");
//            System.out.println(listaEstados.get(i).getEstadoPersonaId());
//            System.out.println(listaEstados.get(i).getNombre());
//        }
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        
//        EstadoPersonaDto estado = new EstadoPersonaDto();
//        // AJUSTA este ID a uno que realmente exista
//        estado.setEstadoPersonaId(2);
//        estado.setNombre("Activo Modificado");
//        
//        Integer resultado = this.estadoPersonaDao.modificar(estado);
//        assertTrue(resultado != 0);
//    }
//    
  
}
