package pe.pucp.edu.squirlearn.business.persona;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.persona.RolPersonaDto;

public class RolPersonaBoTest {

    private RolPersonaBo rolPersonaBO;

    public RolPersonaBoTest() {
        this.rolPersonaBO = new RolPersonaBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<RolPersonaDto> lista = this.rolPersonaBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getNombre());
//            System.out.println(lista.get(i).getRolPersonaId());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        RolPersonaDto entidad = this.rolPersonaBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getRolPersonaId());
//            System.out.println(entidad.getNombre());
//        }
//    }
}
