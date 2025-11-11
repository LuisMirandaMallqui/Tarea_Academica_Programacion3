package pe.edu.pucp.squirlearn.dao.alquiler;

import java.util.ArrayList;
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
//        ArrayList<Integer> listaAlquilerId = new ArrayList<>();
//        insertarAlquilers(listaAlquilerId);
//    }
//    
//    private void insertarAlquilers(ArrayList<Integer> listaAlquilerId) {
//        PersonaDto per = new PersonaDto();
//        per.setPersonaId(2);
//        ItemDto item = new ItemDto();
//        item.setItemId(1);
//        AlquilerDto alquiler = new AlquilerDto();
//        alquiler.setPersona(per);
//        alquiler.setItem(item);
//        alquiler.setFechaInicio(new java.sql.Date(System.currentTimeMillis()));
//        alquiler.setFechaFin(null);
//        alquiler.setDevuelto(Boolean.FALSE);
//        alquiler.setMonto(69.69);
//        alquiler.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
//        alquiler.setUsuarioCreacion("root");
//        Integer resultado = this.alquilerDAO.insertar(alquiler);
//        assertTrue(resultado != 0);
//        listaAlquilerId.add(resultado); 
//    }
    
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        AlquilerDto alquiler = this.alquilerDAO.obtenerPorId(11);
//        System.out.println(alquiler.getMonto());
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
//        alquiler.setFechaInicio(new java.sql.Date(System.currentTimeMillis()));
//        alquiler.setFechaFin(null);
//        alquiler.setDevuelto(Boolean.FALSE);
//        alquiler.setMonto(69.69);
//        alquiler.setFechaCreacion(new java.sql.Date(System.currentTimeMillis()));
//        alquiler.setUsuarioCreacion("root");
//        Integer resultado = this.alquilerDAO.modificar(alquiler);
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        AlquilerDto alquiler = new AlquilerDto();
//        alquiler.setAlquilerId(12);
//        alquilerDAO.eliminar(alquiler);
//    }
    
//    private void eliminarTodo(){                
//        ArrayList<AlquilerDto> listaAlquilers = this.alquilerDAO.listarTodos();
//        for (Integer i = 0; i < listaAlquilers.size(); i++) {
//            Integer resultado = this.alquilerDAO.eliminar(listaAlquilers.get(i));
//            assertNotEquals(0, resultado);
//            AlquilerDto alquiler = this.alquilerDAO.obtenerPorId(listaAlquilers.get(i).getAlquilerId());
//            assertNull(alquiler);
//        }
//    }
}
