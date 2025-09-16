/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.mapper;

import pe.pucp.squirlmarket.domain.Notificacion;
import pe.pucp.squirlmarket.domain.NotificacionDestinatario;
import pe.pucp.squirlmarket.dto.NotificacionCreateDTO;
import pe.pucp.squirlmarket.dto.NotificacionDTO;
import pe.pucp.squirlmarket.dto.NotificacionDestinatarioDTO;
/**
 *
 * @author luque
 */
public final class NotificacionMapper {
  private NotificacionMapper(){}

  public static Notificacion fromCreate(NotificacionCreateDTO dto){
    Notificacion n = new Notificacion();
    n.setTipo(dto.tipo);
    n.setTitulo(dto.titulo);
    n.setContenido(dto.contenido);
    return n;
  }

  public static NotificacionDTO toDTO(Notificacion n){
    NotificacionDTO dto = new NotificacionDTO();
    dto.id = n.getNotificacionId();
    dto.tipo = n.getTipo();
    dto.titulo = n.getTitulo();
    dto.contenido = n.getContenido();
    dto.creadoEn = n.getCreadoEn().toString();
    return dto;
  }

  public static NotificacionDestinatarioDTO toDestinatarioDTO(NotificacionDestinatario nd){
    NotificacionDestinatarioDTO dto = new NotificacionDestinatarioDTO();
    dto.notificacionId = nd.getNotificacionId();
    dto.personaCodigo = nd.getPersonaCodigo();
    dto.leido = nd.isLeido();
    dto.leidoEn = nd.getLeidoEn() != null ? nd.getLeidoEn().toString() : null;
    return dto;
  }
}
