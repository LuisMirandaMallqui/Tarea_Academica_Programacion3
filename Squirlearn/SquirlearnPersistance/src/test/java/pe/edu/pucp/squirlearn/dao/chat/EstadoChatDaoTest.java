package pe.edu.pucp.squirlearn.dao.chat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.daoImpl.chat.EstadoChatDaoImpl;
import pe.edu.pucp.squirlearn.model.chat.EstadoChatDto;

public class EstadoChatDaoTest {

    private EstadoChatDao estadoChatDAO;

    public EstadoChatDaoTest() {
        this.estadoChatDAO = new EstadoChatDaoImpl();
    }

//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        EstadoChatDto estado = new EstadoChatDto();
//        estado.setNombre("Activo");
//        Integer resultado = this.estadoChatDAO.insertar(estado);
//        assertTrue(resultado != 0);
//    }
//
//    @Test
//    public void testObtenerPorId() {
//        System.out.println("obtenerPorId");
//        EstadoChatDto estado = this.estadoChatDAO.obtenerPorId(1);
//        if (estado != null) {
//            System.out.println(estado.getEstadoChatId());
//            System.out.println(estado.getNombre());
//        }
//    }
//
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<EstadoChatDto> lista = this.estadoChatDAO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getEstadoChatId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        EstadoChatDto estado = new EstadoChatDto();
//        estado.setEstadoChatId(1);
//        estado.setNombre("Activo Modificado");
//        Integer resultado = this.estadoChatDAO.modificar(estado);
//        assertTrue(resultado != 0);
//    }

}
