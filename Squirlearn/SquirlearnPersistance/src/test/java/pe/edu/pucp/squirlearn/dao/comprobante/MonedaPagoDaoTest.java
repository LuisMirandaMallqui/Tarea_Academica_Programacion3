package pe.edu.pucp.squirlearn.dao.comprobante;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.comprobante.MonedaPagoDaoImpl;
import pe.edu.pucp.squirlearn.model.comprobante.MonedaPagoDto;

public class MonedaPagoDaoTest {

    private MonedaPagoDao monedaPagoDAO;

    public MonedaPagoDaoTest() {
        this.monedaPagoDAO = new MonedaPagoDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        MonedaPagoDto m = new MonedaPagoDto();
//        m.setNombre("Soles");
//        Integer resultado = this.monedaPagoDAO.insertar(m);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        MonedaPagoDto m = this.monedaPagoDAO.obtenerPorId(1);
//        if (m != null) {
//            System.out.println(m.getMonedaId());
//            System.out.println(m.getNombre());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<MonedaPagoDto> lista = this.monedaPagoDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            MonedaPagoDto m = lista.get(i);
//            System.out.println("Dato:");
//            System.out.println(m.getMonedaId());
//            System.out.println(m.getNombre());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        MonedaPagoDto m = new MonedaPagoDto();
//        m.setMonedaId(1);
//        m.setNombre("Soles Modificados");
//        Integer resultado = this.monedaPagoDAO.modificar(m);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        MonedaPagoDto m = new MonedaPagoDto();
//        m.setMonedaId(2);
//        this.monedaPagoDAO.eliminar(m);
//    }
}
