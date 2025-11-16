package pe.edu.pucp.squirlearn.dao.comprobante;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.comprobante.FormaPagoDaoImpl;
import pe.edu.pucp.squirlearn.model.comprobante.FormaPagoDto;

public class FormaPagoDaoTest {

    private FormaPagoDao formaPagoDAO;

//    public FormaPagoDaoTest() {
//        this.formaPagoDAO = new FormaPagoDaoImpl();
//    }
//
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        FormaPagoDto f = new FormaPagoDto();
//        f.setNombre("JEJEJEJE");
//        Integer resultado = this.formaPagoDAO.insertar(f);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        FormaPagoDto f = this.formaPagoDAO.obtenerPorId(1);
//        if (f != null) {
//            System.out.println(f.getFormaPagoId());
//            System.out.println(f.getNombre());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<FormaPagoDto> lista = this.formaPagoDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            FormaPagoDto f = lista.get(i);
//            System.out.println("Dato:");
//            System.out.println(f.getFormaPagoId());
//            System.out.println(f.getNombre());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        FormaPagoDto f = new FormaPagoDto();
//        f.setFormaPagoId(1);
//        f.setNombre("Tarjeta Modificada");
//        Integer resultado = this.formaPagoDAO.modificar(f);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        FormaPagoDto f = new FormaPagoDto();
//        f.setFormaPagoId(2);
//        this.formaPagoDAO.eliminar(f);
//    }
}


