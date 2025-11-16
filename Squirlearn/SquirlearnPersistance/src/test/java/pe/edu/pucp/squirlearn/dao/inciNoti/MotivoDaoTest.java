package pe.edu.pucp.squirlearn.dao.inciNoti;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.inciNoti.MotivoDaoImpl;
import pe.edu.pucp.squirlearn.model.inciNoti.MotivoDto;

public class MotivoDaoTest {

    private MotivoDao motivoDAO;

    public MotivoDaoTest() {
        this.motivoDAO = new MotivoDaoImpl();
    }
//
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        MotivoDto m = new MotivoDto();
//        m.setNombre("Motivo test");
//        Integer resultado = this.motivoDAO.insertar(m);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        MotivoDto m = this.motivoDAO.obtenerPorId(1);
//        if (m != null) {
//            System.out.println(m.getMotivoId());
//            System.out.println(m.getNombre());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<MotivoDto> lista = this.motivoDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            MotivoDto m = lista.get(i);
//            System.out.println("Dato:");
//            System.out.println(m.getMotivoId());
//            System.out.println(m.getNombre());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        MotivoDto m = new MotivoDto();
//        m.setMotivoId(1);
//        m.setNombre("Motivo modificado");
//        Integer resultado = this.motivoDAO.modificar(m);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        MotivoDto m = new MotivoDto();
//        m.setMotivoId(2);
//        this.motivoDAO.eliminar(m);
//    }
}
