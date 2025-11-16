package pe.pucp.edu.squirlearn.business.comprobante;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.pucp.edu.squirlearn.business.comprobante.ComprobanteBo;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto;

public class ComprobanteBoTest {
    
    private ComprobanteBo comprobanteBO;
    
    public ComprobanteBoTest() {
        this.comprobanteBO = new ComprobanteBo();
    }
    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        Integer resultado = this.comprobanteBO.insertar(
//                150.0,                 // monto
//                "TX-BO-001",           // transaccionId
//                1,                     // personaId
//                1,                     // formaPagoId
//                1,                     // monedaId
//                27.0,                  // impuesto
//                "2025-12-01 12:34:56", // fechaEmision
//                "DANIEL"               // usuarioCreacion
//        );
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        Integer resultado = this.comprobanteBO.modificar(
//                2,
//                200.0,                 // monto
//                "TX-BO-001",           // transaccionId (debe existir)
//                1,                     // personaId
//                1,                     // formaPagoId
//                1,                     // monedaId
//                36.0,                  // impuesto
//                "2025-12-31 12:34:56", // fechaEmision
//                "DANIEL"               // usuarioCreacion
//        );
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        ComprobanteDto c = this.comprobanteBO.obtenerPorId(11); // AJUSTA ID
//        if (c != null) {
//            System.out.println(c.getComprobanteId());
//            System.out.println(c.getTransaccion());
//            System.out.println(c.getFechaEmision());
//            System.out.println(c.getMonto());
//            if (c.getPersona() != null) {
//                System.out.println(c.getPersona().getPersonaId());
//            }
//        }
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos (listarPorDueno)");
//        ArrayList<ComprobanteDto> lista = this.comprobanteBO.listarPorDueno(1); // personaId de prueba
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.print("Dato: ");
//            System.out.println(i);
//            System.out.println(lista.get(i).getComprobanteId());
//            System.out.println(lista.get(i).getTransaccion());
//            System.out.println(lista.get(i).getMonto());
//        }
//    }
}
