package pe.edu.pucp.squirlearn.dao.alquiler;

import static java.time.Instant.now;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.alquiler.AlquilerDaoImpl;
import pe.edu.pucp.squirlearn.model.alquiler.AlquilerDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class AlquilerDaoTest {
    
    private AlquilerDao alquilerDAO;    
    
    public AlquilerDaoTest() {
        this.alquilerDAO = new AlquilerDaoImpl();        
    }
    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        PersonaDto per = new PersonaDto();
//        per.setPersonaId(2);
//        ItemDto item = new ItemDto();
//        item.setItemId(1);
//        AlquilerDto alquiler = new AlquilerDto();
//        alquiler.setPersona(per);
//        alquiler.setItem(item);
//        alquiler.setFechaInicio("2025-11-10");
//        alquiler.setFechaFin(null);
//        alquiler.setDevuelto(Boolean.FALSE);
//        alquiler.setMonto(69.69);
//        alquiler.setFechaCreacion("2025-11-10");
//        alquiler.setUsuarioCreacion("hola");
//        Integer resultado = this.alquilerDAO.insertar(alquiler);
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        AlquilerDto alquiler = this.alquilerDAO.obtenerPorId(11);
//        System.out.println(alquiler.getAlquilerId());
//        System.out.println(alquiler.getFechaCreacion());
//        System.out.println(alquiler.getFechaFin());
//        System.out.println(alquiler.getFechaInicio());
//        System.out.println(alquiler.getItem().getItemId());
//        System.out.println(alquiler.getMonto());
//        System.out.println(alquiler.getPersona().getPersonaId());
//        System.out.println(alquiler.getUsuarioCreacion());
//
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<AlquilerDto> listaAlquilers = this.alquilerDAO.listarTodos();
//        for (Integer i = 0; i < listaAlquilers.size(); i++) {
//            
//            System.out.println("Dato: ");
//            System.out.println(listaAlquilers.get(i).getAlquilerId());
//            System.out.println(listaAlquilers.get(i).getPersona().getPersonaId());
//            System.out.println(listaAlquilers.get(i).getItem().getItemId());
//        }
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        
//        PersonaDto per = new PersonaDto();
//        per.setPersonaId(2);
//        ItemDto item = new ItemDto();
//        item.setItemId(1);
//        AlquilerDto alquiler = new AlquilerDto();
//        alquiler.setAlquilerId(11);
//        alquiler.setPersona(per);
//        alquiler.setItem(item);
//        alquiler.setFechaInicio("2019-12-10");
//        alquiler.setFechaFin(null);
//        alquiler.setDevuelto(Boolean.TRUE);
//        alquiler.setMonto(69.0);
//        alquiler.setFechaCreacion(null);
//        alquiler.setUsuarioCreacion(null);
//        Integer resultado = this.alquilerDAO.modificar(alquiler);
//        assertTrue(resultado != 0);
//    }
    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        AlquilerDto alquiler = new AlquilerDto();
//        alquiler.setAlquilerId(13);
//        alquilerDAO.eliminar(alquiler);
//    }
//    
}
