package pe.pucp.edu.squirlearn.business.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.item.FormatoDto;

public class FormatoBoTest {

    private FormatoBo formatoBO;

    public FormatoBoTest() {
        this.formatoBO = new FormatoBo();
    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<FormatoDto> lista = this.formatoBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getFormatoId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        FormatoDto entidad = this.formatoBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getFormatoId());
//            System.out.println(entidad.getNombre());
//        }
//    }
}
