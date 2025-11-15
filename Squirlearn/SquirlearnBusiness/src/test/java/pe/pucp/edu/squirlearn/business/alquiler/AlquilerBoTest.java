package pe.pucp.edu.squirlearn.business.alquiler;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.alquiler.AlquilerDto;

/**
 *
 * @author adria
 */
public class AlquilerBoTest {
    
    private AlquilerBo alquilerBO;
    
    public AlquilerBoTest() {
        this.alquilerBO = new AlquilerBo();  
    }

    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Integer resultado = this.alquilerBO.insertar(2,1,"2025-12-01 12:34:56",null,
                69.69,"DANIEL","2025-12-01 12:34:56");
        
        assertTrue(resultado != 0);
    }
    @Test
    public void testModificar() {
        System.out.println("modificar");
        Integer resultado = this.alquilerBO.Modificar(11,2,1,"2025-12-01 12:34:56","2025-12-31 12:34:56",
                69.69,true);
        
        assertTrue(resultado != 0);
    }
    @Test
    public void testBuscarPorId() {
        System.out.println("buscarPorId");
        AlquilerDto alquiler = this.alquilerBO.obtenerPorId(11);
        System.out.println(alquiler.getAlquilerId());
        System.out.println(alquiler.getFechaCreacion());
        System.out.println(alquiler.getFechaFin());
        System.out.println(alquiler.getFechaInicio());
        System.out.println(alquiler.getItem().getItemId());
        System.out.println(alquiler.getMonto());
        System.out.println(alquiler.getPersona().getPersonaId());
        System.out.println(alquiler.getUsuarioCreacion());
    }
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<AlquilerDto> listaAlquilers = this.alquilerBO.listarTodos();
        for (Integer i = 0; i < listaAlquilers.size(); i++) {
            
            System.out.print("Dato: ");
            System.out.println(i);
            System.out.println(listaAlquilers.get(i).getAlquilerId());
            System.out.println(listaAlquilers.get(i).getPersona().getPersonaId());
            System.out.println(listaAlquilers.get(i).getItem().getItemId());
        }
    }
    
    
}
