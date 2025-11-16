package pe.pucp.edu.squirlearn.business.comprobante;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.comprobante.FormaPagoDto;

public class FormaPagoBoTest {

    private FormaPagoBo formaPagoBO;

    public FormaPagoBoTest() {
        this.formaPagoBO = new FormaPagoBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<FormaPagoDto> lista = this.formaPagoBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getFormaPagoId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        FormaPagoDto entidad = this.formaPagoBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getFormaPagoId());
//            System.out.println(entidad.getNombre());
//        }
//    }
}
