/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.pucp.squirlmarket.mapper;

import pe.pucp.squirlmarket.domain.Mensaje;
import pe.pucp.squirlmarket.dto.MensajeCreateDTO;
import pe.pucp.squirlmarket.dto.MensajeDTO;
/**
 *
 * @author luque
 */
public final class MensajeMapper {
  private MensajeMapper() {}

  public static Mensaje fromCreate(MensajeCreateDTO dto){
    Mensaje m = new Mensaje();
    m.setChatId(dto.chatId);
    m.setContenido(dto.contenido);
    return m; // estado ENVIADO por defecto
  }

  public static MensajeDTO toDTO(Mensaje m){
    MensajeDTO dto = new MensajeDTO();
    dto.id = m.getMensajeId();
    dto.chatId = m.getChatId();
    dto.contenido = m.getContenido();
    dto.estado = m.getEstado().name();
    dto.enviadoEn = m.getFechaEnvio().toString();
    return dto;
  }
}
