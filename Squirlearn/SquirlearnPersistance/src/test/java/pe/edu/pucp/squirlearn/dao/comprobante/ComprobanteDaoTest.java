package pe.edu.pucp.squirlearn.dao.comprobante;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.comprobante.ComprobanteDaoImpl;
import pe.edu.pucp.squirlearn.model.comprobante.ComprobanteDto;
import pe.edu.pucp.squirlearn.model.comprobante.FormaPagoDto;
import pe.edu.pucp.squirlearn.model.comprobante.MonedaPagoDto;
import pe.edu.pucp.squirlearn.model.persona.PersonaDto;

public class ComprobanteDaoTest {

    private ComprobanteDao comprobanteDAO;

    public ComprobanteDaoTest() {
        this.comprobanteDAO = new ComprobanteDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        PersonaDto persona = new PersonaDto();
//        persona.setPersonaId(1);
//        FormaPagoDto forma = new FormaPagoDto();
//        forma.setFormaPagoId(1);
//        MonedaPagoDto moneda = new MonedaPagoDto();
//        moneda.setMonedaId(1);
//
//        ComprobanteDto c = new ComprobanteDto();
//        c.setPersona(persona);
//        c.setFormaPago(forma);
//        c.setMoneda(moneda);
//        c.setTransaccion("TX-TEST-001");
//        c.setFechaEmision("2025-02-12");
//        c.setMonto(100.0);
//        c.setImpuesto(18.0);
//        c.setusuarioCreacion("testUser");
//
//        Integer resultado = this.comprobanteDAO.insertar(c);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        ComprobanteDto c = this.comprobanteDAO.obtenerPorId(1);
//        if (c != null) {
//            System.out.println(c.getComprobanteId());
//            System.out.println(c.getTransaccion());
//            System.out.println(c.getFechaEmision());
//            System.out.println(c.getMonto());
//            for (int i = 0;i<c.getDetallesComprobante().size(); i++) {
//                System.err.println(c.getDetallesComprobante().get(i).getDetalleComId());
//                System.err.println(c.getDetallesComprobante().get(i).getDescripcion());
//            }
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<ComprobanteDto> lista = this.comprobanteDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getComprobanteId());
//            System.out.println(lista.get(i).getTransaccion());
//            for (int j = 0;j<lista.get(i).getDetallesComprobante().size(); j++) {
//                System.err.println(lista.get(i).getDetallesComprobante().get(j).getDetalleComId());
//                System.err.println(lista.get(i).getDetallesComprobante().get(j).getDescripcion());
//            }
//        }
//    }

//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        PersonaDto persona = new PersonaDto();
//        persona.setPersonaId(1);
//        FormaPagoDto forma = new FormaPagoDto();
//        forma.setFormaPagoId(1);
//        MonedaPagoDto moneda = new MonedaPagoDto();
//        moneda.setMonedaId(1);
//        ComprobanteDto c = new ComprobanteDto();
//        c.setComprobanteId(10);
//        c.setPersona(persona);
//        c.setFormaPago(forma);
//        c.setMoneda(moneda);
//        c.setTransaccion("TX-TEST-MOD");
//        c.setFechaEmision("2025-02-12");
//        c.setMonto(200.0);
//        c.setImpuesto(36.0);
//        Integer resultado = this.comprobanteDAO.modificar(c);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        ComprobanteDto c = new ComprobanteDto();
//        c.setComprobanteId(11);
//        this.comprobanteDAO.eliminar(c);
//    }
}
