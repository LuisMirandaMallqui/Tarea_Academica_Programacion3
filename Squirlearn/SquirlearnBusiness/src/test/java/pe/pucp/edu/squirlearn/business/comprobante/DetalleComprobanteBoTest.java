package pe.pucp.edu.squirlearn.business.comprobante;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.comprobante.DetalleComprobanteDto;

public class DetalleComprobanteBoTest {

    private DetalleComprobanteBo detalleComprobanteBO;

    public DetalleComprobanteBoTest() {
        this.detalleComprobanteBO = new DetalleComprobanteBo();
    }

//    @Test
//    public void testListarPorComprobante() {
//        System.out.println("listarPorComprobante");
//        // AJUSTA el ID de comprobante según tu BD
//        ArrayList<DetalleComprobanteDto> lista = this.detalleComprobanteBO.listarPorComprobante(1);
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getDetalleComId());
//            System.out.println(lista.get(i).getComprobante().getComprobanteId());
//            System.out.println(lista.get(i).getAlquiler().getAlquilerId());
//            System.out.println(lista.get(i).getDescripcion());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        DetalleComprobanteDto entidad = this.detalleComprobanteBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getDetalleComId());
//            System.out.println(entidad.getComprobante().getComprobanteId());
//            System.out.println(entidad.getAlquiler().getAlquilerId());
//            System.out.println(entidad.getDescripcion());
//        }
//    }
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        // Mismos datos de prueba que en DetalleComprobanteDaoTest
//        Integer resultado = this.detalleComprobanteBO.insertar(
//                "EQUIZDE",   // descripcion
//                69.0,        // precio
//                1,           // itemId (AJUSTAR según tu BD)
//                1,           // alquilerId (AJUSTAR)
//                1,           // comprobanteId (AJUSTAR)
//                "jeje"       // usuarioCreacion
//        );
//        assertTrue(resultado != 0);
//    }
}
