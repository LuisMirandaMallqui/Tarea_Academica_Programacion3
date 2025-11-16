package pe.edu.pucp.squirlearn.dao.item;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.item.CondicionDaoImpl;
import pe.edu.pucp.squirlearn.model.item.CondicionDto;

public class CondicionDaoTest {

    private CondicionDao condicionDAO;

    public CondicionDaoTest() {
        this.condicionDAO = new CondicionDaoImpl();
    }
//
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        CondicionDto condicion = new CondicionDto();
//        condicion.setNombre("Como nuevo");
//        Integer resultado = this.condicionDAO.insertar(condicion);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        CondicionDto condicion = this.condicionDAO.obtenerPorId(1);
//        if (condicion != null) {
//            System.out.println(condicion.getCondicionId());
//            System.out.println(condicion.getNombre());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<CondicionDto> lista = this.condicionDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getCondicionId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        CondicionDto condicion = new CondicionDto();
//        condicion.setCondicionId(1);
//        condicion.setNombre("Como nuevo MOD");
//        Integer resultado = this.condicionDAO.modificar(condicion);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        CondicionDto condicion = new CondicionDto();
//        condicion.setCondicionId(2);
//        this.condicionDAO.eliminar(condicion);
//    }
}
