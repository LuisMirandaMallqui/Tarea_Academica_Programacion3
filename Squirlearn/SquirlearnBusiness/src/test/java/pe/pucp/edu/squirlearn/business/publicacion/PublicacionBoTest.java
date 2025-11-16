package pe.pucp.edu.squirlearn.business.publicacion;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.pucp.edu.squirlearn.business.publicacion.PublicacionBo;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionDto;

public class PublicacionBoTest {
    
    private PublicacionBo publicacionBO;
    
    public PublicacionBoTest() {
        this.publicacionBO = new PublicacionBo();
    }
    
//    @Test
//    public void testInsertar() {
//        System.out.println("insertar");
//        Integer resultado = this.publicacionBO.insertar(
//                1,                       // itemId
//                1,                       // personaId
//                "DANIEL",                // usuarioCreacion
//                69.69,                   // precio
//                "Libro publicado",       // nombre
//                "Descripción publicación",
//                true,                    // esVenta
//                1,                       // colorId
//                1,                       // condicionId
//                1,                       // tamanoId
//                1,                       // formatoId
//                1,                       // categoriaId
//                1                        // subcategoriaId
//        );
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testModificar() {
//        System.out.println("modificar");
//        Integer resultado = this.publicacionBO.modificar(
//                1,                      // publicacionId (AJUSTA)
//                "2025-12-01",   // fechaAlta
//                null,                    // fechaBaja
//                2,                       // estadoId
//                1,                       // itemId
//                1,                       // personaId
//                5,                       // calificacion
//                "DANIEL",                // usuarioCreacion
//                "MOD_TEST"               // usuarioModificacion
//        );
//        assertTrue(resultado != 0);
//    }
//    
//    @Test
//    public void testBuscarPorId() {
//        System.out.println("buscarPorId");
//        PublicacionDto p = this.publicacionBO.obtenerPorId(3); // AJUSTA
//        if (p != null) {
//            System.out.println(p.getPublicacionId());
//            System.out.println(p.getFechaAlta());
//            System.out.println(p.getFechaBaja());
//            if (p.getItem() != null) {
//                System.out.println(p.getItem().getItemId());
//            }
//            if (p.getPersona() != null) {
//                System.out.println(p.getPersona().getPersonaId());
//            }
//            System.out.println(p.getCalificacion());
//        }
//    }
//    
//    @Test
//    public void testListarTodos() {
//        System.out.println("listarTodos (listarPorEstado)");
//        ArrayList<PublicacionDto> lista = this.publicacionBO.listarPorEstado(1); // estadoId de prueba
//        for (Integer i = 0; i < lista.size(); i++) {
//            System.out.print("Dato: ");
//            System.out.println(i);
//            System.out.println(lista.get(i).getPublicacionId());
//            System.out.println(lista.get(i).getFechaAlta());
//            System.out.println(lista.get(i).getCalificacion());
//        }
//    }
}
