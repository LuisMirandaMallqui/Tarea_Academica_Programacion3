package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.item.CondicionDto;

public class CondicionBoTest {

    private CondicionBo condicionBO;

    public CondicionBoTest() {
        this.condicionBO = new CondicionBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<CondicionDto> lista = this.condicionBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getCondicionId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        CondicionDto entidad = this.condicionBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getCondicionId());
//            System.out.println(entidad.getNombre());
//        }
//    }
}
