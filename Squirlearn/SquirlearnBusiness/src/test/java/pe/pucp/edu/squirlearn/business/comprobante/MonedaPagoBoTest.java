package pe.pucp.edu.squirlearn.business.comprobante;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.comprobante.MonedaPagoDto;

public class MonedaPagoBoTest {

    private MonedaPagoBo monedaPagoBO;

    public MonedaPagoBoTest() {
        this.monedaPagoBO = new MonedaPagoBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<MonedaPagoDto> lista = this.monedaPagoBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getMonedaId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        MonedaPagoDto entidad = this.monedaPagoBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getMonedaId());
//            System.out.println(entidad.getNombre());
//        }
//    }
}
