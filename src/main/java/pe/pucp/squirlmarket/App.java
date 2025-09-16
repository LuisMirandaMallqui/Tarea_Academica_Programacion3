/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pe.pucp.squirlmarket;

import java.math.BigDecimal;
import pe.pucp.squirlmarket.domain.Publicacion;
import pe.pucp.squirlmarket.domain.state.Modalidad;


/**
 *
 * @author luque
 */
public class App {
  public static void main(String[] args) {
    Publicacion p = new Publicacion();
    p.setMaterialId(10L);
    p.setPersonaCodigo(100L);
    p.setModalidad(Modalidad.ALQUILER);
    p.setPrecio(new BigDecimal("12.50"));
    p.activar();
    p.pausar();
    p.retirar();
    System.out.println("Estado final publicación: " + p.getEstado()); // esperado: RETIRADA
    var chat = new pe.pucp.squirlmarket.domain.Chat();
    chat.setChatId(50L);
    chat.setPublicacionId(1L);
    chat.cerrar();
    chat.reabrir();
    System.out.println("Estado chat: " + chat.getEstado()); // ABIERTO
    // --- Prueba de Mensaje ---
    pe.pucp.squirlmarket.domain.Mensaje msg = new pe.pucp.squirlmarket.domain.Mensaje();
    msg.setChatId(50L);
    msg.setContenido("¿Coordinamos la entrega en la biblioteca?");
    msg.marcarEntregado();
    msg.marcarLeido();
    System.out.println("Estado mensaje: " + msg.getEstado()); // esperado: LEIDO
    // --- Prueba de ComprobantePago ---
    var cp = new pe.pucp.squirlmarket.domain.ComprobantePago();
    cp.setPersonaCodigo(100L);
    cp.setMetodoPagoId(1L);
    cp.setMontoPago(new java.math.BigDecimal("12.50"));
    cp.confirmar(); // cambia a CONFIRMADO y setea fechaPago
    System.out.println("Estado pago: " + cp.getEstado()); // esperado: CONFIRMADO
    // --- Prueba DTO + Mapper de Publicacion ---
    var create = new pe.pucp.squirlmarket.dto.PublicacionCreateDTO();
    create.materialId = 10L;
    create.personaCodigo = 100L;
    create.modalidad = "ALQUILER";
    create.precio = new java.math.BigDecimal("15.00");

    // Mapeo a entidad (queda BORRADOR), luego activamos
    var pub = pe.pucp.squirlmarket.mapper.PublicacionMapper.fromCreate(create);
    pub.activar();

    // Mapeo a DTO de lista (pasamos strings simulados para mostrar)
    var listDto = pe.pucp.squirlmarket.mapper.PublicacionMapper.toListDTO(
            pub, "Cálculo I", "Libro", "María Pérez");

    System.out.println("DTO lista -> id=" + listDto.id +
                       ", titulo=" + listDto.tituloMaterial +
                       ", tipo=" + listDto.tipoMaterial +
                       ", estado=" + listDto.estado +
                       ", modalidad=" + listDto.modalidad +
                       ", precio=" + listDto.precio +
                       ", autor=" + listDto.autorNombre);
    // --- Prueba DTO + Mapper de Mensaje ---
    var msgCreate = new pe.pucp.squirlmarket.dto.MensajeCreateDTO();
    msgCreate.chatId = 50L;
    msgCreate.contenido = "¿Nos vemos en la biblioteca a las 3?";

    var mensaje = pe.pucp.squirlmarket.mapper.MensajeMapper.fromCreate(msgCreate);
    mensaje.marcarEntregado();
    mensaje.marcarLeido();

    var msgDTO = pe.pucp.squirlmarket.mapper.MensajeMapper.toDTO(mensaje);
    System.out.println("MensajeDTO -> id="+msgDTO.id+
                       ", chatId="+msgDTO.chatId+
                       ", estado="+msgDTO.estado+
                       ", enviadoEn="+msgDTO.enviadoEn+
                       ", contenido="+msgDTO.contenido);
    // --- Prueba DTO + Mapper de ComprobantePago ---
    var cpCreate = new pe.pucp.squirlmarket.dto.ComprobantePagoCreateDTO();
    cpCreate.personaCodigo = 100L;
    cpCreate.metodoPagoId = 1L;
    cpCreate.montoPago = new java.math.BigDecimal("12.50");
    cpCreate.numeroTransaccion = "TX-001";
    cpCreate.descripcion = "Reserva de material";

    // ANTES: var cp = ...   ⛔
    // AHORA:
    var pago = pe.pucp.squirlmarket.mapper.ComprobantePagoMapper.fromCreate(cpCreate);
    pago.confirmar();

    var cpDTO = pe.pucp.squirlmarket.mapper.ComprobantePagoMapper.toDTO(pago);
    System.out.println("PagoDTO -> estado="+cpDTO.estado+
                       ", monto="+cpDTO.montoPago+
                       ", fechaPago="+cpDTO.fechaPago+
                       ", tx="+cpDTO.numeroTransaccion);
    // --- Prueba DTO + Mapper de Chat ---
    var chatCreate = new pe.pucp.squirlmarket.dto.ChatCreateDTO();
    chatCreate.publicacionId = 1L;

    var chatEnt = pe.pucp.squirlmarket.mapper.ChatMapper.fromCreate(chatCreate);
    chatEnt.setChatId(99L);
    chatEnt.cerrar();   // cerrar y luego reabrir para probar
    chatEnt.reabrir();

    var chatDTO = pe.pucp.squirlmarket.mapper.ChatMapper.toDTO(chatEnt);
    System.out.println("ChatDTO -> id="+chatDTO.chatId+
                       ", pubId="+chatDTO.publicacionId+
                       ", estado="+chatDTO.estado+
                       ", creado="+chatDTO.fechaCreacion);
    // --- Prueba de Persona ---
    var per = new pe.pucp.squirlmarket.domain.Persona();
    per.setPersonaCodigo(100L);
    per.setNombre("María");
    per.setApellido("Pérez");
    per.setEmailPucp("maria.perez@pucp.edu.pe");
    per.setReputacion(4.7);
    System.out.println(per.toString());
    // --- Prueba de Material ---
    var mat = new pe.pucp.squirlmarket.domain.Material();
    mat.setMaterialId(10L);
    mat.setTipoMaterialId(1L);
    mat.setEstadoMaterialId(1L);
    mat.setCategoriaTamanioId(2L);
    mat.setColorId(3L);
    mat.setNombre("Cálculo I");
    mat.setDescripcion("Libro base, buen estado");
    mat.setImagenUrl("https://ejemplo/img1.jpg");
    mat.setDimensiones("21x28cm");
    mat.setPeso(new java.math.BigDecimal("0.75"));
    System.out.println(mat);
    // --- Prueba de Incidencia ---
    var inc = new pe.pucp.squirlmarket.domain.Incidencia();
    inc.setReportadoPorId(100L);
    inc.setOperacionId(200L);
    inc.setDescripcion("Material recibido con páginas sueltas");
    inc.setSeveridad("MEDIA");
    inc.tomar(999L); // admin 999 toma el caso
    inc.resolver("Se acordó devolución parcial");
    inc.cerrar();
    System.out.println("Incidencia -> estado=" + inc.getEstado());
    // --- Prueba DTO + Mapper de Incidencia ---
    var incCreate = new pe.pucp.squirlmarket.dto.IncidenciaCreateDTO();
    incCreate.reportadoPorId = 100L;
    incCreate.operacionId = 200L;
    incCreate.descripcion = "Material con páginas sueltas";
    incCreate.severidad = "MEDIA";

    var incEnt = pe.pucp.squirlmarket.mapper.IncidenciaMapper.fromCreate(incCreate);
    incEnt.tomar(999L);
    incEnt.resolver("Se acordó devolución parcial");
    incEnt.cerrar();

    var incDTO = pe.pucp.squirlmarket.mapper.IncidenciaMapper.toDTO(incEnt);
    System.out.println("IncidenciaDTO -> id="+incDTO.id+
                       ", estado="+incDTO.estado+
                       ", sev="+incDTO.severidad+
                       ", atendidoPor="+incDTO.atendidoPorId+
                       ", updatedAt="+incDTO.updatedAt);
    // --- Prueba DTO Detalle de Publicacion ---
    var det = pe.pucp.squirlmarket.mapper.PublicacionMapper.toDetailDTO(
        // reutilizo 'pub' que ya creaste antes; si no existe, crea uno igual
        pub,
        "Cálculo I",
        "Libro",
        "Texto base del curso, en buen estado. Incluye CD.",
        "María Pérez"
    );
    System.out.println("Detalle -> id="+det.id+
                       ", titulo="+det.tituloMaterial+
                       ", tipo="+det.tipoMaterial+
                       ", estado="+det.estado+
                       ", modalidad="+det.modalidad+
                       ", precio="+det.precio+
                       ", autor="+det.autorNombre+
                       ", valoracion="+det.valoracion+
                       ", fecha="+det.fechaPublicacion+
                       ", desc="+det.descripcionMaterial);
    // --- Prueba de Notificacion + Destinatario ---
    var notif = new pe.pucp.squirlmarket.domain.Notificacion();
    notif.setTipo("RESERVA");
    notif.setTitulo("Reserva confirmada");
    notif.setContenido("Tu reserva del material #10 ha sido confirmada");

    var nd = new pe.pucp.squirlmarket.domain.NotificacionDestinatario();
    nd.setNotificacionId(1L);
    nd.setPersonaCodigo(100L);
    nd.marcarLeido();
    System.out.println("Notificación -> " + notif.getTitulo() +
                       " | leido=" + nd.isLeido() + " en " + nd.getLeidoEn());
    // --- Prueba DTO + Mapper de Notificacion ---
    var nCreate = new pe.pucp.squirlmarket.dto.NotificacionCreateDTO();
    nCreate.tipo = "RESERVA";
    nCreate.titulo = "Reserva confirmada";
    nCreate.contenido = "Tu reserva del material #10 ha sido confirmada.";

    var nEnt = pe.pucp.squirlmarket.mapper.NotificacionMapper.fromCreate(nCreate);
    nEnt.setNotificacionId(77L);
    var nDTO = pe.pucp.squirlmarket.mapper.NotificacionMapper.toDTO(nEnt);
    System.out.println("NotifDTO -> id="+nDTO.id+", tipo="+nDTO.tipo+", titulo="+nDTO.titulo+", creadoEn="+nDTO.creadoEn);

    // Destinatario
    var ndEnt = new pe.pucp.squirlmarket.domain.NotificacionDestinatario();
    ndEnt.setNotificacionId(nDTO.id);
    ndEnt.setPersonaCodigo(100L);
    ndEnt.marcarLeido();
    var ndDTO = pe.pucp.squirlmarket.mapper.NotificacionMapper.toDestinatarioDTO(ndEnt);
    System.out.println("NotifDestDTO -> notifId="+ndDTO.notificacionId+
                       ", persona="+ndDTO.personaCodigo+
                       ", leido="+ndDTO.leido+
                       ", leidoEn="+ndDTO.leidoEn);
  }
}
