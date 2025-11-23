package pe.pucp.edu.squirlearn.business.publicacion;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.squirlearn.model.publicacion.ListadoPublicacionGestionDto;
import pe.pucp.edu.squirlearn.business.publicacion.PublicacionBo;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionDto;
import pe.edu.pucp.squirlearn.model.publicacion.PublicacionShortDto;

public class PublicacionBoTest {
    
    private PublicacionBo publicacionBO;
    
    public PublicacionBoTest() {
        this.publicacionBO = new PublicacionBo();
    }
//    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Integer resultado = this.publicacionBO.insertar(
                11,                       // itemId
                "DANIEL",                       // personaId
                "Pendiente",                // usuarioCreacion
                69.69,                   // precio
                "Libro acear",       // nombre
                "Descripción publicación",
                true,                    // esVenta
                1,                       // colorId
                1,                       // condicionId
                1,                       // tamanoId
                1,                       // formatoId
                1,                       // categoriaId
                1,                        // subcategoriaId
                null
        );
        assertTrue(resultado != 0);
    }
    
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
    
//      @Test
//    public void testListarPorFiltrosPublicacion() {
//        System.out.println("Test listarPorFiltrosPublicacion");
//
//        Integer usuarioId = 0;        // Usuario de prueba
//        Integer cantidadPorPagina = 10;
//        Integer pagina = 1;
//        Integer estadoId = 1;          // Por ejemplo "Borrador" o "Aprobado"
//
//        ListadoPublicacionGestionDto listado = publicacionBO.listarPorFiltrosPublicacion(
//                usuarioId, cantidadPorPagina, pagina, estadoId
//        );
//
//        List<PublicacionShortDto> lista = listado.getLista();
//
//        if (lista != null && !lista.isEmpty()) {
//            for (Integer i = 0; i < lista.size(); i++) {
//                System.out.println("Dato #" + i);
//                System.out.println("ID Publicación: " + lista.get(i).getPublicacionId());
//                System.out.println("Nombre: " + lista.get(i).getCategoriaNombre());
//                System.out.println("Estado: " + lista.get(i).getEstadoNombre());
//                System.out.println("Fecha Alta: " + lista.get(i).getEsVenta());
//                System.out.println("---------------------------");
//            }
//        } else {
//            System.out.println("No se encontraron publicaciones.");
//        }
//
//        System.out.println("Total de páginas: " + listado.getTotalPaginas());
//    }
    
    
//     @Test
//    public void testModificarPublicacion() {
//        System.out.println("=== Test modificar publicación ===");
//
//        Integer publicacionId = 7; // Id de la publicación que quieres probar
//        String usuario = "usuarioTest";
//        String estado = "Transaccionada"; // Estado que queremos asignar
//        Double precio = 30.0;
//        String nombre = "Libro Modificado";
//        String descripcion = "Descripcion modificada";
//        Boolean esVenta = true;
//        Integer colorId = 1, condicionId = 1, tamanoId = 1, formatoId = 1, categoriaId = 1, subcategoriaId = 1;
//
//        try {
//            Integer resultado = publicacionBO.modificar(
//                    publicacionId,
//                    usuario,
//                    estado,
//                    precio,
//                    nombre,
//                    descripcion,
//                    esVenta,
//                    colorId,
//                    condicionId,
//                    tamanoId,
//                    formatoId,
//                    categoriaId,
//                    subcategoriaId
//            );
//
//            System.out.println("Resultado modificar: " + resultado);
//
//            // Para verificar visualmente
//            PublicacionDto pubActualizada = publicacionBO.obtenerPorId(publicacionId);
//            System.out.println("Id publicación: " + pubActualizada.getPublicacionId());
//            System.out.println("Estado: " + pubActualizada.getEstadoPublicacion().getNombre());
//            System.out.println("Nombre: " + pubActualizada.getItem().getNombre());
//            System.out.println("Precio: " + pubActualizada.getItem().getPrecio());
//            System.out.println("Descripción: " + pubActualizada.getItem().getDescripcion());
//            System.out.println("Es venta: " + pubActualizada.getItem().getEsVenta());
//
//        } catch (Exception e) {
//            System.err.println("Error al modificar la publicación: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
    
    
}
