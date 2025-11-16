package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.item.EstadoItemDto;

public class EstadoItemBoTest {

    private EstadoItemBo estadoItemBO;

    public EstadoItemBoTest() {
        this.estadoItemBO = new EstadoItemBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<EstadoItemDto> lista = this.estadoItemBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getEstadoItemId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        EstadoItemDto entidad = this.estadoItemBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getEstadoItemId());
//            System.out.println(entidad.getNombre());
//        }
//    }
}
