package pe.edu.pucp.squirlearn.dao.comprobante;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.comprobante.DetalleComprobanteDaoImpl;
import pe.edu.pucp.squirlearn.model.alquiler.AlquilerDto;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto;
import pe.edu.pucp.squirlearn.model.comprobante.DetalleComprobanteDto;
import pe.edu.pucp.squirlearn.model.item.ItemDto;

public class DetalleComprobanteDaoTest {

    private DetalleComprobanteDao detalleComprobanteDAO;

    public DetalleComprobanteDaoTest() {
        this.detalleComprobanteDAO = new DetalleComprobanteDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        ComprobanteDto comprobante = new ComprobanteDto();
//        comprobante.setComprobanteId(1);
//        ItemDto item = new ItemDto();
//        item.setItemId(1);
//        AlquilerDto alquiler = new AlquilerDto();
//        alquiler.setAlquilerId(1);
//
//        DetalleComprobanteDto d = new DetalleComprobanteDto();
//        d.setComprobante(comprobante);
//        d.setItem(item);
//        d.setAlquiler(alquiler);
//        d.setDescripcion("EQUIZDE");
//        d.setusuarioCreacion("jeje");
//        d.setPrecio(69.0);
//
//        Integer resultado = this.detalleComprobanteDAO.insertar(d);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        DetalleComprobanteDto d = this.detalleComprobanteDAO.obtenerPorId(1);
//        if (d != null) {
//            System.out.println(d.getDetalleComId());
//            System.out.println(d.getComprobante().getComprobanteId());
//            System.out.println(d.getPrecio());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<DetalleComprobanteDto> lista = this.detalleComprobanteDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            DetalleComprobanteDto d = lista.get(i);
//            System.out.println("Dato:");
//            System.out.println(d.getDetalleComId());
//            System.out.println(d.getComprobante().getComprobanteId());
//            System.out.println(d.getPrecio());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        ComprobanteDto comprobante = new ComprobanteDto();
//        comprobante.setComprobanteId(1);
//        ItemDto item = new ItemDto();
//        item.setItemId(1);
//        AlquilerDto alquiler = new AlquilerDto();
//        alquiler.setAlquilerId(1);
//
//        DetalleComprobanteDto d = new DetalleComprobanteDto();
//        d.setComprobante(comprobante);
//        d.setItem(item);
//        d.setAlquiler(alquiler);
//        d.setDescripcion("EQUIZDE");
//        d.setPrecio(69.0);
//        d.setDetalleComId(1);
//        Integer resultado = this.detalleComprobanteDAO.modificar(d);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        DetalleComprobanteDto d = new DetalleComprobanteDto();
//        d.setDetalleComId(10);
//        this.detalleComprobanteDAO.eliminar(d);
//    }
}
