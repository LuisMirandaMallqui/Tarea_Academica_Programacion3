package pe.pucp.edu.squirlearn.business.publicacion;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.publicacion.EstadoPublicacionDto;

public class EstadoPublicacionBoTest {

    private EstadoPublicacionBo estadoPublicacionBO;

    public EstadoPublicacionBoTest() {
        this.estadoPublicacionBO = new EstadoPublicacionBo();
    }

//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos");
//        ArrayList<EstadoPublicacionDto> lista = this.estadoPublicacionBO.listarTodos();
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.println("Dato:");
//            System.out.println(lista.get(i).getEstadoPublicacionId());
//            System.out.println(lista.get(i).getNombre());
//        }
//    }
//
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        EstadoPublicacionDto entidad = this.estadoPublicacionBO.obtenerPorId(1);
//        if (entidad != null) {
//            System.out.println(entidad.getEstadoPublicacionId());
//            System.out.println(entidad.getNombre());
//        }
//    }
}
