package pe.pucp.edu.squirlearn.business.persona;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.persona.EstadoPersonaDto;

public class EstadoPersonaBoTest {

    private EstadoPersonaBo estadoPersonaBO;

    public EstadoPersonaBoTest() {
        this.estadoPersonaBO = new EstadoPersonaBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<EstadoPersonaDto> lista = this.estadoPersonaBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getEstadoPersonaId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        EstadoPersonaDto entidad = this.estadoPersonaBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getEstadoPersonaId());
//            System.out.println(entidad.getNombre());
//        }
//    }
}
